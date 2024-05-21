#Estructura de conjuntos en Python

#Se pueden modificar
#No tienen orden
#No se permiten duclicados

country = {"col", "mex", "bol","bol"}
# La diferencia con el diccionario es que no tiene clave valor
#Automaticamente elimina los elementos duplicados
print(country)
print(type(country))

numbers = {1,2,3,1,2,3}
print(numbers)
print(type(numbers))

#Tambien puedo combinar los tipos de datos
types = {1,2,3,False,"hola"}
print(types)
print(type(types))

#Crear un conjunto a partir de un string
word = "Hola"
setWord = set(word)
print(setWord)
print(type(setWord))

#Crear un conjunto a partir de una tupla
tupla = (1,2,3,1,2,3)
setTupla = set(tupla)
print(setTupla)
print(type(setTupla))

#Crear un conjunto a partir de una lista
lista = [1, 2, 3, 1, 2, 3]
setLista = set(lista)
print(setLista)
print(type(setLista))
#Los puedo pasar de nuevo a una lista
lista = list(setLista)
print(lista)
print(type(lista))

#Modificar un conjunto CRUD
#Ver cuantos elementos hay dentro de un conjunto

size = len(types)
print(size)

#Verificar si existe un elemento dentro de un conjunto
print('col' in country)

#Añadir un elemento a un conjunro
country.add('pe')
print(country)
#Otra forna de añadir elementos es la siguiente
country.update({'arg','ecu'})
print(country)

#Eliminar un elemento del conjunto
country.remove('col')# Si el elemento no existe lanza un error ejemplo: country.remove('co') -> KeyError: 'co'
print(country)

#Hay otro metodo para eliminar que si no tiene el elemento no falla la aplicacion
country.discard('co')
print(country)

#Para limpiar todo el conjunto podemos usar el siguiente comando
country.clear()
print(country)

#Operaciones de conjuntos 

#Union de dos conjuntos
countrys_a = {'col', 'ven', 'ecu'}
countrys_b = {'mex', 'per', 'col'}

countrys_c = countrys_a.union(countrys_b)

print(countrys_c)

#Podemos hacer lo mismo con el operador |

print(countrys_a | countrys_b)

#Intersepcion de conjuntos
#La intercepcion me trae solo los elementos comunes en los dos comunes
countrys_d = countrys_a.intersection(countrys_b)
print(countrys_d)

#Podemos hacer lo mismo con el operador &
print(countrys_a & countrys_b)

#Conseguir diferencias, me dara los paises de (a) que no estan en (b)
countrys_e = countrys_a.difference(countrys_b)
print(countrys_e)

#Tambien se puede hacer lo mismo con el operador (-)
print(countrys_a - countrys_b)

#Union sin los elementos comunes
countrys_f = countrys_a.symmetric_difference(countrys_b)
print(countrys_f)

#Tambien se puede hacer lo mismo con el operador ^)
print(countrys_a ^ countrys_b)
