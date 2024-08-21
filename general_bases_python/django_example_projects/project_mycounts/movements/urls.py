from django.urls import path
from .views import MovementsFormView, MovementsListView

urlpatterns = [
    path('add/', MovementsFormView.as_view(), name='add_movements'),
    path('list/', MovementsListView.as_view(), name='list_movements'),
]
