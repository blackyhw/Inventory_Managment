package com.gestionador.inventory_management.service;

import com.gestionador.inventory_management.model.Product;
import com.gestionador.inventory_management.model.dtos.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    public Product updateProduct(Product productIn, ProductDto productOut){
        productIn.setName(productOut.getName());
        productIn.setDescription(productOut.getDescription());
        productIn.setQuantity(productOut.getQuantity());
        productIn.setPrice(productOut.getPrice());
        return productIn;
    }
}
