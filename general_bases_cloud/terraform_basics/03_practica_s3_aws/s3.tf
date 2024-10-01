resource "aws_s3_bucket" "test-rcarvajal-s3-tf" {
  bucket = "test-rcarvajal-s3-tf"

  tags = {
    Name        = "test-rcarvajal-s3-tf"
    Environment = "devate"
  }
}