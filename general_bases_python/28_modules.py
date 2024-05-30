#Usando modulos en Python

#Sistema
import sys

print(sys.path)

#Expreciones regulares
import re

text = 'Mi numero de telefono es 0424-4957233 y el codigo pais es +53'

result = re.findall('[0-9]+',text)

print(result)

#Tiempo

import time

timestamp = time.time()
localTime = time.localtime()
resultTime = time.asctime(localTime)
print(timestamp)
print(localTime)
print(resultTime)

#Colecciones

import collections

numebers = [1,2,3,4,5,6,7,8,9,10,10,10,10,2,2,2,2,3,1,1,1,1]

#Buscando la frecuencia con que se repite cada numero
counter = collections.Counter(numebers)

print(counter)

