from django.db import models

class Registry(models.Model):
    name = models.CharField(max_length=100)
    age = models.IntegerField()
    email = models.EmailField(null=True)
    address = models.CharField(max_length=300, null=True)

    def __str__(self):
        return f'{self.name} - {self.age} - {self.email} - {self.address}'
