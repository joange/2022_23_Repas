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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author joange
 */
@Data@NoArgsConstructor@ToString
@Entity
@Table(name="Enemigos")
public class Enemigo implements Serializable {

        private static long SerialVersionUID=1L;
        
	@Id					// Marca el campo como la clave de la tabla
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idEnemigo")  // Opcional si coinciden atributo y columna. 
        // Indica la columna de la tabla que corresponde con este atributo
	private int idEnemigo;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="vida")
	private int vida;
	
	@Column(name="puntos")
	private int puntos;
	
        
        
        
        
        
        
        
        
	// Anota una relación N-M entre dos tablas e indica el atributo (de la otra clase)
	// que ha definido los parámetros de la relación
	// Se utiliza un interfaz List para la colección pero sería más adecuado utilizar el interfaz Set
	// puesto que los datos no están ordenados
	@ManyToMany(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)		// Cuando se elimine un personaje se desvínculará el arma pero ésta no se borrará
	@JoinTable(name="EnemigoLlevaArma", 
		joinColumns={@JoinColumn(name="id_enemigo")}, 
                inverseJoinColumns={@JoinColumn(name="id_arma")})
        
	private Set<Arma> armas= new HashSet<Arma>();;
	
	
	public Enemigo(String nombre, int vida, int puntos) {
		this.nombre = nombre;
		this.vida = vida;
		this.puntos = puntos;
		this.armas = new HashSet<Arma>();
	}
	
}