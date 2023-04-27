/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;



/**
 *
 * @author joange
 */

@Entity
@Table(name="Participa")
public class Participa {
    
    
    public static enum Resultado {
        ILESO, DAÑADO, HUNDIDO
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idParticipa")
    private Long idBatalla;
    
    
    @ManyToOne(fetch=FetchType.EAGER)
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "idBarco")
    private Barco elBarco;
            
    @ManyToOne(fetch=FetchType.EAGER)
    @Cascade({CascadeType.SAVE_UPDATE})
    @JoinColumn(name = "idBatalla")
    private Batalla laBatalla;
                    
    @Column(name = "resultado")
    private Resultado resultado;

    public Long getIdBatalla() {
        return idBatalla;
    }

    public void setIdBatalla(Long idBatalla) {
        this.idBatalla = idBatalla;
    }

    public Barco getElBarco() {
        return elBarco;
    }

    public void setElBarco(Barco elBarco) {
        this.elBarco = elBarco;
        elBarco.addParticipacion(this);
    }

    public Batalla getLaBatalla() {
        return laBatalla;
    }

    public void setLaBatalla(Batalla laBatalla) {
        this.laBatalla = laBatalla;
        laBatalla.addParticipacion(this);
        
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Participa{" + "idBatalla=" + idBatalla + ", elBarco=" + elBarco + ", laBatalla=" + laBatalla + ", resultado=" + resultado + '}';
    }

    public Participa() {
    }

    public Participa(Barco elBarco, Batalla laBatalla, Resultado resultado) {
        this.elBarco = elBarco;
        elBarco.addParticipacion(this);
        this.laBatalla = laBatalla;
        laBatalla.addParticipacion(this);
        this.resultado = resultado;
    }
    
    
}
