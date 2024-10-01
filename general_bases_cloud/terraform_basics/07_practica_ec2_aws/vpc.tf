resource "aws_vpc" "rjcarvajal-oregon-tf-test-vpc" {
  cidr_block = var.vpc_cidr
  tags = {
    Name = "rjcarvajal-oregon-tf-test-vpc-1"
  }
}

resource "aws_subnet" "rjcarvajal-oregon-tf-test-subnet-public" {
  vpc_id = aws_vpc.rjcarvajal-oregon-tf-test-vpc.id
  cidr_block = var.subnet_cidrs[0]
  tags = {
    Name = "rjcarvajal-oregon-tf-test-subnet-public"
  }
  map_public_ip_on_launch = true
}

resource "aws_subnet" "rjcarvajal-oregon-tf-test-subnet-private" {
  vpc_id = aws_vpc.rjcarvajal-oregon-tf-test-vpc.id
  cidr_block = var.subnet_cidrs[1]
  tags = {
    Name = "rjcarvajal-oregon-tf-test-subnet-private"
  }
}


