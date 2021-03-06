# recetas-app
API RESTful de recetas implementada usando Play Framework para máster MIMO

## Running

Run this using [sbt](http://www.scala-sbt.org/)

```
sbt run
```
⚠️ La base de datos es H2 por lo que es local.

Las peticiones a la app se realizarán desde: http://localhost:9000. Con la ruta y el verbo correspondiente.

## Peticiones receta
### Crear receta: `POST`
Para crear una receta se debe hacer una peticion `POST` a http://localhost:9000/recetas con el siguiente cuerpo **JSON**:

      {
        "nombre": "Cocido de garbanzos",
        "tiempo": "45",
        "tipo": "omnivoro",
        "usuario": {"nombre": "Raquel Ch"},
        "descripcion": {"texto": "Delicioso cocido de garbanzos madrileño con carne y sopa"},
        "ingredientes": [
            {"nombre": "garbanzos"},
            {"nombre": "carne"},
            {"nombre": "patata"},
            {"nombre": "zanahoria"}
        ]
      }
      
### Buscar receta: `GET`
Busca una o varias recetas según los siguientes parámetros:
- Según el id de la receta: `GET` http://localhost:9000/recetas/search/id/#id#   
- Según el nombre de la receta: `GET` http://localhost:9000/recetas/search/nombre/#nombre#
- Según el tiempo (min): `GET` http://localhost:9000/recetas/search/tiempo/#tiempo#
- Según el tipo (vegano, vegetariano, omnívoro): `GET` http://localhost:9000/recetas/search/tipo/#tipo#
- Según el ingrediente (id): `GET` http://localhost:9000/recetas/search/ingrediente/id/#id#
- Según el usuario (id): `GET` http://localhost:9000/recetas/search/usuario/id/#id#
- TODA la lista de recetas: `GET` http://localhost:9000/recetas/list

Los parámetros se pasan en la URL sustituyendo los valores entre "##"
Para elegir el formato de la respuesta es necesario especificar el lenguaje (**json** o **xml**) en la cabecera.

Un ejemplo de peticion: `GET` http://localhost:9000/recetas/search/nombre/cocido con respuesta en xml

```
      <?xml version="1.0" encoding="utf-8" ?>
      <recetas>
          <receta>
              <nombre>Cocido de garbanzos</nombre>
              <tiempo>45</tiempo>
              <tipo>omnivoro</tipo>
              <usuario>
                  <nombre>Raquel Ch</nombre>
              </usuario>
              <descripcion>
                  <texto>Delicioso cocido de garbanzos madrileño con carne, verduras y sopa de fideos.</texto>
              </descripcion>
              <ingredientes>
                  <ingrediente>
                      <nombre>garbanzos</nombre>
                  </ingrediente>
                  <ingrediente>
                      <nombre>carne</nombre>
                  </ingrediente>
                  <ingrediente>
                      <nombre>patata</nombre>
                  </ingrediente>
                  <ingrediente>
                      <nombre>zanahoria</nombre>
                  </ingrediente>
                  <ingrediente>
                      <nombre>sal</nombre>
                  </ingrediente>
              </ingredientes>
          </receta>
      </recetas>
```


### Actualizar receta: `PUT`
Para actualizar una receta (añadir o eliminar ingredientes de la receta, editar tiempo, tipo, usuario...) es necesario pasar en el JSON la id de la receta:

      {
        "id": 1,
        "nombre": "Cocido de garbanzos",
        "tiempo": "45",
        "tipo": "omnivoro",
        "usuario": {"nombre": "Raquel Ch"},
        "descripcion": {"texto": "Delicioso cocido de garbanzos madrileño con carne y sopa"},
        "ingredientes": [
            {"nombre": "garbanzos"},
            {"nombre": "carne"},
            {"nombre": "patata"},
            {"nombre": "zanahoria"}
        ]
      }
      
⚠️ No vale con introducir solo el campo a editar. Toda la receta debe ser enviada en el JSON

Ejemplo: `PUT` http://localhost:9000/recetas/  + body JSON
### Eliminar receta `DELETE`:
Para eliminar una receta es necesario pasar la id de la receta en la url: `DELETE` http://localhost:9000/recetas/#id#
Este paso no eliminará el usuario ni los ingredientes que tenía la receta puesto que estos no dependen únicamente de la receta.

## Peticiones ingredientes
### Buscar ingredientes: `GET`

Busca una o varios ingredientes según los siguientes parámetros:
- Según el id del ingrediente: `GET` http://localhost:9000/ingredientes/search/id/#id#   
- Según el nombre del ingrediente: `GET` http://localhost:9000/ingredientes/search/nombre/#nombre#

Los parámetros se pasan en la URL sustituyendo los valores entre "##"
Para elegir el formato de la respuesta es necesario especificar el lenguaje (**json** o **xml**) en la cabecera.

Un ejemplo de peticion: `GET` http://localhost:9000/ingredientes/search/nombre/garbanzo con respuesta en JSON:

      {
          "ingredientes": [
              {
                  "id": 1,
                  "nombre": "garbanzos"
              }
          ]
      }
### Actualizar ingrediente: `PUT`
Para actualizar un ingrediente (editar nombre) es necesario pasar en el JSON la id del ingrediente:

      {
        "id": 5,
        "nombre": "chorizo",
      }
      
Ejemplo: `PUT` http://localhost:9000/ingredientes/  + body JSON

## Peticiones usuarios
### Buscar usuarios: `GET`

Busca uno o varios usuarios según los siguientes parámetros:
- Según el id del usuario: `GET` http://localhost:9000/usuarios/search/id/#id#   
- Según el nombre del usuario: `GET` http://localhost:9000/usuarios/search/nombre/#nombre#

Los parámetros se pasan en la URL sustituyendo los valores entre "##"
Para elegir el formato de la respuesta es necesario especificar el lenguaje (**json** o **xml**) en la cabecera.

Un ejemplo de peticion: `GET` http://localhost:9000/usuarios/search/nombre/raquel con respuesta en JSON:

      {
          "usuario": [
              {
                  "id": 1,
                  "nombre": "Raquel Ch"
              }
          ]
      }
### Actualizar usuario: `PUT`
Para actualizar un usuario (editar nombre) es necesario pasar en el JSON la id del usuario:

      {
        "id": 5,
        "nombre": "Juanjo F.",
      }
      
Ejemplo: `PUT` http://localhost:9000/usuarios/  + body JSON

## Peticion descripciones
### Actualizar descripción: `PUT`
Para actualizar una descripción (editar texto) es necesario pasar en el JSON la id de la descripción:

      {
        "id": 5,
        "texto": "Delicioso cocido de garbanzos madrileño con carne, verduras y sopa de fideos.",
      }
      
Ejemplo: `PUT` http://localhost:9000/descripcion/  + body JSON

