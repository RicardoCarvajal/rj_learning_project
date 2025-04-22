#manejo de estructura de diccionario en Python

person = {
    'first_name': 'Juan',
    'last_name': 'Perez',
    'age': 25,
    'city': 'Bogota',
    'isMerried': True,
    'skills': ['Python', 'Java', 'JavaScript'],
    'data': {"direction":"El Molino"}
}

print(person.get('data'))
print(person.get('data').get('direction'))
print(person['data'].get('phone'))

print(person)
print(type(person))

#Para buscar una dato llamamos al campo llave que contiene el valor
print(person['first_name'])

#Lo mismo podemos hacer con el metodo get
#Si no existe el campo, nos devolvera None, lo cual no hace cuando buscamos un campo por su llave
print(person.get('name'))#Aca dira que el valor es none ya que la llave 'name' no existe dentro del diccionario

#tambien podemos validar si una llave existe de la siguiente manera
print('first_name' in person)
print('name' in person)

#Modificar un valor de un diccionario
person['age'] -= 5
person['first_name'] = "Ricardo"
person['isMerried'] = False
person['skills'].append('C#')

print(person)

#Eliminar un campo de un diccionario
#Tenemos dos formas de eliminar un campo de un diccionario
#Cabe destacar que el metodo pop en este caso siempre debe resivir una llave como parametro
del person['city']
person.pop('age')

print(person)

#tambien podemos ver los items, los values y las keys
print(person.items())#Me da una tupla con una array de tuplas con la llave y el valor
print(person.keys())#Me da una tupla con un array de las llaves
print(person.values())#Me da una tupla con un array de los valores

