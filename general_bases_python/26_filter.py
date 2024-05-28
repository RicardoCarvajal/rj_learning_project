#Uso de los filtros en python

numbers_v1 = [1,2,3,4,5,6,7,8,9,10]

numbers_v2 = list(filter(lambda i: i != 5, numbers_v1))

#Como vemos filter crea una lista nueva sin afectar la anterior
print(numbers_v1)
print(numbers_v2)

#Trabajando con listas de diccionarios

#Crear lista de diccionario de productos, que tenga el nombre del producto la descripcion, la unidad de medida y el precio
products_v1 = [
    {'name': 'Camisa', 'description': 'Camisa de algodon', 'unit': 'unidad', 'price': 100},
    {'name': 'Pantalon', 'description': 'Pantalon de algodon', 'unit': 'unidad', 'price': 200},
    {'name': 'Zapatos', 'description': 'Zapatos de algodon', 'unit': 'unidad', 'price': 300},
    {'name': 'Gorra', 'description': 'Gorra de algodon', 'unit': 'unidad', 'price': 400},
    {'name': 'Buzo', 'description': 'Buzo de algodon', 'unit': 'unidad', 'price': 500},
]

products_v2 = list(filter(lambda i: i['price'] > 200, products_v1))

#Como vemos filter crea una lista nueva sin afectar la anterior
print()                   
print(products_v1)
print(len(products_v1))
print()
print(products_v2)
print(len(products_v2))
