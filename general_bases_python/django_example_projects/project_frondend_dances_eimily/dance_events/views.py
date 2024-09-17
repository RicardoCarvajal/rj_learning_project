from django.views import generic
from .models import DanceEnvent

class DanceEventsView(generic.ListView):
    model = DanceEnvent
    template_name = 'list_events.html'
    context_object_name = 'list_events'