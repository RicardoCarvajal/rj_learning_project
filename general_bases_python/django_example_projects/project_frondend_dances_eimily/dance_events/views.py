from django.views import generic
from rest_framework.views import APIView
from rest_framework.response import Response
from .models import DanceEnvent
from .serializers import DanceEventSerializer


class DanceEventsView(generic.ListView):
    model = DanceEnvent
    template_name = "list_events.html"
    context_object_name = "list_events"


class DanceEventsAPI(APIView):
    authentication_classes = []
    permission_classes = []

    def get(self, request):
        events = DanceEnvent.objects.all()
        serializer = DanceEventSerializer(events, many=True)
        return Response(serializer.data)
