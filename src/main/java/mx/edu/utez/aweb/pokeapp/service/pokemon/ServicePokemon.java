package mx.edu.utez.aweb.pokeapp.service.pokemon;

import mx.edu.utez.aweb.pokeapp.model.pokemon.BeanPokemon;
import mx.edu.utez.aweb.pokeapp.model.pokemon.DaoPokemon;
import mx.edu.utez.aweb.pokeapp.utils.resultAction;

import java.util.List;

public class ServicePokemon {
    DaoPokemon daoPokemon = new DaoPokemon();

    public List<BeanPokemon> getAll(){
        return daoPokemon.findAll();
    }
    public resultAction save(BeanPokemon pokemon){
        resultAction result = new resultAction();
        if (daoPokemon.save(pokemon)){
            result.setResult(true);
            result.setMessage("Pokemon registrado correctamente");
            result.setStatus(200);
        }else{
            result.setResult(false);
            result.setMessage("Ocurrio un error al registrar");
            result.setStatus(400);
        }
        return result;
    }
}
