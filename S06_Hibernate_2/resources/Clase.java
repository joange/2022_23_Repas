package Model;


@Entity
@Table(name = "Clase")
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
            fetch = FetchType.EAGER,
            orphanRemoval = true)
    private Set<Barco> losBarcos;

    public Clase() {
        this.losBarcos = new HashSet<>();
    }

    public Long getIdClase() {
        return idClase;
    }

    public void setIdClase(Long idClase) {
        this.idClase = idClase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getNumArmas() {
        return numArmas;
    }

    public void setNumArmas(int numArmas) {
        this.numArmas = numArmas;
    }

    public int getQuilla() {
        return quilla;
    }

    public void setQuilla(int quilla) {
        this.quilla = quilla;
    }

    public int getDesplazamiento() {
        return desplazamiento;
    }

    public void setDesplazamiento(int desplazamiento) {
        this.desplazamiento = desplazamiento;
    }

    public Set<Barco> getLosBarcos() {
        return losBarcos;
    }

    public void setLosBarcos(Set<Barco> losBarcos) {
        this.losBarcos = losBarcos;
    }

    
   
    public void addBarcos(Barco b) {
        this.losBarcos.add(b);
    }

    public void mostrarBarcos() {
        if (losBarcos.isEmpty()) {
            System.out.println(ConsoleColors.BLUE_BOLD + "\tEsta clase no tiene barcos" + ConsoleColors.RESET);
        } else {
            System.out.println(ConsoleColors.BLUE_BOLD + "\tEsta clase tiene estos barcos:" + ConsoleColors.RESET);
            for (Barco b : losBarcos) {
                System.out.printf("%-1s %-25s %-1s %-25s%n", "\t\tNombre: " + ConsoleColors.GREEN_BOLD_BRIGHT, b.getNombre() + ConsoleColors.RESET,
                        "\tAño: ", ConsoleColors.GREEN_BOLD_BRIGHT + b.getLanzamiento() + ConsoleColors.RESET);
            }
        }
    }

    @Override
    public String toString() {
        return String.format(ConsoleColors.GREEN_BOLD_BRIGHT +
                        "%-5s %-25s %-5s %-10s %-5s %-25s",
                idClase,
                nombre,
                pais,
                numArmas,
                quilla,
                desplazamiento + ConsoleColors.RESET
        );
    }

    public Clase(String nombre, String pais, int numArmas, int quilla, int desplazamiento) {
        this.nombre = nombre;
        this.pais = pais;
        this.numArmas = numArmas;
        this.quilla = quilla;
        this.desplazamiento = desplazamiento;
    }


}

