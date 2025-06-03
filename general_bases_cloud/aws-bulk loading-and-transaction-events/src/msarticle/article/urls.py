from django.urls import path
from .views import ArticleAPI

urlpatterns = [
    path("article/", ArticleAPI.as_view(), name="article_api"),
]
