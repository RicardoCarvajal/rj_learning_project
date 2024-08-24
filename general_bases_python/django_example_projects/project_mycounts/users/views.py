from django.urls import reverse_lazy
from django.contrib.auth.forms import UserCreationForm
from django.views import generic

class RegisterView(generic.CreateView):
    form_class = UserCreationForm
    template_name = 'register.html'
    success_url = reverse_lazy('app_login')


