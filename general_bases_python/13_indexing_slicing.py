#Uso de Indexing y slicing en python

text = "Ricardo esta programando en Python"

#Indexing
#Puedo indexar a nivel de posiciones

print(text[0]) #Nos muestra la primera letra, print(text[100]) Si le doy una posicion que no existe me dara un error

#Para poder ubicarme en la ultima posicion podemos calcular el tamaño con
#len y debemos tomar en cuenta que siempre esto comienza en 0

print(text[len(text)-1])

#Lo que se hizo en la linea anterior facilmente en python se puede hacer de la siguiente otra manera
#simplemente el -1 nos lleva a la ultima posicion

print(text[-1])

#Slicing
#Basado en las posiciones de los caracteres de un String sacar un frafmento del texto
#es como un substring

print(text[0:7]) #Nos muestra la primera letra hasta la posicion 7

#Si siempre vamos a empezar en la primera posicion podemos omitir el primer parametro

print(text[:7])

#Lo mismo ocurre con el final

print(text[28:])

#Haciendo saltos con un tercer parametro

print(text[:24:1])#Solo un salto
print(text[:24:2])#Dos saltos
print(text[:24:3])#Tres saltos