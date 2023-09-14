# Creacion de repositorios en sprin data jpa

## Clases de spring que nos ayudan a trabajar con spring repositorys

Para trabajar con los repositorios de spring data JPA los cuales nos ayudan a trabajar de una manera mas facil las consulata y en general el CRUD en la BD, tenemos las siguientes clases de las cuales podemos extender.

Lo primero por supuesto es que en nuestro proyecto de spring debemos tener un paquete para nuestras clases de repositorios  ```com.service.repository``` y aca debemos hacer una interfaz por cada una de las tablas o entidades que queremos consultar o trabajar en la BD.

Entonces sabiendo esto, para trabajar con los repositorio, nuestra interfaz puede extender de las siguientes interfases de spring:

1. ```CrudRepository``` Estas interfases devuelven un Iterable en las consultas de varios registros
2. ```PagingAndSortingRepository``` Estas interfases devuelven un Iterable en las consultas de varios registros, el resultado que devuelve nos permite paginiar por medio de un Entity

3. ```ListCrudRepository``` Estas interfases devuelven un list en las consultas y extiende de ```CrudRepository```
4. ```ListPagingAndSortingRepository``` Estas interfases devuelven un list en las consultas y extiende de ```PagingAndSortingRepository```

5. ```JpaRepository``` Esta interfaz extiende de las dos interfases anteriormente mencionada ```ListCrudRepository``` y ```ListPagingAndSortingRepository```

```java
	public interface NameTableRepository extends ListCrudRepository<NameTableEntity, Integer> {

	}		
    ....
```
## QueryMethods

En estas interfaces podemos crear otras consultas a base de datos que no bienen en sus metodos por defectos, como por ejemplo ```findAll()``` entre otros, para esto usamos los QueryMethods, estos se declaran como metodos de la interfaz creada para la entidad, otros metodos adicionales usando palabras claves en camelCase.

```java
	public interface NameTableRepository extends ListCrudRepository<NameTableEntity, Integer> {
	
		List<NameTableEntity> findAllByAvailableTrueOrderByPrice();

		NameTableEntity findByNameIgnoreCase(String name);

	}		
    ....
```

Palabras como ```find```, ```All```, ```By```, ```Order``` y ```IgnoreCase``` son palabras claves de las interfaces usadas, las cuales combinamos con palabras como ```Available```, ```Name``` y ```True```, palabras como ```Available``` y ```Name``` son nombres de campos de las entidades que representan una tabla de bd y ```True``` son valores que para uno de esos campos (en este caso para el campo ```Available```), todo esto lo reconoce spring data jpa y crea una consulta a bd a partir de este QueryMethods.

Es muy importante respetar ciertas cosas:

1. El orden en que colocamos las palabras ya que esto afecta los parametros que recibe el metoido, en tal caso que reciba un parametro.
2. El nombre del campo debe ser identicon al nombre del campo de la entidad.

Hay infinidades de palabras claves para los QueryMethods con las que se puede experimentar y formar diferentes combinaciones y consultas.

