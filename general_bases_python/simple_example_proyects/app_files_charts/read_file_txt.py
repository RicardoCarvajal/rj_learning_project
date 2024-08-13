#Trabajando con archivos

file = open('text.txt')

#Leer todo el contenido del archivo
#print(file.read())

#Leer una sola linea del archivo
#print(file.readline())

#Leyendo el archivo linea a linea
for line in file:
    print(line)

#Debemos cerrar el archivo siempre
file.close()

#Una forma mas comun de leer los archivos en python es la siguiente
#de la siguiente manera python cierra el archivo automaticamente

with open('text.txt') as file:
    for line in file:
        print(line)