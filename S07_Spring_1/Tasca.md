# 1. Setup Spring project

Create a new Spring project via Spring Studio (**Starter Project**). Remember that you can do the same in Spring Initilizr <https://start.spring.io>.

Select:

- Java 17
- Maven
- Spring Boot 3.0.6
- Dependencies:
  - Web
  - Lombok
  - MySQL
  - JPA

Once you have created:

1. Build it. Or Project -> Clean and rebuild it.
2. Update project vis Maven
3. Delete `src/test/java/` folder
4. First run (right click and `Run Spring)and check Tomcat is working via <http://localhost:80> on your web browser.


> It's recommended to install last version of Spring Tools Suite Version: 4.18.1.RELEASE

# 2. First configuration

Setup in `application.properties` (under `/src/main/resources`) all necessary configuration to:

- make the application listening in 9090 port
- setup database configuration under your server
- setup hibernate configuration to update changes done in database, show sql and works in a case sensitive way.
- run it and check the changes

# 3. First controller

Add a controller who maps `/test`, and create this services:

- `/test/`: will return `Hello World`
- `/test/name?name=Antonio` : will return `Hola Antonio`
- `/test/name?name=Antonio&edad=27` : will return `Hola Antonio, tu puedes|no puedes votar`, depending of the age.
- `/test/people`: Pass to this service this JSON object named people, like this

```json
{
	"name":"Joan Gerard",
	"age":46,
	"topics":["Java","Python","Nodejs"]
}
```
- `/test/people/1998/year`: will return `Hello to all people who were born in 1998`.

> Test all previous requests with [Postman](https://www.postman.com)

# 4. First model

Do all necessary to:

- Create a simple class to store information in a new package `model`. This class will be `People=Id + name + age`. `name` can not be null with a maximum length of 50 characters.
- The working database will be a `testdb` database
- The table will be created in when the project starts and dropped after the project finish.
- Insert a few rows stored in a file named `data.sql`. You can generate by your own in <https://filldb.info>
- Run the project and test yhe table has been created, data inserted and data dropped.


# 5. Completing another model

## 5.1. Product 
Starting with last exercise, create a class `Product` to represent several products in a online supemarket:

```java
public class Product {
 
	private Long id;
	private String name;
	private String description;
	private String category;
	private float price;
	private LocalDateTime creationDate;
}
```

Find a way to assign current time stamp to `creationDate`

## 5.2. ShoppingCart

Create a new class who represent a shopping cart. It will contains:

- An Id.
- The owner of the shopping cart.
- A collection of products.
- A `creationDate` and `lastUpdatedOn`, to store when the project was created and the last update done.

> Notes:
>
> - The owner is a unidirectional 1:N relationship with `People` (stored in ShoppingCart only).
> - The product is a N:M relationships, unidirectional (stored in ShoppingCart only).
> - Find a way to assign current time stamp to `creationDate`.
> - Find a way to update `lastUpdatedOn` every time the shopping cart was stored.



# 6. Extra
Pay attention:

default MySQL driver added by Spring. Works fine

```xml
	<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
```

Sometimes appear this error:
```
Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.
```

does not work. Change by
```xml
		<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
		<dependency>
		    <groupId>mysql</groupId>
		    <artifactId>mysql-connector-java</artifactId>
		    <version>8.0.33</version>
		</dependency>
```

