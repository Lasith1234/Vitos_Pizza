package online_web_app.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import online_web_app.model.dtos.OrderDTO;
import online_web_app.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Valid
@Slf4j
public class OrderController {

    private final OrderService orderService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO makeOrder(@Valid @RequestBody OrderDTO orderDTO) {
        return orderService.makeOrder(orderDTO);
    }
}
