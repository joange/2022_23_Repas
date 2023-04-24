# 1. Creating Hibernate projects

## 1.1. Hibernate project management

Create a maven project to work with hibernate. You must setup:

1. `pom.xml` file with dependencies to:
  - Lombok, version > 1.18
  - Mysql connector, version > 8.0
  - Hibernate core, version > 6.2
> use Java17 as java compiler
2. Create a `hibernate.cfg.xml` file with usual configuration
3. Create `HibernateUtil.java` class as in the notes
4. Call a `testHibernate` method from `main`  in `App.java`  (main class). Check for any information about deprecated commands and solve it.

## 1.2. Mapping a single class

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


## 1.3. One to one relationship

Create two single classes Profe and Direccion, where a Profe contains a Direction. Use Lombok to create default getters and setters, no args constructor and others constructors you need.

Following the notes, create an attribute called `id_direccion` where the foreign key starts, pointing to primary key of Direccion table.

Try this code:

```java
public void Ejercicio3(){
    laSessio=HibernateUtil.getSessionFactory().getCurrentSession();
    laSessio.getTransaction().begin();
    
    Direccion direccion=new Direccion("Plaza del ayuntamiento", 8, "Xativa", "Valencia");
    Profe profesor=new Profe("Juan", "Perez", "García");
    profesor.setDireccion(direccion);

    // next code

    laSessio.persist(profesor);
    laSessio.getTransaction().commit();
    laSessio.close();
}
```

Add following code in `// next code` comment and run again. What happens? Why?

```java
Profe profesor2=new Profe("Pepe", "Gomez", "Sanchis");
profesor2.setDireccion(direccion);
laSessio.persist(profesor2);
```

## 1.4. One to many unidirectional

Let's go to create a simple relationship between Item bought in Cart.

- Store only Id's. 
- A Cart must have several Items, 
- and a Item must be on a Cart. 
- In order to do a easy exercise avoid `cascades` and `fetch`.
- Using Lombok avoid recursions produced by `toString` and `Equals`

## 1.5. Modify relationships

If you run this code:

```java
laSessio=HibernateUtil.getSessionFactory().getCurrentSession();
laSessio.getTransaction().begin();

Cart cart=laSessio.get(Cart.class, 1L);
System.out.println(cart);

Item item=new Item(cart);
cart.getItems().add(item);

laSessio.persist(cart);

laSessio.getTransaction().commit();
laSessio.close();
```

If you check database, the `Item` won't be persisted. Modify `Item` (and `Cart`) classes in order to persist the related object when save the main object (save Item when you save Carts).

Modify relationship to load the related objects:
  - Always in the object at M relation (the Item)
  - When you need in the 1 relation part (the Cart)

