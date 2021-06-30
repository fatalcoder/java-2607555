package com.merixstudio.rq2877270.mrpotato.pokemon;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonAPI {
    private final RestTemplate restTemplate;

    public PokemonAPI(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public PokemonDto fetchById(Long id) {
        String url = "https://pokeapi.co/api/v2/pokemon/" + id;
        return this.restTemplate.getForObject(url, PokemonDto.class);
    }
}
