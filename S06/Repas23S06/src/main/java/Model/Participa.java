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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



/**
 *
 * @author joange
 */

@Entity
@Table(name="Participa")
@Data@NoArgsConstructor@ToString
public class Participa {
    
    
    public static enum Resultado {
        ILESO, DAÑADO, HUNDIDO
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idParticipa")
    private Long idBatalla;
    
    
    @ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idBarco")
    private Barco elBarco;
            
    @ManyToOne(fetch=FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idBatalla")
    private Batalla laBatalla;
      
    
    
    @Column(name = "resultado",columnDefinition = "int")
    private Resultado resultado;

    
}
