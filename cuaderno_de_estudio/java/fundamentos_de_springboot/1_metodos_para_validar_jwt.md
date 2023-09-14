# Validar JWT dentro de un servicio spring boot 

## Crear metodo

```java
	public boolean isValid(String jwt) {
		try {
			JWT.require(ALGORITHM)
			.build()
			.verify(jwt);
		
			return true;	
		} catch (JWTVerificationException e) {
			return false;
		}		
	}
```

Debemos crear un metodo llamado ``` isValid()``` (el nombre puede variar) este metodo retornara un valor booleano y recibira un valor de tipo ``` String``` que contenera el token luego de esto utiliza la clase ``` JWT``` del paquete ``` com.auth0.jwt.JWT``` la cual nos ayuna a manejar el token.

Luego usamos el metodo ``` require()``` al cual le pasamos el algoritmo creado en la misma clase como campo constante, anteriormente se creo de la siguiente forma:

```java
    private static String SECRET_KEY = "secret";
    private static Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);
```
Luego se contruye el objeto y se usa el metodo que verifica el jwt ``` verify(jwt)``` que estamos pasando por parametro al metodo, si el token es valido este metodo retornara un objeto de tipo ``` DecodedJWT``` sino, retornara una excepcion de tipo ``` JWTVerificationException```

El objeto ``` DecodedJWT``` es algo que podemos usar para poder obtener la informacion de token de manera mas sencilla y organizada, de hecho podemos tener accediendo al metodo ``` getSubject``` de este objeto para saber el usuario registrado en el token, creando un metodo como el siguiente:

```java
	public String getUsername(String jwt){
		return JWT.require(ALGORITHM)
		.build()
		.verify(jwt)
		.getSubject();
	}
```
