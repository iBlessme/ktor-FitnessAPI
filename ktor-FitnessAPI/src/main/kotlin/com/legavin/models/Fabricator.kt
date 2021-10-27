package com.legavin.models

import com.legavin.EntityWithModel
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Fabricators: IntIdTable("Fabricator","id_fabricator"){
    val fabricator: Column<String> = varchar("fabricator", 50)
    val nameFabricator: Column<String> = varchar("nameFabricator", 50)
    val country: Column<String> = varchar("country", 50)
}

class FabricatorEntity(id: EntityID<Int>) : IntEntity(id){
    companion object : IntEntityClass<FabricatorEntity>(Fabricators)

    var fabricator by Fabricators.fabricator
    var nameFabricator by Fabricators.nameFabricator
    var country by Fabricators.country


}
    @Serializable
    data class Fabricator(
        @Transient val model: FabricatorEntity? = null
    ){
        val id = model!!.id.value
        val fabricator = model!!.fabricator
        val nameFabricator = model!!.nameFabricator
        val country = model!!.country
    }