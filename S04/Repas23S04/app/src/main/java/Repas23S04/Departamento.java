/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repas23S04;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;


/**
 *
 * @author joange
 */

@Data
@AllArgsConstructor
@ToString
public class Departamento implements Serializable{
    
    public static long SerialVersionUID=1L;
    
    private int DEPT_NO;
    private String DNOMBRE;
    private String LOC;
    


}
