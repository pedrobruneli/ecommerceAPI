package com.estreet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estreet.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
