package com.selimatasoy.turkeycovid19api.util

import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object DateUtil {

    fun getTodayAndConvertToStringForCountry(countryCode: String): String {
        val today: LocalDate = getTodayForCountry(countryCode)
        val formatter: DateTimeFormatter = getDateFormatterForCountry(countryCode)
        return formatter.format(today)
    }

    private fun getTodayForCountry(countryCode: String): LocalDate {
        return when (countryCode) {
            "TR" -> {
                LocalDate.now(java.time.Clock.system(ZoneId.of("UTC+3")))
            }
            else -> {
                LocalDate.now(java.time.Clock.system(ZoneId.of("UTC")))
            }
        }
    }

    fun convertToStringForCountryForDate(countryCode: String, date:LocalDate): String {
        val formatter: DateTimeFormatter = getDateFormatterForCountry(countryCode)
        return formatter.format(date)
    }

    private fun getDateFormatterForCountry(countryCode: String):DateTimeFormatter {
        val formatter: DateTimeFormatter = when (countryCode) {
            "TR" -> {
                DateTimeFormatter.ofPattern("dd.MM.yyyy")
            }
            else -> {
                DateTimeFormatter.ofPattern("dd.MM.yyyy")
            }
        }
        return formatter
    }

}