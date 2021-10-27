package com.legavin.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object TypesOfTranings: IntIdTable(columnName = "id_typesOfTraning"){
    val traning: Column<String> = varchar("traning", 50)
    val nameTraning: Column<String> = varchar("nameTraning", 50)

}

class TypesOfTraningEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<TypesOfTraningEntity>(TypesOfTranings)
    var traning by TypesOfTranings.traning
    var nameTraning by TypesOfTranings.nameTraning
}

@Serializable
data class TypesOfTraning(
    @Transient val people : TypesOfTraningEntity? = null
){
    val traning = people?.traning
    val nameTraning = people?.nameTraning

}