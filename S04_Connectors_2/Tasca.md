# 1. Data manipulation. Queries and resultset

> Notes:
> 
> - In this exercise you need to create a database (empty) with structure studied in first two weeks. You need to run script `Depart-Emple-light.sql` to create our database.
> - Then we are going to perform crud operations in our database

# 2. Insert

Let's go to populate our database. Starting with methods created in previous weeks:

1. Load all Departments in memory.
2. For each Department, insert it on Department table.
3. Create a function `int getMaxDepID`, who retrieves maximum Department number from database.
4. Ask user for a new Department data, and insert it. You must generate a new ID by adding 10 to max ID stored in database (calling last part method).

# 3. Insert

Similar to last exercise:

1. Load all Empleado in memory.
2. For each Empleado, insert it on Department table.

# 4. Update

Create a java program who ask user for a department number, and update salaries of its workers increasing in 5%. Show on screen how many workers have been changed

# 5. Delete

Whe have detected unorthodox behaviors in a report. The boss's name was partially erased in the report, and the text `EZ` appears in the name (field APELLIDO) and the text `LIS` appears in the job. Delete all the workers who work at his/her orders.

# 6. Queries

Let's go to do some queries:


## 6.1. Create a function who receives a department number and show how many workers have. 

1. Show its number on screen
2. Use prepared statement

## 6.2. Create a function whe receives a year, and return all empleado who started to work on that year.

1. Use prepared statement
2. The function must return an `ArrayList<Empleado>`
3. Show the workers on screen

## 6.3. Create a function that, starting with and Oficio, computes all the maximum, minimum and average salary, for this Oficio.

1. Use prepared statement
2. Show this information on screen