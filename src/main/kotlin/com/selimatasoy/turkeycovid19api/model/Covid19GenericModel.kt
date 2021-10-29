package com.selimatasoy.turkeycovid19api.model

import java.time.LocalDate

abstract class Covid19GenericModel {
    open val date:String? = null
    open val death: String? = null
    open val cases: String? = null
    open val healed: String? = null
    open val tests: String? = null
}