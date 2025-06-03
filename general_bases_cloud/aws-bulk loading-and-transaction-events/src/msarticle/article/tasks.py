from celery import shared_task
from .models import Article

@shared_task
def process_data(data):
    Article.objects.bulk_create(Article(**item) for item in data)