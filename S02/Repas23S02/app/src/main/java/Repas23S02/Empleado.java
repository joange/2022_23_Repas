/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repas23S02;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.json.JSONObject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author joange
 */
@Data
@AllArgsConstructor
public class Empleado implements Serializable {

    public static long SerialVersionUID = 1L;

    private int EMP_NO;
    private String APELLIDO;
    private String OFICIO;
    private int DIR;
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
            this.DIR = -1;
        }
        this.FECHA_ALT = dateFromString(empleado.getString("FECHA_ALT"));
        this.DEPT_NO = empleado.getInt("DEPT_NO");
        this.OFICIO = empleado.getString("OFICIO");
        this.SALARIO = empleado.getDouble("SALARIO");

    }
    
    public Element asXML(Document doc) {

        Element el = doc.createElement("Empleado");

        el.setAttribute("number", String.valueOf(this.EMP_NO));
        el.setAttribute("dir", String.valueOf(this.DIR));
        el.setAttribute("dept", String.valueOf(this.DEPT_NO));

        Element ape = doc.createElement("Apellido");
        el.appendChild(ape);
        ape.appendChild(doc.createTextNode(this.APELLIDO));

        Element ofi = doc.createElement("Oficio");
        el.appendChild(ofi);
        ofi.appendChild(doc.createTextNode(this.OFICIO));

        Element admin = doc.createElement("Administrativos");
        el.appendChild(admin);
        Element f_alta = doc.createElement("Fecha_Alta");
        admin.appendChild(f_alta);
        f_alta.appendChild(doc.createTextNode("" + this.FECHA_ALT));

        Element salario = doc.createElement("Salario");
        admin.appendChild(salario);
        salario.appendChild(doc.createTextNode("" + this.SALARIO));

        Element comision = doc.createElement("Comision");
        admin.appendChild(comision);
        comision.appendChild(doc.createTextNode("" + this.COMISION));

       
        return el;

    }

    public JSONObject asJSON() {
        JSONObject emple = new JSONObject();
        emple.put("EMP_NO", this.EMP_NO);
        emple.put("APELLIDO", this.APELLIDO);
        emple.put("OFICIO", this.OFICIO);
        emple.put("FECHA_ALT", this.FECHA_ALT);
        emple.put("SALARIO", this.SALARIO);
        emple.put("COMISION", this.COMISION);
        emple.put("DEPT_NO", this.DEPT_NO);
        return emple;
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
