package Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Table(name = "Clase")
@Data@NoArgsConstructor@ToString
public class Clase implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClase;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "pais")
    private String pais;

    @Column(name = "numArmas")
    private int numArmas;
    
    @Column(name = "quilla")
    private int quilla;


    @Column(name = "desplazamiento")
    private int desplazamiento;

    @OneToMany(
            mappedBy = "laClase",
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @ToString.Exclude
    private Set<Barco> losBarcos= new HashSet<>();

   
    public void addBarcos(Barco b) {
        this.losBarcos.add(b);
    }

    public void mostrarBarcos() {
        if (losBarcos.isEmpty()) {
            System.out.println("\tEsta clase no tiene barcos" );
        } else {
            System.out.println("\tEsta clase tiene estos barcos:" );
            for (Barco b : losBarcos) {
                System.out.printf("%-1s %-25s %-1s %-25s%n", "\t\tNombre: ", b.getNombre(), "\tAño: ",  b.getLanzamiento() );
            }
        }
    }
/*
    @Override
    public String toString() {
        return String.format("%-5s %-25s %-5s %-10s %-5s %-25s",
                idClase,
                nombre,
                pais,
                numArmas,
                quilla,
                desplazamiento);
    }
*/
    public Clase(String nombre, String pais, int numArmas, int quilla, int desplazamiento) {
        this.nombre = nombre;
        this.pais = pais;
        this.numArmas = numArmas;
        this.quilla = quilla;
        this.desplazamiento = desplazamiento;
    }


}

