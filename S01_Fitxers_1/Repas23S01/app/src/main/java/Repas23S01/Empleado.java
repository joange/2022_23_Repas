/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repas23S01;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

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
    private int DIR;
    private Date FECHA_ALT;
    private double SALARIO;
    private double COMISION;
    private int DEPT_NO;

}
