variable "instances" {
  description = "Nombres de las intancias"
  type        = list(string)
  default     = ["apache"]
}

resource "aws_instance" "ec2-primary" {
  for_each               = toset(var.instances)
  ami                    = var.ami
  instance_type          = var.type
  subnet_id              = var.subnetid
  key_name               = var.key_name
  vpc_security_group_ids = var.sg-ec2  
  availability_zone = "us-west-2a"
  user_data = file("script/userdata.sh")
  tags = {
    Name = "${var.name-sufix}-ec2-${each.value}"
  }
}