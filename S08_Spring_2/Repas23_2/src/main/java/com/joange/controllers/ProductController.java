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
import com.joange.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("products")
public class ProductController {
	
	
	
	
	
	private static final Logger myLog=LoggerFactory.getLogger(ProductController.class);
	 
	@Autowired
	private ProductService productService;

	
	@PostMapping()
	public ResponseEntity<ProductDTO> newProduct(@RequestBody ProductDTO productDTO) {
		myLog.info("Petició <POST product> rebuda");
		ProductDTO newProduct=productService.saveProduct(productDTO);
		myLog.info(newProduct.toString());
		return new ResponseEntity<>(newProduct,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{id}/")
	public ResponseEntity<?> getProduct(@PathVariable Long id){
		ProductDTO productoDTO=productService.getProductById(id);
		
		if (productoDTO == null)
			return new ResponseEntity<>("El producto con ID="+id+" no existe",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(productoDTO,HttpStatus.OK);

	}
	
	

	
	
	@PutMapping()
	public ResponseEntity<?> updateProduct(@RequestBody ProductDTO productDTO) {
		ProductDTO oldProduct=productService.getProductById(productDTO.getId());
		if (oldProduct==null) {
			return new ResponseEntity<>("Este producto no existe",HttpStatus.NOT_FOUND);
		}
		else {
			ProductDTO newProduct=productService.updateProduct(productDTO);
			return new ResponseEntity<>(newProduct,HttpStatus.OK);
		}
	}
	
	/**
	 * 
	 * @param productDTO
	 * @return Versió que em genera dubtes ja que l'objecte que passem,
	 * encara que te els mateixos continguts, és distint. Insereix o actualitza
	 * Sembla que així ho insereix
	 */
	/*
	@PutMapping()
	public ResponseEntity<?> updateProduct(@RequestBody ProductDTO productDTO) {
		ProductDTO oldProduct=productService.getProductById(productDTO.getId());
		if (oldProduct==null) {
			return new ResponseEntity<>("Este producto no existe",HttpStatus.NOT_FOUND);
		}
		else {
			ProductDTO newProduct=productService.saveProduct(productDTO);
			return new ResponseEntity<>(newProduct,HttpStatus.OK);
		}
	}
	*/
	
	@GetMapping
	public ResponseEntity<?> getAllProducts(){
		List<ProductDTO> productos=productService.listAllProducts();
		
		if (productos.isEmpty())
			return new ResponseEntity<>("Sin productos en la base de datos",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(productos,HttpStatus.OK);

	}
	
	
	
	@DeleteMapping("/{id}/")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id){
		ProductDTO productoDTO=productService.getProductById(id);
		if (productoDTO == null)
			return new ResponseEntity<>("Sin productos en la base de datos",HttpStatus.NOT_FOUND);
		else {
			productService.deleteProduct(id);
			return new ResponseEntity<>(productoDTO,HttpStatus.OK);
		}		
	}

}
