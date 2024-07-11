package online_web_app.service;

import online_web_app.model.Pizza;
import online_web_app.model.dtos.PizzaDTO;

import java.util.List;


public interface PizzaService {
    Pizza addPizza(PizzaDTO pizzaDTO);
    Pizza updatePizza(PizzaDTO pizzaDTO, String id);
    void deletePizza(String id);
    Pizza getPizza(String id);
    List<Pizza> getAllPizzas();
}
