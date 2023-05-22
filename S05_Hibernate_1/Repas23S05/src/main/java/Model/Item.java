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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author joange
 */
@Entity
@Table(name="ITEMS")
@Data@NoArgsConstructor@ToString
public class Item {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idItem;
    
    @ManyToOne(
            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER)
    @JoinColumn(name="cart_id", nullable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Cart cart;

    public Item(Cart cart) {
        this.cart = cart;
    }

    
    
  
}
