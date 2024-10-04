resource "aws_vpc" "vpc-ate" {
  cidr_block = var.vpc_cidr
  tags = {
    Name = "${local.sufix}-vpc"
  }
}

resource "aws_subnet" "subnet-ate-public" {
  vpc_id     = aws_vpc.vpc-ate.id
  cidr_block = var.subnet_cidrs[0]
  availability_zone = "us-west-2a"
  tags = {
    Name = "${local.sufix}-subnet-public"
  }
  map_public_ip_on_launch = true
}

resource "aws_subnet" "subnet-ate-private" {
  vpc_id     = aws_vpc.vpc-ate.id
  cidr_block = var.subnet_cidrs[1]
  tags = {
    Name = "${local.sufix}-subnet-private"
  }
}

resource "aws_internet_gateway" "igw-ate" {
  vpc_id = aws_vpc.vpc-ate.id
  tags = {
    Name = "${local.sufix}-igw"
  }
}

resource "aws_route_table" "route-ate" {
  vpc_id = aws_vpc.vpc-ate.id
  route {
    cidr_block = "0.0.0.0/0"
    gateway_id = aws_internet_gateway.igw-ate.id
  }

  tags = {
    Name = "${local.sufix}-route"
  }
}

resource "aws_route_table_association" "assoc-public-ate" {
  subnet_id      = aws_subnet.subnet-ate-public.id
  route_table_id = aws_route_table.route-ate.id
}


resource "aws_security_group" "sg-ate" {
  name   = "${local.sufix}-sg"
  vpc_id = aws_vpc.vpc-ate.id

  dynamic "ingress" {
    for_each = var.sg_ingress_ports
    content {
      from_port   = ingress.value
      to_port     = ingress.value
      protocol    = "tcp"
      cidr_blocks = [var.sg_ingress_cidr]          
    }
  }
  
  egress {
    from_port        = 0
    to_port          = 0
    protocol         = "-1"
    cidr_blocks      = ["0.0.0.0/0"]
    ipv6_cidr_blocks = ["::/0"]
  }
  
  tags = {
    Name = "${local.sufix}-sg"
  }
}
