vpc_cidr     = "10.23.0.0/16"
subnet_cidrs = ["10.23.0.0/24", "10.23.10.0/24"]
commons_tags = {
  "env"     = "dev"
  "country" = "ve"
  "int"     = "stellar"
}
enable_monitoring = false