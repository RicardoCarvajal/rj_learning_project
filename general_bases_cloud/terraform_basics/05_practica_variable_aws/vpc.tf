resource "aws_vpc" "rjcarvajal-oregon-tf-test-vpc-1" {
  cidr_block = var.vpc_oregon_cdir
  tags = {
    env  = "devate"
    Name = "rjcarvajal-oregon-tf-test-vpc-1"
  }
}

resource "aws_vpc" "rjcarvajal-oregon-tf-test-vpc-2" {
  cidr_block = var.vpc_cdir[2]
  tags = {
    env  = "devate"
    Name = "rjcarvajal-oregon-tf-test-vpc-2"
  }
}

resource "aws_vpc" "rjcarvajal-virginia-tf-test-vpc" {
  cidr_block = var.vpc_virginia_cdir
  tags = {
    env  = "devate"
    Name = "rjcarvajal-virginia-tf-test-vpc"
  }
  provider = aws.virginia
}

