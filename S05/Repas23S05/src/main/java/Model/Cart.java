/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author joange
 */
@Entity
@Data@NoArgsConstructor
@Table(name="CART")
public class Cart implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCart;

    @OneToMany(mappedBy="cart",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY)
    private Set<Item> items;
    
    @Override
    public String toString(){
        String res="(Cart(idCart="+ this.idCart + ")";
        for (Item item : items) {
            res+=item.toString();
        }
        return res;
    }

}
