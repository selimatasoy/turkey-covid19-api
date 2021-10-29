package com.selimatasoy.turkeycovid19api.features.covid19.remote

import com.selimatasoy.turkeycovid19api.features.covid19.errors.NoWebSiteScrapeSourceDefinedForCountryException
import com.selimatasoy.turkeycovid19api.httpclient.ExternalHttpClientImpl
import io.ktor.client.request.*
import org.springframework.stereotype.Component

@Component
class Covid19RemoteImpl(private val httpService: ExternalHttpClientImpl) : Covid19Remote {
    override suspend fun getAllTimeCovidData(countryCode: String): String {
        if (countryCode == "TR") {
            return httpService.getClient().get("https://covid19.saglik.gov.tr/TR-66935/genel-koronavirus-tablosu.html")
        } else {
            throw NoWebSiteScrapeSourceDefinedForCountryException()
        }
    }
}