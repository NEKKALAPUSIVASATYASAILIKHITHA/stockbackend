package com.example.stock_portfolio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SRepository extends JpaRepository<Model, Long> {
}
