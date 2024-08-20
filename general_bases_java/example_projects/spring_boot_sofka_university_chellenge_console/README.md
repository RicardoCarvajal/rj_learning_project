# Practica para capacitacion de Sofka
### Aplicación de consola

 ![Static Badge](https://img.shields.io/badge/0.0.1-version-%2300bab4) ![Static Badge](https://img.shields.io/badge/0.0.1-release-%2300bab4)

## Crear una aplicación por consola que permita ejecutar el siguiente job:

1. Tomar todas las facturas que están en la colección Sales y recorriendo la lista de items crear una nueva colección Productos en donde quede un registro por cada producto con la siguiente estructura:

```
{
	“Id”: “id autogenerado por la base de datos”,
	“productName”: “nombre del producto”,
	“quantity”: número de veces que este producto ha sido vendido.
}
```
2. Crear una acción que te permita recorrer todas las facturas en la colección Sales añadiendoles el total del valor de cada una de las facturas, campo que no está presente en los registros actuales.

# Configuraciones
## Configuración de propertie y de ambiente

#### Base de datos

Application.yml (configuración de base de datos)

```
spring:
   data:
      mongodb:
         host: localhost
         port: 27017
         database: sofka
         username: ${USERMONGO}
         password: ${PASSMONGO}
         authentication-database: admin 
```

Antes de comenzar y arrancar nuestro proyecto debemos configurar dos variables de entorno en nuestro sistema operativo, las cuales deberán tener el **usuario y contraseña** de la base de datos mongo.

Adicionalmente tenemos al inicio debemos tener una **base de datos mongo llamada sofka**, la cual  debe tener la **colección sale**.

Datos de conexión  | Valores
------------- | -------------
host  | localhost
puerto | 27017
base de datos  | sofka
nombre de variable de entorno para usuario  | USERMONGO
nombre de variable de entorno para contraseña  | PASSMONGO
base de datos de autenticación | admin

#### Parametros de propertie para eleccion de procesos

En el archivo application.yml podemos configurar que job se ejecutará de la siguiente forma:

```
consoleapp:
   option:
      type: 1
```

Si  ```type``` es igual a ```1``` se ejecutará el proceso de creación de productos y si ```type``` es igual a ```2``` entonces se ejecutará el proceso de totalización de ventas.

### End
