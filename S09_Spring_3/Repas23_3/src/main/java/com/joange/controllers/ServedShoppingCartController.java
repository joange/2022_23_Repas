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
import com.joange.model.ServedShoppingCart;
import com.joange.model.ShoppingCart;
import com.joange.service.PeopleService;
import com.joange.service.ProductService;
import com.joange.service.ServedShoppingCartService;
import com.joange.service.ShoppingCartService;

@RestController
@RequestMapping("servedShoppingCart")
public class ServedShoppingCartController {

	private static final Logger myLog=LoggerFactory.getLogger(ServedShoppingCartController.class);

	
	@Autowired
	PeopleService peopleService;
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@Autowired
	ServedShoppingCartService servedShoppingCartService;
	

	
	@GetMapping
	public ResponseEntity<?> getAllServedShoppings(){
		List<ServedShoppingCart> shops=servedShoppingCartService.listAllServedShoppingCarts();
		if (shops.isEmpty())
			return new ResponseEntity<>("Sin carritos en la base de datos",HttpStatus.OK);
		else
			return new ResponseEntity<>(shops,HttpStatus.OK);

	}
	
	@GetMapping("/{idCart}/")
	public ResponseEntity<?> getServedShopping(@PathVariable Long idCart){
		ServedShoppingCart shop=servedShoppingCartService.getServedShoppingCartById(idCart);
		if (shop==null)
			return new ResponseEntity<>("Sin compra en la base de datos",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(shop,HttpStatus.OK);

	}
	
	/**
	 *  Serveix per a crear la informació com a que s'ha validat la compra
	 * @param idCart
	 * @return created cart
	 */
	@PostMapping("/{idCart}/")
	public ResponseEntity<?> checkOut(@PathVariable Long idCart) {
		
		ServedShoppingCart newShoppingCart=servedShoppingCartService.saveServedShoppingCart(idCart);
		if (newShoppingCart==null) {
			return new ResponseEntity<>("Sin compra en la base de datos o ya dada de alta para pagar",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(newShoppingCart,HttpStatus.OK);
	}
	
	/**
	 * Serveix per a marcar-la com a pagada
	 * @param idCart
	 * @return updated card
	 */
	@PutMapping("/{idCart}/")
	public ResponseEntity<?> pagar(@PathVariable Long idCart){
		
		ServedShoppingCart servedShopping=servedShoppingCartService.getByIDShoppingCart(idCart);
		if (servedShopping==null) {
			return new ResponseEntity<>("Aquesta compra no existeix o ha estat pagada",HttpStatus.NOT_FOUND);
		}
		else {
			servedShopping.setPaid(true);
			ServedShoppingCart modified=servedShoppingCartService.updateServedShoppingCart(servedShopping);
			return new ResponseEntity<>(modified,HttpStatus.OK);
		}
		
		
	}
	
	
}
