package Model;


@Entity
@Table(name = "Batalla")
public class Batalla implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBatalla")
    private Long idBatalla;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha")
    private Date fecha;

    @OneToMany(mappedBy = "laBatalla",fetch = FetchType.LAZY,orphanRemoval = true)
    @Cascade({CascadeType.SAVE_UPDATE})
    private Set<Participa> participaciones;

    public Batalla() {
        participaciones = new HashSet<>();
    }

    public Batalla(String nombre, Date fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
        participaciones = new HashSet<>();
    }

    public Long getIdBatalla() {
        return idBatalla;
    }

    public void setIdBatalla(Long idBatalla) {
        this.idBatalla = idBatalla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Set<Participa> getParticipaciones() {
        return participaciones;
    }

    public void setLosBarcos(Set<Participa> lasParticipaciones) {
        this.participaciones = lasParticipaciones;
    }

    @Override
    public String toString() {
        return String.format(ConsoleColors.GREEN_BOLD_BRIGHT
                + "%-5s %-25s %-25s",
                idBatalla,
                nombre,
                fecha + ConsoleColors.RESET
        );
    }

    public void mostrarParticipantes() {
        if (participaciones.isEmpty()) {
            System.out.println(ConsoleColors.BLUE_BOLD + "\tEsta batalla no tiene participantes" + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.BLUE_BOLD + "\tEsta batalla tiene estos participantes:" + ConsoleColors.RESET);
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
