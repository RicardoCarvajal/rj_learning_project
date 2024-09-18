from django.urls import path
from .views import CreateTicketEventView, TicketView

urlpatterns = [
    path("list/", TicketView.as_view(), name="list_tickets"),
    path("add-ticket/", CreateTicketEventView.as_view(), name="add_tickets"),
]
