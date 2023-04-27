# 1. Many to Many relationShips

Imagine we want to model a video game, in which we have to store weapons (`Arma`) and enemies (`Enemigo`). We need to store a relationship between them: an Enemy can equip with several weapons, and a weapon can be equip by several enemies.

Enemy: Nombre + Vida + Puntos
Arma:  Nombre + Descripcion + Danyo

> We do not need to store any more information, only and id for each class

We need to:

- Create a class for each class
- Map each class to store in respective table
- Map the N:M relationship on a table called EnemigoLlevaArma

Run this code to create and generate tables:

```java
public class App {
   
  private Session laSessio;

  public static void main(String[] args) {
      App app=new App();
      
      app.testHibernate();
  }
  
      public void testHibernate(){
      // get a Session and start a transaction
      laSessio=HibernateUtil.getSessionFactory().getCurrentSession();
      laSessio.getTransaction().begin();
      

      
      laSessio.getTransaction().commit();
      laSessio.close();
  }
        
}
```
# 2. What's happen?

If last exercise was well done, you get something like this:

```sh
Hibernate: create table Armas (idArma bigint not null auto_increment, danyo integer, descripcion varchar(255), nombre varchar(255), primary key (idArma)) engine=InnoDB
Hibernate: create table EnemigoLlevaArma (id_enemigo integer not null, id_arma bigint not null, primary key (id_enemigo, id_arma)) engine=InnoDB
Hibernate: create table Enemigos (idEnemigo integer not null auto_increment, nombre varchar(255), puntos integer, vida integer, primary key (idEnemigo)) engine=InnoDB
Hibernate: alter table EnemigoLlevaArma add constraint FKd8iv42lyvpuku4vpoakr5asql foreign key (id_arma) references Armas (idArma)
Hibernate: alter table EnemigoLlevaArma add constraint FK9cgn32ose175v4cpp7ha81ime foreign key (id_enemigo) references Enemigos (idEnemigo)
```

Revise the database once your tables have been created. Revise how hibernate works.

# 3. Storing objects

Run this code:
```java
Arma a1 = new Arma("Dark Saber", "Dark saber who turns Mandalorean Power", 90);
Arma a2 = new Arma("Light Saber", "Jedi saber to young padawans", 70);

Enemigo e1= new Enemigo("Yoda", 100, 50);
Enemigo e2= new Enemigo("Bo katan", 80, 70);
Enemigo e3= new Enemigo("Grogu", 60, 120);  

// assign weapons to enemies

e1.getArmas().add(a2);

e2.getArmas().add(a1);

e3.getArmas().add(a1);
e3.getArmas().add(a2);

// store objects
laSessio.persist(a1);
laSessio.persist(a2);

change lines for these;

```java
laSessio.persist(e1);
laSessio.persist(e2);
laSessio.persist(e3);
```

What's the difference?

# 4. Managing objects

Preparing the environment:

- In resources folder you have `Batallas.sql` to create a daatabase. Run it on your database server.
- Create a hibernate project to access new database.
- Add four classes on a `Model` package and adapt it to your project. Remove methods and constructors in order to use Lombok

Create a class `DAOBarco` who contains next methods:

- `List<Barco> getAllBarcos();`
- `Barco getBarcoById(Long id);`
- `Long addBarco(Barco b);`
- `boolean removeBarco(Barco b);`
- `boolean removeBarco(Long id);`
- `boolean updateBarco(Long id, Barco b);`

# 5. Advance option

Add new methods to:

1. Ask a user for a new Battle
2. Show all Barco in database and ask user for a list of numbers, separated by commas
3. Add given Barco as participating in this Battle
4. Store it

# 6. Check it

Recover from database battle created in last exercise, and show it on screen.