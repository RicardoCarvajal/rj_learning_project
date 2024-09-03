from django.db import models


class Articulo(models.Model):
    m_product_id = models.BigAutoField(primary_key=True)
    m_product_category_id = models.IntegerField()
    xx_co_secciones_id = models.IntegerField()
    c_uom_id = models.IntegerField()
    isactive = models.CharField(max_length=255, null=True, blank=True)
    discontinued = models.CharField(max_length=255, null=True, blank=True)
    value = models.CharField(max_length=12, null=True, blank=True)
    name = models.CharField(max_length=255, null=True, blank=True)
    description = models.CharField(max_length=255, null=True, blank=True)
    updatedat = models.DateTimeField(auto_now=True)
    createdat = models.DateTimeField(auto_now_add=True)
    xx_co_tipo = models.CharField(max_length=2, null=True, blank=True)
    country_code = models.CharField(max_length=2, null=True, blank=True)
    c_taxcategory_id = models.IntegerField(null=True, blank=True)
    xx_co_tipo_articulo_id = models.IntegerField(null=True, blank=True)
    rate = models.DecimalField(max_digits=10, decimal_places=2, null=True, blank=True)
    bi_category = models.IntegerField(null=True, blank=True)

    class Meta:
        managed = False
        db_table  = '"global"."articulos"'
        app_label = 'ate'

    def __str__(self):
        return self.name