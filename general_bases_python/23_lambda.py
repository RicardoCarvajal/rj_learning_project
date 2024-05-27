#Funciones lambdas en python

#Funcion normal
def increment_one_v1(x):
    return x + 1

result_1 = increment_one_v1(10)
print(result_1)

#funcion lambda
increment_one_v2 = lambda x: x + 1

result_2 = increment_one_v1(20)
print(result_2)


#Funcion lambda con dos valores
full_name = lambda name, last_name: f'{name} {last_name}'

name = 'Juan'
last_name = 'Perez'

result_3 = full_name(name, last_name)
print(result_3)