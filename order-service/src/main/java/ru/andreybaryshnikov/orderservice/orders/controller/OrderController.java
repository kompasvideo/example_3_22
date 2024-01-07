package ru.andreybaryshnikov.orderservice.orders.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.andreybaryshnikov.orderservice.orders.exception.UnauthorizedException;
import ru.andreybaryshnikov.orderservice.orders.model.Order;
import ru.andreybaryshnikov.orderservice.orders.model.dto.OrderDto;
import ru.andreybaryshnikov.orderservice.orders.service.OrderService;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @GetMapping
    public Order get(@RequestParam UUID uuid, HttpServletRequest request) {
        String xUserId = request.getHeader("X-UserId");
        if (xUserId == null)
            throw new UnauthorizedException();
        return orderService.getToId( uuid);
    }

    @PostMapping
    public Order create(@RequestBody OrderDto orderRequest, HttpServletRequest request) {
        String xUserId = request.getHeader("X-UserId");
        if (xUserId == null)
            throw new UnauthorizedException();
        return orderService.create(orderRequest);
    }
}
