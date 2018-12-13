package com.pixelaxon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AxonVaadinApplication

fun main(args: Array<String>) {
    runApplication<AxonVaadinApplication>(*args)
}
