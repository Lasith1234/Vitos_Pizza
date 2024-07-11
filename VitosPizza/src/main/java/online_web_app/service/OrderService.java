package online_web_app.service;

import online_web_app.model.dtos.OrderDTO;

public interface OrderService {
    OrderDTO makeOrder(OrderDTO order);
}
