from rest_framework.serializers import ModelSerializer
from .models import DanceEnvent


class DanceEventSerializer(ModelSerializer):
    class Meta:
        model = DanceEnvent
        fields = ["name", "description", "location"]
