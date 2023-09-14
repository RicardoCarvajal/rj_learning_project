# Comandos basicos de git

## Crear un repositorio local

Para esto solo debo crear un directorio o carpeta y dentro de esta carpeta que sera nuestro repositorio ejecutar el comando ```git init``` por medio de una consola linux. Luego si creo un archivo dentro de esta carpeta y ejecuto el comando ```git status``` podremos ver que ya git nos va informando de los cambios que vamos haciendo.

## Configuraciones

Para ver las configuraciones de nuestro repositorio podemos ejecutar el comando ```git config -l``` y nos listara las configuraciones que actualmente tenemos. Si ejecutamos solo ```git config``` nos muestra una lista de parametros con los cuales podremos configurar y trabajar en git. Por otra parte el comando ```git config -l --show-origin``` nos da todas las configuraciones guardadas.

## Ciclo de vida de GIT entendiendo el **stage**

Se prodria decir que los archivos dentro de un repositorio pueden tener 3 estados principales:

1. El directorio (directory) 
   * Se dice que esta sin seguimiento (untracked)
   
2. La puesta en escena (staging)
   * Se dice que esta en seguimiento (tracked)
   * Esta en la memoria RAM preparandose para pasar al repositorio
   
3. Guardado en el repositorio (repository) (rama maste u otra)

## Moviendonos entre los estados

Si hacemos una modificacion a nuestro archivo, al hacer ```git status``` dentro de la carpeta de nuestro repo nos dice que tenemos cambios, pero en este momento solo tenemos los cambios en el **directorio**.

```console
usuario@maquina:~/workspaces/estudios/practicas_git$ git status 
En la rama master
Cambios no rastreados para el commit:
  (usa "git add <archivo>..." para actualizar lo que será confirmado)
  (usa "git restore <archivo>..." para descartar los cambios en el directorio de trabajo)
	modificado:     archivo_practica.txt

sin cambios agregados al commit (usa "git add" y/o "git commit -a")

```

Como nos sugiere el mismo git al hacer ```git status``` debemos ejecutar el comando ```git add``` para pasar los cambiuos del **directorio** a la **puesta en escena (stage)**, podemos usar el comando ```git add nombre_archivo``` para pasar archivo por archivo individualmente o ```git add .``` para pasar todos los archivos que tengan cambios. Y listo cuando volvemos a ejecutar ```git status``` nos aparece el siguiente mensaje con el archivo modificado señalado (en color verde normalmente) indicando que esta listo para pasarse al **repositorio**. 

```console
usuario@maquina:~/workspaces/estudios/practicas_git$ git status 
En la rama master
Cambios a ser confirmados:
  (usa "git restore --staged <archivo>..." para sacar del área de stage)
	modificado:     archivo_practica.txt

```

Si en este punto me he equivocado solo me basta con ejecutar el comando ```git rm --cached nombre_archivo``` si deseo quitar del **stage** algun archivo en especifico o ```git rm --cached *.*``` si quiero sacar todos los cambios que subi al **stage**. Si ejecuto esto tendremos la siguiente respuesta en nuestra consola.

```console
usuario@maquina:~/workspaces/estudios/practicas_git$ git rm --cached *.*
rm 'archivo_practica.txt'
```

Luego si volvemos a hacer un ```git status``` solo volveremos a ver al archivo fuera del **stage** pero con los cambios en el **directorio**

Una cosa adicional es que si cuando el archivo este con cambios detectados en el **directorio** estos cambios tambien los podemos echar a atras con el comando ```git restore archivo_practica.txt``` o ```git restore *.*``` 

Si luego de esto ejecutamos un ```git status``` nos dira que no hemos hecho ningun cambio.

```console
usuario@maquina:~/workspaces/estudios/practicas_git$ git status 
En la rama master
nada para hacer commit, el árbol de trabajo esta limpio
```

Ahora bien volvamos a hacer un cambio en el archivo en nuestro **directorio**, y luego vamos a añadirlo al **stage** con un ```git add .```, para ahora si pasarlo al **repositorio** con el comando ```git commit -m```, el parametro ```-m``` es para añadir un mensaje de cambio al commit. Luego de ejecutar ```git commit -m``` recibimos la siguiente respuesta en consola ya que no tenemos diferencias entre nuestro directorio, puesta en escena y ultima version del repositorio.

```console
usuario@maquina:~/workspaces/estudios/practicas_git$ git status 
En la rama master
nada para hacer commit, el árbol de trabajo esta limpio
```

## Ver cambios y comparaciones








