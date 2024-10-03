vpc_cidr     = "10.23.0.0/16"
subnet_cidrs = ["10.23.0.0/24", "10.23.10.0/24"]
commons_tags = {
  "env"     = "devate"
  "country" = "ve"
  "int"     = "stellar"
}
enable_monitoring = false

instance_features = {
  "type" = "t2.micro"
  "ami" = "ami-08d8ac128e0a1b91c"
}