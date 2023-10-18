package com.onlinesales.ai.assignment.controller;

import com.onlinesales.ai.assignment.service.MathExpressionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


@RestController
public class MathExpressionController {

    @Autowired
    MathExpressionService mathExpressionService;

    @PostMapping(value = "/api/evaluate")
    public String evaluateExpression(@RequestBody List<String> expressions) {
        StringBuilder result = new StringBuilder();
        try {
            // Evaluate expressions asynchronously and collect the results
            List<CompletableFuture<String>> futures = mathExpressionService.evaluateExpression(expressions);
            CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

            // Build the result string
            for (int i = 0; i < expressions.size(); i++) {
                String expression = expressions.get(i);
                String value = futures.get(i).get();
                result.append(expression).append(" => ").append(value).append("\n");
            }

            return result.toString();
        } catch (InterruptedException | ExecutionException e) {
            // Handle exceptions and return an error response
            return "Error occurred while evaluating expressions: " + e.getMessage();
        }
    }
}

