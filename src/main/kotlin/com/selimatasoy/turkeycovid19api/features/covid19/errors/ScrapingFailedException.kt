package com.selimatasoy.turkeycovid19api.features.covid19.errors

data class ScrapingFailedException(override val message:String = "Scraping Failed"): Exception()
