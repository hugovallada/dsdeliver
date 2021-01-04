package github.hugovallada.dsdeliver.controllers;

import github.hugovallada.dsdeliver.dtos.OrderDto;
import github.hugovallada.dsdeliver.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<OrderDto> insert(@RequestBody OrderDto orderDto){
        var savedOrderDto = service.insert(orderDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedOrderDto.getId()).toUri();
        return ResponseEntity.created(uri).body(savedOrderDto);
    }
}
