from django.urls import path
from django.contrib.auth.views import LoginView, LogoutView
from .views import RegisterView

urlpatterns = [
    path('login/',LoginView.as_view(template_name="login.html"),name='app_login'),
    path('logout/',LogoutView.as_view(),name='app_logout'),
    path('register/',RegisterView.as_view(),name='app_register'),
]
