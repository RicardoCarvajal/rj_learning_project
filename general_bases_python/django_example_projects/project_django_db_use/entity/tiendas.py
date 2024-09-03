from django.db import models


class Tienda(models.Model):
    ad_org_id = models.BigIntegerField(primary_key=True)
    isactive = models.CharField(max_length=255)
    duns = models.CharField(max_length=4)
    name = models.CharField(max_length=50)
    description = models.CharField(max_length=50, null=True, blank=True)
    xx_si_codigotipo = models.CharField(max_length=3)
    updatedat = models.DateTimeField(auto_now=True)
    createdat = models.DateTimeField(auto_now_add=True)
    country_code = models.CharField(max_length=2, null=True, blank=True)
    isbase = models.BooleanField(default=False)

    class Meta:
        managed = False
        db_table  = '"global"."tiendas"'
        app_label = 'ate'

    def __str__(self):
        return self.name