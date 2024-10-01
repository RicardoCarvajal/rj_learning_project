resource "aws_vpc" "rjcarvajal-oregon-tf-test-vpc" {
  cidr_block = var.vpc_oregon_cdir
  tags = {
    env = "devate"
  }
}

resource "aws_vpc" "rjcarvajal-virginia-tf-test-vpc" {
  cidr_block = var.vpc_virginia_cdir
  tags = {
    env = "devate"
  }
  provider = aws.virginia
}