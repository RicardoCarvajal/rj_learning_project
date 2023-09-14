# Configuración de tipos de busquedas en entidades

Dentro de las anotaciones ```@OneToMany```, ```@ManyToOne```, ```@OneToOne``` y ```@ManyToMany```; se puede configurar el parametro de tipo de busqueda ```fetch = ...```  en el cual se le dice de que manera se traeran los valores de la relación. Dentro de este parametros se configuran valores constantes de la clase ```FetchType```.


## Lazy

Busqueda perezosa, cuando configuramos la relación con este parametro, el valor de la relacion no lo obtendremos a menos que lo consultemos por medio del metodo get del campo que representa la relación.


```java
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_entity", referencedColumnName = "id_relationEntity", insertable = false, updatable = false)
	private TableRelationEntity relationEntity;	
    ....
```

## Eager

Busqueda afanada, la cual consultara y traera todos los valores de la relación. 

```java
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_entity", referencedColumnName = "id_relationEntity", insertable = false, updatable = false)
	private TableRelationEntity relationEntity;	
    ....
```

## @JsonIgnore

Independientemente si usamos Lazy o Eager, tambien se puede usar la anotación  ```@JsonIgnore```, para a pesar de que un valor de relacion este configurado como eager, el valor se consulte pero no se envie en el Json de la respuesta, tambien se puede usar para evitar relaciones recursivas.

```java
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_entity", referencedColumnName = "id_relationEntity", insertable = false, updatable = false)
	@JsonIgnore
	private TableRelationEntity relationEntity;	
    ....
```

**Relaciones Recursivas**

```java
	//Clase Order
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
	private List<OrderItemEntity> orderItems;

	//Clase OrderItem
	@ManyToOne
	@JoinColumn(name = "id_order", referencedColumnName = "id_order", insertable = false, updatable = false)
	@JsonIgnore
	private OrderEntity order;
    ....
```

Si no se declara uno de ellos con ```@JsonIgnore``` el programa dara un StackOverFlow, ya que los valores se buscaran mutuamente de manera infinita a causa de la relación.
