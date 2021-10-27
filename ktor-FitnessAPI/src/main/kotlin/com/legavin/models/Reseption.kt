package com.legavin.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Reseptions: IntIdTable(columnName = "id_reseption"){
    val reseption: Column<String> = varchar("reseption", 50)

    val inventory = reference("inventory", SportInventorys)
    val worker = reference("worker", Workers)
    val client = reference("client", Clients)

}

class ReseptionEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ReseptionEntity>(Reseptions)

    var reseption by Reseptions.reseption

    var inventory by SportInventoryEntity referencedOn SportInventorys.inventory
    var worker by WorkerEntity referencedOn Workers.worker
    var client by ClientEntity referencedOn Clients.client
}

@Serializable
data class Reseption(
    @Transient val people : ReseptionEntity? = null
){
    val reseption = people?.reseption

    val inventory = people?.inventory.toString()
    val worker = people?.worker.toString()
    val client = people?.client.toString()
}