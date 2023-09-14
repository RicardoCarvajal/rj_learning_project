# Creando nuestro espacio de trabajo:
  
## 1. Instando lo necesario

Para trabajar con angular debemos asegurarnos de que tenemos [node.js](https://nodejs.org/es) y el gestor de paquete [npm](https://www.npmjs.com/) instalados.

Para asegurarnos de esto podemos ejecutar los comandos  ```npm --version``` y ```node --version``` en nuestra consola linux, estos comandos nos diran la version de estas dos herramientas, si no lo tenemos instalados debemos seguir los pasos para la instalacion en sus paginas oficiales.

Luego para instalar angular ejecutamos el comando ```npm i -g @angular/cli``` para instalarlo con la ayuda del gestor de paquetes npm, y despues procedemos a ver la version de angular con el comando ```ng version```, cabe destacar que si corremos este comando desde la carpeta de un proyecto de angular, se nos dara mucha mas información, ya que nos mostrara las versiones de nuestras dependencias tambien.

Por su puesto tambien debemos tener un editor de texto instalado, de preferencia para esta documentacion trabajaremos con [Visual Studio Code](https://code.visualstudio.com/download) el cual se puede descargar facilmente desde su pagina oficial.


## 2. Preparando ambiente

Antes de empezar nuestro trabajo en angular, debemos instalar algunos plugins en nuestro [vscode](https://code.visualstudio.com/download)

 * [EditorConfig for VS Code](https://marketplace.visualstudio.com/items?itemName=EditorConfig.EditorConfig)
      En los proyectos de angular siempre existe un archivo llamado editorconfig, el cual se usa para la configuracion del trabajo colaborativo en cuanto an cosas como la identación, lo cual ayuda a tener un mejor control de cambio del codigo.
    
 * [Angular Language Service](https://marketplace.visualstudio.com/items?itemName=Angular.ng-template)
      Este es un complemento para mejorar nuestra experiencia de desarrollo de angular, nos ayuda a detectar errores y tener cuidado con nuestra sintaxis


## 3. Creando proyecto y descubriendo su estructura base

Ahora podemos crear nuestro proyecto con el comando ```ng new nombre-proyecto```

Al crear nuestro proyecto nos vamos a dar cuenta de ciertas estructuras, lo primero es que todo el codigo fuente de nuestro proyecto estara en la carpeta ```src``` del proyecto, tambien vemos que tiene la carpeta ```node_modules``` la cual guarda las dependencias descargadas del proyecto por medio de npm.

En la raiz del proyecto tambien tenemos los siguientes archivos:

  * **.editconfig**: contiene la configuracion de identacion a tomar en cuenta en un proyecto colaborativo
  * **tsconfig.json**: contiene la configuracion de nuestro TypeScript (con el cual Angular trabaja por defecto), aca configuramos como va a compilar ts, que version de javaScript vamos a usar, y algunas opciones del compilador de angular como si queremos activar ```strictTemplates``` o no.
  * **angular.json**: en este archivo es donde podremos configurar varios ambientes, como ambientes de pruebas y ambientes de QA o ambientes productivos. Tambien algo muy interezante es que aca podemos configurar los ```budgets``` donde podemos cuidar cuanto pesa nuestra aplicacion para que Angular nos alerte si sobrepasamos el limite indicado.
  * **package.json**: contiene las versiones de las dependencias que estamos usando, de igual forma podemos configurar nuestros scripts de arranque y este tipo de cosas.
  * **.nvmrc**: no viene por defecto, pero se recomienda crearlo, para el manejo de diferentes versiones de node.js, aca solo agregamos la version de node tal cual nos la da el comando ```node --version```, 


## 4. Corriendo proyecto

Para iniciar el proyecto solo ejecutamos el comando ```ng serve```, si quiero que corra en un puerto particular simplemente añadimos al comando el parametro ```--port=numero```, y para abrir el navegador de una sola vez añadimos el parametro ```-o```, quedando de la siguiente manera ```ng serve -o --port=numero```.
