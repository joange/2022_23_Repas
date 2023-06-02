package com.joange.service;

import java.util.List;

import com.joange.model.ShoppingCart;

public interface ShoppingCartService {
	ShoppingCart saveShoppingCart(ShoppingCart shoppingCart);
	ShoppingCart updateShoppingCart(ShoppingCart shoppingCart);
	ShoppingCart getShoppingCartById(Long id);
	List<ShoppingCart> listAllShoppingCarts();
	void deleteShoppingCart(Long id);
	
	ShoppingCart addPeopleToShoppingCart(Long idCart,Long idPeople);
	ShoppingCart addProductToShoppingCart(Long idCart,Long idProduct);
	ShoppingCart delProductToShoppingCart(Long idCart,Long idProduct);
}
