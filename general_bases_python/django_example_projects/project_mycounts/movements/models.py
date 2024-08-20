from django.db import models
from items.models import Item

class Movement(models.Model):
    local_amount = models.DecimalField(max_digits=10, decimal_places=2)
    foreign_exchange = models.DecimalField(max_digits=10, decimal_places=2, null=True)    
    date = models.DateTimeField(auto_created=True)
    items = models.ForeignKey(Item,on_delete=models.PROTECT)

    def __str__(self):
        return self.amount    