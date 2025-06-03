import os
from celery import Celery

# Set the default Django settings module for the 'celery' program.
os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'config.settings')

app = Celery('config',broker='amqps://app_poc:kWWjatrjcfQQt@b-fa1c88d9-77df-4861-95c4-af9e17dfd2bb.mq.us-west-2.on.aws:5671')

# Using a string here means the worker doesn't have to serialize
# the configuration object to child processes.
# - namespace='CELERY' means all celery-related configuration keys
#   should have a `CELERY_` prefix.
app.config_from_object('django.conf:settings', namespace='CELERY')

app.conf.task_default_queue = 'articles_proccess'

app.autodiscover_tasks()


#@app.task
#def process_data(data):
#    print(data)
    #Article.objects.bulk_create(Article(**item) for item in data)