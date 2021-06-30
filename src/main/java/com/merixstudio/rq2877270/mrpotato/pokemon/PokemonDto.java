package com.merixstudio.rq2877270.mrpotato.pokemon;

import java.util.Objects;

public class PokemonDto {
    private Long id;
    private String name;
    private Integer weight;
    private Integer height;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getSize() {
        return height * weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PokemonDto that = (PokemonDto) o;
        return id.equals(that.id) && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
