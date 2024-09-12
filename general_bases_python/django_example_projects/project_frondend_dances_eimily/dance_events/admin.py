from django.contrib import admin
from .models import DanceEnvent

class DanceEventsAdmin(admin.ModelAdmin):
    model = DanceEnvent
    list_display = ['name', 'description','date']
    search_fields = ['name', 'description','date']

admin.site.register(DanceEnvent,DanceEventsAdmin)    
