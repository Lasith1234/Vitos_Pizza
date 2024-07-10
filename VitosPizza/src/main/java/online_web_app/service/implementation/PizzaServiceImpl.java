package online_web_app.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online_web_app.model.Pizza;
import online_web_app.repository.PizzaRepo;
import online_web_app.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepo pizzaRepo;

    @Override
    public void addPizza(Pizza p) {
        pizzaRepo.save(p);
        log.info("Pizza saved");
    }

    @Override
    public void updatePizza(Pizza p, Integer id) {
        if (pizzaRepo.existsById(id)) {
            p.setId(id);
            pizzaRepo.save(p);
            log.info("Pizza Updated");
        } else {
            log.info("Pizza not found to be updated");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such pizza found to be updated!");
        }
    }

    @Override
    public void deletePizza(Integer id) {
        pizzaRepo.deleteById(id);
        log.info("Pizza deleted");
    }

    @Override
    public Pizza getPizza(Integer id) {
        return pizzaRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza Not Found"));
    }

    @Override
    public List<Pizza> getAllPizzas() {
        return pizzaRepo.findAll();
    }
}
