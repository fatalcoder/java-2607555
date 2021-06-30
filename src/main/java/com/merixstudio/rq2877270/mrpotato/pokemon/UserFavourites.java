package com.merixstudio.rq2877270.mrpotato.pokemon;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class UserFavourites {
    private @Id Long userId;
    private Long pokemonId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(Long pokemonId) {
        this.pokemonId = pokemonId;
    }

    @Override
    public boolean equals(Object o) {
        UserFavourites that = (UserFavourites) o;
        return Objects.equals(pokemonId, that.pokemonId);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
