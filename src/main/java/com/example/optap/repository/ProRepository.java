package com.example.optap.repository;

import com.example.optap.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProRepository extends JpaRepository<Product, Integer> {
}
