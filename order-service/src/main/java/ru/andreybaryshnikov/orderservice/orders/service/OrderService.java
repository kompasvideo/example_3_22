package ru.andreybaryshnikov.orderservice.orders.service;

import ru.andreybaryshnikov.orderservice.orders.model.dto.OrderDto;
import ru.andreybaryshnikov.orderservice.orders.model.Order;

import java.util.UUID;

public interface OrderService {
    Order create(OrderDto orderRequest);

    Order getToId(UUID uuid);
}
