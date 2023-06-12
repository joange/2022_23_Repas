/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.jaumeii.repas23s10;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;

import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;








import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;

/**
 *
 * @author joange
 */
public class Repas23S10 {

    public static void main(String[] args) {
        Repas23S10 app = new Repas23S10();

        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger rootLogger = (Logger) loggerContext.getLogger("org.mongodb.driver");
        rootLogger.setLevel(Level.ERROR);

        MongoClient mongoClient = app.connectServer();
        System.out.println("----- Exercise 1 -------");
        app.exercise1(mongoClient, "Italian");

        System.out.println("----- Exercise 2 -------");
        int max_habilitites = app.exercise2(mongoClient);

        System.out.println("----- Exercise 3 -------");
        for (int i = 1; i <= max_habilitites; i++) {
            app.exercise3(mongoClient, i);

        }

        app.disConnect(mongoClient);
    }

    public MongoClient connectServer() {
        String uri = "mongodb://root:TooR@www.jgcamarena.es:27017";
        MongoClient mongoClient = MongoClients.create(uri);
        return mongoClient;
    }

    public void disConnect(MongoClient client) {
        client.close();
    }

    
    
    
    
    
    /**
     * Show on screen full name and nick (`knownAs`) from Italian
     * (`nationality`) artists.
     *
     * @param client
     * @param nationality
     */
    public void exercise1(MongoClient client, String nationality) {
        // Obtenemos la colección a partir de la base de datos test
        MongoDatabase db = client.getDatabase("artists");
        MongoCollection<Document> colArtists = db.getCollection("artists");

        // And now, we apply a filter
        Bson filtro = Filters.eq("nationality", nationality);

        Bson proyeccion = Projections.fields(
                Projections.include("name", "knownAs"),
                Projections.excludeId());

        FindIterable<Document> docsArtists = colArtists
                .find(filtro)
                .projection(proyeccion);

        for (Document doc : docsArtists) {
            System.out.println(doc.toString());
        }
        
        

        
        
        
        
        
        
    }

    public int exercise2(MongoClient client) {
        // Obtenemos la colección a partir de la base de datos test
        MongoDatabase db = client.getDatabase("artists");
        MongoCollection<Document> colArtists = db.getCollection("artists");

        // And now, we apply a filter
        Bson proyeccion = Projections.fields(
                Projections.include("name", "knownAs", "knownFor"),
                Projections.excludeId()
        );

        FindIterable<Document> docsArtists = colArtists
                .find()
                .projection(proyeccion);

        int max_habilitites = -1;
        String name = "";
        for (Document doc : docsArtists) {
            List<String> habilities = doc.getList("knownFor", String.class);
            System.out.println(doc.getString("name") + " has " + habilities.size() + " habilitites.");
            if (habilities.size() > max_habilitites) {
                max_habilitites = habilities.size();
                name = doc.getString("name");
            }
        }

        System.out.println("\nBest artist is " + name + " with " + max_habilitites + " habilitites");

        return max_habilitites;
    }

    public void exercise3(MongoClient client, int habilitites) {
        // Obtenemos la colección a partir de la base de datos test
        MongoDatabase db = client.getDatabase("artists");
        MongoCollection<Document> colArtists = db.getCollection("artists");

        // And now, we apply a filter
        Bson filtro = Filters.size("knownFor", habilitites);

        Bson proyeccion = Projections.fields(
                Projections.include("knownAs"),
                Projections.excludeId());

        FindIterable<Document> docsArtists = colArtists
                .find(filtro)
                .projection(proyeccion);
        System.out.println("Artists with " + habilitites + " abilities:");
        System.out.println("==========================================");
        for (Document doc : docsArtists) {
            System.out.println("\t" + doc.getString("knownAs"));
        }
    }

}
