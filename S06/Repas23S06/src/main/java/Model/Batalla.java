package Model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "Batalla")
@Data@NoArgsConstructor@ToString
public class Batalla implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBatalla")
    private Long idBatalla;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha")
    private Date fecha;

    @ToString.Exclude
    @OneToMany(mappedBy = "laBatalla",fetch = FetchType.LAZY,orphanRemoval = true,cascade={CascadeType.PERSIST})
    private Set<Participa> participaciones=new HashSet<>();


    public Batalla(String nombre, Date fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
        participaciones = new HashSet<>();
    }



    public void mostrarParticipantes() {
        if (participaciones.isEmpty()) {
            System.out.println("\tEsta batalla no tiene participantes");
        } else {
            System.out.println( "\tEsta batalla tiene estos participantes:");
            for (Participa p : participaciones) {
                System.out.println("\t\tBarco: " + p.getElBarco().getNombre() + " que quedó " + p.getResultado());
            }
        }

    }

    public void addParticipacion(Participa p) {
        if (!this.participaciones.contains(p)) {
            participaciones.add(p);
            p.setLaBatalla(this);
        } else {
            System.out.println("Esta batalla: " + this.getNombre() + " ya contiene este barco");
        }
    }
}
