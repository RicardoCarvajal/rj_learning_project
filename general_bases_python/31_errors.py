#Manejo de errores

#Primer error (ZeroDivisionError)
#print(0/0)

#Segundo error (NameError)
#print(resul)

#Error de Assert (AssertionError)
"""
suma = lambda x,y: x +y
assert suma(2,2) == 3
"""

#Lanzando errores (Exception)
"""
age = 10
if age < 18:
    raise Exception('No se permiten menores de edad y edad menor a 18')
"""

#Manejo de excepciones
"""
try:
    print(0/0)
except ZeroDivisionError as error:
    print(error)    
    
print('Continua el programa')
"""

#Combinando todo lo visto

try:

    input = int(input('Escribe una opcion: '))

    if input == 1:
        print(0/0)

    if input == 2:
        print(resul)

    if input == 3:
        suma = lambda x,y: x +y
        assert suma(2,2) == 3, 'La suma no es correcta'

    if input == 4:
        age = 10
        if age < 18:
            raise Exception('No se permiten menores de edad y edad menor a 18')
    
    if input > 4 or input < 1:
        raise Exception('Opcion invalida')

except ZeroDivisionError as error:
    print(error)
except NameError as error:
    print(error)
except AssertionError as error:
    print(error)
except Exception as error:
    print(error)

print('Continua el programa')    
            