package com.telefonica.jee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telefonica.jee.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
