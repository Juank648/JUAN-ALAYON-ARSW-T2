package com.example;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

@Service
public class CoronavirusStatsServices {
    HttpConnectionService hcs = null;

    /**
     * Método encargado de traer todas las estadísticas
     * @return HttpResponse<JsonNode>
     * @throws UnirestException
     */
    public HttpResponse<JsonNode> getAllCases() throws UnirestException {
        return hcs.getAllCases();
    }

    /**
     *
     * @param country nombre del pais
     * @return HttpResponse<JsonNode>
     * @throws UnirestException
     */
    public HttpResponse<JsonNode> getCasesByCountry(String country) throws UnirestException {
        return hcs.getCaseByCountry(country);
    }
}
