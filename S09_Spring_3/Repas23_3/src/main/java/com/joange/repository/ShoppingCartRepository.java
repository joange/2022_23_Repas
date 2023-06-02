package com.joange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.joange.model.ShoppingCart;

@Repository
@Transactional
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long>{
}