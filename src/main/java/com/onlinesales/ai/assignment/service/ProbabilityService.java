package com.onlinesales.ai.assignment.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class ProbabilityService {
    private final HashMap<Integer, Double> diceProbability;
    // HashMap to store the occurrences of each dice side after rolling the dice
    private final HashMap<Integer, Integer> sideOccurrences;

    public ProbabilityService(){
        // Initialize the diceProbability and sideOccurrences HashMaps and generate random probabilities
        this.diceProbability = new HashMap<>();
        this.sideOccurrences = new HashMap<>();
        this.generateRandomProbability();
    }

    // Method to generate random probabilities for each dice side
    public void generateRandomProbability(){
        Random random = new Random();
        double totalProbability = 0.0;

        // Loop through each dice side (from 1 to 6) to generate random probabilities
        for (int diceSide = 1; diceSide <= 6; diceSide++) {
            double randomSideProbability = random.nextDouble();
            totalProbability += randomSideProbability;
            this.diceProbability.put(diceSide, randomSideProbability);
            this.sideOccurrences.put(diceSide, 0); // Initialize side occurrences to 0
        }

        // Calculates relative probabilities and store them as percentages in diceProbability
        for(Integer diceSide : diceProbability.keySet()){
            double sideProbability = (diceProbability.get(diceSide) / totalProbability) * 100;
            diceProbability.put(diceSide, sideProbability);
        }
    }

    // Method to simulate rolling a dice for a specified number of times
    // and return the occurrences of each dice side to controller
    public HashMap<Integer, Integer> rollDice(int maxRollCount) {
        Random random = new Random();
        double totalProbability = diceProbability.values().stream().mapToDouble(Double::doubleValue).sum();

        // Simulate rolling the dice 'maxRollCount' times
        for(int rollCount = 1; rollCount <= maxRollCount; rollCount++) {
            double randomValue = random.nextDouble() * 100;
            double cumulativeProbability = 0.0;

            // Determine which dice side corresponds to the random value rolled
            for (Integer key : this.diceProbability.keySet()) {
                cumulativeProbability += this.diceProbability.get(key);
                if (randomValue <= cumulativeProbability) {
                    // Increment the occurrence count for the selected dice side
                    sideOccurrences.put(key, sideOccurrences.getOrDefault(key, 0) + 1);
                    break;
                }
            }
        }
        // Return the HashMap containing the occurrences of each dice side after rolling
        return this.sideOccurrences;
    }
}