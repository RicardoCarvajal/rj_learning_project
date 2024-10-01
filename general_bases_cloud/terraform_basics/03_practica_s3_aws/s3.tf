resource "aws_s3_bucket" "test-rcarvajal-s3-tf" {
  bucket = "test-rcarvajal-s3-tf-${random_string.sufijo.id}"
  tags = {
    Environment = "devate"
  }
}