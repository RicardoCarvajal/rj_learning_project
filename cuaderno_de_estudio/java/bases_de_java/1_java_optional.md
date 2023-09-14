# Java Optional

Los ```Optional``` en java son tipos de Objetos encoltorios creados a partir de java 1.8 para facilitar el manejo de los valores nulos y evitar las excepciones de tipo ```NullPointerException```.

Algo importante de destacar es que este tipo de objeto **solo se debe usar como valores de retornos de metodos** ya que su funcion es presisamente para evitar valores de retorno nulos.

## Metodos principales

Los dos metodos principales de los optional que se utilizan para instanciar objetos son los siguientes:

1. ```ofNullableOptional.of()``` El cual solo permite que ingresemos como parametro un objeto del tipo declarado en el Optional
2. ```Optional.ofNullable(null)``` El cual permite que ingresemos como parametro un objeto del tipo declarado en el Optional y valores nulos tambien

```java
	Optional<String> box = Optional.of("Hola mundo optional"); 

	Optional<String> box = Optional.ofNullable("Hola mundo optional");
																				
	Optional<String> box = Optional.ofNullable(null);
    ....
```

Realmente es recomendable siempre instanciar nuestros objetos de tipo Optional con el metodo ```ofNullable()```

## Variedad de metodos

### a) isPresent() y isEmpity()

El primer metodo nos ayuda a validar si el opcional tiene algun valor que no sea ni null ni vacio, y el segundo hace lo contrario valida que el optional sea o vacio o null.

```java
	if (box.isPresent()) {
	  ....
	}
    ....
```

```java
	if (box.isEmpty()) {
	  ....
	}
    ....
```

### b) ifPresent() y ifPresentOrElse()

Con el primer metodo podemos ejecutar alguna accion si el optional no esta nulo o vacio, esta accion se ejecutan en una funcion lambda la cual podemos pasar por parametro al metodo. Por otro lado el segundo metodo recibe dos parametros uno para cuando el opjeto no este vacio o nulo y otro para cuando sea nulo o vacio, por lo tanto aca podemos declarar dos funciones lambda.

```java
	box.ifPresent(op -> System.out.println("Ejecunatdo accion"));
    ....
```

```java
	box.ifPresentOrElse(op -> System.out.println("No es nulo"),() -> System.out.println("Si es nulo"));
    ....
```

### c) orElse(), orElseGet() y orElseThrow()

Con el primer metodo podemos retornar (ya sea por un metodo o directamente) un valor del tipo declarado en el optional si el optional es vacio o nulo, cabe destacar que si ejecutamos dentro de el un metodo y el valor del optional no esta vacio o nulo este metodo aun asi ejecutara la funcion pero sin retornar nada, lo cual no es muy bueno en cuanto a rendimiento se refiere, por eso se usa mas el segundo metodo el cual si el valor del optional no es nulo no ejecutara la funcion especificada dentro de el y directamente retornara el valor envuelto dentro del optional, cabe destacar que este metodo siempre recibe como parametro una funcion lambda o un objeto de tipo ```Supplier```, y con el tercer metedo si el optional esta vacio podemos lanzar una excepción.


```java
	Optional<String> box = Optional.ofNullable(null);

	//Opcion 1
	String resultado = box.orElse("Esta valor era nulo");

	//Opcion 2	
	String resultado = box.orElse(getText());
    ....
```

```java
	Optional<String> box = Optional.ofNullable(null);
	
	//Opcion 1
	Supplier<String> supplierLambda = () -> {
			System.out.println("Efecutando funcion lambda");
			return "Esta nulo";
		};
	
	String resultado = box.orElseGet(supplierLambda);
	
	//Opcion 2
	String resultado = box.orElseGet(() -> {
			System.out.println("Efecutando funcion lambda");
			return "Esta nulo";
		});
    ....
```

```java
	Optional<String> box = Optional.ofNullable(null);
	
	String resultado = box.orElse("Esta valor era nulo");
    ....
```


```java
	Optional<Integer> box = Optional.ofNullable(null);
	
	box.orElseThrow(NumberFormatException::new);
    ....
```

### d) get()

Este metodo lounico que hace es retornarnos el valor que esta en vuelto dentro del Optional sin importar si es nulo, antes de usar este metodo se recomienda usar metodos como  ```isPresent()``` y ```isEmpity()```, ya que de no ser asi podriamos estar opteniendo un null causandonos una excepcion de tipo ```NoSuchElementException```.

