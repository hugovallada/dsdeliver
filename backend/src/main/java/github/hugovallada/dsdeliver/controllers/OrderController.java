package github.hugovallada.dsdeliver.controllers;

import github.hugovallada.dsdeliver.dtos.OrderDto;
import github.hugovallada.dsdeliver.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAll(){
        var orders = service.findAll();
        return ResponseEntity.ok().body(orders);
    }
}
