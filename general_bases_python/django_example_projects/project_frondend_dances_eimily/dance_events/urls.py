from django.urls import path
from .views import DanceEventsView,DanceEventsAPI

urlpatterns = [
    path('', DanceEventsView.as_view(),name='list_events'),
    path('api/', DanceEventsAPI.as_view(),name='list_events_api'),
] 
