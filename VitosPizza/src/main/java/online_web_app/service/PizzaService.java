package online_web_app.service;

import online_web_app.model.Pizza;

import java.util.List;


public interface PizzaService {
    void addPizza(Pizza p);
    void updatePizza(Pizza p, Integer id);
    void deletePizza(Integer id);
    Pizza getPizza(Integer id);
    List<Pizza> getAllPizzas();
}
