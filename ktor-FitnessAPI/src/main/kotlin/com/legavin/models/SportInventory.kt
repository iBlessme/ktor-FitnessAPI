package com.legavin.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object SportInventorys: IntIdTable(columnName = "id_sportInventory"){
    val inventory: Column<String> = varchar("inventory", 50)

    val typesInventory = reference("typesInventory", TypesOfInventorys)
    val hall = reference("hall", Halls)
    val fabricator = reference("fabricator", Fabricators)

}

class SportInventoryEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<SportInventoryEntity>(SportInventorys)

    var inventory by SportInventorys.inventory

    var typesInventory by TypesOfInventoryEntity referencedOn SportInventorys.typesInventory
    var hall by HallEntity referencedOn SportInventorys.hall
    var fabricator by FabricatorEntity referencedOn SportInventorys.fabricator
}

@Serializable
data class SportInventory(
    @Transient val people : SportInventoryEntity? = null
){
    val inventory = people?.inventory
    val typesInventory = people?.typesInventory.toString()
    val hall = people?.hall.toString()
    val fabricator = people?.fabricator.toString()
}