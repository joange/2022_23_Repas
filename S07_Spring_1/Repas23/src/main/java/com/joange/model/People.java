package com.joange.model;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @ToString
@Entity
@Table(name = "people")
public class People {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPeople;
	
	@Column(nullable=false,length = 50)
	private String name;
	
	@Column
	private int age;

	public People(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	
}
