package com.example.check.check

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class CheckApplication

fun main(args: Array<String>) {
    runApplication<CheckApplication>(*args)
}
