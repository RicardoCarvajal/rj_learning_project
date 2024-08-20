from django.urls import path
from .views import MovementsFormView

urlpatterns = [
    path('add/', MovementsFormView.as_view(), name='ad_movements'),
]
