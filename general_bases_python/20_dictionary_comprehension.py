#Diccionarios de forma resumida

#Sintaxis normal para crear el diccionario
#cada elemento con el cual se crea el diccionario se multiplica por 2
#si la llave de un elemento es 5 se omite

import random

dic_v1 = {}

for i in range(1,11):
    if i != 5:
        dic_v1[i] = i*2

print(dic_v1)

#En la manera resumida es casi igual que la creacion de la lista resumida
#pero tomando encuenta la estructura de llave valor de los diccionarios

dic_v2 = {i : i *2 for i in range(1,11) if i != 5}

print(dic_v2)

#Creando el diccionario a partir de una lista

countries = ['col', 'mex', 'bol', 'pe']

#Manera tradicional
population_v1 = {}
for country in countries:
    population_v1[country] = random.randint(1,100)

print(population_v1)

#Forma resumida
population_v2 = {country: random.randint(1,100) for country in countries}
print(population_v2)

#Ahora crearemos un diccionario a partir de dos listas que contienen las claves y los valores respectivamente
#Esto a fin de obtener un diccionario con la siguiente estructura y valores
'''
{
    'Ricardo': '40',
    'Juan': '23',
    'Lazaro': '69'
}
'''
#Usaremos de una vez la manera resumida
names = ['Ricardo', 'Juan', 'Lazaro']
ages = [40, 23, 69]

data_list = list(zip(names, ages))#Creamos una lista de tuplas

print(data_list)

data = {name: age for (name,age) in data_list if name != 'Ricardo'}#Creamos el diccionario a partir de la lista de tuplas

print(data)