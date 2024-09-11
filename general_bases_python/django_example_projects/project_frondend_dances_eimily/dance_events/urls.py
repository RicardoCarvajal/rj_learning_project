from django.urls import path
from .views import DanceEventsView

urlpatterns = [
    path('list/', DanceEventsView.as_view(),name='list_events'),
]
