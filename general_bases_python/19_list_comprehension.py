# Listas de forma resumida

#Forma basica de generar la lista
#al crear la lista cada elemento se multiplica por 2
#en la creacion de la lista se evalua si el elemento es igual
#a 5 y lo omite
numbers_v1 = []

for element in range(1,11):
    if element != 5:
        numbers_v1.append(element * 2)

print(numbers_v1)

#Una forma mas resumida de generar la lista
numbers_v2 = [element * 2 for element in range(1,11) if element != 5]

print(numbers_v2)