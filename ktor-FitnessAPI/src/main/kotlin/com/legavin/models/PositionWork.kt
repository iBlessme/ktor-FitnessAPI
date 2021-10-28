package com.legavin.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object PositionWorks: IntIdTable("positionwork","id_position"){
    val namePosition: Column<String> = varchar("nameposition", 50)

}

class PositionWorkEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PositionWorkEntity>(PositionWorks)
    var namePosition by PositionWorks.namePosition
}

@Serializable
data class PositionWork(
    @Transient val model : PositionWorkEntity? = null
){
    val namePosition = model?.namePosition

}