En el siguiente [link](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#appendix.query.method.subject) hay una documentacion de todos las subject keywords y predicate keywords que se pueden usar.

## ListPagingAndSortingRepository

Hablando un poco de esta interfaz en particular, resulta ser una herramienta muy poderosa.

Una cosa que debemos tomar en cuenta es que sus metodos resiven siempre un objeto de tipo ```org.springframework.data.domain.Pageable``` y devuelven un objeto de tipo ```import org.springframework.data.domain.Page``` en vez de un ```java.util.List``` como lo hacen ```ListCrudRepository``` y ```CrudRepository```.

Lo que quiere decir que en la clase de servicio donde se implementa la interfaz extendida de ```ListPagingAndSortingRepository``` siempre se debe instanciar un objeto de tipo ```org.springframework.data.domain.Pageable``` y un objeto de tipo ```org.springframework.data.domain.Sort```. Adicionalmente, en el controlador normalmente se recibirian normalmente parametros como ```@RequestParam(defaultValue = "0") int page```, ```@RequestParam(defaultValue = "10") int elements```, ```@RequestParam(defaultValue = "price") String sortBy``` y ```@RequestParam(defaultValue = "ASC") String sortDirection```, para poder paginear por medio de la peticion rest.


**Repositorio**

```java
public interface EntityPagSortRepository extends ListPagingAndSortingRepository<TableEntity, Integer> {

	Page<TableEntity> findByAvailableTrue(Pageable pageable);
...
}
```

**Servicio**

```java

@Service
public class TableService {

	private final EntityPagSortRepository entityPagSortRepository;

    .....

    public Page<TableEntity> getAvailable(int page, int elements, String sortBy, String sortDirection) {

		    Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);

		    Pageable pageable = PageRequest.of(page, elements, sort);
		    return this.entityPagSortRepository.findByAvailableTrue(pageable);
    }
....
```

**Controlador**

```java
@GetMapping("/available")
	public ResponseEntity<Page<TableService>> getAvailable(@RequestParam(defaultValue = "0") int page,
                                                           @RequestParam(defaultValue = "10") int elements,
                                                           @RequestParam(defaultValue = "price") String sortBy,
                                                           @RequestParam(defaultValue = "ASC") String sortDirection) {

		return ResponseEntity.ok(this.tableEntity.getAvailable(page, elements, sortBy, sortDirection));
}
...
```

Una cosa a destacar es el como esto paginea mediante los parametros expuestos en el controlador.

1. **Page**: Cual pagina debe mostras (segun la cantidad la interfaz nos mostrara la informacion que esta en la pagina calculada)
2. **Elements**: La cantidad de elementos por pagina
3. **sortBy**: En este debemos indicar el nombre exacto de un campo de la entidad por el cual queremos ordenar la información, lo cual tambien afecta la informacion que sale por pagina.
4. **sortDirection**: Recibe un estring con dos palabras ```DESC``` y ```ASC``` e indican la direccion del orden.

Como vemos en la clase de servicio los parametros ```sortBy``` y ```sortDirection``` se usan para la creacion de la instancia del objeto de tipo ```Sort``` y ese objeto en conjunto con los demas parametros de tipo entero se usan para la creacion del objeto ```Pageable``` que requieren los metodos de la interza extendida de ```ListPagingAndSortingRepository```.

## @Query en repositorios

Son muy utiles para trabajar con JPQL (java persistence query lenguage) y para trabajar con querys nativos.

Lo unico que debemos hacer para usar esto es crear un metodo nuevo en nuestra interfaz extendida ```ListCrudRepository```, la caul puede tener cualquier nombre (ya que no estamos trabajando con QueryMethods) y arriba de este metodo colocamos la anotacion ```@Query()``` y le colocamos como parametros ```nativeQuery = ``` y el valor que se le asigna es un boolean, true si va a ser un query nativo o false si no, sin embargo, si no ponemos este parametro por defecto siempre sera false, el siguiente parametro que recibe esta anotación es el query sql como tal bajo el parametro ```value = " "``` el cual entre comillas recibe el JPQL o el SQL dependiendo si es un JPQL o un query nativo.

Cabe destacar que los JPQL usan el nombre de las entidades en vez de el nombre de las tablas en las sentencias.

Tanto para los JPQL como para los SQL, si reciben algun parametro el mismo se coloca en la sentencia presedido de dos puntos (:) y en el metodo creado debe recibir este parametro el cual debe llevar la anotación ```@Param(" ")``` de ```org.springframework.data.repository.query.Param```  que lleva como parametro dentro de el el nombre del parametro que colocamos en la sentencia, luego de la anotacion colocamos el parametro del metodo presedido de su tipo de dato.

Del resto la manera de implementarlo en las clases de servicios y controladores es igual que con los QueryMethods.

```java

    //Query nativo	
    @Query(nativeQuery = true,
           value = "select * from table_entity where id_other = :id")
    List<TableEntity> findTableRegistre(@Param("id") String id);

    //JPQL
    @Query(value = "select p from TableEntity p where p.idOther = :id")
    List<TableEntity> findTableRegistre(@Param("id") String id);

...
```


## @Query en repositorios con @Modifying

Con @Query tambien podemos actualizar (update) un registro en la base de datos, pero para esto abajo de la antación @Query que contiene el query nativo de sql, debe colocarse la anotación @Modifying. Para esto se sugiere crear un objeto dto para pasar los parametros al metodo que implementa la interfaz del repositorio usando Spring Expression Language (SpEL), esto nos ayudara mas adelante cuando implementemos el nuevo metodo en el controlador, el cual estara configurado bajo el metodo http PUT quien debe resivir no parametros sino un requestBody.

**Ejemplo del uso de la anotacion en la clase repositoty**

```java

    @Query(nativeQuery = true, value = "UPDATE table SET field = :#{#updateTableFieldsDto.field} WHERE id = :#{#updateTableFieldsDto.id}")
	@Modifying
	void updateFields(@Param("updateTableFieldsDto") UpdateTableFieldsDto updateTableFieldsDto);
...
```

Se puede notar en el ejemplo anterior como se hace uso del (SpEL) para trabajar con los campos del dto que utilizaremos como parametros ```:#{#updateTableFieldsDto.field}```.

**Ejemplo del DTO**

```java

public class UpdateTableFieldsDto {
	
	private int id;
	private BigDecimal field;
	
	public UpdatePizzaPriceDto(int id, BigDecimal field) {
		this.id = id;
		this.field = field;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getField() {
		return field;
	}

	public void setField(BigDecimal field) {
		this.field = field;
	}
...
```

## @Transactional y las actualizaciones


Tambien para las actualizaciones debemos usar la anotacion @Transactional, lo cual nos garantiza poder cumplir con los principios de ACID (Atomicity, Consistency, Isolation y Durability), esto garantiza que una operacion a la base de datos o se ejecute toda o no se ejecute nada.

Si colocamos esta anotacion en un metodo de una clase servicio, aunque se haya ejecutado un metodo del repositorio dentro de el para actualizar en la BD antes de que de una excepcion, de igualforma spring hara un rollback de todo.


Sin embargo, incluso podemos configurar @Transactional por medio de un parametro con el cual podemos especificarle que no haga rollback en alguna excepcion especifica con la cual no seria necesario hacer un rollback ```@Transactional(noRollbackFor = ExcepcionEspecifica.class);```, tambien tenemos el parametro ```@Transactional( propagation = Propagation.REQUIRES_NEW )``` el cual es util cuando trabajamos con un metodo que ya tienen la anotacion @Transactional dentro de otro metodo que tambien tiene la anotacion @Transactional, con lo cual podemos indicar si el metodo hijo forma parte de la transaccion del metodo padre y asi controlar cosas como si el metodo padre hace rollback cuando haya una excepcion el metodo hijo o no.

```java

    @Transactional(noRollbackFor = NullPointerException.class, propagation = Propagation.REQUIRED)
	public void updateFields(UpdateTableFieldsDto updateTableFieldsDto) {
		this.tableRepository.updateFields(updateTableFieldsDto);		
	}
...
```
cabe destacar que la propiedad de propagación ```propagation = Propagation.REQUIRED```, es la propiedad por defecto del @Transactional.




