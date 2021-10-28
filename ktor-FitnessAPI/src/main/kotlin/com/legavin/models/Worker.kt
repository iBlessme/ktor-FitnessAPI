package com.legavin.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Workers: IntIdTable("worker","id_worker") {
    val salary: Column<Int> = integer("salary")

    val position = reference("position_id", PositionWorks)
    val user = reference("user_id", UserClubs)
}

class WorkerEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<WorkerEntity>(Workers)
    var salary by Workers.salary

    var position by PositionWorkEntity referencedOn Workers.position
    var user by UserClubEntity referencedOn Workers.user

}

@Serializable
data class Worker(
    @Transient val model : WorkerEntity? = null
){
    val salary = model?.salary

    val position = model?.position.toString()
    val user = model?.user.toString()
}