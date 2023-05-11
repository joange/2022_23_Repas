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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Data@NoArgsConstructor@ToString
@Table(name = "Barco")
public class Barco implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBarco;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "lanzamiento")
    private int lanzamiento;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idClase")
    @EqualsAndHashCode.Exclude
    private Clase laClase;


    @OneToMany(mappedBy = "elBarco",
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            cascade = CascadeType.PERSIST)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Participa> lasParticipaciones;

    
    public Barco(String nombre, int lanzamiento, Clase laClase) {
        this.nombre = nombre;
        this.lanzamiento = lanzamiento;
        this.laClase = laClase;
        this.lasParticipaciones = new HashSet<>();
    }
    
    public void mostrarParticipaciones(){
        if (lasParticipaciones.isEmpty())
            return;
        
        System.out.println("Batallas en las que ha participado:");
        for (Participa p : lasParticipaciones) {
            System.out.println("\t Batalla de " + p.getLaBatalla().getNombre() + " con resultado " + p.getResultado().toString());
        }
    }

 

}
