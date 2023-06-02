package com.joange.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

import com.joange.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor@AllArgsConstructor@Data
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 137L;

	private Long id;
	private String name;
	private String description;
	private String category;
	private float price;
	private LocalDateTime creationDate;
	
	public static ProductDTO fromModel2DTO(Product product) {
		ProductDTO productDTO=new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setDescription(product.getDescription());
		productDTO.setCategory(product.getCategory());
		productDTO.setPrice(product.getPrice());
		productDTO.setCreationDate(product.getCreationDate());
		return productDTO;
	}
	
	public static Product fromDTO2Model(ProductDTO productDTO) {
		Product product=new Product();
		product.setName(productDTO.getName());
		product.setDescription(productDTO.getDescription());
		product.setCategory(productDTO.getCategory());
		product.setPrice(productDTO.getPrice());
		return product;
	}

	public static List<ProductDTO> fromModel2DTO(List<Product> productos){
		List<ProductDTO> productosDTO=new ArrayList<>();
		for (Product product : productos) {
			productosDTO.add(fromModel2DTO(product));
		}	
		return productosDTO;	
	}
}
