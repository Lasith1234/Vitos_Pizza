package online_web_app.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online_web_app.model.Order;
import online_web_app.model.Pizza;
import online_web_app.model.dtos.OrderDTO;
import online_web_app.repository.OrderRepo;
import online_web_app.repository.PizzaRepo;
import online_web_app.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private final PizzaRepo pizzaRepo;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public OrderDTO makeOrder(OrderDTO order) {

        Order newOrder = modelMapper.map(order, Order.class);
        newOrder.setCustomerId("668f8726513c1b2f1ede5aad");
        newOrder.setOrderPlacedAt(LocalDateTime.now());

        float totCost = 0;

        for (int i = 0; i < order.getPizzaIds().size(); i++) {
            Optional<Pizza> pizza = pizzaRepo.findById(order.getPizzaIds().get(i));
            if (pizza.isPresent()) {
                totCost += pizza.get().getPizzaPrice() * order.getQuantities().get(i);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pizza not found");

            }
        }
        newOrder.setTotalPrice(totCost);

        orderRepo.save(newOrder);

        return null;
    }
}
