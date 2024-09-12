from django.http import HttpResponse
from django.views import generic
from django.urls import reverse_lazy
from .models import DanceEnvent
from .forms import DanceEventsForm

class DanceEventsView(generic.ListView):
    model = DanceEnvent
    template_name = 'list_events.html'
    context_object_name = 'list_events'

class DanceEventsFormView(generic.FormView):
    form_class = DanceEventsForm
    template_name = 'add_events.html'
    context_object_name = 'add_events'
    success_url = reverse_lazy('add_events')

    def form_valid(self, form):
        form.save()
        return super().form_valid(form)