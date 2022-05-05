package com.estreet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estreet.models.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{

}
