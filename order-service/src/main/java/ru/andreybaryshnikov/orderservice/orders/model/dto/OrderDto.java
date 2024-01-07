package ru.andreybaryshnikov.orderservice.orders.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class OrderDto {
    private UUID id;
    private String name;
    private String count;
    private double price;
}
