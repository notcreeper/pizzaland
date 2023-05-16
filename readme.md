<!-- ///////// Partie 1 Les ingredients  ////////// -->

<!-- GET /ingredients/{id} -->

curl -X 'GET' \
  'http://localhost:8080/ingredients/1' \
  -H 'accept: */*'

renvoi l'ingredient
{
  "id": 1,
  "nom": "chorizo",
  "prix": 5
}

curl -X 'GET' \
  'http://localhost:8080/ingredients/88' \
  -H 'accept: */*'

Error: response status is 404

<!-- GET /ingredients -->

curl -X 'GET' \
  'http://localhost:8080/ingredients' \
  -H 'accept: */*'
[
  {
    "id": 1,
    "nom": "chorizo",
    "prix": 5
  },
  {
    "id": 2,
    "nom": "olives",
    "prix": 3
  },
  {
    "id": 3,
    "nom": "tomates",
    "prix": 5
  },
  {
    "id": 4,
    "nom": "oeufs",
    "prix": 2
  }
]

curl -X 'GET' \
  'http://localhost:8080/ingredients' \
  -H 'accept: */*'

(si il n'y a pas de pizza dans la list)
Error: response status is 404

<!-- POST /ingredients -->
curl -X 'POST' \
  'http://localhost:8080/ingredients' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "id": 8,
  "nom": "fromage",
  "prix": 10
}'

Result : 
{
  "id": 8,
  "nom": "fromage",
  "prix": 10
}


<!-- ///////// Partie 2 Les pizzas  ////////// -->

Dû à de nombreux problèmes durant le ds je n'ai rien pu faire je vais vous le renvoyer

<!-- GET /pizzas/{id} -->

curl -X 'GET'   'http://localhost:8080/pizzas/10'   -H 'accept: */*'
renvoie une pizza
{"id":10,"nom":"margarita","prix":10,"ingredients":[{"id":3,"nom":"tomates","prix":5},{"id":4,"nom":"oeufs","prix":2}]}

curl -X 'GET'   'http://localhost:8080/pizzas/1'   -H 'accept: */*'
renvoie une erreur (la pizza n'existe pas)
Error: response status is 404



<!-- GET /pizzas/{id}/prixfinal -->

curl -X 'GET' \
  'http://localhost:8080/pizzas/10/prixfinal' \
  -H 'accept: */*'
renvoie un interger:
10

curl -X 'GET' \
  'http://localhost:8080/pizzas/1/prixfinal' \
  -H 'accept: */*'
renvoie une erreur (la pizza n'existe pas)
Error: response status is 404


<!-- GET /pizzas -->
curl -X 'GET' \
  'http://localhost:8080/pizzas' \
  -H 'accept: */*'
[
  {
    "id": 10,
    "nom": "margarita",
    "prix": 10,
    "ingredients": [
      {
        "id": 3,
        "nom": "tomates",
        "prix": 5
      },
      {
        "id": 4,
        "nom": "oeufs",
        "prix": 2
      }
    ]
  },
  {
    "id": 20,
    "nom": "reine",
    "prix": 12,
    "ingredients": [
      {
        "id": 1,
        "nom": "chorizo",
        "prix": 5
      },
      {
        "id": 2,
        "nom": "olives",
        "prix": 3
      },
      {
        "id": 3,
        "nom": "tomates",
        "prix": 5
      }
    ]
  }
]

curl -X 'GET' \
  'http://localhost:8080/pizzas' \
  -H 'accept: */*'
  renvoie une erreur (aucune pizza)


<!-- POST /pizzas -->
curl -X 'POST' \
  'http://localhost:8080/pizzas' \
  -H 'accept: */*'
  {
  "id": 70,
  "nom": "La 4 fromage XL",
  "prix": 10,
  "ingredients": [
    {
      "id": 50,
      "nom": "fromage",
      "prix": 5,
      "pizzas": [
        "La 4 fromage XL"
      ]
    }
  ],
  "commandes": [
    {
      "id": 60,
      "dat": "2023-02-15T12:10:57.306Z",
      "login": "string"
    }
  ]
}

Result:
{
  "id": 0,
  "nom": "string",
  "prix": 0,
  "ingredients": [
    {
      "id": 0,
      "nom": "string",
      "prix": 0,
      "pizzas": [
        "string"
      ]
    }
  ],
  "commandes": [
    {
      "id": 0,
      "dat": "2023-02-15T12:14:10.905Z",
      "login": "string"
    }
  ]
}



curl -X 'POST' \
  'http://localhost:8080/pizzas' \
  -H 'accept: */*'
  {
  "id": 10,
  "nom": "La 4 fromage XL",
  "prix": 10,
  "ingredients": [
    {
      "id": 50,
      "nom": "fromage",
      "prix": 5,
      "pizzas": [
        "La 4 fromage XL"
      ]
    }
  ],
  "commandes": [
    {
      "id": 60,
      "dat": "2023-02-15T12:10:57.306Z",
      "login": "string"
    }
  ]
}
renvoie une erreur (la pizza existe déjà)
Error: response status is 409




<!-- ///////// Partie 3 Les Commandes  ////////// -->

<!-- POST/commandes -->

curl -X 'POST' \
  'http://localhost:8080/commandes' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "id": 2,
  "dat": "2023-02-15T12:35:21.060Z",
  "login": "test"
}'

result:
{
  "id": 2,
  "dat": "2023-02-15T12:35:21.060+00:00",
  "login": "test"
}


<!-- GET /commandes/{id} -->

curl -X 'GET' \
  'http://localhost:8080/commandes/1' \
  -H 'accept: */*'

renvoie une commande:
{
  "id": 1,
  "dat": "2023-02-15",
  "login": "jean"
}


curl -X 'GET' \
  'http://localhost:8080/commandes/5' \
  -H 'accept: */*'

renvoie error (la commande n'existe pas):
response status is 404


<!-- GET /commandes/{id}/prixfinal -->

curl -X 'GET' \
  'http://localhost:8080/commandes/1/prixfinal' \
  -H 'accept: */*'

renvoie un integer du prix final : 22

Qui correspond a :
insert into pizza values (10,'margarita',10);
insert into pizza values (20,'reine',12);



curl -X 'GET' \
'http://localhost:8080/commandes/2/prixfinal' \
-H 'accept: */*'
renvoie error (la commande n'existe pas):
response status is 404



<!-- GET /commandes/ -->

curl -X 'GET' \
  'http://localhost:8080/commandes/' \
  -H 'accept: */*'

result:
	
[
  {
    "id": 1,
    "dat": "2023-02-15",
    "login": "jean"
  }
]


curl -X 'GET' \
  'http://localhost:8080/commandes/' \
  -H 'accept: */*'
renvoie error (si aucune commande):
response status is 404


<!-- ///////// Partie 4 Restrictions d'accès  ////////// -->

Avec un Delegating passwordencoder en bonus Terminier pendant la pause du midi ^^
curl -X 'GET'   'http://localhost:8080/ingredients'   -H 'accept: */*' -u jean:jean