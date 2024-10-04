/*
Iniciando un primer uso de Terraform
usando el provaider local_file
los cuales son proveedores de HashiCorp
*/
resource "local_file" "products" {
  content = "Lista de productos"
  filename = "productos.txt"
}