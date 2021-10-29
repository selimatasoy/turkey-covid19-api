package com.selimatasoy.turkeycovid19api.features.covid19.service

import com.selimatasoy.turkeycovid19api.features.covid19.errors.TodaysDataNotFoundException
import com.selimatasoy.turkeycovid19api.features.covid19.remote.Covid19Remote
import com.selimatasoy.turkeycovid19api.features.covid19.webscraper.Covid19WebScraper
import com.selimatasoy.turkeycovid19api.model.Covid19GenericModel
import com.selimatasoy.turkeycovid19api.util.DateUtil
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class Covid19ServiceImpl(
    private val remote: Covid19Remote,
    private val covid19WebScraper: Covid19WebScraper
) : Covid19Service {
    override suspend fun getAllTimeCovidData(countryCode: String): List<Covid19GenericModel> {
        return covid19WebScraper.getAllCovidData(countryCode, remote.getAllTimeCovidData(countryCode))
    }

    override suspend fun getTodaysCovidData(countryCode: String): Covid19GenericModel {
        return findTodaysCovidData(
            covid19WebScraper.getAllCovidData(countryCode, remote.getAllTimeCovidData(countryCode)),
            countryCode
        )
    }

    override suspend fun getCovidDataOfDate(countryCode: String, date: LocalDate): Covid19GenericModel {
        return findCovidDataOfDate(
            covid19WebScraper.getAllCovidData(
                countryCode,
                remote.getAllTimeCovidData(countryCode)
            ), countryCode, date
        )
    }

    private fun findCovidDataOfDate(
        list: MutableList<Covid19GenericModel>,
        countryCode: String,
        date: LocalDate
    ): Covid19GenericModel {
        for (item in list) {
            if (item.date!! == DateUtil.convertToStringForCountryForDate(countryCode, date)) {
                return item
            }
        }
        throw TodaysDataNotFoundException()
    }

    private fun findTodaysCovidData(list: MutableList<Covid19GenericModel>, countryCode: String): Covid19GenericModel {
        for (item in list) {
            if (item.date!! == DateUtil.getTodayAndConvertToStringForCountry(countryCode)) {
                return item
            }
        }
        throw TodaysDataNotFoundException()
    }
}