from django.forms import ModelForm
from .models import TicketEvent


class TicketEventForm(ModelForm):
    class Meta:
        model = TicketEvent
        fields = ["event"]
