#Como escribir en un archivo con python
#El argumento r+ se usa para dar permisos de lectura y escritura al archivo 
#que estamos manipulando, sin embaro, con este tipo de permiso no podemos
#sobre escribir lo que ya esta solo podemos añadir nuevas lineas al archivo,
#para sobreescribir utilizamos el permiso w+, cuando coloque este tipo de
#permiso se va areemplazar todo el archivo por lo que mande 
with open('32_files/text.txt','w+') as file:
    for line in file:
        print(line)
    file.write('\nNueva linea')