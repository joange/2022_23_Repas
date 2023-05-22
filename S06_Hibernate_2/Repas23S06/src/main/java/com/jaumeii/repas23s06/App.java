/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.jaumeii.repas23s06;

import Model.Arma;
import Model.Barco;
import Model.Enemigo;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author joange
 */
public class App {

    private Session laSessio;

    public static void main(String[] args) {
        App app = new App();

        //app.testHibernate();
       // app.storeObjects();
        app.testBarcos();
        //app.moreTestBarcos();
    }

    public void testHibernate() {
        // get a Session and start a transaction
        laSessio = HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.getTransaction().begin();

        laSessio.getTransaction().commit();
        laSessio.close();
    }

    public void storeObjects() {
        laSessio = HibernateUtil.getSessionFactory().getCurrentSession();
        laSessio.getTransaction().begin();

        Arma a1 = new Arma("Dark Saber", "Dark saber who turns Mandalorean Power", 90);
        Arma a2 = new Arma("Light Saber", "Jedi saber to young padawans", 70);

        Enemigo e1 = new Enemigo("Yoda", 100, 50);
        Enemigo e2 = new Enemigo("Bo katan", 80, 70);
        Enemigo e3 = new Enemigo("Grogu", 60, 120);

        // assign weapons to enemies
        e1.getArmas().add(a2);
  
        e2.getArmas().add(a1);

        e3.getArmas().add(a1);
        e3.getArmas().add(a2);

        laSessio.persist(e1);
        laSessio.persist(e2);
        laSessio.persist(e3);
        //print

        laSessio.getTransaction().commit();
        laSessio.close();
    }

    
    
    public void testBarcos() {

        DAOBarco daoBarco = new DAOBarco(HibernateUtil.getSessionFactory());

        List<Barco> losBarcos = null;
        Barco barco;
        Long ID;

        
      System.out.println(" === 1 === ");
      losBarcos=daoBarco.getAllBarco();
       for (Barco b : losBarcos) {
           System.out.println(b);
       }
      
        System.out.println(" === 2 === ");
       barco=daoBarco.getBarcoByID(90L);
       if (barco!=null)
           System.out.println(barco.getNombre());
       else
            System.out.println("No existeix eixe barco.");
       
       
      System.out.println(" === 3 === ");
      losBarcos=daoBarco.getBarcoByClassName("Ibañez II");
       for (Barco b : losBarcos) {
           System.out.println(b);
       }
         
        System.out.println(" === 4 === ");
        ID = daoBarco.addBarco();
        System.out.println("Barco añadido con ID " + ID);
        
        
        
    
        
        barco=daoBarco.getBarcoByID(8L);
        System.out.println(barco);
        if (barco!=null)
            daoBarco.deleteBarco(barco);

    }

    public void moreTestBarcos() {
        DAOBarco daoBarco = new DAOBarco(HibernateUtil.getSessionFactory());

        List<Barco> losBarcos = null;
        Barco barco;
        Long ID;
/*
        System.out.println("=== 1 === ");
        ID = daoBarco.addBarcoPlus();
        System.out.println("Barco añadido con ID " + ID);

        System.out.println("=== 2 === ");
    
        barco=daoBarco.updateBarco(3L);
        System.out.println(barco);
        
  */      
        
        System.out.println("=== 3 === ");
    
        daoBarco.addParticipaciones(12L);
        barco=daoBarco.getBarcoByID(12L);
        System.out.println(barco);
        barco.mostrarParticipaciones();
    }
}
