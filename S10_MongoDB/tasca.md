# 1. MongoDB

Lets go to solve several queries in MongoDB and connect our application to it.

# 2. Queries

Let's go to do the course <http://nicholasjohnson.com/mongo/course/workbook/>.

# 3. Accessing from Java programs

Finally we will create a Java program to do several tasks. You have a file named `artists.json` in your resource folder. You have to import this file first.

```sh
mongoimport --host localhost --port 27017 \
  --authenticationDatabase \
  --username root --password root \
  --db artists --collection artists \
  --type json --file artists.json 
```

The data stored on this files are about famous artist  (mostly painters) from several nationalities, and has the next structure:

```json
{
  "_id" : ObjectId("6471ad556b4ef3f58bd6ff6d"),
  "name" : "Raffaello Sanzio da Urbino",
  "knownAs" : "Raphael",
  "born" : "1483-03-28T00:00:00.000Z",
  "died" : "1520-04-06T00:00:00.000Z",
  "nationality" : "Italian",
  "knownFor" : [
      "Painting",
      "Architecture"
  ],
  "movements" : [
      "High Renaissance"
  ]
}
```

## 3.1. Exercise 1

Show on screen full name (`name`) and nick (`knownAs`) from Italian (`nationality`) artists.

```
Document{{name=Leonardo di ser Piero da Vinci, knownAs=Leonardo da Vinci}}
Document{{name=Michelangelo di Lodovico Buonarroti Simoni, knownAs=Michelangelo}}
Document{{name=Raffaello Sanzio da Urbino, knownAs=Raphael}}
Document{{name=Michelangelo Merisi (or Amerighi) da Caravaggio, knownAs=Caravaggio}}
```

## 3.2. Exercise 2

Create a function to find the artist and how many abilities he has, returning only the number of more abilities he has.

```
Best artist is Pablo Diego José Francisco de Paula Juan Nepomuceno María de los Remedios Cipriano de la Santísima Trinidad Martyr Patricio Clito Ruíz y Picasso with 7 habilitites
```

## 3.3. Exercise 3

Show all artist, group by how many abilities they have (`knownFor`). It's a good idea to find first artist with one, then artist with to, etc. finishing with the number of abilities found in exercise 2.

```
Artists with 1 abilities:
==========================================
	Caravaggio
	Velázquez
	Vermeer
	Cézanne
	Monet
	Kandinsky
Artists with 2 abilities:
==========================================
	Raphael
	Rubens
	Rembrandt
Artists with 3 abilities:
==========================================
	Leonardo da Vinci
Artists with 4 abilities:
==========================================
	Michelangelo
	Goya
	Gauguin
Artists with 5 abilities:
==========================================
	Matisse
	Dalí
Artists with 6 abilities:
==========================================
Artists with 7 abilities:
==========================================
	Picasso
```




