from django.db import models

class Registry(models.Model):
    name = models.CharField(max_length=100)
    age = models.IntegerField()
    email = models.EmailField(null=True)
    address = models.CharField(max_length=300, null=True)

    def __str__(self):
        return f'{self.name} - {self.age} - {self.email} - {self.address}'

class MedicalInfo(models.Model):
    weight = models.DecimalField(max_digits=5, decimal_places=2)
    height = models.DecimalField(max_digits=5,decimal_places=2)
    blod = models.CharField(max_length=3)
    observation = models.TextField(null=True)
    registry = models.OneToOneField(Registry, on_delete=models.PROTECT)

    def __str__(self):
        return f'{self.weight} - {self.height} - {self.blod} - {self.observation}'

class PaymentMethod(models.Model):
    name = models.CharField(max_length=100)
    type = models.CharField(max_length=100)

    def __str__(self):
        return f'{self.name} - {self.type}'

class Pay(models.Model):
    amount = models.DecimalField(max_digits=10, decimal_places=2)
    paydate = models.DateField()
    registry = models.ForeignKey(Registry,on_delete=models.PROTECT)
    paymentMethod = models.ManyToManyField(PaymentMethod)

    def __str__(self):
        return f'{self.amount} - {self.paydate} - {self.registry} - {self.paymentMethod}'