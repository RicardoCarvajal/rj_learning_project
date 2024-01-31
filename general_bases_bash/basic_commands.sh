#!/bin/bash

# Redireccionar salida


# Redirecciona salidsa de comando ls, ordenada por nombres en un archivo .txt para redireccionar a un archivo cuando se usa pipe | se debe usar el comando tee

ls -lh | sort | tee output.txt | less

# Monerias

# El comando cowsay te genera una vaca en la consola y lolcat te pinta de colores el texto de la consola

cowsay "Vaca" | lolcat


# Ejecucion de varios comandos de forma sincrona

ls; mkdir prueba; date

# Ejecucion de varios comandos de forma asincrona

ls & mkdir prueba & date

# Ejecucion de varios comandos de forma condicionada... si se ejecuta la primera sentencia la segunda tambien lo hara

mkdir prueba && cd prueba

# El operador || sirve para concatenar las agciones sin importar si la primera no se ejecuta, es como una ejecucion asincrona pero sin varios hilos como lo realiza el &&

# Nota: touch es el comando que se usa para crear archivos 

cd prueba || touch archivo.txt || echo "Archivo creado"


# El operador > tambien puede crear un archivo sin mas ya que es un operador de salida

> prueba.txt

# Tambien puedo escribir un archivo con cat de la siguiente manera usando el operador de salida

cat > pruebas.txt

# CAMBIANDO PERMISOS

# De manera octal

# El primer numero representa el usuario, luego el grupo y despues el mundo, estos numero representan 3 bits cada uno, el primer bit es el permiso de (r) lectura, el segundo (w) escritura y el tercero (x) ejecucion, si uno de ellos se activa seria 1 sino seria 0, sacando la sumatoria de bits de izquierda a derecha daria el numero total, por ejemplo si es (1 1 1) la suma seria (4 + 2 + 1) es decir 7. 

chmod 755 pruebas.txt 

# De manera simbolica

# En el siguiente ejemplo quitamos los permisos de ejecucion (x) al usuario (u) y al grupo y al mundo (g y o) le asignamos solo permisos de escritura (w)

# (-) es para quitar un permiso
# (+) es para añadir un permiso
# (=) es para cambiar lo que se tiene por lo que se asigna un permiso

chmod u-x,go=w pruebas.txt


# Busqueda

# Buscar desde el directorio donde me encuentro todo los archivos punto txt, para luego reisarlo con less

find ./ -name *.txt | less

# Con la opcion (-type d ) busca lo que son directorios, si colocamos (f) solo buscara archivos

find ./ -type d -name Documentos

# Con la opcion (-size) podemos buscar archivos por tamaño, todos los mayores al valor especificados

find ./ -size 20M


# El comando grep

# Buscar todas las lineas que tengan la palabra "the"

grep the movies.csv

# Desactivar el case sensitive

grep -i the movies.csv

# Contar el numero de palabras "the" encontradas

grep -c the movies.csv

# Se puede convinar los dos anteriores

grep -ci the movies.csv

# Excluir las lineas que contengan "towers"

grep -v towers movies.csv

# Comando wc para ver cuantas lineas, palabras y bits tiene un archivo. Se puede tener los valores por separados usando los parametros -l,-w,-c respectivamente

wc movies.csv

wc -l movies.csv
wc -w movies.csv
wc -c movies.csv

#Comprimir un directorio con todos sus archivos dentro en un .tar.gz
#c de comprimir
#v de vervoso para ver que hace cuando comprime
#f de file
#luego viene como se llamara el comprimido

tar -cvf compres.tar compres/


#Comprimir un directorio con todos sus archivos dentro en un .tar.gz
#c de comprimir
#v de vervoso para ver que hace cuando comprime
#z para .gz
#f de file
#luego viene como se llamara el comprimido

tar -cvzf compres.tar.gz compres/


#Descomprimiri un directorio con todos sus archivos dentro en un .tar
#x de descomprimir

tar -xvf compres.tar 

#Descomprimiri un directorio con todos sus archivos dentro en un .tar.gz
#x de descomprimir

tar -xvzf compres.tar.gz 

#Comprimir un directorio con todos sus archivos dentro en un .zip
#r para hacerlo recursivo

zip -r compres.zip compres/

#Descomprimir un directorio con todos sus archivos dentro en un .zip

unzip compres.zip 

#Envia proceso a background con &
cat > mi_nota.txt &

#Recorrer los aparatos de la red
traceroute www.google.com













