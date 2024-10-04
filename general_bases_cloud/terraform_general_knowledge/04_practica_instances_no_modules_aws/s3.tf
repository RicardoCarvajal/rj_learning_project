resource "aws_s3_bucket" "s3-ate" {
  bucket = local.sufix-s3

  tags = {
    Name =  "${local.sufix-s3}-s3"
  }
}