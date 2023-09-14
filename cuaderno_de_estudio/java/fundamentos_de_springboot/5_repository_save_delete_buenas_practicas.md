# Buenas practicas al trabajar el save y el delete en spring repository

## Save

El metodo ```save()``` de la interfaz ```ListCrudRepository``` se usa para dos cosas a la vez, tanto para actualizar como para crear. El metodo es inteligente, cuando ya existe la clave primaria que se envia y algun otro valor tiene un cambio lo actualiza, si no detecta ningun cambio en los valores no hace nada y si no le mandamos la clave primaria lo actualiza (en una entidad cuya clave primaria esta configurada con un ```id``` incremental y autogenerado con el parametro ```@GeneratedValue(strategy = GenerationType.IDENTITY)```), el comportamiento puede variar dependiendo de la configuracion de la entidad, pero en general es de esta manera.

* Clase servicio

Para las actualizaciones y creaciones que se publicaran en el controlador debemos crear dos metodos en nuestra clase de servicio, un metodo para actualizar y crear (el mismo para las dos cosas) y un metodo que usa el metodo ```existsById()``` de la interfaz ```ListCrudRepository``` para usar tambien en el controlador.

```java
	public TableEntity save(TableEntity tableEntity) {
		return this.tableRepository.save(tableEntity);
	}

	public boolean exists(Integer id) {
		return this.tableRepository.existsById(id);
	}		
    ....
```

* Clase controladora

Utilizando el mismo metodo de la clase servicio podremos tener los metodo post y put de una misma entidad en nuestro controlador, solo por buenas practicas de validación debemos hacer las siguientes verificaciones:

1. En el metodo ```add``` (post) se valida que el ```id``` de la entidad enviada como request sea null lo cual identificaria esta peticion como una creación, ya que para que el metodo ```save()``` cree no se le debe mandar el ```id```.

2. En el metodo ```update``` (put) se valida todo lo contrario, que el ```id``` sea diferente de null y que exista (para lo cual usamos el metodo ```exists()``` creado de antemano en la clase servicio), esto ya que paraque el mismo metodo ```save()``` actualice se requiere que el ```id``` del registro de la entidad a actualizar exista.

```java
	@PostMapping
	public ResponseEntity<TableEntity> add(@RequestBody TableEntity tableEntity) {
		if (tableEntity.getId() == null)
			return ResponseEntity.ok(this.tableService.save(tableEntity));

		return ResponseEntity.badRequest().build();
	}

	@PutMapping
	public ResponseEntity<TableEntity> update(@RequestBody TableEntity tableEntity) {
		if (tableEntity.getId() != null && this.tableService.exists(tableEntity.getId()))
			return ResponseEntity.ok(this.tableService.save(tableEntity));

		return ResponseEntity.badRequest().build();
	}	
    ....
```


## Delete

La interfaz ```ListCrudRepository``` tiene varios metodos para delete, uno de los que podemos usar es ```deleteById()``` el cual recibe como parametro el ```id``` del registro de la entidad a eliminar.

* Clase servicio

Continuamos con el metodo ```exists()``` y añadimos a nuestra clase de servicios el metodo ```delete()``` que usaremos en nuestro controlador.

```java
	public void delete(Integer id) {
		this.tableRepository.deleteById(id);
	}

	public boolean exists(Integer id) {
		return this.tableRepository.existsById(id);
	}		
    ....
```

* Clase controladora

En nuestro controlador creamos el metodo ```delete()``` y hacemos dentro de el las validaciones correspondientes, verificando si existe el registro de la entidad a eliminar, y si existe usamos el metodo ```delete()``` anteriormente usado en la clase de servicios, como este metodo no responde nada ```Void``` debemos, despues de usar el metodo ```delete()```, retornar un ```ResponseEntity.ok().build()```

```java
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		if (id != null && this.tableService.exists(id)) {
			this.tableService.delete(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.badRequest().build();

	}	
    ....
```




