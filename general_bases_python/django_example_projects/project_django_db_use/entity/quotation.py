from django.db import models

class Quotation(models.Model):
    quote_id = models.CharField(max_length=10, primary_key=True)
    customer_id = models.CharField(max_length=255, null=True, blank=True)
    branch_office_id = models.IntegerField(null=True, blank=True)
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
        return f'{self.quote_id}, {self.customer_id}, {self.branch_office_id}, {self.quote_origin}, {self.createdby}, {self.updatedby}, {self.createdat}, {self.updatedat}'