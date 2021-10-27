package com.legavin.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object PositionWorks: IntIdTable(columnName = "id_position"){
    val position: Column<String> = varchar("position", 50)
    val namePosition: Column<String> = varchar("namePosition", 50)

}

class PositionWorkEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PositionWorkEntity>(PositionWorks)
    var position by PositionWorks.position
    var namePosition by PositionWorks.namePosition
}

@Serializable
data class PositionWork(
    @Transient val people : PositionWorkEntity? = null
){
    val position = people?.position
    val namePosition = people?.namePosition

}