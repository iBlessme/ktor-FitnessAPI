package com.legavin.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Halls: IntIdTable("hall", "id_hall"){
    val nameHall: Column<String> = varchar("namehall", 50)
    val capacity: Column<String> = varchar("capacity", 50)

    val typesOfTraning = reference("typesoftraning_id", TypesOfTranings)
}

class HallEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<HallEntity>(Halls)
    var nameHall by Halls.nameHall
    var capacity by Halls.capacity

    var typesOfTraning by TypesOfTraningEntity referencedOn Halls.typesOfTraning
}

@Serializable
data class Hall(
    @Transient val model : HallEntity? = null
){
    val nameHall = model?.nameHall
    val capacity = model?.capacity

    val typesOfTraning = model?.typesOfTraning.toString()
}