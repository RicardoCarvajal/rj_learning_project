from django.db import models

class Movement(models.Model):
    local_amount = models.DecimalField(max_digits=10, decimal_places=2)
    foreign_exchange = models.DecimalField(max_digits=10, decimal_places=2, null=True)    
    date = models.DateTimeField(auto_now_add=True)
    items = models.TextField(max_length=200)

    def __str__(self):
        return self.items    