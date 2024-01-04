package ru.andreybaryshnikov.otus_3_22.orders.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.andreybaryshnikov.otus_3_22.orders.model.Order;
import ru.andreybaryshnikov.otus_3_22.orders.model.dto.OrderDto;
import ru.andreybaryshnikov.otus_3_22.orders.service.OrderService;
import ru.andreybaryshnikov.otus_3_22.users.exception.UnauthorizedException;

import javax.servlet.http.HttpServletRequest;
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
