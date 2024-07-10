package online_web_app.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online_web_app.model.Pizza;
import online_web_app.service.PizzaService;
import online_web_app.service.implementation.PizzaServiceImpl;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizza")
@RequiredArgsConstructor
@Valid
@Slf4j
public class PizzaController {

    private final PizzaService pizzaService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    void createPizza(@Valid @RequestBody Pizza pizza) {
        log.info(pizza.getPizzaDescription());
        pizzaService.addPizza(pizza);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    void updatePizza(@Valid @RequestBody Pizza pizza, @PathVariable Integer id) {
        pizzaService.updatePizza(pizza, id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePizza(@PathVariable Integer id) {
        pizzaService.deletePizza(id);
    }

    @GetMapping("/{id}")
    Pizza findPizzaById(@PathVariable Integer id) {
        return pizzaService.getPizza(id);
    }

    @GetMapping("")
    List<Pizza> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }
}
