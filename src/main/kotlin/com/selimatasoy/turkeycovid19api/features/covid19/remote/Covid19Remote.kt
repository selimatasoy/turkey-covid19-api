package com.selimatasoy.turkeycovid19api.features.covid19.remote


interface Covid19Remote {
    suspend fun getAllTimeCovidData(countryCode: String): String
}