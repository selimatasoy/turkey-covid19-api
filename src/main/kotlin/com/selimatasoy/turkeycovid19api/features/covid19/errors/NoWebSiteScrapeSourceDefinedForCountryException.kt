package com.selimatasoy.turkeycovid19api.features.covid19.errors

data class NoWebSiteScrapeSourceDefinedForCountryException(override val message: String = "No Web Site Scrape Source Defined For Country") :
    Exception()