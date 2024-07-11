package online_web_app.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online_web_app.model.Pizza;
import online_web_app.model.dtos.PizzaDTO;
import online_web_app.repository.PizzaRepo;
import online_web_app.service.PizzaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PizzaServiceImpl implements PizzaService {

    private final PizzaRepo pizzaRepo;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Pizza addPizza(PizzaDTO pizzaDTO) {

        Pizza newPizza = modelMapper.map(pizzaDTO, Pizza.class);
        pizzaRepo.save(newPizza);
        log.info("Pizza saved");
        return newPizza;
    }

    @Override
    public Pizza updatePizza(PizzaDTO pizzaDTO, String id) {

        ResponseEntity<Pizza> responseEntity;

        Optional<Pizza> optionalPizza =  pizzaRepo.findById(id);
        if (optionalPizza.isPresent()) {
            Pizza updatedPizza = modelMapper.map(pizzaDTO, Pizza.class);
            updatedPizza.setId(id);
            pizzaRepo.save(updatedPizza);
            log.info("Pizza Updated");
//            responseEntity = new ResponseEntity<>(pizza,HttpStatus.NOT_FOUND);
            return updatedPizza;

        }else {
            responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pizza not found");
        }
    }

    @Override
    public void deletePizza(String id) {
        pizzaRepo.deleteById(id);
        log.info("Pizza deleted");
    }

    @Override
    public Pizza getPizza(String id) {
        return pizzaRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pizza Not Found"));
    }

    @Override
    public List<Pizza> getAllPizzas() {
        return pizzaRepo.findAll();
    }
}
