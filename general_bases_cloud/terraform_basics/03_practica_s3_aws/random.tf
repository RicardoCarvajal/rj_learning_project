resource "random_string" "sufijo" {
  length  = 8
  special = false
  upper   = false
  numeric = false
}