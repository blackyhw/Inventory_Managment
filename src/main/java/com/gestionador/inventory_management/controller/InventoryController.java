package com.gestionador.inventory_management.controller;

import com.gestionador.inventory_management.model.Product;
import com.gestionador.inventory_management.model.dtos.ProductDto;
import com.gestionador.inventory_management.service.InventoryService;
import com.gestionador.inventory_management.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final ProductService productService;

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
        product = productService.updateProduct(product,productDto);
        return new ResponseEntity<>(product,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void>deleteProduct(@PathVariable Long id){
        Product product = inventoryService.findById(id);
        if(product == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Producto no encontrado");
        }
        inventoryService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
