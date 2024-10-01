resource "aws_vpc" "rjcarvajal-oregon-tf-test-vpc" {
  cidr_block = var.vpc_cidr
  tags = {
    Name = "rjcarvajal-oregon-tf-test-vpc-1"
  }
}

resource "aws_subnet" "rjcarvajal-oregon-tf-test-subnet-public" {
  vpc_id     = aws_vpc.rjcarvajal-oregon-tf-test-vpc.id
  cidr_block = var.subnet_cidrs[0]
  tags = {
    Name = "rjcarvajal-oregon-tf-test-subnet-public"
  }
  map_public_ip_on_launch = true
}

resource "aws_subnet" "rjcarvajal-oregon-tf-test-subnet-private" {
  vpc_id     = aws_vpc.rjcarvajal-oregon-tf-test-vpc.id
  cidr_block = var.subnet_cidrs[1]
  tags = {
    Name = "rjcarvajal-oregon-tf-test-subnet-private"
  }
}

resource "aws_internet_gateway" "rjcarvajal-oregon-tf-test-igw" {
  vpc_id = aws_vpc.rjcarvajal-oregon-tf-test-vpc.id
  tags = {
    Name = "rjcarvajal-oregon-tf-test-igw"
  }
}

resource "aws_route_table" "rjcarvajal-oregon-tf-test-route" {
  vpc_id = aws_vpc.rjcarvajal-oregon-tf-test-vpc.id
  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.rjcarvajal-oregon-tf-test-igw.id
  }

  tags = {
    Name = "rjcarvajal-oregon-tf-test-route"
  }
}

resource "aws_route_table_association" "rjcarvajal-oregon-tf-test-assoc-public" {
  subnet_id      = aws_subnet.rjcarvajal-oregon-tf-test-subnet-public.id
  route_table_id = aws_route_table.rjcarvajal-oregon-tf-test-route.id
}


resource "aws_security_group" "rjcarvajal-oregon-tf-test-sg" {
  name   = "rjcarvajal-oregon-tf-test-sg"
  vpc_id = aws_vpc.rjcarvajal-oregon-tf-test-vpc.id
  ingress = {
    description = "SSH ingress rule"
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
  egress {
    from_port        = 0
    to_port          = 0
    protocol         = "-1"
    cidr_blocks      = ["0.0.0.0/0"]
    ipv6_cidr_blocks = ["::/0"]
  }
  tags = {
    Name = "rjcarvajal-oregon-tf-test-sg"
  }
}
