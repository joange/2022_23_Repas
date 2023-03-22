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
                System.out.print("Emple: ");
                System.out.println(Arrays.toString(info));
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