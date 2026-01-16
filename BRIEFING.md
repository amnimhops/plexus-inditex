# Enunciado

En la base de datos de comercio electrónico de la compañía disponemos de la tabla `PRICES` que refleja el precio final (PVP) y la tarifa que aplica a un producto de una cadena entre unas fechas determinadas. A continuación se muestra un ejemplo de la tabla con los campos relevantes:

## PRICES

| BRAND_ID | START_DATE           | END_DATE             | PRICE_LIST | PRODUCT_ID | PRIORITY | PRICE  | CURR |
|----------|--------------------|--------------------|------------|------------|----------|--------|------|
| 1        | 2020-06-14-00.00.00 | 2020-12-31-23.59.59 | 1          | 35455      | 0        | 35.50  | EUR  |
| 1        | 2020-06-14-15.00.00 | 2020-06-14-18.30.00 | 2          | 35455      | 1        | 25.45  | EUR  |
| 1        | 2020-06-15-00.00.00 | 2020-06-15-11.00.00 | 3          | 35455      | 1        | 30.50  | EUR  |
| 1        | 2020-06-15-16.00.00 | 2020-12-31-23.59.59 | 4          | 35455      | 1        | 38.95  | EUR  |

### Campos

- **BRAND_ID**: foreign key de la cadena del grupo (1 = ZARA).
- **START_DATE, END_DATE**: rango de fechas en el que aplica el precio/tarifa indicado.
- **PRICE_LIST**: identificador de la tarifa de precios aplicable.
- **PRODUCT_ID**: identificador/código de producto.
- **PRIORITY**: desambiguador de aplicación de precios. Si dos tarifas coinciden en un rango de fechas se aplica la de mayor prioridad (mayor valor numérico).
- **PRICE**: precio final de venta.
- **CURR**: ISO de la moneda.

---

## Se pide

Construir una **aplicación/servicio en Spring Boot** que provea un **endpoint REST de consulta** tal que:

- **Parámetros de entrada**: fecha de aplicación, identificador de producto, identificador de cadena.
- **Datos de salida**: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.

Se debe utilizar una **base de datos en memoria (tipo H2)** e inicializar con los datos del ejemplo (se pueden cambiar nombres de campos, añadir otros nuevos y elegir el tipo de dato adecuado).

---

## Tests a desarrollar

Validar el endpoint REST con las siguientes peticiones usando los datos del ejemplo:

| Test | Fecha/Hora           | Producto | Brand |
|------|--------------------|---------|-------|
| 1    | 2020-06-14 10:00    | 35455   | 1 (ZARA) |
| 2    | 2020-06-14 16:00    | 35455   | 1 (ZARA) |
| 3    | 2020-06-14 21:00    | 35455   | 1 (ZARA) |
| 4    | 2020-06-15 10:00    | 35455   | 1 (ZARA) |
| 5    | 2020-06-16 21:00    | 35455   | 1 (ZARA) |

---

## Criterios de valoración

- Diseño y construcción del servicio.
- Calidad de código.
- Resultados correctos en los tests.  

---

## Entrega

El test deberá entregarse en formato **ZIP** y se compartirá la ubicación del archivo para su descarga (Google Cloud, OneDrive, etc.).
Es importante que el archivo se denomine ` PruebaTécnica_NombreApellido1Apellido2`

---

## Recomendaciones generales

- &#x2705;Aplicar **arquitectura Hexagonal**:
    - Separar las capas y limitar la visibilidad entre aplicación e infraestructura a través de interfaces o puertos de dominio.
    - &#x2705;Evitar el uso de frameworks en la capa de dominio, incluido Spring.
    - Realizar las inyecciones de dependencia por constructor.
    - Crear una estructura de paquetes adecuada: en infraestructura estructurar por tecnología (por ejemplo, base de datos, API REST, etc.), en dominio por entidad de dominio. Muy valorable crear submódulos con cada capa usando Maven.
- Buenas prácticas: limpieza de código, nombres de variables y métodos apropiados, aplicar metodología SOLID. Evitar comentarios innecesarios.
- Uso de **inmutabilidad** con `records` y variables finales.
- Evitar el uso de **queries nativas**.
- &#x2705;Muy valorable aplicar **API First** con OpenAPI para generar modelos y controladores.
- Manejo de excepciones:
    - Elevar las excepciones **checked** en capa de aplicación.
    - Capturarlas en el controlador y transformar en Runtime exceptions que se manejen con **@ControllerAdvice** para enviar una respuesta de error.
- Evitar el uso de `get`, `isPresent`, etc., de Optional: usar `map`, `orElse`, `orElseThrow`.
- Incluir **MapStruct** para los mappers entre entidades de cada capa.
- Incluir un **README** con descripción del proyecto: objetivo, tech stack, desarrollo, seguridad, cómo ejecutar los tests y levantar el proyecto.

---

## Recomendaciones para tests

- Incluir **tests de integración y unitarios**.
- No limitar los tests solo a los casos indicados: incluir casos de excepciones, parámetros incorrectos, etc., hasta obtener máxima cobertura.  
