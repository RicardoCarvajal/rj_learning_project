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

















