variable "ami" {
    type = string
    description = "AMI de las instancias"
}

variable "type" {
    type = string
    description = "tipo de las instancias"
}

variable "subnetid" {
    type = string
    description = "ID de las subnets de las instancias"
}

variable "key_name" {
    type = string
    description = "Nombre del key para acceder al la instancia por SSH"
}

variable "sg-ec2" {
  type = list(string)
  description = "Lista de grupos de seguridad"
}

variable "name-sufix" {
    type = string
    description = "Nombre del para sufijo de la instancia"
}