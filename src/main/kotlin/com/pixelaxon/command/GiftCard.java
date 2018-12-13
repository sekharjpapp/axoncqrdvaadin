package com.pixelaxon.command;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class GiftCard {

    @AggregateIdentifier
    private String id;
    private int balance;

    public GiftCard() {
    }

    @CommandHandler
    public GiftCard(IssueCmd cmd){
        if (cmd.getAmount() <= 0) throw new IllegalArgumentException("amount <= 0");
        apply(new IssuedEvt(cmd.getId(),cmd.getAmount()));
    }
    @CommandHandler
    public void handle(RedeemCmd cmd){
        if (cmd.getAmount() <= 0) throw new IllegalArgumentException("amount <= 0");
        if (cmd.getAmount() > balance)  throw  new IllegalArgumentException("Amont > balanace");
        apply(new RedeemdEvt(cmd.getId(),cmd.getAmount()));
    }
    @EventSourcingHandler
    public void on(IssuedEvt evt){
        id = evt.getId();
        balance =evt.getAmount();
    }
    @EventSourcingHandler
    public void on(RedeemdEvt evt){
        balance -= evt.getAmount();
    }
}
