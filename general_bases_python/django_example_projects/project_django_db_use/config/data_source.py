import django
from django.conf import settings
import os

os.environ.setdefault('DJANGO_SETTINGS_MODULE', 'autopricing.settings')

settings.configure(
        DATABASES = {
            'default': {
                    'ENGINE': 'django.db.backends.postgresql',
                    'HOST': 'devate-common-services-pgproxy.proxy-c74uyu8qee5o.us-east-1.rds.amazonaws.com',
                    'USER': 'masteradmin',
                    'PASSWORD': 'T%qS],.:9N=ehLz)',        
                    'NAME': 'autopricing_cr',
                    'PORT': '5432',
                },
            }
        )

django.setup()