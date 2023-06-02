package com.joange.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.joange.model.ServedShoppingCart;

@Repository
@Transactional
public interface ServedShoppingCartRepository extends JpaRepository<ServedShoppingCart, Long>{
	
	@Query(value = "from ServedShoppingCart c where c.shoppingCart.id = :idCart")
	public ServedShoppingCart getByShoppingCartID(@Param("idCart") Long Id);

}