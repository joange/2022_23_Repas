/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author joange
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="Direccion")
public class Direccion implements Serializable  {
 
    
    private static long SerialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @Column(name="calle")
    private String calle;
 
    @Column(name="numero")
    private int numero;
    
    @Column(name="poblacion")
    private String poblacion;
 
    @Column(name="provincia")
    private String provincia;

    public Direccion(String calle, int numero, String poblacion, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.poblacion = poblacion;
        this.provincia = provincia;
    }

  
    
    

}