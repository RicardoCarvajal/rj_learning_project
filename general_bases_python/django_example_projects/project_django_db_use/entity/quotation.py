from django.db import models
from .tiendas import Tienda

class Quotation(models.Model):
    quote_id = models.CharField(max_length=10, primary_key=True)
    customer_id = models.CharField(max_length=255, null=True, blank=True)
    branch_office_id = models.ForeignKey(Tienda, on_delete=models.SET_NULL, null=True, blank=True, db_column='branch_office_id')
    quote_origin = models.CharField(max_length=3, null=True, blank=True)
    createdby = models.IntegerField(null=True, blank=True)
    updatedby = models.IntegerField(null=True, blank=True)
    createdat = models.DateTimeField(auto_now_add=True)
    updatedat = models.DateTimeField(auto_now=True)

    class Meta:
        managed = False
        db_table  = '"global"."quotation"'
        app_label = 'ate'

    def __str__(self):
        return self.quote_id
  
