package ru.andreybaryshnikov.otus_3_22.orders.service;

import ru.andreybaryshnikov.otus_3_22.orders.model.Order;
import ru.andreybaryshnikov.otus_3_22.orders.model.dto.OrderDto;

import java.util.UUID;

public interface OrderService {
    Order create(OrderDto orderRequest);

    Order getToId(UUID uuid);
}
