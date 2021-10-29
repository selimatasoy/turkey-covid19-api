package com.selimatasoy.turkeycovid19api.features.covid19.webscraper

import com.selimatasoy.turkeycovid19api.model.Covid19GenericModel

interface Covid19WebScraper {
    suspend fun getAllCovidData(countryCode: String, html:String): MutableList<Covid19GenericModel>
}