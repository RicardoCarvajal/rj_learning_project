/*
En esta practica numero 3 ya se utiliza el 
provaider de AWS para crear un recurso de
Amazon (Bucket de S3) con un nombre aleatorio
utilizando el provider random de HashiCorp
*/
resource "aws_s3_bucket" "test-rcarvajal-s3-tf" {
  bucket = "test-rcarvajal-s3-tf-${random_string.sufijo.id}"
  tags = {
    Environment = "devate"
  }
}