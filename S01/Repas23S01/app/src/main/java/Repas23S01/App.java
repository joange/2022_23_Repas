/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package Repas23S01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    public static String ruta = "/Users/joange/Documents/2022_23_Repas/S01";

    public long listAndSize(String path) {
        File folder = new File(path);  

        if (folder.isDirectory()) {

            long size = 0;

            File[] elements = folder.listFiles();

            
            for (File element : elements) {
                long tam;
                if (element.isFile()) {
                    tam = element.length();
                    size += tam;
                    System.out.printf("File %s inside %s folder has %.3f Kb\n", element.getName(), element.getParent(), tam / 1024.0);
                } else {
                    tam = listAndSize(element.getAbsolutePath());
                    System.out.printf("Folder <%s> has %.3f Kb\n", element.getName(), tam / 1024.0);
                }
            }
            return size;
        } else {
            System.out.println("<" + path + "> it is not a folder. Exiting");
            return -1L;
        }

    }

    public ArrayList<Departamento> loadCSVDepartamento(String filename, boolean header) {

        File f = new File(filename);

        if (!f.exists()) {
            System.out.println("File " + filename + " does not exists. Exiting");
            return null;
        }

        if (!f.isFile()) {
            System.out.println("File " + filename + " it is not a file. Exiting");
            return null;

        }
        
        
      
        ArrayList<Departamento> losDepartamentos = new ArrayList<>();
        
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            String linea = "";
            
            while ((linea = bfr.readLine()) != null) {

                // is header, we ommit
                if (header) {
                    header = false;
                    continue;
                }

                String info[] = linea.split(",");
                Departamento d = new Departamento(
                        Integer.parseInt(info[0]),
                        info[1],
                        info[2]);
                
                losDepartamentos.add(d);
            }
            bfr.close();
            fr.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return losDepartamentos;
    }

    public ArrayList<Empleado> loadCSVEmpleado(String filename, boolean header) {

        File f = new File(filename);

        if (!f.exists()) {
            System.out.println("File " + filename + " does not exists. Exiting");
            return null;
        }

        if (!f.isFile()) {
            System.out.println("File " + filename + " it is not a file. Exiting");
            return null;

        }

        ArrayList<Empleado> losEmpleados = new ArrayList<>();
        
        try {
            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);
            String linea = "";
            while ((linea = bfr.readLine()) != null) {

                // is header, we ommit
                if (header) {
                    header = false;
                    continue;
                }

                String info[] = linea.split(",");
           //     System.out.print("Emple: ");
           //     System.out.println(Arrays.toString(info));
                try {
                    Empleado e = new Empleado(
                            (info[0].equals("NULL")) ? 0 : Integer.parseInt(info[0]),
                            info[1],
                            info[2],
                            (info[3].equals("NULL")) ? 0 : Integer.parseInt(info[3]),
                            dateFromString(info[4]),
                            (info[5].equals("NULL")) ? 0 : Double.parseDouble(info[5]),
                            (info[6].equals("NULL")) ? 0 : Double.parseDouble(info[6]),
                            (info[7].equals("NULL")) ? 0 : Integer.parseInt(info[7]));

                    losEmpleados.add(e);
                } catch (NumberFormatException ex) {

                }
            }
            bfr.close();
            fr.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return losEmpleados;
    }
    
    public void exportEmpleados (ArrayList<Empleado> losEmpleados,String fileName){
        
        FileOutputStream fos= null;
        
        try {
            File f= new File(fileName);
            fos = new FileOutputStream(f);
            ObjectOutputStream OOS = new ObjectOutputStream(fos);
            
            for (Empleado e : losEmpleados) {
                OOS.writeObject(e);
            }
            
            OOS.close();
            fos.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    public ArrayList<Empleado> loadEmpleados(String fileName){
        
        ArrayList<Empleado> losEmpleados=null;
        try {
            File f = new File(fileName);
            
            if (!f.exists()) {
                System.out.println("File " + fileName + " does not exists. Exiting");
                return null;
            }
            
            if (!f.isFile()) {
                System.out.println("File " + fileName + " it is not a file. Exiting");
                return null;
                
            }
            
            losEmpleados = new ArrayList<>();
            
            FileInputStream fis;
            fis = new FileInputStream(f);
            ObjectInputStream OIS = new ObjectInputStream(fis);
            
            while(fis.available()>0){
                Empleado e=(Empleado)OIS.readObject();
                losEmpleados.add(e);   
            }
         
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
        return losEmpleados;
                
    }
    
    public static void main(String[] args) {
        App app = new App();

       // app.listAndSize(ruta);
        
       
        ArrayList<Departamento> losDepartamentos = app.loadCSVDepartamento(ruta + "/Departamentos/Departamentos.csv", true);
        for (Departamento d : losDepartamentos) {
            System.out.println(d);
        }
        
        
        
        
        

        System.out.println("====== READ FROM EMPLEADOS CSV========");

        ArrayList<Empleado> losEmpleados = app.loadCSVEmpleado(ruta + "/Empleados/Empleados.csv", true);
        for (Empleado e : losEmpleados) {
            System.out.println(e);
        }
        
        
        /*
        System.out.println("====== EXPORT TO EMPLEADOS OBJECT FILE ========");
        
        app.exportEmpleados(losEmpleados, ruta +"/Empleados/Empleados.dat");
        
        System.out.println("===== IMPORT AND SHOW EMPLEADOS FROM OBJECT FILE  =====");
        ArrayList<Empleado> losEmpleadosDat=app.loadEmpleados(ruta +"/Empleados/Empleados.dat");
        for (Empleado empleado : losEmpleadosDat) {
            System.out.println(empleado);
        }

*/

    }

    public Date dateFromString(String date) {
        Date convertedDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            convertedDate = sdf.parse(date);

        } catch (ParseException ex) {
            ex.getMessage();
        }
        return convertedDate;
    }
}
