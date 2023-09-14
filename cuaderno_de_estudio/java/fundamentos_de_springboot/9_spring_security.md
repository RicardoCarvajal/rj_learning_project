# Uso de Spring Security primeros pasos

Spring Security trabaja con algo que se llama Securiry Filter Chain lo cual es un conjunto de filtros de seguridad con los cuales podemos jugar para manejar la seguridad de nuestra aplicacion de diversas maneras.

A continuacion veremos una grafica con varios de los filtros que vienen en Spring Security:

![Grafico de filtros de Spring](https://github.com/RicardoCarvajal/cuaderno_de_estudios/blob/main/java/fundamentos_de_springboot/img/spring_security_filters.png)

Lo primero que debemos agragar a nuestro ```build.gradle``` es la dependencia de sewguridad de Spring ```implementation 'org.springframework.boot:spring-boot-starter-security'```. Al hacer esto ya todos nuestros endpoint estaran requiriendo autenticación por medio de Basic Authentication por lo cual Spring nos genera un usuario y contraseña por defecto, el usuario por defecto es ```user``` y la contraseña se autogenera al arrancar el servicio y se muestra en el log de la aplicación.

Cabe destacar que despues de configurar nuestras dependencias de Spring Security en el ```build.gradle```, podemos habilitar la opcion en nuestro ```application.properties``` llamada ```logging.level.org.springframework.security.web.*= ``` a la cual le podemos pasar como parametro la palabra ```debug```, esto nos ayudara ver en consola lo que esta haciendo Spring Security y entre esas cosas que nos muestra estaran todos los filtros de seguridad activos en nuestra aplicacion en los cuales se encuentran algunos de los que vimos en la imagen anterior.

## Crear clase de configuración

Por otra parte debemos crear la clase de configuracion si requerimos ir trabajando con la personalizacion de nuestra aplicación.


```java
@Configuration
public class SecurityConfig {

}
```

Como se dijo anteriormente Spring Security trabaja con Securiry Filter Chain, por lo tanto dentro de nuestra clase de configuracion de seguridad, haremos un metodo (el cual sera un Bean de Spring, por lo cual debemos anotarlo con ```@Bean```) el cual nos retornara un objeto de tipo ```SecurityFilterChain```, con este metodo modificaremos nuestra configuracion de seguridad o en otras palabras personalizaremos el Securiry Filter Chain de nuestra aplicación.

```java

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filteSecurity(HttpSecurity httpSecurity) throws Exception{
		
	httpSecurity
			.authorizeHttpRequests()
			.anyRequest()
			.permitAll();

    return httpSecurity.build();

    }
}

```

Como vemos este metodo debe resivir un ```org.springframework.security.config.annotation.web.builders.HttpSecurity``` y debido al uso del metodo ```.build()``` debemos hacer que nuestro metodo de configuracion de Filter Chain lanse una excepción ```throws Exception```.

La configuracion de Security Filter Chain que se encuentra en el metodo anterior es la mas sencilla posible, esta configuracion permite todas las peticiones a todos los endpoint.

La configuracion del ```httpSecurity``` se lee de la siguiente manera:

1. ```authorizeHttpRequests``` al autorizar las peticiones http
2. ```anyRequest``` cualquier petición
3. ```permitAll``` permitela

**Cabe destacar que el orden de como pongamos esta cadena de metodos es muy importante para que los filtros de seguridad funcionen correctamente.**

Ahora veamos otra configuracion diferente

```java

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filteSecurity(HttpSecurity httpSecurity) throws Exception{
		
	httpSecurity
			.authorizeHttpRequests()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();

    return httpSecurity.build();

    }
}

```

Esta configuracion (la cual da una seguridad basica con el usuario y contraseña por defecto de Spring) se lee de la siguiente forma:


1. ```authorizeHttpRequests``` al autorizar las peticiones http
2. ```anyRequest``` cualquier petición
3. ```authenticated``` debe autenticarse
4. ```and``` y
5. ```httpBasic``` usar http basic

Cuando usamos esta sencilla configuración, el proceso se lleva de la manera que se refleja en la siguiente grafica:

![Grafico de Authetication Filter Chain con Basic Authetication](https://github.com/RicardoCarvajal/cuaderno_de_estudios/blob/main/java/fundamentos_de_springboot/img/porceso_filtro_Basic_AuthenticationFilter.png)

Notemos que en este caso cuando Spring llama a AuthenticationProvaider este implementa a DAOAuthenticationProvaider ya que es una autenticacion por contraseña y cuando llama a UserDetailService esta implementa en este caso a InMemoryUserDetailsManager debido a que se esta utilizando la contraseña por defecto de Spring.

## Deshabilitar proteccion CSRF para APIs (Stateless + JWT)

Como esta documentacion se enfoca en hacer un api (Stateless + JWT) es decir que no maneja estados ni almacena sesiones y ademas trabaja con Json Web Token, estonces desactivaremos la proteccion CSRF (del inglés Cross-site request forgery o falsificación de petición en sitios cruzados) ya que un API como la que se plantea no puede funcionar con esta proteccion activa. Para desactivar esto lo haremos de la siguiente forma:

```java

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filteSecurity(HttpSecurity httpSecurity) throws Exception{
		
	httpSecurity
            .csrf()
            .disable()
			.authorizeHttpRequests()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();

    return httpSecurity.build();

    }
}

```
Para desactivar la proteccion CSRF solo tenemos que en nuestro objeto httpSecurity comenzar añadiendo los metodos ```.csrf().disable()```.

## Uso de CORS (Cross-Origin Resource Sharing)

Los cors se usan para indicar cuales peticiones de origen de un dominio diferente al dominio de la API queremos permitir.

![Cross-Origin Resource Sharing](https://github.com/RicardoCarvajal/cuaderno_de_estudios/blob/main/java/fundamentos_de_springboot/img/cors.png)

Debemos saber configurar y manejar esto ya que desde el postman o otra aplicacion cliente en JAVA probablemente no tengamos problemas, pero si el api es consumida por ejemplo por una aplicacion en Angular que esta alojada en un dominio diferente al de nuestra api, la aplicacion de frontend no se podra conectar.

Podemos configurar los CORS en nuestro proyecto de dos maneras:

1. **Directamente por cada endpoint**

Para esto solo tenemos que añadir los metodos ```cors().and()``` al ```httpSecurity``` de nuestro Security Filter Chain, y luego y al endpoint en el controlador que desaamos permitir a la aplicacion externa y usar la anotacion ```@CrossOrigin("http://dominio.com:puerto")```.

**SecurityConfig**

```java

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filteSecurity(HttpSecurity httpSecurity) throws Exception{
		
	httpSecurity
            .csrf()
            .disable()
            .cors()
            .and()
			.authorizeHttpRequests()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();

    return httpSecurity.build();

    }
}

```

**Controller**

```java

@GetMapping("/{id}")
    @CrossOrigin("http://localhost:4200")
    public ResponseEntity<TableEntity> get(@PathVariable int id) {
        return ResponseEntity.ok(this.tableService.get(id));
    }

```

2. **Creando una clase de configuración CorsConfig**

Tambien podemos crear una clase para el manejo de CORS en todo nuestro proyecto la cual podriamos llamar CorsConfig pero podria tener un nombre diferente esta clase debe estar anotada con ```@Configuration```. Y dentro de esta clase debemos tener un metodo que retorne un ```CorsConfigurationSource``` y este metodo tambien lo debemos anotar con ```@Bean``` para que sea reconocido como un bean de Spring.

```java

@Configuration
public class CorsConfig {

	@Bean
	public CorsConfigurationSource configurationSource() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://dominio.com:puerto"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfiguration);
		
		return source;
	}
	
}

```

Como se puede visualizar dentro del metodo creado se usan dos objetos importantes el primero de tipo ```CorsConfiguration``` el cual se utiliza para indicar la configuracion de los CORS tal como cuales son los origenes permitidos, los metodos http permitidos y los encabezados permitidos (en el ejemplo anterior se permiten todos los encabezados), el segundo objeto a usar es de tipo ```UrlBasedCorsConfigurationSource```, el cual se usa para configurar a cuales endpoints aplica la configuracion la cual recibe como parametro por medio de un objeto ```CorsConfiguration``` (en el ejemplo anterior se permiten todos los endpoints) y este segundo objeto es el que retornara nuestro metodo ya que esta clase implementa ```CorsConfigurationSource```.

## RequestMatchers

Este es un metodo que usamos dentro de nuestra clase de seguridad para configurar los permisos de los metodos Http y las rutas permitidas, tambien se puede con requestMatchers configurar los permisos hacia algun metodo Http o endpoint especifico por roles.



```java

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filteSecurity(HttpSecurity httpSecurity) throws Exception{
		
	httpSecurity
            .csrf()
            .disable()
            .cors()
            .and()
			.authorizeHttpRequests()
            .requestMatchers(HttpMethod.GET,"/api/endpoint*").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();

    return httpSecurity.build();

    }
}

```

Aunque en nuestro ejemplo anterior estamos indicando que nuestor servicio funciona con una autenticacion de tipo Basic Authentication, tambien con requestMatchers le estamos indicando que para todas las url (/api/endpoint*) (todas por el asterisco) y unicamento cuando es una solicitud de tipo (GET), el servicio no necesitara permisos. el asterispo es muy importanto porque nos indica hasta que nivel se puede tener acceso al endpoint, en este caso si tenemos una url como ```http://localhost:8080/api/endpoint``` tendremos el acceso esperado pero si tenemos ```http://localhost:8080/api/endpoint/otronivel``` nos dara una respuesta http 403, para tener acceso a ese otronivel debemos colocar un asterisco adicional a la misma configuración de la siguiente manera ```.requestMatchers(HttpMethod.GET,"/api/endpoint**")```.


Asi como puedo permitir todo para esa pericion con el metodo ```.permitAll()``` tambien puedo denegar todo para cualquier otra petición con ```.denyAll()```, como lo podemos ver en el siguiente ejemplo.

```java

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filteSecurity(HttpSecurity httpSecurity) throws Exception{
		
	httpSecurity
            .csrf()
            .disable()
            .cors()
            .and()
			.authorizeHttpRequests()
            .requestMatchers(HttpMethod.GET,"/api/endpoint*").permitAll()
            .requestMatchers(HttpMethod.PUT).denyAll()
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();

    return httpSecurity.build();

    }
}

```

## Manipulación de usuarios sencillos en memoria

Como vimos anteriormente si usamos la autenticacion basica en memoria por defecto de Spring, el mismo al final de su proceso de filtros de seguridad llama a una clase llamada ```InMemoryUserDetailsManager```, lo que se puede hacer es personalizar ese usuario por defecto en memoria e incluso añadir otros y configurar roles para ellos que posteriormente seran usados en los requestMatchers de nuestra clase de configuracion de seguridad.

Para esto en nuestra clase de seguridad creamos otro metodo al cual anotaremos con ```@Bean``` y este metodo retornara un metodo de tipo ```UserDetailsService``` pero este mismo vendra de su implementacion ```InMemoryUserDetailsManager``` la cual usaremos en el metodo creado.

Cabe destacar que el metodo constructor que usamos para instanciar el objeto de retorno, recibe la cantidad de objetos ```UserDetails``` que necesitemos, en este caso solo recibira uno nada mas.


```java

    @Bean
	public UserDetailsService memoryUsers() {
		UserDetails admin = User.builder().username("admin").password("admin").roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(admin);
	}

```

Hasta este momento aun nos falta algo y es que el metodo ```.password("admin")``` nos pide encriptar la contraseña, por lo cual debemos hacer lo siguiente:


Creamos un metodo el cual anotaremos con ```@Bean``` y que sera el encargado de instanciar una clase llamada ```BCryptPasswordEncoder``` con la cual podemos usar su metodo ```.encode(String``` para endriptar nuestra contraseña.


```java

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

```

Luego de crear este metodo solo lo implementamos en el metodo creado anteriormente de la siguiente manera:


```java

    @Bean
	public UserDetailsService memoryUsers() {
		UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(admin);
	}

```

## Configuración de roles de usario con usuarios en memoria


Para esto lo primero es tener otro usuario con otro rol diferente en nuestro metodo ```memoryUsers()```, lo podemos hacer de la siguiente manera, solo debemos crear otro ```UserDetails``` y añadirlo al constructor ```InMemoryUserDetailsManager```.


```java

	@Bean
	public UserDetailsService memoryUsers() {
		UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
				.build();

		UserDetails cajero = User.builder().username("cajero").password(passwordEncoder().encode("cajero"))
				.roles("CAJERO").build();

		return new InMemoryUserDetailsManager(admin, cajero);
	}
	}

```

Luego debemos implementar estos usuarios y roles en los metodos requestMatchers que se encuntra en nuestra configuracion de filtros de nuestra clase de seguridad. Esto lo hacemos utilizando el metodo ```hasRole``` cuando se va a configurar un solo role para un endpoint o el metodo ```hasAnyRole``` para varios roles en un endpoitn.


```java

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filteSecurity(HttpSecurity httpSecurity) throws Exception{
		
	httpSecurity
            .csrf()
            .disable()
            .cors()
            .and()
			.authorizeHttpRequests()
			.requestMatchers(HttpMethod.GET, "/api/endpoint/**").hasAnyRole("ADMIN", "CAJERO")
			.requestMatchers(HttpMethod.POST, "/api/endpoint/**").hasRole("ADMIN")
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();

    return httpSecurity.build();

    }
}

```

Notece que ahora no usamnos los metodos ```.permitAll()``` y ```.denyAll()```, solo indicamos que roles tienen acceso a algun endpoint, en el caso del ejemplo anterior los usuarios con roles de ADMIN y CAJERO son tienen acceso a ese endpoint por el metodo GET pero solo ADMIN tiene acceso al mismo metodo por el metodo POST.


## Manejo de usuarios y roles a travez de una BD

Por supuesto lo primero que debemos tener es una tabla de BD que contenga los usuarios y otra que contenga los roles, y estas tablas deben guardar las contraseñas de manera encriptada.




