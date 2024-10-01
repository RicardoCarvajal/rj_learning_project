resource "aws_vpc" "oregon" {
  cidr_block = "10.23.0.0/16"
  provider = aws.virginia
  tags = {
    env = "devate"
  }
}

resource "aws_vpc" "virginia" {
  cidr_block = "10.23.0.0/16"
  tags = {
    env = "devate"
  }
}