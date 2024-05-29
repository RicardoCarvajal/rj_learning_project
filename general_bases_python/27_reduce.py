#Reduce en python = reducir algo a un valor
import functools

numbers_v1 = [1, 2, 3, 4, 5]

#En este caso el counter por su puesto inicia en 0 y el se va llenado con el resultado de la operacion
result = functools.reduce(lambda counter, item: counter + item, numbers_v1)

print(result)

#Aplicando reduce con una lista de diccionarios
list_of_dicts = [
    {"name": "John", "age": 25},
    {"name": "Jane", "age": 30},
    {"name": "Bob", "age": 35},
]

#Con un argumento adicional puedo indicar donde iniciara el contador
result = functools.reduce(
    lambda counter, item: counter + item["age"], list_of_dicts, 0
)
print(result)