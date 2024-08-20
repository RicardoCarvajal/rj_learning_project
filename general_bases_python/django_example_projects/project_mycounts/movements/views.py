from django.urls import reverse_lazy
from django.views import generic
from .form import MovementsForm

class MovementsFormView(generic.FormView):
    template_name = 'add_movements.html'
    form_class = MovementsForm
    success_url = reverse_lazy('ad_movements')

    def form_valid(self, form):
        form.save()
        return super().form_valid(form)
    
