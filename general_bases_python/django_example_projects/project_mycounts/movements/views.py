from django.urls import reverse_lazy
from django.views import generic
from .form import MovementsForm
from .models import Movement

class MovementsListView(generic.ListView):
    model=Movement
    template_name = 'list_movements.html'
    context_object_name = 'list_movements'

class MovementsFormView(generic.FormView):
    template_name = 'add_movements.html'
    form_class = MovementsForm
    success_url = reverse_lazy('list_movements')

    def form_valid(self, form):
        form.save()
        return super().form_valid(form)
    
