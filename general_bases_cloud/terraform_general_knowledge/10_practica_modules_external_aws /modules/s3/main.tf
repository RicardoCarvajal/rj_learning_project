resource "aws_s3_bucket" "s3-ate" {
  bucket = var.bucket_name
  tags = {
    Name =  "${var.bucket_name}-s3"
  }
}