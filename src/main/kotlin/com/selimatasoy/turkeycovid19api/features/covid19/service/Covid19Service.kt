package com.selimatasoy.turkeycovid19api.features.covid19.service

import com.selimatasoy.turkeycovid19api.model.Covid19GenericModel
import java.time.LocalDate

interface Covid19Service {
    suspend fun getAllTimeCovidData(countryCode: String): List<Covid19GenericModel>
    suspend fun getTodaysCovidData(countryCode: String): Covid19GenericModel
    suspend fun getCovidDataOfDate(countryCode: String, date: LocalDate): Covid19GenericModel
}