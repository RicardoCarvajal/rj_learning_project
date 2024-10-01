resource "aws_instance" "rjcarvajal-oregon-tf-test-ec2" {
  ami           = "ami-08d8ac128e0a1b91c"
  instance_type = "t2.micro"
  subnet_id = aws_subnet.rjcarvajal-oregon-tf-test-subnet-public.id
  tags = {
    Name = "rjcarvajal-oregon-tf-test-ec2"
  }
}