package mx.edu.utez.aweb.pokeapp.controller.pokemon;


import mx.edu.utez.aweb.pokeapp.service.pokemon.ServicePokemon;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "ServletPokemon",
urlPatterns = {
        "/get-pokemons",
        "/add-pokemon",
        "/update-pokemon",
        "/get-pokemon"
})

public class ServletPokemon extends HttpServlet {
    Logger logger = Logger.getLogger("ServletPokemon");
    String action;
    String urlRedirect = "/get-pokemons";
    ServicePokemon servicePokemon= new ServicePokemon();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath(); //recuperar uno de los cuatro uris
        logger.log(Level.INFO, "Path-> "+action);
        switch (action){
            case "/get-pokemons":
                request.setAttribute("pokemons",servicePokemon.getAll());
                urlRedirect = "/views/pokemon/index.jsp;";
                break;
            default:
                request.setAttribute("pokemons",servicePokemon.getAll());
                urlRedirect = "/get-pokemons";
                break;
        }
    }
}
