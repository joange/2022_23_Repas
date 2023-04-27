/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repas23S04;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.json.JSONObject;

/**
           *
 * @author joange
 */

@Data
@AllArgsConstructor
public class Empleado implements Serializable{
    
    public static long SerialVersionUID=1L;
    
    private int EMP_NO;
    private String APELLIDO;
    private String OFICIO;
    private Integer DIR;
    private Date FECHA_ALT;
    private double SALARIO;
    private double COMISION;
    private int DEPT_NO;
    
    public Empleado(JSONObject empleado) {

        this.APELLIDO = empleado.getString("APELLIDO");
        try {
            this.COMISION = empleado.getDouble("COMISION");
        } catch (org.json.JSONException ex) {
            this.COMISION = 0.0;
        }
        this.EMP_NO = empleado.getInt("EMP_NO");
        try {
            this.DIR = empleado.getInt("DIR");
        } catch (org.json.JSONException ex) {
            this.DIR = null;
        }
        this.FECHA_ALT = dateFromString(empleado.getString("FECHA_ALT"));
        this.DEPT_NO = empleado.getInt("DEPT_NO");
        this.OFICIO = empleado.getString("OFICIO");
        this.SALARIO = empleado.getDouble("SALARIO");

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

