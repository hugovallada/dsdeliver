package github.hugovallada.dsdeliver.services;

import github.hugovallada.dsdeliver.dtos.ProductDTO;
import github.hugovallada.dsdeliver.entities.Product;
import github.hugovallada.dsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true) // readonly não faz o lock de escrita no banco... trabalha com transações
    public List<ProductDTO> findAll(){
        var products = repository.findAll();
        return products.stream().map(product -> new ProductDTO(product)).collect(Collectors.toList());
    }
}
