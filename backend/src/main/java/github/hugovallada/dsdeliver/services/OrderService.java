package github.hugovallada.dsdeliver.services;

import github.hugovallada.dsdeliver.dtos.OrderDto;
import github.hugovallada.dsdeliver.entities.Order;
import github.hugovallada.dsdeliver.entities.OrderStatus;
import github.hugovallada.dsdeliver.repositories.OrderRepository;
import github.hugovallada.dsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;


import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDto> findAll() {
        //var orders = repository.findAllByStatusOrderByMomentAsc(OrderStatus.PENDING);
        var orders = repository.findOrdersWithProducts();
        return orders.stream().map(order -> new OrderDto(order)).collect(Collectors.toList());
    }

    @Transactional
    public OrderDto insert(OrderDto orderDto) {
        var order = new Order(
                null,
                orderDto.getAddress(),
                orderDto.getLatitude(),
                orderDto.getLongitude(),
                Instant.now(),
                orderDto.getStatus());

        for (var productDto : orderDto.getProducts()) {
            var product = productRepository.getOne(productDto.getId());
            order.getProducts().add(product);
        }

        var savedOrder = repository.save(order);
        return new OrderDto(savedOrder);
    }

    @Transactional
    public  OrderDto setDelivered(Long id){
        var order = repository.getOne(id);
        order.setStatus(OrderStatus.DELIVERED);
        var updatedOrder = repository.save(order);

        return new OrderDto(updatedOrder);
    }
}
