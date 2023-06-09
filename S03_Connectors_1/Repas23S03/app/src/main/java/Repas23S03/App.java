/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Repas23S03;

import Utils.ConnexioDBMySQL;
import Utils.ConsoleColors;
import Utils.Utilitats;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static ConnexioDBMySQL conexio;

    public static void main(String[] args) {
        App app = new App();
        conexio = new ConnexioDBMySQL("src/main/resources/conexio.properties");

        Connection laConexion = conexio.getConnexio();

        app.describe(laConexion);
        app.createDatabase(laConexion);
        app.createTable(laConexion,"src/main/resources/script.sql");
        app.showTable(laConexion);
    }

    public void describe(Connection con) {

        try {
            DatabaseMetaData dbmd = con.getMetaData();

            System.out.println(ConsoleColors.BLUE + "\nDBMS information--------" + ConsoleColors.RESET);
            System.out.println(ConsoleColors.WHITE_BRIGHT + "DBMS:\t" + ConsoleColors.RESET + dbmd.getDatabaseProductName());
            System.out.println(ConsoleColors.WHITE_BRIGHT + "DBMS:\t" + ConsoleColors.RESET + dbmd.getDatabaseProductVersion());

            ResultSet rstDatabases = dbmd.getCatalogs();
            int i = 0;
            String dbName = "";
            while (rstDatabases.next()) {
                i++;
                if (i == 1) {
                    dbName = rstDatabases.getString("TABLE_CAT");
                }
            }

            rstDatabases.close();
            System.out.println("There are " + i + " databases on the server.");

            System.out.println("Tables on database <" + dbName + ">");
            ResultSet rstTables = dbmd.getTables(dbName, null, null, null);
            int numTables = 0;
            String tableName = "";
            while (rstTables.next()) {
                numTables++;
                System.out.println("\t" + rstTables.getString("TABLE_NAME"));
                if (numTables == 2) {
                    tableName = rstTables.getString("TABLE_NAME");
                }
            }
            rstTables.close();

            ResultSet rstColumnes = dbmd.getColumns(dbName, null, tableName, null);

            System.out.println("\t\tColumnes de la taula <" + tableName + ">");
            while (rstColumnes.next()) {
                System.out.println("\t\t\t" + rstColumnes.getString("COLUMN_NAME") + "\t\t\t" + rstColumnes.getString("TYPE_NAME"));
            }

            rstColumnes.close();

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createDatabase(Connection con) {

        String newDBName = Utilitats.leerTextoG("Dis-me el nom de la nova DDBB");

        try {
            DatabaseMetaData dbmd = con.getMetaData();

            ResultSet rstDatabases = dbmd.getCatalogs();
            boolean exists = false;
            while (rstDatabases.next()) {
                if (newDBName.equalsIgnoreCase(rstDatabases.getString("TABLE_CAT"))) {
                    exists = true;
                    break;
                }
            }
            rstDatabases.close();

            if (exists) {
                System.out.println("No podem crear una BBDD que ja existeix. Ixint...");
            } else {
                String query = "create database " + newDBName;
                Statement stm = con.createStatement();
                int result = stm.executeUpdate(query);
                if (result == 1) {
                    System.out.println("Database <"+newDBName + "> created succesfully.");
                }
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void createTable(Connection con,String scriptName){
        
        BufferedReader bfr = null;
        try {
            File script = new File(scriptName);
            bfr = bfr = new BufferedReader(new FileReader(script));
            String line = null;
            StringBuilder sb = new StringBuilder();
            // Obtenemos el salto de linea del sistema subyacente
            String breakLine = System.getProperty("line.separator");
            
            while ((line = bfr.readLine()) != null) {
                sb.append(line);
                sb.append(breakLine);
            }
            
            String query = sb.toString();   // generemos el Script en un String
            
            System.out.println(query);
            
            Statement stm = con.createStatement();
            int result = stm.executeUpdate(query);
            
            System.out.println("Script ejecutado con salida " + result);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage()  +" code:"+ex.getSQLState());
        } finally {
            try {
                bfr.close();
            } catch (IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void showTable(Connection con){
        try {
            DatabaseMetaData dbmd = con.getMetaData();
            
            ResultSet rstColumnes = dbmd.getColumns("testdb", null, "People", null);
            
            ResultSet rstKeys=dbmd.getPrimaryKeys("testdb", null, "People");
            
            ArrayList<String> lesClaus =new ArrayList<>();
            while(rstKeys.next())
                lesClaus.add(rstKeys.getString("COLUMN_NAME"));
            
            
            System.out.println(String.format("%15s%5s%15s%12s", "Column","Key","Type","Nullable"));
            while (rstColumnes.next()) {
                String name=rstColumnes.getString("COLUMN_NAME");
                String key=(lesClaus.contains(name)?"Y":"N");
                String type=rstColumnes.getString("TYPE_NAME");
                String isNull=rstColumnes.getString("IS_NULLABLE");
               
                System.out.println(String.format("%15s%5s%15s%12s", name,key,type,isNull));
            }
        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
}
