package com.merixstudio.rq2877270.mrpotato.pokemon;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserFavouritesController {
    private final UserFavouritesRepository repository;

    UserFavouritesController(UserFavouritesRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/favourites")
    List<UserFavourites> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/favourites")
    UserFavourites newFavourite(@RequestBody UserFavourites newFavourite) {
        return repository.save(newFavourite);
    }

    @PostMapping("/favourites/gem")
    void generateSomeFavourites() {
        for(int i=0; i < 10; i++) {
            System.out.println("Generating favourite pairs: user " + i + " and pokemon " + 1);
            UserFavourites newFavourite = new UserFavourites();
            newFavourite.setUserId((long) i);
            newFavourite.setPokemonId((long) i);
            repository.save(newFavourite);
        }
    }

    // Single item
    @GetMapping("/favourites/{id}")
    UserFavourites one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new UserFavouriteNotFoundException(id));
    }

    @PutMapping("/favourites/{id}")
    UserFavourites replaceFavourite(@RequestBody UserFavourites newFavourite, @PathVariable Long id) {
        return repository.findById(id)
                .map(favourite -> {
                    favourite.setUserId(newFavourite.getUserId());
                    favourite.setPokemonId(newFavourite.getPokemonId());
                    return repository.save(favourite);
                })
                .orElseThrow(() -> new RuntimeException("Missing favourites for user " + id));
    }

    @DeleteMapping("/favourites/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
