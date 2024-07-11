package online_web_app.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online_web_app.model.Pizza;
import online_web_app.model.dtos.PizzaDTO;
import online_web_app.service.PizzaService;
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
    Pizza createPizza(@Valid @RequestBody PizzaDTO pizzaDTO) {
        return pizzaService.addPizza(pizzaDTO);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    Pizza updatePizza(@Valid @RequestBody PizzaDTO pizzaDTO, @PathVariable String id) {
        return pizzaService.updatePizza(pizzaDTO, id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletePizza(@PathVariable String id) {
        pizzaService.deletePizza(id);
    }

    @GetMapping("/{id}")
    Pizza findPizzaById(@PathVariable String id) {
        return pizzaService.getPizza(id);
    }

    @GetMapping("")
    List<Pizza> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }
}
