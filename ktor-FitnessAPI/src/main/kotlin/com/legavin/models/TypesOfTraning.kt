package com.legavin.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object TypesOfTranings: IntIdTable("typesoftraning","id_typesoftraning"){
    val nameTraning: Column<String> = varchar("nametraning", 50)

}

class TypesOfTraningEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<TypesOfTraningEntity>(TypesOfTranings)
    var nameTraning by TypesOfTranings.nameTraning
}

@Serializable
data class TypesOfTraning(
    @Transient val model : TypesOfTraningEntity? = null
){
    val nameTraning = model?.nameTraning

}