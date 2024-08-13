#Comenzando a usar operadores de comparacion 

print(7 < 3)#<>
print(7 >= 7)#<>=
print(7 == 7)#==
print("Ricardo" == "ricardo")#== Texto sencible a minusculas y mayusculas
print(7 != 7)#!=
print("Ricardo" != "ricardo")#!= Texto sencible a minusculas y mayusculas

x = 3.3
print(x)
y = 1.1 + 2.2
print(y)#y tendra una presicion decimal diferente a x 
print(x == y)

#Cambiando la presicion de y forma numero 1

"""
y_str = format(y, ".2g")
print(y_str)#Aca obtenemos el numero con 2 decimales pero convertido en string
y = float(y_str)#Convertimos el string a float
print(y)
print(x == y)
"""

#Cambiando la presicion de y forma numero 2

tolerance = 0.00001
print(abs(x - y) < tolerance)#abs nos da el valor absoluto de un numero
