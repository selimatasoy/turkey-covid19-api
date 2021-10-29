package com.selimatasoy.turkeycovid19api.features.covid19.model

import com.selimatasoy.turkeycovid19api.model.Covid19GenericModel
import io.swagger.annotations.ApiModel

@ApiModel
data class Covid19TurkeyModel(
    override val date: String, override val death: String?, override val cases: String?,
    override val healed: String?, override val tests: String?
) : Covid19GenericModel()
