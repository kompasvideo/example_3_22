package ru.andreybaryshnikov.orderservice.orders.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.andreybaryshnikov.orderservice.orders.exception.BadRequestException;
import ru.andreybaryshnikov.orderservice.orders.exception.ConflictException;
import ru.andreybaryshnikov.orderservice.orders.model.dto.OrderDto;
import ru.andreybaryshnikov.orderservice.orders.repository.OrderRepository;
import ru.andreybaryshnikov.orderservice.orders.model.Order;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService{
    private final ModelMapper mapper;
    private final OrderRepository orderRepository;

    @Override
    public Order create(OrderDto orderDto) {
        Order order = mapper.map(orderDto, Order.class);
        Optional<Order> orderOptional = orderRepository.findById(order.getId());
        if (orderOptional.isPresent()) {
            throw new ConflictException();
        } else {
            return orderRepository.save(order);
        }
    }

    @Override
    public Order getToId(UUID uuid) {
        Optional<Order> orderOptional = orderRepository.findById(uuid);
        if (orderOptional.isPresent()) {
            return orderOptional.get();
        } else {
            throw new BadRequestException();
        }
    }
}
