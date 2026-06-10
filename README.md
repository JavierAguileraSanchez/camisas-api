# Camisas API

Proyecto backend Spring Boot Java para gestionar camisas y marcas.

## Estructura

- `domain` - entidades JPA: `Camisa`, `Marca`
- `repository` - repositorios Spring Data JPA
- `service` - lógica de negocio
- `controller` - endpoints REST
- `dto` - datos de transferencia
- `mapper` - conversión entre entidades y DTOs

## Configuración local

1. Abrir `camisas-api` en IntelliJ.
2. Ejecutar:
   ```bash
   ./gradlew build
   ```
3. Ejecutar localmente:
   ```bash
   ./gradlew bootRun
   ```

## Variables de entorno

En Render o en local se pueden usar estas variables:

- `SPRING_DATASOURCE_URL`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`
- `PORT`

Si no se definen, el proyecto usa la configuración local de `application.properties`.

## Endpoints

### Marcas

- POST `/api/marcas`
- GET `/api/marcas`
- GET `/api/marcas/{id}`
- PUT `/api/marcas/{id}`
- DELETE `/api/marcas/{id}`

### Camisas

- POST `/api/camisas`
- GET `/api/camisas`
- GET `/api/camisas?marca=NombreMarca`
- GET `/api/camisas/{id}`
- PUT `/api/camisas/{id}`
- DELETE `/api/camisas/{id}`

## Despliegue en Render

1. Crear repo GitHub con este proyecto.
2. En Render, crear `Web Service` apuntando a este repo.
3. Crear base de datos PostgreSQL en Render.
4. Configurar variables de entorno en el servicio:
   - `SPRING_DATASOURCE_URL`
   - `SPRING_DATASOURCE_USERNAME`
   - `SPRING_DATASOURCE_PASSWORD`
   - `PORT`

## Pruebas con Postman

Ejemplos de cuerpos JSON:

Marca:
```json
{
  "nombre": "Nike"
}
```

Camisa:
```json
{
  "modelo": "AirMax",
  "talla": "M",
  "precio": 49.9,
  "marcaId": 1
}
```
