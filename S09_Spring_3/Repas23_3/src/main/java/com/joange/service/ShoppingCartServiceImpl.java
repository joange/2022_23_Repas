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
import com.joange.repository.PeopleRepository;
import com.joange.repository.ProductRepository;
import com.joange.repository.ShoppingCartRepository;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	PeopleRepository peopleRepository;
	
	@Override
	public ShoppingCart saveShoppingCart(ShoppingCart shoppingCart) {
		ShoppingCart newShoppingCart=shoppingCartRepository.save(shoppingCart);
		return newShoppingCart;
	}

	@Override
	public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingCart getShoppingCartById(Long id) {
		Optional<ShoppingCart> shoppingCart=shoppingCartRepository.findById(id);
		if (shoppingCart.isPresent()) {
			return shoppingCart.get();
		}
		else
			return null;
	}

	@Override
	public List<ShoppingCart> listAllShoppingCarts() {
		return shoppingCartRepository.findAll();
	}

	@Override
	public void deleteShoppingCart(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ShoppingCart addPeopleToShoppingCart(Long idCart, Long idPeople) {
		
		People people=peopleRepository.findById(idPeople).orElse(null);
		ShoppingCart shoppingCart= shoppingCartRepository.findById(idCart).orElse(null);
		
		if (people==null ||shoppingCart==null ) {
			return null;
		}
		
		shoppingCart.setOwner(people);
		shoppingCartRepository.save(shoppingCart);
	
		return shoppingCart;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public ShoppingCart addProductToShoppingCart(Long idCart, Long idProduct) {
		Product product=productRepository.findById(idProduct).orElse(null);
		ShoppingCart shoppingCart= shoppingCartRepository.findById(idCart).orElse(null);
		
		if (product==null || shoppingCart==null ) {
			return null;
		}
		
		
		shoppingCart.getProducts().add(product);
		shoppingCartRepository.save(shoppingCart);
		return shoppingCart;
	}

	@Override
	public ShoppingCart delProductToShoppingCart(Long idCart, Long idProduct) {
		Product product=productRepository.findById(idProduct).orElse(null);
		ShoppingCart shoppingCart= shoppingCartRepository.findById(idCart).orElse(null);
		
		if (product==null || shoppingCart==null ) {
			return null;
		}
				
		shoppingCart.getProducts().remove(product);
		shoppingCartRepository.save(shoppingCart);
		return shoppingCart;
	}

}
