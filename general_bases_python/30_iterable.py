#Iteraciones

#Una iteracion normal
for i in range(1,11):
    print(i)


#Imprimir un objeto iterable
my_iter = iter(range(1,4))
print(my_iter)

#Obtener el primer elemento de la iteracion
print(next(my_iter))
#Con el next puedo iterar manualmente
print(next(my_iter))
print(next(my_iter))
#Si no tomo en cuenta la cantidad de elementos me daria un error
print(next(my_iter))