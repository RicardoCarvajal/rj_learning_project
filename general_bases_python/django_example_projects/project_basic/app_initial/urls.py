from django.urls import path
from app_initial.views import registry_view_test, registry_view, RegistryListView

urlpatterns = [
    path("lists/",RegistryListView.as_view()),
    path("details/<int:id>",registry_view_test)
]
