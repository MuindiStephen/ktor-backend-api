package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World! Welcome to Ktor")
        }
    }

    routing {
        get("/ktor") {
            call.respondText("My name is Stephen Muindi and welcome to Ktor backend for android")
        }
    }
}
