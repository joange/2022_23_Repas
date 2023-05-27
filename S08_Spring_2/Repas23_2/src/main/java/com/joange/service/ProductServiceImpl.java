package com.joange.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joange.DTO.ProductDTO;
import com.joange.model.Product;
import com.joange.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	

	@Autowired
	private ProductRepository productRepository;

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public ProductDTO saveProduct(ProductDTO productoDTO) {
		Product product=ProductDTO.fromDTO2Model(productoDTO);
		Product newProduct =productRepository.save(product);
		return productoDTO.fromModel2DTO(newProduct);
	}
	

	@Override
	public ProductDTO getProductById(Long id) {
		Optional<Product> product=productRepository.findById(id);
		if(product.isPresent())
			return ProductDTO.fromModel2DTO(product.get());
		else
			return null;
	}
	

	@Override
	public List<ProductDTO> listAllProducts() {
		List<Product> losProductos= productRepository.findAll();
		return ProductDTO.fromModel2DTO(losProductos);
	}
	

	@Override
	public void deleteProduct(Long id) {
			productRepository.deleteById(id);
		
	}

	@Override
	public ProductDTO updateProduct(ProductDTO newProduct) {
		Optional<Product> optOldProduct=productRepository.findById(newProduct.getId());
		Product oldProduct=optOldProduct.get();
		
		// update the product
		oldProduct.setCategory(newProduct.getCategory());
		oldProduct.setCreationDate(newProduct.getCreationDate());
		oldProduct.setDescription(newProduct.getDescription());
		oldProduct.setName(newProduct.getName());
		oldProduct.setPrice(newProduct.getPrice());
		
		return ProductDTO.fromModel2DTO(productRepository.save(oldProduct));
		
	}

}
