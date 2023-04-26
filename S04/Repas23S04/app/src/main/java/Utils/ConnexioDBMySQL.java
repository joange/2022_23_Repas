/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author joange
 */
public class ConnexioDBMySQL {

    private Connection laConnexio = null;

    private String dbName;
    private String host;
    private String port;
    private String user;
    private String pass;

    public ConnexioDBMySQL() {
        this.dbName = "DEPART_EMPLE_LIGHT";
        this.host = "127.0.0.1";
        this.port = "3308";
        this.user = "root";
        this.pass = "root";
    }

    public ConnexioDBMySQL(String filename) {
        try {
            Properties config = new Properties();
            config.load(new FileInputStream(filename));

            this.port = config.getProperty("port");
            this.host = config.getProperty("server");
            this.dbName = config.getProperty("dbName");
            this.pass = config.getProperty("password");
            this.user = config.getProperty("user");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConnexioDBMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnexioDBMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void obrirConnexio() {
        try {
            String connectionUrl = "jdbc:mysql://" + this.host + ":" + port + "/" + dbName+"?allowMultiQueries=true";

            Properties p = new Properties();

            p.put("user", this.user);
            p.put("password", this.pass);
//            p.put("allowMultiQueries", this.allowMultiple);
            laConnexio = DriverManager.getConnection(connectionUrl, p);
            


            System.out.println(ConsoleColors.GREEN + "Connection to MySQL has been established with DB: " + dbName + ConsoleColors.RESET);
        } catch (SQLException ex) {
            System.out.println(ConsoleColors.RED + "Error connection to mysql" + ConsoleColors.RESET);
        }

    }

    public Connection getConnexio() {
        if (laConnexio == null) {
            obrirConnexio();
        }

        return laConnexio;

    }

    public void tancarConnexio() {
        if (laConnexio != null) {
            try {
                laConnexio.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnexioDBMySQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        laConnexio = null;
    }

}
