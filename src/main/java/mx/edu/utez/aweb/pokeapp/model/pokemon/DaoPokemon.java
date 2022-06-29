package mx.edu.utez.aweb.pokeapp.model.pokemon;

import mx.edu.utez.aweb.pokeapp.utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoPokemon {
    Connection conn;
    PreparedStatement pstm;
    CallableStatement cstm;
    ResultSet rs;
    public List<BeanPokemon> findAll(){
        List<BeanPokemon> pokemons = new ArrayList<>();
        BeanPokemon pokemon = null;
        try {
            conn = new MySQLConnection().getConnection();
            String query = "SELECT * FROM pokemons;";
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()){
                pokemon = new BeanPokemon();
                pokemon.setId(rs.getLong("id"));
                pokemon.setName(rs.getString("name"));
                pokemon.setPokemonType(rs.getString("type"));
                pokemon.setHealth(rs.getDouble("health"));
                pokemon.setHeight(rs.getDouble("height"));
                pokemon.setPower(rs.getDouble("power"));
                pokemon.setWeight(rs.getDouble("weight"));
                pokemons.add(pokemon);
            }
        }catch (SQLException e){

        }
        return pokemons;
    }
}