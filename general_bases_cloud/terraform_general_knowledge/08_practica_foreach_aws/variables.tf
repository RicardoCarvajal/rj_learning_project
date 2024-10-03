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
  type = bool
  description = "Activacion de instancia de monitoreo"  
}