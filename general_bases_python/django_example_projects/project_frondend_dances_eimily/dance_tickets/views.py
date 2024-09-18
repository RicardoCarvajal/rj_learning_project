from django.views.generic import DetailView, CreateView
from django.urls import reverse_lazy
from django.contrib.auth.mixins import LoginRequiredMixin
from .form import TicketEventForm
from .models import Ticket


class TicketView(LoginRequiredMixin, DetailView):
    model = Ticket
    template_name = "ticket_list.html"
    context_object_name = "ticket"

    def get_object(self, queryset=None):
        return Ticket.objects.filter(is_active=True, user=self.request.user).first()


class CreateTicketEventView(LoginRequiredMixin, CreateView):
    template_name = "ticket_create.html"
    form_class = TicketEventForm
    success_url = reverse_lazy("list_tickets")

    def form_valid(self, form):
        ticket, _ = Ticket.objects.get_or_create(is_active=True, user=self.request.user)
        form.instance.ticket = ticket
        form.instance.quantity = 1
        form.save()
        return super().form_valid(form)
