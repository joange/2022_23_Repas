package com.joange.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity(name = "products")
public class Product implements Serializable{
 
	private static final long serialVersionUID=137L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String name;
    
    @Column
    private String description;
    
    @Column
    private String category;
    
    @Column
    private float price;
    
    @Column(name = "creation_date")
    @CreationTimestamp
    private LocalDateTime creationDate;
}