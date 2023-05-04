/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author joange
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="Profe")
public class Profe implements Serializable{
    
    private static long SerialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String nombre;
    
    @Column(name="apellido1")
    private String ape1;
    
    @Column(name="apellido2")
    private String ape2;  
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(
    name="id_direccion",
    referencedColumnName = "id",
    unique=true,
    foreignKey = @ForeignKey(name = "FK_PROFE_DIR"))
    private Direccion direccion;

    public Profe(String nombre, String ape1, String ape2, Direccion direccion) {
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.direccion = direccion;
    }
    
     public Profe(String nombre, String ape1, String ape2) {
        this.nombre = nombre;
        this.ape1 = ape1;
        this.ape2 = ape2;
    }

   
    
    
}
