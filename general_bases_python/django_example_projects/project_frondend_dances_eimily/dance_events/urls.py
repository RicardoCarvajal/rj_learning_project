from django.urls import path
from .views import DanceEventsView

urlpatterns = [
    path('', DanceEventsView.as_view(),name='list_events'),
] 
