resource "aws_instance" "rjcarvajal-oregon-tf-test-ec2" {
  ami             = "ami-08d8ac128e0a1b91c"
  instance_type   = "t2.micro"
  subnet_id       = aws_subnet.rjcarvajal-oregon-tf-test-subnet-public.id
  key_name        = data.aws_key_pair.key-pair.key_name
  security_groups = [aws_security_group.rjcarvajal-oregon-tf-test-sg.id]
  tags = {
    Name = "rjcarvajal-oregon-tf-test-ec2"
  }

  provisioner "local-exec" {
    command = "echo intancia creada con IP ${aws_instance.rjcarvajal-oregon-tf-test-ec2.public_ip} >> datos.txt"
  }

  provisioner "local-exec" {
    when    = destroy
    command = "echo intancia destruida con IP ${self.public_ip} >> datos.txt"
  }

}