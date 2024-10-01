variable "vpc_oregon_cdir" {
  type        = string
  sensitive   = false
  description = "CIDR de oregon"
}

variable "vpc_virginia_cdir" {
  type        = string
  sensitive   = true
  description = "CIDR de virginia"
}

variable "vpc_cdir" {
  type        = list(string)
  sensitive   = false
  description = "lista de CIDR"
}