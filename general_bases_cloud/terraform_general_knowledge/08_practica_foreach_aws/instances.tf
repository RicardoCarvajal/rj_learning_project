variable "instances" {
  description = "Nombres de las intancias"
  type = list(string)
  default = ["apache","mysql","jumpsever"]  
}

resource "aws_instance" "rjcarvajal-oregon-tf-test-ec2" {
  for_each =  toset(var.instances)
  ami             = "ami-08d8ac128e0a1b91c"
  instance_type   = "t2.micro"
  subnet_id       = aws_subnet.rjcarvajal-oregon-tf-test-subnet-public.id
  key_name        = data.aws_key_pair.key-pair.key_name
  vpc_security_group_ids = [aws_security_group.rjcarvajal-oregon-tf-test-sg.id]
  tags = {
    Name = each.value
  }
}

resource "aws_instance" "rjcarvajal-oregon-tf-test-ec2-mon" {
  count = var.enable_monitoring ? 1:0
  ami             = "ami-08d8ac128e0a1b91c"
  instance_type   = "t2.micro"
  subnet_id       = aws_subnet.rjcarvajal-oregon-tf-test-subnet-public.id
  key_name        = data.aws_key_pair.key-pair.key_name
  vpc_security_group_ids = [aws_security_group.rjcarvajal-oregon-tf-test-sg.id]
  tags = {
    Name = "rjcarvajal-oregon-tf-test-ec2-mon"
  }
}