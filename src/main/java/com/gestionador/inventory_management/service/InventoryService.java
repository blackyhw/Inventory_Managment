package com.gestionador.inventory_management.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestionador.inventory_management.model.Product;
import com.gestionador.inventory_management.model.dtos.ProductDto;
import com.gestionador.inventory_management.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final ObjectMapper mapper;

    public Product save(ProductDto product){
        return inventoryRepository.save(mapper.convertValue(product,Product.class));
    }

    public List<Product> getAllProducts(){
        return inventoryRepository.findAll();
    }

    public Product findById(Long id){
        return inventoryRepository.findById(id).orElse(null);


    }
}
