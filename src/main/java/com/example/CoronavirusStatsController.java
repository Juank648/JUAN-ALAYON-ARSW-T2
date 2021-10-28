package com.example;

import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/corona")
public class CoronavirusStatsController {
    @Autowired
    CoronavirusStatsServices csservices = null;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> GetAllCases(){
        try {
            return new ResponseEntity<>(csservices.getAllCases(), HttpStatus.ACCEPTED);
        } catch (UnirestException e) {
            Logger.getLogger(CoronavirusStatsController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(path ="/{country}",method = RequestMethod.GET)
    public ResponseEntity<?> GetCasesByCountry(@PathVariable("country") String countryName){
        try {
            return new ResponseEntity<>(csservices.getCasesByCountry(countryName),HttpStatus.ACCEPTED);
        } catch (UnirestException e) {
            Logger.getLogger(CoronavirusStatsController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

}
