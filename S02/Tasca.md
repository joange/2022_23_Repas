# 1. Importing and Exporting data

## 1.1. Loading data

Starting with file name and previous classes, load data from ***Empleados.json*** into a `Set` of Empleados.

Once we have loaded data, create a program who find or check this information:

- Empleados who has a wrong Departamento
- For each Empleado check how many other empleados has at his orders. Think that DIR field is DIRECTOR

## 1.2. Creating new data

- Create file ___newEmpleados.xml___ changing the structure:

Original

```xml
<Empleado>
  <EMP_NO>7369</EMP_NO>
  <APELLIDO>SÁNCHEZ</APELLIDO>
  <OFICIO>EMPLEADO</OFICIO>
  <DIR>7902</DIR>
  <FECHA_ALT>1990-12-17</FECHA_ALT>
  <SALARIO>1040.00</SALARIO>
  <COMISION>NULL</COMISION>
  <DEPT_NO>20</DEPT_NO>
</ROW>
```

New Structure:

```xml
<Empleado number=7369 dir=7902 dept=20> 
  <Apellido>SÁNCHEZ</Apellido>
  <Oficio>EMPLEADO</Oficio>
  <Administrativos>
    <Fecha_Alta>1990-12-17</Fecha_Alta>
    <Salario>1040.00</Salario>
    <Comision>Null</Comision>
  </Administrativos>
</Empleado>
```


## 1.3. Generating data

Starting with data from Empleados and Departamentos...