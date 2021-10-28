package com.example;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoronavirusStatsServices {

    HttpConnectionService hcs = null;

    /**
     * Método encargado de traer todas las estadísticas
     * @return JsonNode
     * @throws UnirestException
     */
    public JsonNode getAllCases() throws UnirestException {
        return hcs.getAllCases();
    }

    /**
     *
     * @param country nombre del pais
     * @return JsonNode
     * @throws UnirestException
     */
    public JsonNode getCasesByCountry(String country) throws UnirestException {
        return hcs.getCaseByCountry(country);
    }
}
