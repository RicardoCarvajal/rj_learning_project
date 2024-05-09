#String un poco mas a fondo

#Verificar que este una cadena de caracteres especifica dentro de un texto

text = "Ricardo esta programando en Python"

print("JavaScript" in text)
print("Python" in text)

#Evaluar tamaño de un string
#La funcion len cuenta los caracteres de un string hasta los que estan en blanco o los espacios

print(len(text))

#Pasar todo el texto a mayuscula o minusculas, esto no modifica el texto original

print(text.upper())
print(text.lower())

#Invertir las mayusculas y minusculas

print(text.swapcase())

#Poner el primer caracter en mayusculas

print(text.capitalize())

#Poner todas las primeras letras de una palabra en mayusculas

print(text.title())

#Contar cuantas veces hay un caracter dentro de una cadena de texto

print(text.count("a"))

#Verificar los caracteres de inicio de un texto o los caracteres con los que finaliza una cadena de caracteres

print(text.startswith("Ricardo"))
print(text.endswith("Python"))

#Reemplazar un caracter por otro

print(text.replace("Python", "JavaScript"))

#Verificar si es un digito o no

print(text.isdigit())
print("123".isdigit())