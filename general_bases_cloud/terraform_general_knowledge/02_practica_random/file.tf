/*
En esta practica se demuestra 
que se puede trabajar con recursos
en archivos apartes y Terraform 
maneja las dependencias implicitas.

Adicionalmente se hace uso de otro
provaider, llamado random, para
generar un sufijo aleatorio
para cada archivo.
*/
resource "local_file" "products" {
  count = 5
  content = "Lista de productos"
  filename = "productos-${random_string.sufijo[count.index].id}.txt"
}