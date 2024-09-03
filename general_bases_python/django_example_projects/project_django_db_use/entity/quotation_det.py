from django.db import models
from .quotation import Quotation
from .articulos import Articulo

class QuotationDet(models.Model):
    id = models.AutoField(primary_key=True)
    quote_id = models.ForeignKey(Quotation, on_delete=models.CASCADE,db_column='quote_id')
    product_code = models.ForeignKey(Articulo, on_delete=models.SET_NULL, null=True, blank=True,db_column='product_code')
    quantity = models.DecimalField(max_digits=10, decimal_places=2, null=True, blank=True)
    product_price = models.DecimalField(max_digits=10, decimal_places=2, null=True, blank=True)
    percentage_tax = models.IntegerField(null=True, blank=True)
    discount_unit_ammount = models.DecimalField(max_digits=10, decimal_places=2, null=True, blank=True)
    createdby = models.IntegerField(null=True, blank=True)
    updatedby = models.IntegerField(null=True, blank=True)
    createdat = models.DateTimeField(auto_now_add=True)
    updatedat = models.DateTimeField(auto_now=True)

    class Meta:
        managed = False
        db_table  = '"global"."quotation_det"'
        unique_together = (('quote_id', 'product_code'),)        
        app_label = 'ate'        

    def __str__(self):
        return f"{self.quote_id} - {self.product_code}"