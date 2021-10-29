package com.selimatasoy.turkeycovid19api.features.covid19.webscraper

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.selimatasoy.turkeycovid19api.features.covid19.errors.ScrapingFailedException
import com.selimatasoy.turkeycovid19api.features.covid19.model.Covid19TurkeyModel
import com.selimatasoy.turkeycovid19api.features.covid19.model.Covid19TurkeyScrapedResponse
import com.selimatasoy.turkeycovid19api.model.Covid19GenericModel
import org.springframework.stereotype.Component
import java.lang.reflect.Type
import java.util.regex.Matcher
import java.util.regex.Pattern


@Component
class Covid19WebScraperImpl : Covid19WebScraper {
    override suspend fun getAllCovidData(countryCode: String, html: String): MutableList<Covid19GenericModel> {
        return if (countryCode == "TR") {
            scrapeCovidDataForTR(html)
        } else {
            throw ScrapingFailedException()
        }
    }

    private fun scrapeCovidDataForTR(html: String): MutableList<Covid19GenericModel> {
        try {
            var jsonString: String? = null
            val pattern = Pattern.compile("(?<=geneldurumjson = )(.*)(?=;//]]>)")
            val matcher: Matcher = pattern.matcher(html)
            while (matcher.find()) {
                jsonString = matcher.group(1)
            }

            val list = mutableListOf<Covid19GenericModel>()

            val listType: Type = object : TypeToken<ArrayList<Covid19TurkeyScrapedResponse?>?>() {}.type
            val response: List<Covid19TurkeyScrapedResponse> = Gson().fromJson(jsonString, listType)

            for (data in response) {
                list.add(
                    Covid19TurkeyModel(
                        data.tarih,
                        data.gunluk_vefat,
                        data.gunluk_vaka,
                        data.gunluk_iyilesen,
                        data.gunluk_test
                    )
                )
            }

            return list
        } catch (e: Exception) {
            throw ScrapingFailedException()
        }
    }

}