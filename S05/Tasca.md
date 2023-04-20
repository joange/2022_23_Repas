# Creating Hibernate projects

## Hibernate project management

Create a maven project to work with hibernate. You must setup:

1. `pom.xml` file with dependencies to:
  - Lombok, version > 1.18
  - Mysql connector, version > 8.0
  - Hibernate core, version > 6.2
> use Java17 as java compiler
2. Create a `hibernate.cfg.xml` file with usual configuration
3. Create `HibernateUtil.java` class as in the notes
4. Call a `testHibernate` method from `main`  in `App.java`  (main class). Check for any information about deprecated commands and solve it.

## Mapping a single class

Create a class with this structure:

```java
public class Profesor {
    private Long id;
    private String nombre;
    private String ape1;
    private String ape2;  
```

and map it in order to use it with hibernate. Modify `App.java` to the next code:

```java
public class App {
    
    private Session laSessio;

    public static void main(String[] args) {
      App app = new App(); 
      app.testHibernate();
    }
    
    public void testHibernate(){
      // get a Session and start a transaction
      laSessio=HibernateUtil.getSessionFactory().getCurrentSession();
      laSessio.getTransaction().begin();

      // create a Profesor, show, store it and show again
      Profesor p= new Profesor("Joan","Camarena","Estruch");
      System.out.println(p);  
      laSessio.persist(p);
      System.out.println(p);

      //close all
      laSessio.getTransaction().commit();
      laSessio.close();
    }
}
```