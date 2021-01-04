package github.hugovallada.dsdeliver.entities;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product implements Serializable {

    @EqualsAndHashCode.Include
    private Long id;

    private String name;

    private Double price;

    private String description;

    private String imageUri;



}
