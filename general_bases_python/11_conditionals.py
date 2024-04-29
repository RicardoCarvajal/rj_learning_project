#Condicionales en python

if True:
    print("Es verdadero")

if False:
    print("Es falso")

#Veamos un ejemplo del usu de estas condiciones

age_str = input("Introduce tu edad: ")
if age_str.isdigit():
    age = int(age_str)
    if age >= 18:
        print("Eres mayor de edad")
    elif age < 18:
        print("Eres menor de edad")
else:
    print("Introduce un valor valido")
    print("Introduce un numero")

print("FIN")