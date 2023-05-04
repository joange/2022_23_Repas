
package com.jaumeii.repas23s05;

import Model.Cart;
import Model.Direccion;
import Model.Item;
import Model.Profe;
import Model.Profesor;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;

/**
 *
 * @author joange
 */
public class App {
    
    private Session laSessio;

    public static void main(String[] args) {
        App app = new App();
        
       // app.testHibernate();
        
       // app.Ejercicio3();
    
        app.Ejercicio4();
        
       // app.Ejercicio5();
        
    }
    
    public void testHibernate(){
        // get a Session and start a transaction
        laSessio=HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.getTransaction().begin();
        
        // create a Profesor, show, store it and show again
          Profesor p= new Profesor("Joan","Camarena","Estruch");
          System.out.println(p);  
          laSessio.persist(p);
          System.out.println(p);
        
        laSessio.getTransaction().commit();
        laSessio.close();
    }
    
    public void Ejercicio3(){
        laSessio=HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.getTransaction().begin();
        
        Direccion direccion=new Direccion("AVD Filemon", 8, "Xativa", "Valencia");
        Profe profesor=new Profe("Juan", "Perez", "García");
        profesor.setDireccion(direccion);
        
        
        laSessio.persist(profesor);
        
        
        Profe profesor2=new Profe("Pepe", "Gomez", "Sanchis");
        profesor2.setDireccion(direccion);
     
        laSessio.persist(profesor2);

 
        
        
        laSessio.getTransaction().commit();
        laSessio.close();
    }
    
     public void Ejercicio4(){
        laSessio=HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.getTransaction().begin();
        
        Cart cart = new Cart();

        Item item1 = new Item(cart);
        Item item2 = new Item(cart);
        Set<Item> itemsSet = new HashSet<>();
        
        itemsSet.add(item1);
        itemsSet.add(item2);

        cart.setItems(itemsSet);

        laSessio.persist(cart);
        laSessio.persist(item1);
        laSessio.persist(item2);
        
         System.out.println(cart);
         System.out.println(item1);
         System.out.println(item2);
         
        laSessio.getTransaction().commit();
        laSessio.close();
    }
     
     
     public void Ejercicio5(){
        laSessio=HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.getTransaction().begin();
       
        Cart cart=laSessio.get(Cart.class, 2L);
        System.out.println(cart);
        
        Item item=new Item(cart);
        cart.getItems().add(item);
        
        laSessio.persist(cart);
        
        laSessio.getTransaction().commit();
        laSessio.close();
    }
}
