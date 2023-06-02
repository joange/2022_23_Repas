package com.joange.service;

import java.util.List;

import com.joange.model.ServedShoppingCart;

public interface ServedShoppingCartService {
	ServedShoppingCart saveServedShoppingCart(Long id);
	ServedShoppingCart getByIDShoppingCart(Long id);
	ServedShoppingCart updateServedShoppingCart(ServedShoppingCart servedShoppingCart);
	ServedShoppingCart getServedShoppingCartById(Long id);
	List<ServedShoppingCart> listAllServedShoppingCarts();
	void deleteServedShoppingCart(Long id);
	

}
