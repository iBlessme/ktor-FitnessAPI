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

object UserClubs: IntIdTable(columnName = "id_user"){
    val user: Column<String> = varchar("user", 50)
    val name: Column<String> = varchar("name", 50)
    val surname: Column<String> = varchar("surname", 50)
    val therdName: Column<String> = varchar("therdName", 50)
    val passportNumber: Column<Int> = integer("passportNumber")
    val passportSerial: Column<Int> = integer("passportSerial")
    val phoneNumber: Column<String> = varchar("phoneNumber", 12)
    val login: Column<String> = varchar("login", 50)
    val password: Column<String> = varchar("password", 50)
    val birthDay: Column<LocalDateTime> = datetime("birthDay")
    val snils: Column<Int> = integer("snils")
}

class UserClubEntity(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UserClubEntity>(UserClubs)
    var user by UserClubs.user
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
    @Transient val people : UserClubEntity? = null
){
    val user = people?.user
    val name = people?.name
    val surename = people?.surename
    val therdName =  people?.therdName
    val passportNumber = people?.passportNumber
    val passportSerial = people?.passportSerial
    val phoneNumber = people?.phoneNumber
    val login = people?.login
    val password = people?.password
    val birthDay = people?.birthDay.toString()
    val snils = people?.snils



}