variable "vpc_cidr" {
    type = string
    description = "Bloque de red de la VPC"  
}

variable "name_sufix" {
    type = string
    description = "Sufijo de nombres"  
}

variable "subnet_cidrs_public" {
  type = string
  description = "Bloque de red de subnet publica"
}

variable "subnet_cidrs_private" {
  type = string
  description = "Bloque de red de subnet privada"
}

variable "sg_ingress_ports" {
  type = list(number)
  description = "Puertos de las reglas de ingreso"  
}

variable "sg_ingress_cidr" {
  type = string
  description = "IP de reglas de ingreso"  
}