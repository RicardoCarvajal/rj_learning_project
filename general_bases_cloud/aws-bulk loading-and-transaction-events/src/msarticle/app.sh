#!/bin/bash

# Iniciar Celery en segundo plano
celery -A config worker -l INFO &

# Iniciar la aplicación Django en primer plano
exec python manage.py runserver 0.0.0.0:8000 --noreload