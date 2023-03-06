package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import com.sun.xml.internal.ws.client.ContentNegotiation

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1") {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient
            })
        }
        configureRouting()
    }
        .start(wait = true)
}

fun Application.module() {
    configureRouting()
}
