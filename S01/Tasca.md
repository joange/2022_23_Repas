# 1. Working with files

This week we will work with the file system, text files and binary files.

# 2. Task to perform

## 2.1. Elements

Make a program that, starting from the path of the `S01` folder , lists the elements (files and folders), showing the size un kilobytes of each element.

> If it is a folder, you must add all elements sizes.

## 2.2. Empleados and Departamentos

Create a Java program with Model classes `Departamento` and `Empleado`:

> Empleado= EMP_NO + APELLIDO + OFICIO + DIR +FECHA_ALT + SALARIO + COMISION+ DEPT_NO

> Departamento=DEPT_NO +DNOMBRE +LOC


## 2.3. Loading data

Create a Java program who:

- Starting with file name and previous classes, load data from ___Departamentos.csv___  into a List of Departamentos.
- Starting with file name and previous classes, load data from Empleados.json  into a Set of Empleados.

## 2.4. Processing data

Once we have loaded data, create a program who find or check this information:

- Empleados who has a wrong Departamento
- For each Empleado check how many other empleados has at his orders. Think that DIR field is DIRECTOR

## 2.5. Creating new data

- Store into a new file, called ___Empleados.dat___ information about Empleados in binary format. You need to make partable information.
- Create file ___newEmpleados.xml___ changing the structure:

Orignial

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

## 2.6. Extra

Create your own exercise with data trasnformation at your own
