from django.contrib import admin
from .models import DanceEnvent


class DanceEventsAdmin(admin.ModelAdmin):
    model = DanceEnvent
    list_display = ["name"]
    search_fields = ["name", "description", "date"]


admin.site.register(DanceEnvent, DanceEventsAdmin)

admin.site.site_header = "Administrador Danzas Eimily"
admin.site.index_title = "Panel de control Danzas Eimily"
admin.site.site_title = "Admin"
