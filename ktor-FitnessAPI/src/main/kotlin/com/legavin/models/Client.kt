package com.legavin.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Clients: IntIdTable("Client","id_client") {
    val client: Column<String> = varchar("client", 50)

    val abonement = reference("abonement_id", Abonements)
    val user = reference("userclub_id", UserClubs)
}

class ClientEntity(id: EntityID<Int>) : IntEntity(id){
    companion object : IntEntityClass<ClientEntity>(Clients)

    var client by Clients.client

    var abonement by AbonementEntity referencedOn Clients.abonement
    var user by UserClubEntity referencedOn Clients.user

}
    @Serializable
    data class Client(@Transient val model: ClientEntity? = null){
        val id = model!!.id.value
        val client = model!!.client

        val abonement = model!!.abonement.toString()
        val user = model!!.user.toString()
    }