```java
	if(box.isPresent()) {
		String objeto = box.get();	
	}
```

### e) map()

Con este gran metodo podemos acceder a campos dentro de campos de un objeto sin correr el riesgo de un ```NullPointerException``` y sin tener que hacer ```if``` anidados para validar en los campos no cean null antes de acceder a su valor. Para esto solo debemos utilizar este metodo el cual recive una lambda o metodos de referencia, con lo cual vamos extrayendo cada campo con sus metodos getters, si alguno de los campos que accedemos es null el map retorna un ```Optional.empity``` sino retorna el valor del metodo indicado y asi sucesivamente concatenando los .map() hasta cuantos campos de campos queramos acceder, luego terminamos usando un metodo de retorno concatenado al ultimo .map() usado, esto para indicar que vamos a hacer si alguno de los campos es null, ya sea retornar un valor null o alguna otra cosa como en el ejemplo.

**Ejemplo 1:**
```java
	// Con todos los campos llenos
	Person i = new Person("Ricardo", "Carvajal",
				new Address("Callejon carabobo", "Venezuela", "Carabobo", "Valencia"));

	Optional<Person> box = Optional.ofNullable(i);

	String municipality = box.map(Person::getAddress).map(Address::getMunicipality)
				.orElseGet(() -> "municipio no encontrado");

	System.out.println("Resultado: " + municipality);
	// Retorna -> Resultado: Valencia
```

**Ejemplo 2:**
```java
	// Con la persona en null
	Person i = null;

	Optional<Person> box = Optional.ofNullable(i);

	String municipality = box.map(Person::getAddress).map(Address::getMunicipality)
				.orElseGet(() -> "municipio no encontrado");

	System.out.println("Resultado: " + municipality);
	// Retorna -> Resultado: municipio no encontrado
```

**Ejemplo 3:**
```java
	// Con la direccion en null
	Person i = new Person("Ricardo", "Carvajal", null);

	Optional<Person> box = Optional.ofNullable(i);

	String municipality = box.map(Person::getAddress).map(Address::getMunicipality)
				.orElseGet(() -> "municipio no encontrado");

	System.out.println("Resultado: " + municipality);
	// Retorna -> Resultado: municipio no encontrado	
```

**Ejemplo 4:**
```java
	// Con el municipio en null
	Person i = new Person("Ricardo", "Carvajal", new Address("Callejon carabobo", "Venezuela", "Carabobo", null));

	Optional<Person> box = Optional.ofNullable(i);

	String municipality = box.map(Person::getAddress).map(Address::getMunicipality)
				.orElseGet(() -> "municipio no encontrado");

	System.out.println("Resultado: " + municipality);
	// Retorna -> Resultado: municipio no encontrado	
```

Esto de verdad es muy buena opcion para evitar los null.

### f) flatMap()

Supongamos que queremos usar ```map()``` para acceder alvalor del campo de un campo, pero uno de los campos devuelve un optional dificultanto un poco el acceso al dato ya que uno de los ```map()``` devolveria un optional de tipo optional, por ejemplo algo asi ```Optional<Optional<String>>```. Aca es donde entra en juego el ```flatMap()```, ya que este tiene la misma funcionalidad de acceso a datos que el ```map()``` pero con la diferencia que el no envuelve automaticamente el dato dentro de un optional como lo hace el ```map()```, por lo cual nos permite tener un facil acceso al dato que ya es un optional. Este metodo se puede usar concuntamente con el ```map```.

```java
	Person i = new Person("Ricardo", "Carvajal",new Address("Callejon carabobo", "Venezuela", "Carabobo", "Valencia"));

	Optional<Person> box = Optional.ofNullable(i);

	String municipality = box.flatMap(Person::getAddress).map(Address::getMunicipality).orElseGet(() -> "municipio no encontrado");

	System.out.println("Resultado: " + municipality);	
```

Notece que el primer metodo para acceder a datos a usar es el ```flatMap()``` debido a que el metodo ```getAddress()``` de la clase ```Person``` devuelve un ```Optional```.

```java
class Person {
	private String name;
	private String lastName;
	private Address address;

	public Person(String name, String lastName, Address address) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Optional<Address> getAddress() {
		return Optional.ofNullable(address);
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
```
