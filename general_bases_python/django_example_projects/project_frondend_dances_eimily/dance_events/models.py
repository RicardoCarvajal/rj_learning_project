from django.db import models

class DanceEnvents(models.Model):
    name = models.CharField(max_length=100, verbose_name='nombre')
    date = models.DateTimeField(blank=True, null=True, verbose_name='fecha')
    description = models.TextField(max_length=200, verbose_name='descripcion')
    location = models.CharField(max_length=100, verbose_name='ubicacion')
    image = models.ImageField(upload_to="img", blank=True, null=True, verbose_name='imagen')

    def __str__(self):
        return f'Nombre: {self.name} - Descripcion {self.description}'
