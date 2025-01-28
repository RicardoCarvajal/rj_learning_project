from unittest import TestCase, mock
from src.get_information_ip import InformationIp as i
from requests.exceptions import RequestException

class TestInformationIp(TestCase):

    @mock.patch("src.get_information_ip.requests.get")
    def test_get_info_country(self,mockMethod):
        mockMethod.return_value.status_code = 200
        mockMethod.return_value.json.return_value = {"countryName": "United States of America"}
        result = i.get_info_country("8.8.8.8")
        self.assertEqual(result,"United States of America")


    @mock.patch("src.get_information_ip.requests.get")
    def test_get_multi_info(self,mockMethod):
        mockMethod.side_effect = [
            mock.Mock(
                status_code=200,
                json = lambda: {"countryName": "United States of America"}
            ),
            mock.Mock(
                status_code=200,
                json = lambda: {"ipVersion": "4"}
            ),
            mock.Mock(
                status_code=200,
                json = lambda: {"continent": "Americas"}
            )
        ]
        self.assertEqual(i.get_info_country("8.8.8.8"),"United States of America")
        self.assertEqual(i.get_info_ipVersion("8.8.8.8"), "4")
        self.assertEqual(i.get_info_continent("8.8.8.8"), "Americas")
        
    @mock.patch("src.get_information_ip.requests.get")
    def test_get_info_country_erros(self, mockMethod):
        mockMethod.side_effect = [
            RequestException("Error de conexion"),
            Exception("Error al intentar extraer la informacion")
        ]
        self.assertEqual(i.get_info_country("a.a.a.a"), "Error en la conexion Error de conexion")
        
        with self.assertRaises(Exception):
            i.get_info_continent("8.8.8.8")