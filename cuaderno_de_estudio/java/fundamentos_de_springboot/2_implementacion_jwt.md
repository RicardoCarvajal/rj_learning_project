# Implementar JWT dentro de un servicio spring boot 

## Nuestro propio filtro

Lo primero es crear una clase que sera nuetro propio filtro de seguridad, esto para dejar de usar el filtro por defecto de spring, a la clase le podemos dar un nombre como ``` JWTFilter``` pero si quweremos le podemos dar otro nombre, esta clase debe extender de la clase ``` OncePerRequestFilter```. Es importante recordar colocdar a la clase la anotación ``` @Component``` para que spring lo reconozca como un componente.

```java
    @Component
    public class JWTFilter extends OncePerRequestFilter{
    ...
```

Al extender de la clase ``` OncePerRequestFilter``` deberemos implementar el siguiente metodo:

```java
    @Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
    ....
```

Adentro de este metodo, colocaremos nuestar logica de filtro personalizada para implementar nuestro propio filterChain el cual sera usado en cada peticion que se haga.

La logica de nuestro filtro personalizado comprendera 4 cosas importantes:

1. Verificar que sea un header de autentificacion valido

Para esto se usa el parametro ```request``` que viene dentro de la petición, y con el verificamos que el parametro ```Authorization``` no venga null, vacio o con un token que no sea antecedido por la palabra ```Bearer```

```java
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION); 
		
		if (authHeader == null || authHeader.isEmpty() || !authHeader.startsWith("Bearer")) {
			filterChain.doFilter(request, response);
			return;
		}
    ....
```

2. Verificar que el JWT sea valido

En este secmento lo que hacemos es tomar la variable ```authHeader``` creada para almacenar la informacion del encabezado de la peticion, en su parametro ```Authorization```, lo cual es el token como tal, pero lo primero que hacemos es separar el token de la palabra ```Bearer``` con el metodo ```split(" ")``` de la clase ```String```.

Luego lo validamos con el metodo ```isValid()``` que con anticipacion hemos creado en la clase ```JWTUtils``` la cual inyectamos en este componente y se explica en el siguiente [link](https://github.com/RicardoCarvajal/cuaderno_de_estudios/blob/main/java/fundamentos_de_springboot/1_metodos_para_validar_jwt.md) del cuaderno. 

Si cumple con la validacion continuamos con el flujo, pero si no retornamos sin autorizar la petición.

```java
		String jwt = authHeader.split(" ")[1].trim();
		
		if(!this.jwtUtils.isValid(jwt)) {
			filterChain.doFilter(request, response);
			return;
		}
    ....
```

3. Validamos que el ususario exista en BD y lo cargamos en el ```UserDetailsService```

Esto lo hacemos inyectando dicha clase y usando el metodo ```loadUserByUsername()``` del cual debemos tener una implementación. 

Tambien inyectamos ```JWTUtils``` para usar el metodo ```getUsername()``` el cual nos ayuda a sacar exclusivamente el usuario que cargaremos en ```UserDetailsService```


```java
        String username = this.jwtUtils.getUsername(jwt);

		User user = (User) this.userDetailsService.loadUserByUsername(username);
    ....
```

4. Cargar el usuario al contexto de seguridad

Ahora si autorizamos la petición accediendo al contexto de seguridad por medio del metodo ```setAuthentication()``` en el cual se le asigna un objeto de tipo ```UsernamePasswordAuthenticationToken``` instanciado con los datos del usuario. Luego de haber autorizado la peticion en el contexto de seguridad se usa el metodo ```doFilter()``` del ```filterChain``` que viene como parametro en el metodo ```doFilterInternal``` de la clase ```OncePerRequestFilter``` de la cual estamos extendiendo.

```java
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
		
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

		SecurityContextHolder.getContext().setAuthentication(authenticationToken);
		
		filterChain.doFilter(request, response);
    ....
```









