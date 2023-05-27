use petshop;

db;

db.createCollection('mammals');

show dbs;
show collections;

db.mammals.insert({name: "Polar Bear"});
db.mammals.insert({name: "Star Nosed Mole"});

db.mammals.find();

db.pets.insert({name: "Mikey", species: "Gerbil"})
db.pets.insert({name: "Davey Bungooligan", species: "Piranha"})
db.pets.insert({name: "Suzy B", species: "Cat"})
db.pets.insert({name: "Mikey", species: "Hotdog"})
db.pets.insert({name: "Terrence", species: "Sausagedog"})
db.pets.insert({name: "Philomena Jones", species: "Cat"});


// Add another piranha, and a naked mole rat called Henry.
db.pets.insert({name: "Kevin", species: "Piranha"});
db.pets.insert({name: "Henry", species: "Naked Mole Rat"});

//Use find to list all the pets. Find the ID of Mikey the Gerbil.
db.pets.find();
db.pets.find({"name":"Mikey","species":"Gerbil"},{"_id":1});

// Use find to find Mikey by id.
db.pets.find({"_id" : ObjectId("646cc600238307819a3bf2ab")});

//Use find to find all the gerbils.
db.pets.find({"species":"Gerbil"})

//Find all the creatures named Mikey.
db.pets.find({"name":"Mikey"})

//Find all the creatures named Mikey who are gerbils.
db.pets.find({"name":"Mikey","species":"Gerbil"});

//Find all the creatures with the string "dog" in their species.
db.pets.find({"species":/dog/})



use people
(function() {
  var names = [
    'Yolanda',
    'Iska',
    'Malone',
    'Frank',
    'Foxton',
    'Pirate',
    'Poppelhoffen',
    'Elbow',
    'Fluffy',
    'Paphat'
  ]
  var randName = function() {
    var n = names.length;
    return [
      names[Math.floor(Math.random() * n)],
      names[Math.floor(Math.random() * n)]
    ].join(' ');
  }
  var randAge = function(n) {
    return Math.floor(Math.random() * n);
  }
  for (var i = 0; i < 1000; ++i) {
    var person = {
      name: randName(),
      age: randAge(100)
    }
    if (Math.random() > 0.8) {
      person.cat = {
        name: randName(),
        age: randAge(18)
      }
    }
    db.people.insert(person);
  };
})();

db.people.find();

// Find all the people with cats.
db.people.find({cat:{$exists:true}});

// Find all the pensioners with cats.
db.people.find({cat:{$exists:true},age:{$lte:18}});

// Find all the teenagers with teenage cats.
db.people.find({cat:{$exists:true},"cat.age":{$lte:2}});

// Find all people with cat that neither teenager the people or the car
db.people.find({$and:[{cat:{$exists:true}},    
               {$or:[{age:{$lte:18}},{"cat.age":{$lte:2}}]}]
               });
               
