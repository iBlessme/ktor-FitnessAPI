package com.legavin.plugins

import com.legavin.models.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import org.jetbrains.exposed.sql.transactions.transaction

//Роутинг - это херня внутри которой мы конфигурируем то как будет работать API на запросы
fun Application.configureRouting() {
    routing {

        val abon =
            transaction {
                Abonemet(AbonementEntity.all().elementAt(0))
            }
        val bonus =
            transaction {
                BonusProgram(BonusProgramEntity.all().elementAt(0))
            }
        val education =
            transaction {
                Education(EducationsEntity.all().elementAt(0))
            }
        val fabricator =
            transaction {
                Fabricator(FabricatorEntity.all().elementAt(0))
            }
        val hall =
            transaction {
                Hall(HallEntity.all().elementAt(0))
            }
        val position =
            transaction {
                PositionWork(PositionWorkEntity.all().elementAt(0))
            }
        val reseption =
            transaction {
                Reseption(ReseptionEntity.all().elementAt(0))
            }
        val sportInventory =
            transaction {
                SportInventory(SportInventoryEntity.all().elementAt(0))
            }
        val typesOfTraning=
            transaction {
                TypesOfTraning(TypesOfTraningEntity.all().elementAt(0))
            }
        val typesOfInventory =
            transaction {
                TypesOfInventory(TypesOfInventoryEntity.all().elementAt(0))
            }
        val user =
            transaction {
                UserClub(UserClubEntity.all().elementAt(0))
            }
        val worker =
            transaction {
                Worker(WorkerEntity.all().elementAt(0))
            }


        get("/Abonement") {
            //data class
            call.respond(abon)
        }
    }
}
