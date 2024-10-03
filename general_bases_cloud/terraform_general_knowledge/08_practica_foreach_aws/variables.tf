variable "vpc_cidr" {
  type        = string
  description = "CIDR de la vpc"
}

variable "subnet_cidrs" {
  type        = list(string)
  description = "lista de CIDR para las subnets"
}


variable "commons_tags" {
  type        = map(string)
  description = "Mapa de tags comunes para los recursos"
}

variable "enable_monitoring" {
  type        = bool
  description = "Activacion de instancia de monitoreo"
}

variable "instance_features" {
  type = map(string)
  description = "Caracteristicas de la instancia"  
}

variable "sg_ingress_cidr" {
  type = string
  description = "IP de reglas de ingreso"  
}

variable "sg_ingress_ports" {
  type = list(number)
  description = "Puertos de las reglas de ingreso"  
}