# turkey-covid19-api
Rest API for getting Turkey's Covid-19 data from the Official Government Web Site By Web Scraping

## Header:
apiKey can be changed from application.properties file to increase your security for your custom needs, by default apiKey is like below,

apiKey: myCustomExtremelyLongButNotLongEnoughApiKeyForMaximumSecurity

## Endpoints:

Get All The Data Available:<br> 
## GET /api/v1/covid19/TR

Get Today's data if exists:<br> 
## GET /api/v1/covid19/today/TR

Get data for a specific date:<br>
## GET /api/v1/covid19/date/TR
Body:
{
    "date" : "20.10.2021"
}

## Specs:

Spring Framework<br>
Kotlin<br>
Authorization -> Simple ApiKey<br>
Ktor Client -> For External API calls<br>
Build Tool -> Gradle<br>
Server -> Tomcat<br>
API Documentation -> Swagger<br>
