# Ejecucion de procedimientos almacenados en spring

Para hacer uso de las bondades de spring para ejecutar SP de bases de datos, lo mprimero es tener el SP creado en la base de datos.

Luego debemos cumplir con los siguentes pasos:

## 1. Utilizar anotación @Procedure en nuestra clase Repositoty:

Esta anotacion 	```@Procedure``` la configuramos arriba del metodo el cual usaremos en nuestras clases de servicios, la anotacion se configura con los parametros ```value = ``` en la cual va el nombre del SP y ```outputParameterName = ``` en la cual va el parametro de salida del SP (si aplica).

Luego en nuestro metodo implementado en la interfaz de repósitorio, hacemos que el metodo reciba tantos parametros como tenga el SP parametros de entrada, el nombre de los parametros deben coincidir en nombre con los parametros del SP.

```java
...
    @Procedure(value = "nombre_de_SP", outputParameterName = "nombre_parametro_salida_SP")
    boolean executeSP(@Param("parametro_uno") String parametroUno, @Param("parametro_dos") String parametroDos);
...
```

Y listo solo queda implementar este metodo en nustra clase de servicio y luego en nuestra clase de controlador.


**Servicio**

Ya que estamos ejecutando data, de una manera nativa, debemos usar la anotacion ```@Transactional``` en nuestro metodo de la clase de servicio.

```java
...
	@Transactional
	public boolean executeSP(ParameterExecuteSP request) {
		return orderRepository.executeSP(request.getParametroUno(), request.getParametroDos());
	}
...
```

**Controller**

```java
...
	@PostMapping("/SP")
	public ResponseEntity<Boolean> executeSP(@RequestBody ParameterExecuteSP request) {
		return ResponseEntity.ok(orderService.executeSP(request));
	}
...
```


