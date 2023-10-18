package com.onlinesales.ai.assignment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class MathExpressionService {

    @Autowired
    RestTemplate restTemplate;

    public List<CompletableFuture<String>> evaluateExpression(List<String> expressions) {
        return expressions.stream()
                .map(expression -> CompletableFuture.supplyAsync(() ->
                        restTemplate.getForObject("https://api.mathjs.org/v4/?expr=" + expression, String.class)
                ))
                .collect(Collectors.toList());
    }
}

