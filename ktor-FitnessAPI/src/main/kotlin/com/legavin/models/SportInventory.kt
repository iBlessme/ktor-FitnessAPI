package com.legavin.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object SportInventorys: IntIdTable("sportinvenory", "id_sportinvenory"){

    val typesInventory = reference("typesofinventory_id", TypesOfInventorys)
    val hall = reference("hall_id", Halls)
    val fabricator = reference("fabricator_id", Fabricators)

}

class SportInventoryEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<SportInventoryEntity>(SportInventorys)


    var typesInventory by TypesOfInventoryEntity referencedOn SportInventorys.typesInventory
    var hall by HallEntity referencedOn SportInventorys.hall
    var fabricator by FabricatorEntity referencedOn SportInventorys.fabricator
}

@Serializable
data class SportInventory(
    @Transient val model : SportInventoryEntity? = null
){
    val typesInventory = model?.typesInventory.toString()
    val hall = model?.hall.toString()
    val fabricator = model?.fabricator.toString()
}