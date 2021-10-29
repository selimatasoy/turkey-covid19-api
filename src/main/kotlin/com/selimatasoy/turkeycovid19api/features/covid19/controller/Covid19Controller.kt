package com.selimatasoy.turkeycovid19api.features.covid19.controller

import com.selimatasoy.turkeycovid19api.features.covid19.model.Covid19DateRequest
import com.selimatasoy.turkeycovid19api.features.covid19.service.Covid19Service
import com.selimatasoy.turkeycovid19api.model.Covid19GenericModel
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@Api(value = "Covid19 Controller")
class Covid19Controller(private val covid19Service: Covid19Service) {

    @GetMapping("/api/v1/covid19/{countryCode}")
    @ApiOperation(value = "scrapes and returns all the covid19 data from the official government web site")
    suspend fun getCovid19Data(@PathVariable("countryCode") countryCode: String): List<Covid19GenericModel> {
        return covid19Service.getAllTimeCovidData(countryCode)
    }

    @GetMapping("/api/v1/covid19/today/{countryCode}")
    @ApiOperation(value = "scrapes and returns todays covid19 data from the official government web site if exists")
    suspend fun getTodaysCovid19Data(@PathVariable("countryCode") countryCode: String): Covid19GenericModel {
        return covid19Service.getTodaysCovidData(countryCode)
    }

    @GetMapping("/api/v1/covid19/date/{countryCode}")
    @ApiOperation(value = "scrapes and returns any date of covid19 data from the official government web site if exists")
    suspend fun getCovid19DataOfDate(
        @PathVariable("countryCode") countryCode: String,
        @RequestBody request: Covid19DateRequest
    ): Covid19GenericModel {
        return covid19Service.getCovidDataOfDate(countryCode, request.date)
    }

}