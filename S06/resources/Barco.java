package Model;



@Entity
@Table(name = "Barco")
public class Barco implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBarco;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "lanzamiento")
    private int lanzamiento;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "idClase")
    private Clase laClase;


    @OneToMany(mappedBy = "elBarco",fetch = FetchType.LAZY,orphanRemoval = true)
    @Cascade({CascadeType.SAVE_UPDATE})
    private Set<Participa> lasParticipaciones;

    public Barco() {
        this.lasParticipaciones = new HashSet<>();
    }

    public Barco(String nombre, int lanzamiento, Clase laClase) {
        this.nombre = nombre;
        this.lanzamiento = lanzamiento;
        this.laClase = laClase;
        this.lasParticipaciones = new HashSet<>();
    }

 

    public Long getIdBarco() {
        return idBarco;
    }

    public void setIdBarco(Long idBarco) {
        this.idBarco = idBarco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(int lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

 

    public Clase getLaClase() {
        return laClase;
    }

    public void setLaClase(Clase laClase) {
        this.laClase = laClase;
    }

    public Set<Participa> getParticipaciones() {
        return lasParticipaciones;
    }

    public void setParticipaciones(Set<Participa> participaciones) {
        this.lasParticipaciones = participaciones;
    }

   

    @Override
    public String toString() {
        String datos=String.format(ConsoleColors.GREEN_BOLD_BRIGHT +
                        "%-5s %-25s %-25s",
                idBarco,
                nombre,
                lanzamiento); 
        
        datos +=(laClase==null?"sin clase":laClase.getNombre());
        return datos+ ConsoleColors.RESET;
        
    }

     public void addParticipacion(Participa p) {
        if (!this.lasParticipaciones.contains(p)) {
            lasParticipaciones.add(p);
            p.setElBarco(this);
        } else {
            System.out.println("Este Barco: " + this.getNombre() + " ya contiene esta Batalla");
        }
    }


    public void mostrarBatallas() {
        if (lasParticipaciones.isEmpty()) {
            System.out.println(ConsoleColors.BLUE_BOLD + "\tEste barco no ha participado en ninguna batalla." + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.BLUE_BOLD + "\tEste barco ha participado en las siguientes batallas:" + ConsoleColors.RESET);
            for (Participa p : lasParticipaciones) {
                System.out.println("\tBatalla:" + p.getLaBatalla().getNombre() + " en estado " + p.getResultado());
            }
        }


    }
}
