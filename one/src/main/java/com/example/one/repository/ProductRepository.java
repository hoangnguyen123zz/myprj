package com.example.one.repository;

import com.example.one.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface ProductRepository extends JpaRepository<Product,Long> {
List<Product> findByproductName(String prouctName);

}
