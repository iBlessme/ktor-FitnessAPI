package com.legavin.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Fabricators: IntIdTable("fabricator","id_fabricator"){
    val nameFabricator: Column<String> = varchar("namefabricator", 50)
    val country: Column<String> = varchar("country", 50)
}

class FabricatorEntity(id: EntityID<Int>) : IntEntity(id){
    companion object : IntEntityClass<FabricatorEntity>(Fabricators)

    var nameFabricator by Fabricators.nameFabricator
    var country by Fabricators.country


}
    @Serializable
    data class Fabricator(
        @Transient val model: FabricatorEntity? = null
    ){
        val id = model!!.id.value
        val nameFabricator = model!!.nameFabricator
        val country = model!!.country
    }