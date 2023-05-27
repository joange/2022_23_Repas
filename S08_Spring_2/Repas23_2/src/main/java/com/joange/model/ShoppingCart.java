package com.joange.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "shoppingCart")
public class ShoppingCart implements Serializable{

	private static final long serialVersionUID=137L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    
    @Column(name = "creation_date")
    @CreationTimestamp
    private LocalDateTime creationDate;
    
    @UpdateTimestamp
    private LocalDateTime lastUpdatedOn;
    
    
    @ManyToOne(fetch = FetchType.EAGER, 
			cascade = CascadeType.PERSIST)
    @JoinColumn(name="id_buyer",referencedColumnName = "idPeople")
	@ToString.Exclude
    private People owner;
    
    
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name="cartHasProduct", 
    	joinColumns=@JoinColumn(name="idCartHas"), 
    	inverseJoinColumns=@JoinColumn(name="idCartProduct"))
	@ToString.Exclude
    private Set<Product> products= new HashSet<>();
    
}








