# prices-api
- API REST que devuelve el precio aplicable para un producto/marca en una fecha concreta
- El proyecto está organizado siguiendo una arquitectura hexagonal, separando los objetos de dominio de la infraestructura empleada

# Features
- Arquitectura hexagonal
- Organización en varios módulos _maven_
- H2 como base de datos
- _API first_, toda la generación del código se hace automáticamente

# Requisitos
- Java 17

# Instrucciones

## Generación de código y compilación
```
mvn compile
```
## Tests
```
mvn test
```
## Ejecución
```
curl -s -X GET "http://localhost:8080/api/prices?brandId=1&productId=35455&date=2020-06-14T10:00:00" -H "Accept: application/json"
```
## Generación del binario de distribución
El archivo JAR resultante se puede localizar en `app/target`
```
mvn package
```