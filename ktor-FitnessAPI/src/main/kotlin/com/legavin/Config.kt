package com.legavin

import io.ktor.application.*
import org.jetbrains.exposed.sql.Database
import java.sql.Connection
import java.sql.DriverManager

fun Application.connectDatabase() = Database.connect(::getConnection)

private fun getConnection(): Connection {
    val dbUrl = System.getenv("JDBC_DATABASE_URL")
    return DriverManager.getConnection(dbUrl)
}