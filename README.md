# prices-api
- API REST que devuelve el precio aplicable para un producto/marca en una fecha concreta
- El proyecto está organizado siguiendo una arquitectura hexagonal, separando los objetos de dominio de la infraestructura empleada

# Features
- Arquitectura hexagonal
- Organización en varios módulos _maven_
- H2 como base de datos
- _API first_, toda la generación del código se hace automáticamente
- 
# Instrucciones

## Generación de código y compilación
```
mvn compile
```
## Tests
```
mvn test
```

## Generación del binario de distribución
El archivo JAR resultante se puede localizar en `app/target`
```
mvn package
```