package com.merixstudio.rq2877270.mrpotato.pokemon;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
//@Table(name="pokemon", schema = "public")
public class Pokemon {
    private @Id
    @GeneratedValue
    Long id;
    private String name;
    private Integer size;
    private Integer externalId;

    protected Pokemon() {
    }

    Pokemon(String name, Integer size) {
        this.name = name;
        this.size = size;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Integer getSize() {
        return this.size;
    }

    public Integer getExternalId() {
        return this.externalId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public void setExternalId(Integer externalId) {
        this.externalId = externalId;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Pokemon))
            return false;
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(this.id, pokemon.id) && Objects.equals(this.name, pokemon.name)
                && Objects.equals(this.size, pokemon.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.size);
    }

    @Override
    public String toString() {
        return "Pokemon{" + "id=" + this.id + ", name='" + this.name + '\'' + ", size='" + this.size + '\'' + '}';
    }
}
