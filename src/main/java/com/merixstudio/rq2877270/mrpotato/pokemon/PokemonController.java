package com.merixstudio.rq2877270.mrpotato.pokemon;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokemonController {
    private final PokemonRepository repository;

    PokemonController(PokemonRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/pokemons")
    List<Pokemon> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    // Single item

    @GetMapping("/pokemons/{id}")
    Pokemon one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PokemonNotFoundException(id));
    }
}
