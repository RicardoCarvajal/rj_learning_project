import django
import os
import boto3
from django.conf import settings

region = os.environ['AWS_REGION']
seret_data_base = os.environ['SECRET_DB']

secret = boto3.client('secretsmanager', region_name='us-east-1')
env = eval(secret.get_secret_value(SecretId=seret_data_base)['SecretString'])

os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'autopricing.settings')
settings.configure(
        DATABASES = {
            'default': {
                    'ENGINE': 'django.db.backends.postgresql',
                    'HOST': env['host'],
                    'USER': env['username'],
                    'PASSWORD': env['password'],        
                    'NAME': env['dbname'],
                    'PORT': env['port'],
                },
            }
        )
django.setup()