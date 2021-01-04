package github.hugovallada.dsdeliver.services;

import github.hugovallada.dsdeliver.dtos.OrderDto;
import github.hugovallada.dsdeliver.entities.OrderStatus;
import github.hugovallada.dsdeliver.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<OrderDto> findAll(){
        //var orders = repository.findAllByStatusOrderByMomentAsc(OrderStatus.PENDING);
        var orders = repository.findOrdersWithProducts();
        return orders.stream().map(order -> new OrderDto(order)).collect(Collectors.toList());
    }
}
