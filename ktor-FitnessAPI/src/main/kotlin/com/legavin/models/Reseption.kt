package com.legavin.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Reseptions: IntIdTable("reseption","id_reseption"){

    val inventory = reference("sportinventory_id", SportInventorys)
    val worker = reference("worker_id", Workers)
    val client = reference("client_id", Clients)

}

class ReseptionEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ReseptionEntity>(Reseptions)


    var inventory by SportInventoryEntity referencedOn Reseptions.inventory
    var worker by WorkerEntity referencedOn Reseptions.worker
    var client by ClientEntity referencedOn Reseptions.client
}

@Serializable
data class Reseption(
    @Transient val model : ReseptionEntity? = null
){

    val inventory = model?.inventory.toString()
    val worker = model?.worker.toString()
    val client = model?.client.toString()
}