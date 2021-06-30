package com.merixstudio.rq2877270.mrpotato.pokemon;

public class UserFavouriteNotFoundException extends RuntimeException {

    UserFavouriteNotFoundException(Long id) {
        super("Pokemon with " + id + " not found");
    }
}
