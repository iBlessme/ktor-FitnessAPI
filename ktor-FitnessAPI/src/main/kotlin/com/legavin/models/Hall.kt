package com.legavin.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Halls: IntIdTable(columnName = "id_hall"){
    val hall: Column<String> = varchar("hall", 50)
    val nameHall: Column<String> = varchar("nameHall", 50)
    val capacity: Column<String> = varchar("capacity", 50)

    val typesOfTraning = reference("typesOfTraning", TypesOfTranings)
}

class HallEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<HallEntity>(Halls)
    var hall by Halls.hall
    var nameHall by Halls.nameHall
    var capacity by Halls.capacity

    var typesOfTraning by TypesOfTraningEntity referencedOn TypesOfTranings.traning
}

@Serializable
data class Hall(
    @Transient val people : HallEntity? = null
){
    val hall = people?.hall
    val nameHall = people?.nameHall
    val capacity = people?.capacity

    val typesOfTraning = people?.typesOfTraning.toString()
}