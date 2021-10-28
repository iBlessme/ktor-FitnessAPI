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

object UserClubs: IntIdTable("userclub","id_user"){
    val name: Column<String> = varchar("nameuser", 50)
    val surname: Column<String> = varchar("surname", 50)
    val therdName: Column<String> = varchar("thirdname", 50)
    val passportNumber: Column<Int> = integer("passportnumber")
    val passportSerial: Column<Int> = integer("passportserial")
    val phoneNumber: Column<String> = varchar("phonenumber", 12)
    val login: Column<String> = varchar("login", 50)
    val password: Column<String> = varchar("password", 50)
    val birthDay: Column<LocalDateTime> = datetime("birthday")
    val snils: Column<Int> = integer("snils")
}

class UserClubEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UserClubEntity>(UserClubs)
    var name by UserClubs.name
    var surename by UserClubs.surname
    var therdName by UserClubs.therdName
    var passportNumber by UserClubs.passportNumber
    var passportSerial by  UserClubs.passportSerial
    var phoneNumber by UserClubs.phoneNumber
    var login by UserClubs.login
    var password by UserClubs.password
    var birthDay by UserClubs.birthDay
    var snils by UserClubs.snils

}

@Serializable
data class UserClub(
    @Transient val model : UserClubEntity? = null
){
    val name = model?.name
    val surename = model?.surename
    val therdName =  model?.therdName
    val passportNumber = model?.passportNumber
    val passportSerial = model?.passportSerial
    val phoneNumber = model?.phoneNumber
    val login = model?.login
    val password = model?.password
    val birthDay = model?.birthDay.toString()
    val snils = model?.snils



}