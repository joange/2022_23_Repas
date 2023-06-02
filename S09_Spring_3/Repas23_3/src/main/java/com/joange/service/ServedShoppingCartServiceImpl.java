package com.joange.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.joange.DTO.ProductDTO;
import com.joange.model.People;
import com.joange.model.ShoppingCart;
import com.joange.model.Product;
import com.joange.model.ServedShoppingCart;

import com.joange.repository.ServedShoppingCartRepository;
import com.joange.repository.ShoppingCartRepository;

@Service
public class ServedShoppingCartServiceImpl implements ServedShoppingCartService {

	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	ServedShoppingCartRepository servedShoppingCartRepository;
	


	@Override
	public ServedShoppingCart saveServedShoppingCart(Long id) {
		
		ServedShoppingCart newServedShoppingCart=null;

		// per veure si existeix la compra a pagar
		ShoppingCart shoppingCart=shoppingCartRepository.findById(id).orElse(null);
		
		//per veure que no ha estat ja pagada
		ServedShoppingCart old=servedShoppingCartRepository.getByShoppingCartID(id);
		
		if(old != null) {
			System.out.println("Ja existeix");
			return null;
		}
		
		if (shoppingCart==null)
			return null;
		else {
			newServedShoppingCart=new ServedShoppingCart();
			newServedShoppingCart.setShoppingCart(shoppingCart);
			double total=0.0;
			for (Product p : shoppingCart.getProducts()) {
				total+=p.getPrice();
			}
			newServedShoppingCart.setTotal(total);
			newServedShoppingCart.setPaid(false);
			ServedShoppingCart newShopping =servedShoppingCartRepository.save(newServedShoppingCart);
			return newShopping;
		}

	}

	@Override
	public ServedShoppingCart updateServedShoppingCart(ServedShoppingCart servedShoppingCart) {
		return servedShoppingCartRepository.save(servedShoppingCart);
	}

	@Override
	public ServedShoppingCart getServedShoppingCartById(Long id) {
		return servedShoppingCartRepository.findById(id).orElse(null);
	}
	
	@Override
	public ServedShoppingCart getByIDShoppingCart(Long id) {
		return servedShoppingCartRepository.getByShoppingCartID(id);
	}

	@Override
	public List<ServedShoppingCart> listAllServedShoppingCarts() {
		return servedShoppingCartRepository.findAll();
	}

	@Override
	public void deleteServedShoppingCart(Long id) {
		// TODO Auto-generated method stub
		
	}

	


	
}
