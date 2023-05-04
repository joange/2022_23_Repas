# 1. Many to Many relationShips

Imagine we want to model a video game, in which we have to store weapons (`Arma`) and enemies (`Enemigo`). We need to store a relationship between them: an Enemy can equip with several weapons, and a weapon can be equip by several enemies.

Enemy: Nombre + Vida + Puntos
Arma:  Nombre + Descripcion + Danyo

> We do not need to store any more information, only and id for each class

We need to:

- Create a class for each class
- Map each class to store in respective table
- Map the N:M relationship on a table called `EnemigoLlevaArma`

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
```

change lines for these;

```java
laSessio.persist(e1);
laSessio.persist(e2);
laSessio.persist(e3);
```

What's the difference?

# 4. Managing objects

## Preparing our project

Preparing the environment:

- In resources folder you have `Batallas.sql` to create a database. Run it on your database server.
- Create a hibernate project to access new database.
- Add four classes on a `Model` package and adapt it to your project. Adapt methods and constructors in order to use Lombok

> **Important**: 
> - Set `validate` in `hbm2ddl` option in `hibernate.cfg.xml` file. This will check if you set the classes according to the database.
> - Values for `resultado` in `Participa` table are integers on database, but it will be an enumeration in our java program:
```java
public class Participa {
    
    public static enum Resultado {
        ILESO, DAÑADO, HUNDIDO
    }
    
    //Other fields anb methods

    @Column(name = "resultado",columnDefinition = "int")
    private Resultado resultado;
}
```

## Create a class `DAOBarco` who contains next methods:

1. `List<Barco> getAllBarcos();`
2. `Barco getBarcoById(Long id);`
3. `List<Barco> getBarcosByClassName(String classname);`
4. `Long addBarco();` (in order to be easy, nor ask for `Clase` neither `Participa`, only Barco information). It will returns new Barcos's ID.
5. `void deleteBarco(Barco b);`
6. `void deleteBarco(Long id);`

## 5. Advanced options (proposed)

Add/Modify new methods to:
1. `Long addBarcoPlus();`. It will show all classes stored on database, user will pick up, and assign it to current Barco.
2. `Barco updateBarco(Long IDBarco)`: It will show for Barco fields one by one, except ID, showing current value and asking if you want to change it. If user say `yes` then introduce new value. If say no, the current value will be stored. Do not update `Participa`.
3. `void addParticipaciones(Long IDBarco)`: It will show all participaciones on screen, and enter a comma-seppareted list of its participations. It will assign to this Barco all Participaciones.

