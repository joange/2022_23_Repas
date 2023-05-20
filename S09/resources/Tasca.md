Improving our web app

Let's go to create a functional application

#  1. People

Create a People repository, service and controller with default CRUD operations.

> We do not create a DTO

# 2. Shopping cart

> We do not create a DTO
 
Create repository, service by default. After that, let's go to create necessary methods in service and controller in order to...

> **REMEMBER** It is very important to delegate application logic to service instead of controller:
>
> - Controller -> get the request, adapt the results, and set the response
> - Service -> attend the controller and, using the repository, do the main work and checks.

## 2.1. Get one/all shopping carts

Create two GET request, one for get a given shopping cart, one for get all shopping carts.

## 2.2. Create an empty shopping cart

Create a POST request in order to create an empty shopping cart. You need to send a `{}` empty json object to create it.

## 2.3. Add an owner to the shopping cart

Create a PUT request, to your shopping cart, like `PUT http://localhost:9090/shoppingCart/3/people/23/`. This will set the user 23 as the owner of shopping cart 3. You must check than:

- Shopping cart 3 exists; you must set an error otherwise.
- People 23 exists; you must set an error otherwise.

> We must use this request in order to change the owner

## 2.4. Add a product to your shopping cart

Create a PUT request, to your shopping cart, like `PUT http://localhost:9090/shoppingCart/3/product/17/`. This will add the product 17 as the owner of shopping cart 3. You must check than:

- Shopping cart 3 exists; you must set an error otherwise.
- Product 17 exists; you must set an error otherwise.

> We must use this request in order to change the owner

## 2.5. Remove a product to a shopping cart


Create a DELETE request, to your shopping cart, like `DELETE http://localhost:9090/shoppingCart/3/product/17/`. This will remove the product 17 as the owner of shopping cart 3. You must check than:

- Shopping cart 3 exists; you must set an error otherwise.
- Product 17 exists; you must set an error otherwise.

# EXTRA

Create a new class ServedShoppingCart, inheriting ShoppingCart. This class is used when user accept the shopping cart in order to buy. This will add to shopping cart two extra fields:

- `total`, computd as the sum of the product's price
- `paid`, booleans that said if the cart is paid or not.