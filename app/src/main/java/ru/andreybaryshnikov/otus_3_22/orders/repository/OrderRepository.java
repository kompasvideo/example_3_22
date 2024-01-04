package ru.andreybaryshnikov.otus_3_22.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.andreybaryshnikov.otus_3_22.orders.model.Order;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
