# turkey-covid19-api
Rest API for getting Turkey's Covid-19 data from the Official Government Web Site By Web Scraping

Header:
apiKey can be changed from application.properties file to increase your security for your custom needs, by default apiKey is like below,

apiKey: myCustomExtremelyLongButNotLongEnoughApiKeyForMaximumSecurity

Get All The Data Available: #GET /api/v1/covid19/TR
Get Today's data if exists: #GET /api/v1/covid19/today/TR
Get data for a specific date: #GET /api/v1/covid19/date/TR
Body:
{
    "date" : "20.10.2021"
}
