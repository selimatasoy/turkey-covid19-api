package com.selimatasoy.turkeycovid19api.features.covid19.model

import com.fasterxml.jackson.annotation.JsonFormat
import io.swagger.annotations.ApiModel
import java.time.LocalDate

@ApiModel
data class Covid19DateRequest(@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy") var date: LocalDate)