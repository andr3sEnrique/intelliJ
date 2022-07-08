package mx.edu.utez.aweb.pokeapp.controller.pokemon;


import mx.edu.utez.aweb.pokeapp.model.pokemon.BeanPokemon;
import mx.edu.utez.aweb.pokeapp.service.pokemon.ServicePokemon;
import mx.edu.utez.aweb.pokeapp.utils.resultAction;

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
        "/create-pokemon",
        "/save-pokemon",
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
                urlRedirect = "/views/pokemon/index.jsp";
                break;
            case "/create-pokemon":
                urlRedirect = "/views/pokemon/create.jsp";
                break;
            case "/get-pokemon":
                String id = request.getParameter("id");
                id = (id == null) ? "0":id;
                try{
                    BeanPokemon pokemon = servicePokemon.getPokemon(Long.parseLong(id));
                    request.setAttribute("pokemon", pokemon);
                    urlRedirect = "/views/pokemon/update.jsp";
                }catch (Exception e){
                    urlRedirect = "/get-pokemons";
                }
                break;
            default:
                request.setAttribute("pokemons",servicePokemon.getAll());
                urlRedirect = "/get-pokemons";
                break;
        }
        request.getRequestDispatcher(urlRedirect).forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        action = request.getServletPath();
        switch (action){
            case "/add-pokemon":
                String nombre= request.getParameter("name");
                String health= request.getParameter("health");
                String power= request.getParameter("power");
                String weight= request.getParameter("weight");
                String height= request.getParameter("height");
                String type= request.getParameter("type");
                BeanPokemon pokemon = new BeanPokemon();
                pokemon.setName(nombre);
                pokemon.setHealth(Double.parseDouble(health));
                pokemon.setPower(Double.parseDouble(power));
                pokemon.setWeight(Double.parseDouble(weight));
                pokemon.setHeight(Double.parseDouble(height));
                pokemon.setPokemonType(type);
                resultAction result = servicePokemon.save(pokemon);
                urlRedirect = "/get-pokemons?result="+
                result.isResult()+"&message="+result.getMessage()
                +"&status="+result.getStatus();
                break;
            case "/save-pokemon":
                String nombre2= request.getParameter("name");
                String health2= request.getParameter("health");
                String power2= request.getParameter("power");
                String weight2= request.getParameter("weight");
                String height2= request.getParameter("height");
                String type2= request.getParameter("type");
                String id= request.getParameter("id");
                BeanPokemon pokemon2 = new BeanPokemon();
                pokemon2.setId(Long.parseLong(id));
                pokemon2.setName(nombre2);
                pokemon2.setHealth(Double.parseDouble(health2));
                pokemon2.setPower(Double.parseDouble(power2));
                pokemon2.setWeight(Double.parseDouble(weight2));
                pokemon2.setHeight(Double.parseDouble(height2));
                pokemon2.setPokemonType(type2);
                resultAction result2 = servicePokemon.update(pokemon2);
                urlRedirect = "/get-pokemons?result="+
                        result2.isResult()+"&message="+result2.getMessage()
                        +"&status="+result2.getStatus();
                break;
            default:
                urlRedirect = "/get-pokemons";
                break;

        }
        response.sendRedirect(request.getContextPath()+urlRedirect);//
    }
}
