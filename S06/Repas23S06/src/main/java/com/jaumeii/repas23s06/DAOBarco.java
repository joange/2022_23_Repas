/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jaumeii.repas23s06;

import Model.Barco;
import Model.Batalla;
import Model.Clase;
import Model.Participa;
import jakarta.persistence.Query;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author joange
 */
public class DAOBarco {

    private SessionFactory laSesion;

    public DAOBarco(SessionFactory laSesion) {
        this.laSesion = laSesion;
    }

    public List<Barco> getAllBarco() {
        Session sesion = laSesion.getCurrentSession();
        sesion.beginTransaction();
        
        Query q = sesion.createQuery("from Barco", Barco.class);
        List<Barco> losBarcos = q.getResultList();
        
        sesion.getTransaction().commit();
        return losBarcos;
    }

//        public Barco getBarcoByID(Long id) {
//        Session sesion = laSesion.getCurrentSession();
//        sesion.beginTransaction();
//        Query q = sesion.createQuery("from Barco B where B.idBarco=:idB", Barco.class);
//        q.setParameter("idB", id);
//        
//        List<Barco> losBarcos = q.getResultList();
//        
//        
//        sesion.getTransaction().commit();
//        return losBarcos.get(0);
//
//    }
    
    
    
    public Barco getBarcoByID(Long id) {
        Session sesion = laSesion.getCurrentSession();
        sesion.beginTransaction();
        Barco b = sesion.get(Barco.class, id);
        sesion.getTransaction().commit();
        return b;

    }
    
    
    

    public List<Barco> getBarcoByClassName(String classname) {
        Session sesion = laSesion.getCurrentSession();
        sesion.beginTransaction();
        Query q = sesion.createQuery("from Barco b Where b.laClase.nombre=:clase", Barco.class);
        q.setParameter("clase", classname);
        List<Barco> losBarcos = q.getResultList();
        sesion.getTransaction().commit();
        return losBarcos;
    }

    public Long addBarco() {
        Barco b = new Barco();
        b.setNombre(Utilitats.leerTextoC("Dime el nombre del barco: "));
        b.setLanzamiento(Utilitats.leerEnteroC("Dime el año de lanzamiento: "));
        Session sesion = laSesion.getCurrentSession();
        sesion.beginTransaction();
        sesion.persist(b);
        sesion.getTransaction().commit();
        sesion.close();
        return b.getIdBarco();
    }

    public void deleteBarco(Long idBarco) {
        Session sesion = laSesion.getCurrentSession();
        sesion.beginTransaction();
        Barco b = sesion.get(Barco.class, idBarco);
        sesion.remove(b);
        sesion.getTransaction().commit();
    }

    public void deleteBarco(Barco b) {
        Session sesion = laSesion.getCurrentSession();
        sesion.beginTransaction();
        sesion.remove(b);
        sesion.getTransaction().commit();
    }

    
    
    
    
    public Long addBarcoPlus() {
        Barco b = new Barco();
        b.setNombre(Utilitats.leerTextoC("Dime el nombre del barco: "));
        b.setLanzamiento(Utilitats.leerEnteroC("Dime el año de lanzamiento: "));
        Session sesion = laSesion.getCurrentSession();
        sesion.beginTransaction();

        Query q = sesion.createQuery("from Clase", Clase.class);
        List<Clase> lasClases = q.getResultList();
        int i = 1;
        for (Clase c : lasClases) {
            System.out.println(i + " - " + c);
            i++;
        }
        do {

            i = Utilitats.leerEnteroC("Indica que clase quieres asignar:");
        } while (i < 1 || i > lasClases.size());

        Clase c = lasClases.get(i - 1);
        b.setLaClase(c);
        sesion.persist(b);
        sesion.getTransaction().commit();
        return b.getIdBarco();
    }

    public Barco updateBarco(Long IDBarco) {
        String resposta = "";
        Session sesion = laSesion.getCurrentSession();
        sesion.beginTransaction();
        
        Barco b=sesion.get(Barco.class,IDBarco);
        
        

        resposta = Utilitats.leerTextoC("Nom del barco: <" + b.getNombre() + ">. Actualitzar (s/n): ");
        if (resposta.equalsIgnoreCase("S")) {
            b.setNombre(Utilitats.leerTextoC("Dis-me el nou nom: "));
        }

        resposta = Utilitats.leerTextoC("Any del barco: <" + b.getLanzamiento() + ">. Actualitzar (s/n): ");
        if (resposta.equalsIgnoreCase("S")) {
            b.setLanzamiento(Utilitats.leerEnteroC("Dis-me el nou any: "));
        }

        resposta = Utilitats.leerTextoC("Clase del barco: <" + b.getLaClase().getNombre() + ">. Actualitzar (s/n): ");
        if (resposta.equalsIgnoreCase("S")) {
            Query q = sesion.createQuery("from Clase", Clase.class);
            List<Clase> lasClases = q.getResultList();
            int i = 1;
            for (Clase c : lasClases) {
                System.out.println(i + " - " + c);
                i++;
            }
            do {

                i = Utilitats.leerEnteroC("Indica que clase quieres asignar:");
            } while (i < 1 || i > lasClases.size());

            Clase c = lasClases.get(i - 1);
            b.setLaClase(c);

        }

        sesion.persist(b);
        
        sesion.getTransaction().commit();
        sesion.close();
return b;
    }
    
    
    public void addParticipaciones(Long IDBarco){
        String resposta = "";
        Session sesion = laSesion.getCurrentSession();
        sesion.beginTransaction();
        
        Barco barco=sesion.get(Barco.class,IDBarco);
        
        //Mostrem totes les batalles
        Query q = sesion.createQuery("from Batalla", Batalla.class);
            List<Batalla> lasBatallas = q.getResultList();
            int i = 1;
            for (Batalla b : lasBatallas) {
                System.out.println(i + " - " + b);
                i++;
        }
           // preguntem quines vol mostrar
           resposta=Utilitats.leerTextoC("Dis-me les batalles en que ha particiat, separat per comes: ");
           String[]batalles=resposta.split(",");
           for (String batalla : batalles) {
            Long bat=Long.parseLong(batalla);
            
            // recuperem la batalla
            Batalla laBatalla=sesion.get(Batalla.class, bat);
            
            //preguntem en quin estat va quedar el barco
            System.out.print("Selecciona algun estat de la batalla: " + java.util.Arrays.asList(Participa.Resultado.values()) + ": ");
            String resultatBatalla=Utilitats.leerTextoC("");
            Participa.Resultado resul=Participa.Resultado.valueOf(resultatBatalla);
            
            // creem la participació:
            Participa p= new Participa();
            p.setElBarco(barco);
            p.setLaBatalla(laBatalla);
            p.setResultado(resul);
            
            sesion.persist(p);
            
            
        }
           sesion.getTransaction().commit();
           sesion.close();

    }
}
