resource "local_file" "products" {
  count = 5
  content = "Lista de productos"
  filename = "productos-${random_string.sufijo[count.index].id}.txt"
}