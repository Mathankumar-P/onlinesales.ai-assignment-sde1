package com.onlinesales.ai.assignment.controller;

import com.onlinesales.ai.assignment.service.ProbabilityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ProbabilityController {

    @GetMapping("/api/diceRoll")
    public HashMap<Integer, Integer> diceRoll(@RequestParam int eventCount){
        // Creating an instance of ProbabilityService class to perform dice roll calculations which creates probability percentage for each request
        ProbabilityService probabilityService = new ProbabilityService();
        // Call to 'rollDice' method from ProbabilityService and return the result as a HashMap with dice side as key and value as the occurrences
        return probabilityService.rollDice(eventCount);
    }
}
