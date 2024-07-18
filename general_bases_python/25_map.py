#Uso de map en python map(function, iterable)

numbers_v1 = [1,2,3,4] 

numbers_v2 = [] 

for i in numbers_v1:
    numbers_v2.append(i * 2)

#Recorriendo lista con un MAP
numbers_v3 = list(map(lambda i: i * 3, numbers_v1))

#Sumando los valores de dos listas
numbers_v4 = [1,2,3,4,1] 
numbers_v5 = [5,6,7,8,9]
numbers_v5_v1 = [5,6,7,8,9] 

numbers_v6 = list(map(lambda x,y,z: x + y + z, numbers_v4, numbers_v5,numbers_v5_v1))

print(numbers_v1)
print(numbers_v2)
print(numbers_v3)
print("Map con dos parametrso",numbers_v6)

#Map con dicionarios de datos
products_v1 = [
    {"name": "laptop", "price": 800},
    {"name": "mouse", "price": 40},
    {"name": "monitor", "price": 400},
    {"name": "keyboard", "price": 80}
    ,
]

#Obteniendo el precio de los productos
prices_list = list(map(lambda p: p['price'],products_v1))
print(prices_list)

#Agregando el campo tax al diccionario

#Aca hay que tener cuidado porque cuando usamos map la idea es no modificar la lista original, sino que crear una nueva
#pero en este caso cuando utilizamos un diccionario el original se termina modificando por, temas de referencia en memoria
#con respecto a elemento products
def add_tax(product):
    new_product = product.copy()#Para evitar la modificacion del diccionario original por los temas de manejo en memoria solo usamos el metodo copy()
    new_product['tax'] = new_product['price'] * 0.16
    return new_product


products_v2 = list(map(add_tax,products_v1))

print(products_v1)
print(products_v2)