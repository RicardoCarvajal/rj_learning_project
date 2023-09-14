# Creacion de entidades usando spring data JPA en un servicio spring boot 

## Organizando nuestras clases de entidades

Lo primero es crear un paquete donde podamos almacenar en nuestro proyecto todas las entidades las cuales representan las tablas de BD.

Cabe destacar que las anotaciones usadas para declarar las clases como entidades y especificar sus atributos, estas anotaciones son del paquete ```jakarta.persistence.*```


## Creando entidades

Procedemos a crear cada entidad de la siguiente manera.

### @Entity y @Table

Lo primero es declarar la clase que usaremos (la cual debe tener un nombre que haga referencia a la tabla de BD que queremos homologar) con dos anotaciones, ```@Entity``` que declara que la clase es una entidad de BD y ```@Table``` con la cual podemos especificar el nombre real de la tabla en BD a la cual hacemos referencia.


```java
    @Entity
    @Table(name = "nombre_bd_table")
    public class nameDatabaseTable {		
    ....
```

### @Id, @GeneratedValue y @Column

Una cosa importante es que cada entidad de BD siempre debe tener un campo clave, por lo que debemos proceder a crear el campo a nivel de la clase y anotarlo con ```@Id```, por otro lado si queremos que la entidad autogenere su clave primaria podemos anotar ese campo con ```@GeneratedValue``` y a esta anotacion le podriamos pasar varios tipos de atributos en su parametro ```strategy``` como por ejemplo ```GenerationType.IDENTITY``` el cual genera una clave primaria uno a uno, aunque tambien puede ser ```GenerationType.UUID``` que es muy famoso tambien entre otros.  Por su puesto en el campo tambien debemos usar el la anotación ```@Column``` a la cual podemos pasar por parametro, varios tipos de comfiguraciones, para el campo que identificaa una columna de la base de datos, como por ejemplo identificar cual es el nombre real de la columna, esto si el nombre del campo de clase difiere al nombre de la columna, sino no seria necesario. De igual forma tambien se puede usar esta anotacion para decir si el campo puede ser nulo o no.

```java
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_column", nullable = false)
	private Integer idColumn;		
    ....
```

Para la anotacion ```@Column``` hay varios parametros interezantes interesantes como los siguientes:


1. ```length = ``` Indica el tamaño de cantidad de caracteres de una columna de tipo caracter o texto
2. ```columnDefinition =``` define algunos tipos de datos complejos para columnas por ejemplo ```@Column(columnDefinition = "DATETIME")```

### @OneToOne, @ManyToOne y @OneToMany

Estas anotaciones usamos cuando tenemos relaciones entre tabla, hay algunas otras anotaciones, pero estas son las mas usadas.

Cuando usamos relaciones como estas tambien debmos usar la anotacion ```@JoinColumn``` la cual junto con sus parametros ```name``` y ```referencedColumnName``` indicamos el id de la tabla que representa a la entidad en la cual estamos usando la anotación y el otro parametro representa el id de la entidad que representa a la otra tabla con la cual tenemos relación (cuando esto aplique por existir los dos id en la entidad, ya que cuando no existe y queremos formar la relacion con la tabla que tiene la clave foranea usamos el parametro ```mappedBy = "objetoReferenciadoEnOtraEntidad"```), adicionalmente podemo y creo yo que debemo usar parametros como ```insertable``` y ```updatable``` para evitar que por medio de esta relacion se inserte o actualice algun valor de la tabla a la que hacemos referencia.

**Ejemplo:**

```java
@Entity
@Table(name = "pizza_order")
public class OrderEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order", nullable = false)
	private Integer idOrder;

	@Column(name = "id_customer", nullable = false, length = 15)
	private String idCustomer;

	@Column(nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime date;

	@Column(nullable = false, columnDefinition = "DECIMAL(6,2)")
	private BigDecimal total;

	@Column(nullable = false, columnDefinition = "CHAR(1)")
	private String method;

	@Column(name = "additional_notes", length = 200)
	private String additionalNotes;

	@ManyToOne
	@JoinColumn(name = "id_customer", referencedColumnName = "id_customer", insertable = false, updatable = false)
	private CustomerEntity customerEntity;

	@OneToMany(mappedBy = "orderEntity")
	private List<OrderItemEntity> orderItemEntity;		
    ....
```


```java
@Entity
@Table(name = "order_item")
@IdClass(OrderItemId.class)
public class OrderItemEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_item", nullable = false)
	private Integer IdItem;

	@Id
	@Column(name = "id_order", nullable = false)
	private Integer IdOrder;

	@Column(name = "id_pizza", nullable = false)
	private Integer IdPizza;

	@Column(nullable = false, columnDefinition = "Decimal(5,2)")
	private BigDecimal quantity;

	@Column(nullable = false, columnDefinition = "Decimal(5,2)")
	private BigDecimal price;

	@ManyToOne
	@JoinColumn(name = "id_pizza", referencedColumnName = "id_pizza", insertable = false, updatable = false)
	private PizzaEntity pizzaEntity;

	@ManyToOne
	@JoinColumn(name = "id_order", referencedColumnName = "id_order", insertable = false, updatable = false)
	private OrderEntity orderEntity;	
    ....
```

*La forma de leer las relaciones ```@ManyToOne``` y ```@OneToMany``` son las siguientes:*

1. ```@ManyToOne``` Hay muchos de esta entidad que pertenesen a uno de la otra entidad
2. ```@OneToMany``` Hay uno de esta entidad que pertenese a muchos de la otra entidad



