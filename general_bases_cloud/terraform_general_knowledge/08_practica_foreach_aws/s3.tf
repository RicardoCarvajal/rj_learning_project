resource "aws_s3_bucket" "s3-ate" {
  bucket = "my-tf-test-bucket"

  tags = {
    Name =  "${local.sufix}-s3"
  }
}