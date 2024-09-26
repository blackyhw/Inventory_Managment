package com.gestionador.inventory_management.controller;

import com.gestionador.inventory_management.model.Product;
import com.gestionador.inventory_management.model.dtos.ProductDto;
import com.gestionador.inventory_management.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @PostMapping("/create")
    public ResponseEntity<Product>createProduct(@RequestBody ProductDto product){
        return new ResponseEntity<>(inventoryService.save(product),HttpStatus.CREATED);
    }
    @GetMapping("/read")
    public ResponseEntity<List<Product>>getAllProducts(){
        return new ResponseEntity<>(inventoryService.getAllProducts(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product>updateProduct(@PathVariable Long id,@RequestBody ProductDto productDto){

        Product product = inventoryService.findById(id);
        if(product == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Producto no encontrado");
        }
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setQuantity(productDto.getQuantity());
        product.setPrice(productDto.getPrice());


    }


}
