from django.urls import path
from .views import DanceEventsView, DanceEventsFormView

urlpatterns = [
    path('', DanceEventsView.as_view(),name='list_events'),
    path('add/', DanceEventsFormView.as_view(),name='add_events'),
] 
