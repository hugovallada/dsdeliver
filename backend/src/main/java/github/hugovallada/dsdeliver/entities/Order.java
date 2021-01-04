package github.hugovallada.dsdeliver.entities;

import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order implements Serializable {

    @EqualsAndHashCode.Include
    private Long id;

    @Setter
    private String address;

    @Setter
    private Double latitude;

    @Setter
    private Double longitude;

    @Setter
    private Instant moments;

    @Setter
    private OrderStatus status;

    private Set<Product> products = new HashSet<>();

    public Order(Long id, String address, Double latitude, Double longitude, Instant moments, OrderStatus status) {
        this.id = id;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.moments = moments;
        this.status = status;
    }
}
