package mx.edu.utez.aweb.pokeapp.service.pokemon;

import mx.edu.utez.aweb.pokeapp.model.pokemon.BeanPokemon;
import mx.edu.utez.aweb.pokeapp.model.pokemon.DaoPokemon;

import java.util.List;

public class ServicePokemon {
    DaoPokemon daoPokemon = new DaoPokemon();

    public List<BeanPokemon> getAll(){
        return daoPokemon.findAll();
    }
}
