package com.legavin.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.`java-time`.datetime
import java.time.LocalDateTime

object Abonements: IntIdTable("Abonement", "id_abonement"){
//    val abonement: Column<String> = varchar("abonement", 50)
    val nameAbonement: Column<String> = varchar("nameabonement", 50)
    val costAbonement: Column<String> = varchar("costabonement", 50)
    val dateStart: Column<LocalDateTime> = datetime("datestart")
    val dateFinish: Column<LocalDateTime> = datetime("datefinish")

    //forKey
   val bonus = reference("bonusprogram_id", BonusPrograms)

}

class AbonementEntity(id: EntityID<Int>) : IntEntity(id){
    companion object : IntEntityClass<AbonementEntity>(Abonements)

//    var abonement by Abonements.abonement
    var nameAbonement by Abonements.nameAbonement
    var costAbonement by Abonements.costAbonement
    var dateStart by Abonements.dateStart
    var dateFinish by Abonements.dateFinish

    //   var bonusProgram by bonusProgram referencedOn BonusProgram.nameProgram
    var bonus by BonusProgramEntity referencedOn Abonements.bonus


}
    @Serializable
    data class Abonemet(@Transient val model: AbonementEntity? = null){
        val id = model!!.id.value
//        val abonement = model!!.abonement
        val nameAbonement = model!!.nameAbonement
        val costAbonement = model!!.costAbonement
        val dateStart =  model!!.dateStart.toString()
        val dateFinish = model!!.dateFinish.toString()

        val bonus = model?.bonus.toString()
    }

