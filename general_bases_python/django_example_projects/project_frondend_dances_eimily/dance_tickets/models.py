from django.db import models
from django.contrib.auth.models import User
from dance_events.models import DanceEnvent


class Ticket(models.Model):
    user = models.ForeignKey(User, on_delete=models.CASCADE)
    is_active = models.BooleanField(default=True)
    ticket_buy_date = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        return f"Ticket {self.id} for {self.user.username}"


class TicketEvent(models.Model):
    ticket = models.ForeignKey(Ticket, on_delete=models.CASCADE)
    event = models.ForeignKey(DanceEnvent, on_delete=models.PROTECT)
    quantity = models.IntegerField()

    def __str__(self):
        return f"{self.quantity} tickets for {self.event.name}"
