![Intelix](https://i.imgur.com/VD7nJDi.png)

# Practica para capacitacion de Sofka
### API REST de seguimiento

 ![Static Badge](https://img.shields.io/badge/0.0.1-version-%2300bab4) ![Static Badge](https://img.shields.io/badge/0.0.1-release-%2300bab4)

## Crear un API REST que tenga las siguientes caracteristicas:

Servicio de registro y seguimiento de movimientos de stock, como ventas, compras y ajustes de inventario.

* Endpoint para solicitar todos los registros de forma paginada.
* Endpoint para solicitar los errores. 
* Endpoint para solicitar todos los movimientos de un producto específico.
* Endpoint para solicitar los registros de ventas al detal. 
* Endpoint para solicitar los registros de ventas al por mayor.  

# Configuraciones env

```
PORTAPPSOFKAMONITOR=8080

RABBITURL=amqp://guest:guest@<IP>:5672

HOSTDB=<IP>
PORTDB=27017
DBNAMEMONITOR=sofkaInventario

```
