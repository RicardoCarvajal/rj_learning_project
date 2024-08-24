from django.db import models
from django.contrib.auth.models import User

class Movement(models.Model):
    local_amount = models.DecimalField(max_digits=10, decimal_places=2)
    foreign_exchange = models.DecimalField(max_digits=10, decimal_places=2, null=True)    
    date = models.DateTimeField(auto_now_add=True)
    items = models.TextField(max_length=200)
    user = models.ForeignKey(User,on_delete=models.CASCADE, null=True)

    def __str__(self):
        return self.items    