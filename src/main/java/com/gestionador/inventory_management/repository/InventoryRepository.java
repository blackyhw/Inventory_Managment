package com.gestionador.inventory_management.repository;

import com.gestionador.inventory_management.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Product,Long> {
}
