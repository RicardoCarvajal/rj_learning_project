from django.http import HttpResponse
from django.urls import path
from items.views import ItemsListView

urlpatterns = [
    path('list/', ItemsListView.as_view() , name='list_items'),
]