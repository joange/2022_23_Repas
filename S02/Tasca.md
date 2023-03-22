# 1. Importing and Exporting data

## 1.1. Loading data

Starting with file name and previous classes:

- Load data from **_Empleados.json_** into a `Set` of Empleados.
- Add constructor to create an Empleado from a `JSONObject`.

Once we have loaded data, create a method who find or check this information:

### 1.1.1. Wrong department

Show Empleados who has a wrong Departamento. Imagine that you have this array:

```java
ArrayList<Integer> departamentos= new ArrayList<>(Arrays.asList(10,20,30,40,50));
```

### 1.1.2. The Boss

For each Empleado show how many other Empleados has at his orders. Think that DIR field means DIRECTOR

## 1.2. Creating new data

- Create file **_newEmpleados.xml_** changing the structure:

Original in XML

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
<Empleados>
  <Empleado dept="20" dir="7902" number="7369">
    <Apellido>SÁNCHEZ</Apellido>
    <Oficio>EMPLEADO</Oficio>
    <Administrativos>
      <Fecha_Alta>Mon Dec 17 00:00:00 CET 1990</Fecha_Alta>
      <Salario>1040.0</Salario>
      <Comision>0.0</Comision>
    </Administrativos>
  </Empleado>
  ...
</Empleados>
```

> You have to do a method inside Empleado class in order to create one Empleado information.

## 1.3. Generating data

Starting with data from Empleados and Departamentos (you can use methods to load as your own or reuse from first week task), generate a JSON file with information similar to this:

```json
{"Empresa": [
    {
        "TOTAL": 8675,
        "LOC": "SEVILLA",
        "DNOMBRE": "CONTABILIDAD",
        "EMPLEADOS": [
            {
                "APELLIDO": "REY",
                "FECHA_ALT": "Sun Nov 17 00:00:00 CET 1991",
                "COMISION": 0,
                "SALARIO": 4100,
                "EMP_NO": 7839,
                "OFICIO": "PRESIDENTE",
                "DEPT_NO": 10
            },
            {
                "APELLIDO": "CEREZO",
                "FECHA_ALT": "Sun Jun 09 00:00:00 CEST 1991",
                "COMISION": 0,
                "SALARIO": 2885,
                "EMP_NO": 7782,
                "OFICIO": "DIRECTOR",
                "DEPT_NO": 10
            },
            {
                "APELLIDO": "MUÑOZ",
                "FECHA_ALT": "Thu Jan 23 00:00:00 CET 1992",
                "COMISION": 0,
                "SALARIO": 1690,
                "EMP_NO": 7934,
                "OFICIO": "EMPLEADO",
                "DEPT_NO": 10
            }
        ],
        "DEPT_NO": 10
    },
    {
        "TOTAL": 11370,
        "LOC": "MADRID",
        "DNOMBRE": "INVESTIGACIÓN",
        "EMPLEADOS": [
            {
                "APELLIDO": "JIMÉNEZ",
                "FECHA_ALT": "Tue Apr 02 00:00:00 CEST 1991",
                "COMISION": 0,
                "SALARIO": 2900,
                "EMP_NO": 7566,
                "OFICIO": "DIRECTOR",
                "DEPT_NO": 20
            },
            {
                "APELLIDO": "GIL",
                "FECHA_ALT": "Sat Nov 09 00:00:00 CET 1991",
                "COMISION": 0,
                "SALARIO": 3000,
                "EMP_NO": 7788,
                "OFICIO": "ANALISTA",
                "DEPT_NO": 20
            },
            {
                "APELLIDO": "SÁNCHEZ",
                "FECHA_ALT": "Mon Dec 17 00:00:00 CET 1990",
                "COMISION": 0,
                "SALARIO": 1040,
                "EMP_NO": 7369,
                "OFICIO": "EMPLEADO",
                "DEPT_NO": 20
            },
            {
                "APELLIDO": "ALONSO",
                "FECHA_ALT": "Mon Sep 23 00:00:00 CEST 1991",
                "COMISION": 0,
                "SALARIO": 1430,
                "EMP_NO": 7876,
                "OFICIO": "EMPLEADO",
                "DEPT_NO": 20
            },
            {
                "APELLIDO": "FERNÁNDEZ",
                "FECHA_ALT": "Tue Dec 03 00:00:00 CET 1991",
                "COMISION": 0,
                "SALARIO": 3000,
                "EMP_NO": 7902,
                "OFICIO": "ANALISTA",
                "DEPT_NO": 20
            }
        ],
        "DEPT_NO": 20
    },
```

> TOTAL will be the total amount of salaries
