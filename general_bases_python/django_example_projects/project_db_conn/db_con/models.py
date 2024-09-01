from django.db import models

class Usuarios(models.Model):
    nombre = models.CharField(max_length=30, blank=True, null=True)
    clave = models.CharField(max_length=10, blank=True, null=True)

    class Meta:
        managed = False
        db_table = 'usuarios'


