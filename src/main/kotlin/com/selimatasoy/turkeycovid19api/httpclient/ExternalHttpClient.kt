package com.selimatasoy.turkeycovid19api.httpclient

import io.ktor.client.*

interface ExternalHttpClient {
    fun getClient(): HttpClient
}