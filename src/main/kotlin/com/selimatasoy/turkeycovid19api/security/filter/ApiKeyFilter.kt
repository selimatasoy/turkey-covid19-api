package com.selimatasoy.turkeycovid19api.security.filter

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.client.HttpClientErrorException
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
@Configuration
class ApiKeyFilter: OncePerRequestFilter() {

    @Value("\${apiKey}")
    private val apiKey: String? = null

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        var apiKeyHeader: String? = null

        try {
            apiKeyHeader = request.getHeader("ApiKey")
            if (apiKeyHeader == null || apiKeyHeader != apiKey) {
                throw HttpClientErrorException(HttpStatus.FORBIDDEN)
            }
        } catch (e: Exception) {
            throw HttpClientErrorException(HttpStatus.FORBIDDEN)
        }
        filterChain.doFilter(request, response)
    }
}