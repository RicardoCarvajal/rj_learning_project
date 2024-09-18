from django.test import TestCase
from django.urls import reverse
from django.contrib.auth import get_user_model


class TicketViewTest(TestCase):

    # Prueba si la redireccion cuando no
    # esta logueado el usuario es correcta
    def test_logged_user_redirect(self):
        url = reverse("list_tickets")
        response = self.client.get(url)
        self.assertEqual(response.status_code, 302)
        self.assertEqual(response.url, "/users/login/?next=/tickets/list/")

    # Prueba si la redireccion cuando esta
    # logueado el usuario es correcta
    def test_no_logged_user_redirect(self):
        url = reverse("list_tickets")
        user = get_user_model().objects.create(username="emacarvajal")
        self.client.force_login(user)
        response = self.client.get(url)
        self.assertEqual(response.status_code, 200)
