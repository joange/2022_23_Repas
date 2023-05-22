/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author joange
 */
@Data@NoArgsConstructor@ToString
@Entity
@Table(name="Armas")
public class Arma implements Serializable {

        private static final long SerialVersionUID=1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idArma")
	private Long idArma;
	
	@Column
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="danyo")
	private int danyo;
        
	// Anota una relación N-M entre dos tablas e indica cual es la tabla que mantiene la relación
	// y los campos que relacionan las dos tablas
	// Se utiliza un interfaz List para la colección pero sería más adecuado utilizar el interfaz Set
	// puesto que los datos no están ordenados
	@ManyToMany(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY, mappedBy = "armas")
	// Cuando se elimine un arma se desvinculará de su personaje pero éste no se eliminará
        @ToString.Exclude
	private List<Enemigo> enemigos=new ArrayList<>();
	
	public Arma(String nombre, String descripcion, int danyo) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.danyo = danyo;
	}
}