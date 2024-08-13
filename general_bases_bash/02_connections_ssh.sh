#!/bin/bash

# Conexiones por SSH

# Como conectar

#Para conectar a una maquina por ssh se debe tener instalado openssh, en linux esto lo podemos hacer de una manera muy sencilla ejecutandoi los siguientes comandos ```sudo apt-get update``` y ```sudo apt install openssh-server```, sin embargo en la mayoria de los sistemas operativos actuales viene ya incluido.

#Sabiendo esto, ya nos podriamos conectar a un equipo de la red vis ssh de la siguiente manera usando el comando ```ssh``` añadiendo el usuario y la ip separados por un @, viendose de la siguiente manera ```ssh usuario@127.0.0.1```

#Luego de esto se nos pedira la contraseña por medio del usuario del SO al que nos queremos conectar.

# Problemas comunes

#En ocaciones al intentarnos conectar, en el camino de la conexion nos podemos encontrar un switch viejo, que trabaje con algoritmos de transferencia de informacion desactualizados y vulnerables a cyber ataques, como por emeplo el algoritmo **diffie-hellman-group1-sha1** el cual es vulnerable a un ataque llamado **Logjam**, por lo cual este algoritmo esta deescontinuado por la NSA (Agencia de Seguridad Nacional de Estados Unidos).

#Sin embargo, aun asi puede que nos encontremos con este problema y no nos podamos conectar a algun dispositivo, y en ves de esto nos aparesca el siguiente error en consola **Unable to negotiate with 127.0.0.1 port 22: no matching key exchange method found. Their offer: diffie-hellman-group1-sha1**.

#La mejor solucion a esto es actualizar los dispositivos de la red (switch), pero como esto en la mayoria de los casos depende de algun personal tecnico fuera de nuestro alcance, podemos habilitar **diffie-hellman-group1-sha1** configurandolo de la siguiente manera en el archivo **/etc/ssh/ssh_config**, añadiendo los siguientes parametros en tres lineas adicionales al final del archivo, de la siguiente forma:

sudo vi /etc/ssh/ssh_config

# Luego añadir las siguientes 3 lineas:

KexAlgorithms +diffie-hellman-group1-sha1
HostKeyAlgorithms +ssh-dss
PubkeyAcceptedAlgorithms +ssh-rsa
