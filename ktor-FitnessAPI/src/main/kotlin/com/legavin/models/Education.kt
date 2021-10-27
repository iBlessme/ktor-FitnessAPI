package com.legavin.models

import com.legavin.EntityWithModel
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.`java-time`.datetime
import java.time.LocalDateTime

object Educations: IntIdTable("Education","id_education"){
    val education: Column<String> = varchar("education", 50)
    val qualification: Column<String> = varchar("qualification", 50)
    val stage: Column<String> = varchar("stage", 50)
    val dateOfissue: Column<LocalDateTime> = datetime("dateOfissue")
    val registrationNumber: Column<Int> = integer("registrationNumber")
    val serialNumber: Column<Int> = integer("serialNumber")
    val institution: Column<String> = varchar("institution", 50)

    val worker = reference("worker", Workers)
}

class EducationsEntity(id: EntityID<Int>) : IntEntity(id){
    companion object : IntEntityClass<EducationsEntity>(Educations)

    var education by Educations.education
    var qualification by Educations.qualification
    var stage by Educations.stage
    var dateOfissue by Educations.dateOfissue
    var registrationNumber by Educations.registrationNumber
    var serialNumber by Educations.serialNumber
    var institution by Educations.institution

    var worker by WorkerEntity referencedOn Educations.worker


}
    @Serializable
    data class Education(@Transient val model: EducationsEntity? = null){
        val id = model!!.id.value
        val education = model!!.education
        val qualification = model!!.qualification
        val stage = model!!.stage
        val registrationNumber = model!!.registrationNumber
        val serialNumber = model!!.serialNumber
        val institution = model!!.institution
        val dateOfissue =  model!!.dateOfissue.toString()

        val worker = model!!.worker.toString()
    }

