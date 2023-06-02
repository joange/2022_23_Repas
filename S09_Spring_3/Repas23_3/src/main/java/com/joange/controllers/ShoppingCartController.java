package com.joange.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joange.DTO.ProductDTO;
import com.joange.model.People;
import com.joange.model.Product;
import com.joange.model.ShoppingCart;
import com.joange.service.PeopleService;
import com.joange.service.ProductService;
import com.joange.service.ShoppingCartService;

@RestController
@RequestMapping("shoppingCart")
public class ShoppingCartController {

	private static final Logger myLog=LoggerFactory.getLogger(ShoppingCartController.class);


	@Autowired
	ShoppingCartService shoppingCartService;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping
	public ResponseEntity<?> getAllShoppings(){
		List<ShoppingCart> shops=shoppingCartService.listAllShoppingCarts();
		if (shops.isEmpty())
			return new ResponseEntity<>("Sin carritos en la base de datos",HttpStatus.OK);
		else
			return new ResponseEntity<>(shops,HttpStatus.OK);

	}
	
	@GetMapping("/{idCart}/")
	public ResponseEntity<?> getShopping(@PathVariable Long idCart){
		ShoppingCart shop=shoppingCartService.getShoppingCartById(idCart);
		if (shop==null)
			return new ResponseEntity<>("Sin compra en la base de datos",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(shop,HttpStatus.OK);

	}
	
	
	
	
	
	
	
	
	
	@PostMapping()
	public ResponseEntity<ShoppingCart> newProduct(@RequestBody ShoppingCart shoppingCart) {
		ShoppingCart newShoppingCart=shoppingCartService.saveShoppingCart(shoppingCart);
		return new ResponseEntity<>(newShoppingCart,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Añadimos/modificamos el propietario de la compra
	 * @param idCart La lista de la compra
	 * @param idCliente El cliente
	 * @return La lista de la compra modificada
	 */
	@PutMapping("/{idCart}/people/{idPeople}/")
	public ResponseEntity<?> addPeopletoShoppingCart(
			@PathVariable Long idCart,
			@PathVariable Long idPeople){
		
		ShoppingCart shoppingCart=shoppingCartService.addPeopleToShoppingCart(idCart, idPeople);
		
		if (shoppingCart==null)
			return new ResponseEntity<>("Neither cart or people is incorrect" ,HttpStatus.NOT_FOUND);
			
		return new ResponseEntity<>(shoppingCart,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PutMapping("/{idCart}/product/{idProduct}/")
	public ResponseEntity<?> addProducttoShoppingCart(
			@PathVariable Long idCart,
			@PathVariable Long idProduct){
		
		ShoppingCart shoppingCart=shoppingCartService.addProductToShoppingCart(idCart, idProduct);
		
		if (shoppingCart==null)
			return new ResponseEntity<>("Neither cart or product is incorrect" ,HttpStatus.NOT_FOUND);
			
		return new ResponseEntity<>(shoppingCart,HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/{idCart}/product/{idProduct}/")
	public ResponseEntity<?> delProducttoShoppingCart(
			@PathVariable Long idCart,
			@PathVariable Long idProduct){
		
		ShoppingCart shoppingCart=shoppingCartService.delProductToShoppingCart(idCart, idProduct);
		
		if (shoppingCart==null)
			return new ResponseEntity<>("Neither cart or product is incorrect" ,HttpStatus.NOT_FOUND);
			
		return new ResponseEntity<>(shoppingCart,HttpStatus.OK);
		
		
	}
}
