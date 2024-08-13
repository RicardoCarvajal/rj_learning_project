#Podemos transformar datos en python de la siguiente manera

var_data = "Ricardo"

print(type(var_data))

var_data = 17

print(type(var_data))

var_data = True

print(type(var_data))

#Como vemos python es un lenguaje dinamico, podemos cambiar el tipo de dato de una variable
#pero hay que tener cuidado con los tipos de datos que no sean compatibles ya que la siguiente 
#impresion que busca concatenar dos valores (pensando que los dos son strings) da error
#debido a que el valor de la variable var_data es un booleano

#print("Hola" + var_data);

#tendriamos que convertir el valor de la variable a string para que pueda concatenar
#esto lo podemos hacer con la funcion str()

print("Hola " + str(var_data));

#Con la funcion format() podemos convertir el valor de una variable a un string
#de forma automatica

print("Hola {}".format(var_data));

#La conversion de un string a un entero es muy sencilla, y se puede realizar de la siguiente forma
#supongamos que tenemos un input de tipo string que representa un numero entero como la edad
#pero luego el dato queremos manipularlo como un numerico

age = input("Ingrese su edad: ")

print(type(age))

#Hay que tener siempre cuidado con la conversion de un string a un entero ya que si el
#string no representa un numero entero, la conversion da error
age = int(age)

print(type(age))

age = age+1

print(f'Tu edad es: {age}')