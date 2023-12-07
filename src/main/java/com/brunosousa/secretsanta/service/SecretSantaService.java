package com.brunosousa.secretsanta.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecretSantaService {

    public String draw() {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Helen", "Igor", "Jack");

        Collections.shuffle(names);
        System.out.println(names);

        String result = String.join(" -> ", names);

        return result;
    }
}
