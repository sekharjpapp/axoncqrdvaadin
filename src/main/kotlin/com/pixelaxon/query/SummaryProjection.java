package com.pixelaxon.query;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;

@Component
public class SummaryProjection {

    private final EntityManager entityManager;

    public SummaryProjection(EntityManager entityManager){
        this.entityManager = entityManager;
    }

}
