package com.selimatasoy.turkeycovid19api.features.covid19.errors

data class TodaysDataNotFoundException(override val message:String = "Today's data not found"): Exception()
