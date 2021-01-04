package github.hugovallada.dsdeliver.dtos;

import github.hugovallada.dsdeliver.entities.Order;
import github.hugovallada.dsdeliver.entities.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class OrderDto implements Serializable {

    @Setter
    private Long id;

    @Setter
    private String address;

    @Setter
    private Double latitude;

    @Setter
    private Double longitude;

    @Setter
    private Instant moment;

    @Setter
    private OrderStatus status;

    private List<ProductDTO> products = new ArrayList<>();

    public OrderDto(Long id,String address, Double latitude, Double longitude, Instant moment, OrderStatus status) {
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.moment = moment;
        this.status = status;
    }

    public OrderDto(Order order){
        id = order.getId();
        address = order.getAddress();
        latitude = order.getLatitude();
        longitude = order.getLongitude();
        moment = order.getMoment();
        status = order.getStatus();
        products = order.getProducts().stream()
                .map(ProductDTO::new).collect(Collectors.toList());
    }
}
