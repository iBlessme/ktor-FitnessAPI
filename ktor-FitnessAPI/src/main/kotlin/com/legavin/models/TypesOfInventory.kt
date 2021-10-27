package com.legavin.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object TypesOfInventorys: IntIdTable(columnName = "id_typesOfInventory"){
    val typeInventory: Column<String> = varchar("typeInventory", 50)
    val nameInventory: Column<String> = varchar("nameInventory", 50)

}

class TypesOfInventoryEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<TypesOfInventoryEntity>(TypesOfInventorys)
    var nameInventory by TypesOfInventorys.nameInventory
    var typeInventory by TypesOfInventorys.typeInventory
}

@Serializable
data class TypesOfInventory(
    @Transient val people : TypesOfInventoryEntity? = null
){
    val nameInventory = people?.nameInventory
    val typeInventory = people?.typeInventory

}