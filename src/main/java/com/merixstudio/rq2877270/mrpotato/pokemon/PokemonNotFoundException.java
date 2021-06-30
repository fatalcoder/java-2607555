package com.merixstudio.rq2877270.mrpotato.pokemon;

public class PokemonNotFoundException extends RuntimeException {

    PokemonNotFoundException(Long id) {
        super("Pokemon with " + id + " not found");
    }
}
