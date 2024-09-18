from django.test import TestCase
from django.urls import reverse
from .models import DanceEnvent


class DanceEventsViewTests(TestCase):
    def test_return_200(self):
        url = reverse("list_events")
        response = self.client.get(url)
        self.assertEqual(response.status_code, 200)

    def test_return_events(self):
        DanceEnvent.objects.create(
            name="Volviendo a soñar", description="Evento de pruebas"
        )
        url = reverse("list_events")
        response = self.client.get(url)
        self.assertEqual(response.context["list_events"].count(), 1)
