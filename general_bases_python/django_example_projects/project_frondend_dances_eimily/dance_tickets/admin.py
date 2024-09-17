from django.contrib import admin
from dance_tickets.models import Ticket,TicketEvent

class TicketInLineAdmin(admin.TabularInline):
    model = TicketEvent
    extra = 0

class TicketAdmin(admin.ModelAdmin):
    model = Ticket
    inlines = [
        TicketInLineAdmin
    ]

admin.site.register(Ticket,TicketAdmin)