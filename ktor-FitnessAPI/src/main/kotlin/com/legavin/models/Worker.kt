package com.legavin.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Workers: IntIdTable(columnName = "id_worker") {
    val worker: Column<String> = varchar("worker", 50)
    val salary: Column<Int> = integer("salary")

    val position = reference("position", PositionWorks)
    val user = reference("user", UserClubs)
}

class WorkerEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<WorkerEntity>(Workers)
    var worker by Workers.worker
    var salary by Workers.salary

    var position by PositionWorkEntity referencedOn Workers.position
    var user by UserClubEntity referencedOn Workers.user

}

@Serializable
data class Worker(
    @Transient val people : WorkerEntity? = null
){
    val worker = people?.worker
    val salary = people?.salary

    val position = people?.position.toString()
    val user = people?.user.toString()
}