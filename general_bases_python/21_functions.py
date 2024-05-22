#Funciones en python
#Para definir funciones se usa la palabra clave def

def saludo_v1():
    print("Ricardo haciendo funciones")

saludo_v1()

#Funciones con parametros
def saludo_v2(data):#En la declaracion los parametros no necesitan declarar un tipo
    if type(data) == int:
        txt = data * 2    
        print(f'Ricardo haciendo una funcion que multiplica el numero {data} x 2 = {txt}')
        return
    print(f'Ricardo haciendo funciones en {data}')

saludo_v2("Python...")
saludo_v2(2)

#Funciones con retorno de algun valor
def sum_numbers_with_limit(number):
    if type(number) != int and number < 0:
        return 0
    return number * (number+1) / 2

limit = 2

result = sum_numbers_with_limit(limit)

print(f'El resultado de la suma de todos los numeros enteros positivos hasta el {limit} es igual a {result}')

#Trabajar con multiples parametros y valores de retornos, y configuracion de valor por defecto de parametros, en las funciones de python
def numbers_per_diff(number_1 = 10, numeber_2 = 100):#aca estamos usando multiples parametros y ademas a los parametros se les coloca un valor por defecto
    result = abs(number_1 - numeber_2) + 1 / 2
    return f'El resultado de la diferencias de los numeros {number_1} y {numeber_2} inclusive contando los pares es', result #aca con ayuda de la coma estamos retornando dos resultados

#la funcion numbers_per_diff() retorna dos resultados a la vez y esto lo hace en forma de tupla
#podemos acceder al resultado de dos maneras
#1. colocando variables seguidas por coma en el orden de retorno de los valores
message, result = numbers_per_diff(150,360)
print(message, result)
#2. Buscando el indice de la tupla
response = numbers_per_diff(150,360)
print(response[1])

#cabe resaltar que si no ingresamos ningun argumento a la funcion la misma no fallara
#debido a que tiene los valores 10 y 100 configurados por defecto
print(numbers_per_diff())
#incluso podriamos solo ingresar uno de los argumentos
print(numbers_per_diff(numeber_2=150))

