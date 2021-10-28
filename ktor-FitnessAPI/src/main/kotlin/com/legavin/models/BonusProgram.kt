package com.legavin.models
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object BonusPrograms: IntIdTable("Bonus","id_bonusProgram"){
    val bonus: Column<String> = varchar("bonus", 50)
    val nameProgram: Column<String> = varchar("nameProgram", 50)
    val costProgram: Column<String> = varchar("costProgram", 50)
}

class BonusProgramEntity(id: EntityID<Int>) : IntEntity(id){
    companion object : IntEntityClass<BonusProgramEntity>(BonusPrograms)

    var bonus by BonusPrograms.bonus
    var nameProgram by BonusPrograms.nameProgram
    var costProgram by BonusPrograms.costProgram


}
    @Serializable
    data class BonusProgram(@Transient val model: BonusProgramEntity? = null){
        val id = model!!.id.value
        val bonus = model!!.bonus
        val nameProgram = model!!.nameProgram
        val costProgram = model!!.costProgram
    }
