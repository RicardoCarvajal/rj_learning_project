#Tipo de dato String en python
name = "Ricardo" 
last_name = "Gomez"

print(name)
print(last_name)

#Concatenacion de cadenas de texto
full_name = name + " " + last_name

print(full_name)

#Usando apostrofe en las cadenas de texto
quote_one = "I'm a programmer"

#Podemos invertir el caso cuando necesitamos usar comillas dobles en un string
quote_two = 'He said "hello"'

print(quote_one)
print(quote_two)

#Uso de la funcion format para concatenar cadenas de texto
template_one = "Hola, mi nombre es {} {}".format(name, last_name)

print(template_one)

#Se puede usar el indice para cambiar el orden de los valores
template_two = "Hola, mi nombre es {1} {0}".format(name, last_name)

print(template_two)

#Tambien se puede anteponer la letra f antes de la cadena de texto y colocar las variables dentro de las llaves
#Esta es la forma mas recomendada
template_three = f"Hola, mi nombre es {name} {last_name}"

print(template_three)