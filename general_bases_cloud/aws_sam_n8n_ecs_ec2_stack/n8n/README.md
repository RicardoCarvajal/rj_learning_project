<img src="https://git.intelix.biz/epa1/aplicaciones/ate/ate-int-stellar-sap/-/wikis/img/logointelix-removebg-preview.png" width="50%"><img src="https://git.intelix.biz/epa1/aplicaciones/ate/ate-int-stellar-sap/-/wikis/img/ate_epa-removebg-preview.png" width="50%">

![Static Badge](https://img.shields.io/badge/company-EPA-yellow)
![Static Badge](https://img.shields.io/badge/version-1.0.0-blue)

# Integration Stellar-SAP

Interfaz de integración de Stellar con SAP

## Acerca del proyecto

En la actualidad, Ferreterías EPA se encuentra en proceso de actualizar su sistema ERP a S/4HANA. Esta actualización requiere cambios significativos en la integración entre el sistema de puntos de venta (Stellar) y EPA. Es necesario modificar los microservicios o interfaces de integración actuales que gestionan el envío y recepción de datos para el funcionamiento del sistema de cajas de EPA.

Intelix será responsable de desarrollar los cambios necesarios en las interfaces de integración del lado de EPA. Esto incluye la adaptación de los microservicios actuales.

## Estructura de la aplicación IaC.

Proyecto desarrollado en AWS con IaC configurada con SAM CloudFormation

        .
        ├── conf
        │   └── settings.xml        
        ├── events
        │   └── event<msname>.json
        ├── infraestructure
        │   ├── <msname>
        │   │   └── template.yaml
        │   └── <msname>
        │       └── template.yaml
        ├── README.md
        ├── samconfig.toml
        ├── source
        │   ├── <msname>
        │   │   ├── Makefile
        │   │   ├── mvnw
        │   │   ├── mvnw.cmd
        │   │   ├── pom.xml
        │   │   └── src
        │   ├── ut<name>
        │   │   ├── pom.xml
        │   │   └── src
        │   │
        │   └── <msname>
        │       ├── Makefile
        │       ├── mvnw
        │       ├── mvnw.cmd
        │       ├── pom.xml
        │       └── src
        │
        ├── template.yaml
        └── .gitignore


### **Glosario de estructura**

**conf:** contiene el archivo de configuracion de maven el cual debemos colocar en la carpeta .m2 o en la configuracion de nuestro IDE

**infrastructure:** Contiene los templates de IaC de los recursos definidos tanto para la configuración global como para cada microservicio por individual de la aplicación. Se encuentra dividido en dos contenedores principales:

- **ms<name>** Un microservicio en especifico, con un solo template para sus recursos, ejemplo:

        └── msauth
            └── template.yml

**source/ms<name>:** Contiene el código para las lambdas, esto se divide en directorios por servicios `ms<name>`. y posee:

- **Makefile:** Importante archivo para el compilado de los jar usando SAM

- **mvnw:** Archivo de configuracion para la compilacion de maven

- **pom.xml:** Archivo que maneja las dependencias de maven

- **/src:** Directorio que contiene el codigo fuente

**source/ut<name>:** Contiene el código para librerias comunes, esto se divide en directorios por utils `ut<name>`. y posee:

- **pom.xml:** Archivo que maneja las dependencias de maven

- **/src:** Directorio que contiene el codigo fuente

**.gitignore:** Es un archivo de texto que le dice a Git qué archivos o carpetas ignorar en un proyecto. En este caso, es importante ignorar ".aws-sam/".

**template.yaml:** Es el archivo principal del proyecto cual contiene la definición y localización de los recursos globales y microservicios del proyecto.

**samconfig.toml:** Contiene la configuracion general y de despliegue en AWS del stack.

Es importante tomar en cuenta algunas consideraciones al añadir nuevos microservicios o funcionalidades al proyecto.

## Estandarización

### Git Workflow

Basandose en el flujo de trabajo de Git Flow, las integraciones durante el ciclo de desarrollo tendrán una estructura similar a la siguiente:

![image](https://git.intelix.biz/epa1/aplicaciones/ate/ate-int-stellar-sap/-/wikis/img/gitflow.png)

Pasamos a detallar las ramas mencionadas:

- **master:** Contiene el código de producción. Todo el código de desarrollo es mergeado en esta rama luego de que su funcionamiento haya sido validado a través de la rama de QA.
- **fix-:** Rama encargada de corregir una incidencia crítica en producción. Crear rama bajo la siguiente estructura `fix-<nueva_feature>` en ingles.
- **qa (releases):** Rama encargada de generar valor al producto o proyecto. Contiene el código de develop que se desplegará hacia la rama master una vez hayan sido testeadas las features integradas.
- **dev:** Contiene código de pre-producción. Cuando un desarrollador finaliza su feature, lo mergea contra esta rama.
- **feat-:** Por cada tarea que se realiza, se crea una nueva rama para trabajar en ella. Esta rama parte de develop. Crear rama bajo la siguiente estructura  `feat-<nueva_feature>` en ingles.

#### Plantilla de commits

Con el fin de estandarizar el formato de los commit, es necesario utilizar la siguiente plantilla basada en [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) y [Angular Convention](https://github.com/angular/angular/blob/22b96b9/CONTRIBUTING.md#-commit-message-guidelines)

    type(docs): correcting API tables

* build: Changes that affect the build system or external dependencies (example scopes: gulp, broccoli, npm)
* ci: Changes to our CI configuration files and scripts (examples: CircleCi, SauceLabs)
* docs: Documentation only changes
* feat: A new feature
* fix: A bug fix
* perf: A code change that improves performance
* refactor: A code change that neither fixes a bug nor adds a feature
* test: Adding missing tests or correcting existing tests
* remove: Used for removing a feature or something from the project like a file, asset, and so on...

Para configurar como plantilla para los commit en el git, se ejecuta el siguiente comando:

    git config commit.template ./doc/git/commit-template.txt

##### Consideraciones

- Realizar `git pull origin` antes de hacer cualquier merge
- En la descripción de cada commit debemos ser específicos 

#### Pasos para realizar una nueva feature

1. Partir desde la rama develop. Para ello nos ubicamos en la rama develop.
   
        git checkout develop

2. Actualizar al último commit de la rama, para trabajar bajo la última versión del código.

        git pull

3. Abrir la nueva rama del feature.
   
        git checkout -b feature/<nueva_feature>

4. Luego de finalizar la nueva feature, guardar el stage de los cambios.

        git add .

5. Realizar el commit bajo la plantilla estandarizada.

        git commit

    NOTA: Para cerrar la ventana de commit: ***Ctrl+X -> Ctrl+C -> :x***

6. Subir los cambios al repositorio remoto.

        git push

    Si es el primer commit de la rama:

        git push --set-upstream origin feature/<nueva_feature>

### Nomenclatura de recursos en microservicios

Para el desarrollo de microservicios, se planteo una nomenclatura que seguir para los funciones lambdas y servicios internos:

**Recursos (para la mayoría de los casos hay excepciones en algunos casos)**

    b) <ParentStackName>-<servicio_aws>-<nombre_recurso>

### Nomenclatura de parametros

    c) /<environment>/ate/<pais>/bopos/<tipo_parametro>/<nombre_recurso>

### Nomenclatura de secrets

    d) ate/<environment>/<pais>/bopos/<tipo_parametro>/<nombre_recurso>

Tomando en cuenta en la nomenclatura:

**Paises:**

- gt: Guatemala.
- sv: El Salvador.
- ve: Venezuela.

**Environments:**

- prod: Ambiente de Producción.
- qa: Ambiente de pruebas.
- dev: Ambiente de desarrollo.

**nombre_recurso** nombre del recurso.

**tipo_parametro** Si es una secreto `secrete` si es un parametro `parameter`

## Configuración y Despliegue

Esta sección contempla los requisitos y configuraciones iniciales para llevar a cabo el despliegue del proyecto con AWS SAM.

### Prerrequisitos

Para poder realizar pruebas y despliegues con SAM, es necesario cumplir con los siguientes requisitos:

1. Poseer una cuenta AWS con acceso al ambiente del proyecto.
2. Tener un usuario IAM con sus respectivas credenciales de acceso:
   
        - Access Key ID
        - Secret Access Key

3. Instalar AWS CLI: [Descargar AWS CLI](https://docs.aws.amazon.com/es_es/cli/latest/userguide/getting-started-install.html)

4. Configurar las credenciales de acceso con el comando "aws configure". Por ejemplo:

        aws configure
        AWS Access Key ID [None]: AKIAIOSFODNN7EXAMPLE
        AWS Secret Access Key [None]: wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY
        Default region name [None]: us-east-2
        Default output format [None]: json

    Para más detalle: [Prerequisitos para AWS SAM CLI](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/prerequisites.html)


5. Instalar SAM: [Descargar AWS SAM CLI](https://docs.aws.amazon.com/serverless-application-model/latest/developerguide/install-sam-cli.html)

### Extensiones para VSC (Opcional)

En VSC, es ventajoso utilizar algunas de las siguientes extensiones permite tener un codigo mas legible y facilita el uso de los recursos de AWS.

Principales:

- Name: **AWS Toolkit**
  Id: amazonwebservices.aws-toolkit-vscode
  Description: Amazon Web Services toolkit for browsing and updating cloud resources.
  Publisher: Amazon Web Services
  VS Marketplace Link: [Descargar](https://marketplace.visualstudio.com/items?itemName=AmazonWebServices.aws-toolkit-vscode)

Opcionales:

- Name: **Prettier - Code formatter**
  Id: esbenp.prettier-vscode
  Description: Code formatter using prettier.
  Publisher: Prettier
  VS Marketplace Link: [Descargar](https://marketplace.visualstudio.com/items?itemName=esbenp.prettier-vscode)

- Name: **cloudformation-yaml-validator**
  Id: champgm.cloudformation-yaml-validator
  Description: A reference validator for AWS CloudFormation YAML files.
  Publisher: champgm
  VS Marketplace Link: [Descargar](https://marketplace.visualstudio.com/items?itemName=champgm.cloudformation-yaml-validator)

- Name: **CloudFormation Snippets**
  Id: dannysteenman.cloudformation-yaml-snippets
  Description: This extension adds snippets for all the AWS CloudFormation resources into Visual Studio Code.
  Publisher: Danny Steenman
  VS Marketplace Link: [Descargar](https://marketplace.visualstudio.com/items?itemName=dannysteenman.cloudformation-yaml-snippets)


- Name: **Serverless Console**
  Id: devadvice.serverlessconsole
  Description: Serverless Console is an alternative UI for AWS CloudWatch and DynamoDB, focused on "serverless development".
  Editor: devAdvice
  Vínculo de VS Marketplace: [Descargar](https://marketplace.visualstudio.com/items?itemName=devAdvice.serverlessconsole)

- Name: **Serverless IDE**
  Id: ThreadHeap.serverless-ide-vscode
  Description: Enhanced support for AWS SAM, CloudFormation and Serverless Framework.
  Publisher: ThreadHeap
  VS Marketplace Link: [Descargar](https://marketplace.visualstudio.com/items?itemName=ThreadHeap.serverless-ide-vscode)

### Ejecución

Para realizar un despliegue de la aplicación, según el stage, se ejecutan los siguientes comandos:

    sam build --config-env <stage>
    sam deploy --config-env <stage>

Si es un stage de desarrollo:

    sam build --config-env devate-<pais>
    sam deploy --config-env devate-<pais>

#### Build SAM Application

El comando **sam build** prepara la aplicación para los pasos posteriores del flujo de trabajo del desarrollador, como pruebas locales o implementación en la nube de AWS. Con este comando se valida que todas las modificaciones estan realizadas de manera correcta para su ejecución y prueba.

    sam build <arguments> <options>


#### Deploy SAM Application

El comando **sam deploy** implementa la aplicación mediante AWS CloudFormation.

    <environment variables> sam deploy <options>

Para realizar un despliegue guiado:

    sam deploy --guided

Sin embargo, siempre es mejor preparar las variables y resto de configuración en el archivo **samconfig.toml**.

### Resolución de problemas.

Cualquier problema o error relacionado con el despliegue del stack se verá reflejado en la terminal durante su ejecución y se realizará automáticamente un rollback a la version previa estable del mismo.


