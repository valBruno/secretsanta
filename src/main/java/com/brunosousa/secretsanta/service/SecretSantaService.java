package com.brunosousa.secretsanta.service;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class SecretSantaService {

    public String draw(List<String> names) {

        Collections.shuffle(names);
        System.out.println(names);

        String result = String.join(" -> ", names);

        return result;
    }
}
