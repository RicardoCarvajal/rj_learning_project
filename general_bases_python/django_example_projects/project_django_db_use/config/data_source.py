import django
import os
import boto3
from django.conf import settings

secret = boto3.client('secretsmanager', region_name='us-east-1')
env = eval(secret.get_secret_value(SecretId='arn:aws:secretsmanager:us-east-1:960233350828:secret:ate/dev/common/postgres-MINKtj')['SecretString'])

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