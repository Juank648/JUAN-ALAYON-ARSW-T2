package com.example;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class HttpConnectionService {
    /**
     *
     * Retorna estadísticas de coronavirus de varios paises por medio de una API
     * @return JsonNode
     * @throws UnirestException
     */
    public JsonNode getAllCases() throws UnirestException {
        HttpResponse<JsonNode> response = Unirest
                .get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats")
                .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                .header("x-rapidapi-key", "34f05cff54msh30ba6f36c91c183p166499jsn555917ef62b8")
                .asJson();
        return response.getBody();
        //assertNotNull(response.getBody());
        //assertEquals((int)HttpStatus.SC_OK,response.getStatus());
    }

    /**
     *
     * Retorna estadisticas de coronavirus de un pais en concreto por medio de una API
     * @param country
     * @return
     * @throws UnirestException
     */
    public JsonNode getCaseByCountry(String country) throws UnirestException {
        HttpResponse<JsonNode> response = Unirest
                .get("https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?country="+country)
                .header("x-rapidapi-host", "covid-19-coronavirus-statistics.p.rapidapi.com")
                .header("x-rapidapi-key", "34f05cff54msh30ba6f36c91c183p166499jsn555917ef62b8")
                .asJson();
        return response.getBody();
        //assertNotNull(response.getBody());
        //assertEquals((int)HttpStatus.SC_OK,response.getStatus());
    }
}
