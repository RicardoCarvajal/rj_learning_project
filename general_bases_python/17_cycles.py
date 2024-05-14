#Manejo de ciclos en python

#Ciclo while
counter = 0

while counter < 10:
    counter +=1
    if counter == 5:
        response = input("¿Desea romper el ciclo? s/n")
        if response.casefold() == "s":
            print("Breaking")
            break #Rompiendo el ciclo de manera forzada
        else:
            response = input("¿Desea omitir el numero 5? s/n")
            if response.casefold() == "s":
                continue #Omitiendo el numero 5 o continuando sin el 5
    print("Step " + str(counter))            
            


#Ciclo for
for i in range(1,11):
    print("Step " + str(i))

#Recorriendo una lista o una tupla es igual
list_person = ["Juan", "Pedro", "Maria"]
for i in list_person:
    print(i)

#Recorriendo un diccionario
#En primera instancia por defecto el for itera por las llaves
person = {"name": "Juan", "lastname": "Perez", "age": 30}
for e in person:
    print(e)
#Sin embargo podemos obtener el valor de las llaves de la siguiente forma
for e in person:
    print(person[e])
#Otra manera de hacer esto es la siguiente
for key, value in person.items():
    print(f"Resultado {key} = {value}")
