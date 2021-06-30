package com.merixstudio.rq2877270.mrpotato.pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PokemonController {
    @Autowired
    private final PokemonAPI pokemonAPI = null;

    private final PokemonRepository repository;

    PokemonController(PokemonRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/pokemons")
    List<Pokemon> all() {
        return repository.findAll();
    }

    @GetMapping("/pokemons/{id}")
    Pokemon one(@PathVariable Long id) {
        Optional<Pokemon> item = repository.findById(id);

        if (item.isPresent()) {
            return item.get();
        } else {
            PokemonDto pokemon = pokemonAPI.fetchById(id);

            Pokemon imported = new Pokemon(pokemon.getName(), pokemon.getSize());
            imported.setId(pokemon.getId());

            repository.save(imported);

            return imported;
        }
    }
}
