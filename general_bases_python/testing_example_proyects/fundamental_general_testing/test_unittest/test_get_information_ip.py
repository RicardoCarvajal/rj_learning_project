from unittest import TestCase, mock
from src.get_information_ip import InformationIp as i
from requests.exceptions import RequestException

class TestInformationIp(TestCase):

    @mock.patch("src.get_information_ip.requests.get") # Se indica cual es la funcion que se quiere mockear dentro de la funcion a probar 
    def test_get_info_country(self,mockMethod): # Se declara un argumento que se inyectara como el mock, podemos ponerle cualquier nombre
        mockMethod.return_value.status_code = 200 # Los campos del mock varian (ver documentacion de unittest) pero basicamente siempre comienza con la palabra reservada (return_value) y luego de un punto el nombre del campo que queremos mockear que se encuentra dentro de la funcion que queremos mockear, en este caso status_code
        mockMethod.return_value.json.return_value = {"countryName": "United States of America"} # Los campos del mock varian (ver documentacion de unittest) pero basicamente siempre comienza con la palabra reservada (return_value) y luego de un punto el nombre del campo que queremos mockear que se encuentra dentro de la funcion que queremos mockear, en este caso json, pero como esto es una funcion se usa nuevamente (return_value) al final
        result = i.get_info_country("8.8.8.8")
        self.assertEqual(result,"United States of America")


    @mock.patch("src.get_information_ip.requests.get")
    def test_get_multi_info(self,mockMethod):
        mockMethod.side_effect = [ # podemos usar la funcion side_effect del mock inyectado para mockear varias respuestas que se ejecutaran en el orden en que las definimos
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
        self.assertEqual(i.get_info_country("8.8.8.8"),"United States of America") # la respuesta mockeada de get_info_country se tendra en el orden del side_effect
        self.assertEqual(i.get_info_ipVersion("8.8.8.8"), "4")
        self.assertEqual(i.get_info_continent("8.8.8.8"), "Americas")
        
    @mock.patch("src.get_information_ip.requests.get")
    def test_get_info_country_erros(self, mockMethod):
        mockMethod.side_effect = [
            RequestException("Error de conexion"),
            Exception("Error al intentar extraer la informacion")
        ]
        self.assertEqual(i.get_info_country("a.a.a.a"), "Error en la conexion Error de conexion")
        
        with self.assertRaises(Exception): # De esta manera se prueba el lanzamiento de una excepcion con unittest
            i.get_info_continent("8.8.8.8")