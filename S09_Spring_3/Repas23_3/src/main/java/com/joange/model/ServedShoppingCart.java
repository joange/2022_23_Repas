package com.joange.model;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name = "servedShoppingCart")
public class ServedShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private double total;

	@Column
	private boolean paid;

	@Column(name = "creation_date")
	@CreationTimestamp
	private LocalDateTime creationDate;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_shopping", referencedColumnName = "id", unique = true)
	private ShoppingCart shoppingCart;
}
