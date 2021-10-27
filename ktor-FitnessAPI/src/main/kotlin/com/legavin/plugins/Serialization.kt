package com.legavin.plugins

import io.ktor.serialization.*
import io.ktor.features.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()
    }
}
