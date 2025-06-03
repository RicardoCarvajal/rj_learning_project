# Proyecto de Infraestructura y Replicación de Datos en AWS

Este proyecto define una infraestructura en AWS utilizando AWS Serverless Application Model (SAM) y configura la replicación de datos desde una base de datos SQL Server hacia un bucket S3, procesando los datos mediante una función AWS Lambda.

## Estructura del Proyecto

El proyecto está organizado en varios stacks de AWS CloudFormation anidados, lo que permite modularizar la infraestructura:

* `template.yml` (Stack Principal)
* `vpc.yml` (Stack Hijo: Configuración de Red)
* `rds_postgre_sql.yml` (Stack Hijo: Configuración de RDS PostgreSQL)
* `rds_sql_server.yml` (Stack Hijo: Configuración de RDS SQL Server)
* `dms_resources.yml` (Stack Hijo: Recursos de AWS DMS y Lambda)
* `app.py` (Código de la función Lambda)

## Componentes de la Infraestructura

### 1. Stack Principal (`template.yml`)

Este es el stack principal que orquesta la implementación de los stacks hijos. Define parámetros globales para el entorno de implementación, el país y el proveedor.

**Parámetros:**

* `Environment`: Ambiente de implementación (e.g., `dev`, `qa`, `preprod`, `prod`).
* `Country`: País de implementación (e.g., `cr`, `gt`, `sv`, `ve`).
* `Supplier`: Proveedor de implementación (e.g., `bopos`, `stellar`).
* `DBUsername`: Nombre de usuario para las bases de datos.
* `DBPassword`: Contraseña para las bases de datos.
* `BucketDMSName`: Nombre del bucket S3 para DMS.

**Stacks Hijos Anidados:**

* `vpcstack`: Encargado de la configuración de red.
* `rdsstackpostgresql`: Configura una instancia RDS PostgreSQL.
* `rdsstacksqlserver`: Configura una instancia RDS SQL Server.
* `dmsresourcesstack`: Gestiona los recursos de AWS DMS y la función Lambda asociada.

### 2. Configuración de Red (`vpc.yml`)

Este stack define la infraestructura de red necesaria, incluyendo una VPC, subredes, tablas de ruteo, grupos de seguridad e Internet Gateway.

**Recursos Principales:**

* **VPC (`vpcRds`):** Una VPC con un bloque CIDR `10.23.0.0/16` y soporte para DNS.
* **Subredes (`subnetVpcRdsOne`, `subnetVpcRdsTwo`, `subnetVpcRdsThree`):** Tres subredes en diferentes zonas de disponibilidad (`us-west-2a`, `us-west-2b`, `us-west-2c`) con bloques CIDR `/24` dentro de la VPC.
* **Tabla de Ruteo (`routeTableVpcRds`):** Asociada a las subredes.
* **Grupo de Seguridad (`instanceSecurityGroup`):** Permite el tráfico TCP en los puertos 5432 y 1433 desde cualquier IP (`0.0.0.0/0`).
* **Internet Gateway (`internetGateway`):** Permite la comunicación entre la VPC y el internet.

### 3. Configuración de RDS PostgreSQL (`rds_postgre_sql.yml`)

Este stack configura una instancia de base de datos PostgreSQL en Amazon RDS.

**Recursos Principales:**

* **Grupo de Sub