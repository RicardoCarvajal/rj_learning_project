from django.contrib import admin
from .models import Movement

class MovementAdmin(admin.ModelAdmin):
    model = Movement
    list_display = ['items', 'date']
    search_fields = ['items', 'date']

admin.site.register(Movement,MovementAdmin)