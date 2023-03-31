# 1. Asking database

## 1.1. `LaConexio` a class to manage connection

Create a utility class to manage connection with your MySQL server. This class must:

1. Create a non-arguments constructor which assign to private variables connection information (user, password and so).
2. Create constructor who receives a String, with a filename properties, and load connection information. 
3. Create methods to:
   1. Return an open Connection object.
   2. Close the connection


## 1.2. Alternatives (non mandatory, at your own)

Repeat the same process to connect to a:

- PostgreSQL
- SQLite

## 1.3. `describe` database

Create a Java program that shows on screen:

1. Show information about server name and version.
2. Show how many databases exists on the server.
3. Enter on de second database in the list
   1. Show tables names on that database.
   2. Show second table's columns, if exists
   
## 1.4. Creating a new database

Create a Java program that request a database name. It will check if that database name exist or not in our server. If it does not exist, it will create, running next code:

```java
Connection con=...; // init connection object
String query = "create database " + databasename; 
Statement stm = con.createStatement();
int result = stm.executeUpdate(query);
System.out.println("Executed script with " + result + " result");
```

## 1.5. Creating new table on new database

Complete last program, running next script stored on a single file called `script.sql`:

```sql
CREATE TABLE People (
    PersonID int,
    LastName varchar(255),
    FirstName varchar(255),
    Address varchar(255),
    City varchar(255) 
);

INSERT INTO `People` VALUES (...);
```

> Remember to set  `allowMultipleQueries=true` parameter in Connection string, due to a script could have several sentences

## 1.6. Check you're right

Create a Java program that show data structure (columns, types and keys) og table People in database you created.