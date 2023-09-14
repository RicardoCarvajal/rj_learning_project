# Auditoria en entidades spring data JPA

Con respecto a la auditoria de la operaciones de bd son varias cosas que podemos hacer, de las cuales hablaremos a continuacion:

## 1. Registrar fecha y hora de creación y  modificación

Para esto solo hay que crear (para las entidades que queramos auditar los cambios en sus registros) dos campos nuevos en la bd.

Luego debemos crear un objeto llamado ```AuditableEntity``` o con algun otro nombre referente a auditoria, este objeto sera implementado en las entidades a auditar haciendo que extiendan de ella, y para esto la clase ```AuditableEntity``` debe tener la anotacion ```@MappedSuperclass```.

El objeto de auditoria debe tener como campos los nombres de los campos creados en las tablas de la bd (los cuales se deben llamar igual en todas las tablas) para auditar la fecha y hora de creacion y modificacion. Por ejemplo ```created_date``` y ```modified_date```.


Estos campos en la clase ```AuditableEntity``` a parte de la anotacion ```@Column``` en el cual debemos configurar el nombre real de la columna en bd, tambien llevan las anotacones ```@CreatedDate``` para el campo ```created_date``` y ```@LastModifiedDate``` para el campo ```modified_date``` (en parte esto hace la magia).

**Ejemplo de AuditableEntity.Class**

```java
@MappedSuperclass
public class AuditableEntity {

	@Column(name = "created_date")
	@CreatedDate
	private LocalDateTime createdDate;

	@Column(name = "modified_date")
	@LastModifiedDate
	private LocalDateTime modifiedDate;

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

}
```

Luego de tener esta clase como se comento antes se implementa en la entidad extendiendo de ella, pero adicionalmente en la entidad a auditar se debe usar la anotacion ```@EntityListeners``` pasandole como parametros la clase ```AuditingEntityListener``` la cual temina haciendo toda la magia por si sola.

```java
@Entity
@Table(name = "table")
@EntityListeners(AuditingEntityListener.class)
public class TableEntity extends AuditableEntity implements Serializable {

...
}
```

De apartir de aca toda entidad que extienda de ```AuditableEntity``` y tenga la anotación ```@EntityListeners(AuditingEntityListener.class)``` cuando se cree o actualice un registro por medio de los QueryMethods de spring data jpa, se le sera actualizada en la base de datos los campos ```created_date``` y ```modified_date``` de dicha tabla.

## 2. Ver cambios en progreso

Se deseamos ver los que se actualiza y lo que se crea o borra en la BD en un log por ejemplo, debemos cumplir con lo siguiente:

Se crea una clase que la podriamos llamar ```AuditTableListener``` dependiendo cual sea nuestra entidad o tabla a auditar. Esta clase tendra tres metodos con una de las siguientes anotaciones cada uno, ```@PostLoad``` , (```@PostPersist```, ```@PostUpdate```) Estas dos van juntas en uno de los metodos, ```@PreRemove```.

Tambien se crea un campo con el cual tendremos los valores de la entidad actual y configuramos el metodo que tiene la anotacion  ```@PostLoad``` para que cuando resiva la entidad (cosa que hara cada vez que spring haga un select, lo cual es siempre lo primero que hace al ejecutar una consulta o actualizacion por medio de los QueryMethods) asigne en el campo de clase un clon de el objeto entidad que no sera manejado por referencia (por lo cual las entidades deben implementar la clase Serializable).

Luego en el metodo que tiene las anotaciones ```@PostPersist``` y ```@PostUpdate``` (el cual se ejecutara cuando spring ejecute un create o un update), se puede loggear el campo de clase que tendra los valores anteriores de la entidad y luego loggear el campo de entidad recibido en el metodo el cual tendra los valores actualizados. y Lo mismo podemos hacer con el metodo que posee la anotación  ```@PreRemove```.

**Ejemplo de AuditTableListener.Class (se debe cambiar la palabra Table por el nombre de la entidad)**

```java
public class AuditTableListener {

	private TableEntity currentValue;

	@PostLoad
	public void postLoad(TableEntity entity) {
		System.out.println("POST LOAD");
		this.currentValue = SerializationUtils.clone(entity);
	}

	@PostPersist
	@PostUpdate
	public void onPostPersist(TableEntity entity) {
		System.out.println("CREATE OR UPDATE");

		System.out.println("OLD: " + currentValue);
		System.out.println("NEW: " + entity);
	}

	@PreRemove
	public void onPreDelete(TableEntity entity) {
		System.out.println(entity);
	}

}
```

Luego de tener lista esta clase por cada entidad, vamos a la entidad que queremos auditar y en la anotacion ```@EntityListeners``` a parte de pasar como parametro la clase ```AuditingEntityListener``` la cual hace toda la magia, tambien pasamos un segundo parametro que seria nuestra clase ```AuditTableListener```.


```java
@Entity
@Table(name = "table")
@EntityListeners({ AuditingEntityListener.class, AuditTableListener.class })
public class TableEntity extends AuditableEntity implements Serializable {

...
}
```

Cuando pasamos mas de un parametro a la anotacion ```@EntityListeners``` lo hacemos por medio de corchetes.

**NOTA: todo esto solo funciona cuando usamos la interfaz de QueryMethods nativa de Spring Data JPA**

## 3. Tipos de anotaciones para nuestras clases listeners

|Type         |Description                                                                                                                                         |
|-------------|----------------------------------------------------------------------------------------------------------------------------------------------------|
|@PrePersist  |Se ejecuta antes de que la operación persistente del administrador de la entidad se ejecute o se ponga en cascada. Esta llamada es sincrónica con la operación de persistencia.|
|@PreRemove   |Se ejecuta antes de que la operación de eliminación del administrador de la entidad se ejecute o se ponga en cascada. Esta llamada es sincrónica con la operación de eliminación.|
|@PostPersist |Se ejecuta después de que la operación persistente del administrador de la entidad se ejecute o se ponga en cascada. Esta llamada se invoca después de ejecutar la base de datos INSERT.|
|@PostRemove  |Se ejecuta después de que la operación de eliminación del administrador de la entidad se ejecute o se ponga en cascada. Esta llamada es sincrónica con la operación de eliminación.|
|@PreUpdate   |Ejecutado antes de la operación de ACTUALIZACIÓN de la base de datos.|
|@PostUpdate  |Ejecutado después de la operación de ACTUALIZACIÓN de la base de datos.|
|@PostLoad    |Se ejecuta después de que una entidad se haya cargado en el contexto de persistencia actual o se haya actualizado una entidad.|




