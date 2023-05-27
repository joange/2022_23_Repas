package com.joange.service;

import java.util.List;
import com.joange.DTO.ProductDTO;

public interface ProductService {
	ProductDTO saveProduct(ProductDTO productoDTO);
	ProductDTO updateProduct(ProductDTO productoDTO);
	ProductDTO getProductById(Long id);
	List<ProductDTO> listAllProducts();
	void deleteProduct(Long id);
}
