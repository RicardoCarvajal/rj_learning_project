from unittest import TestCase, mock
from src.get_information_ip import InformationIp as i

class TestInformationIp(TestCase):

    @mock.patch("src.get_information_ip.requests.get")
    def test_get_info_country(self,mock):
        mock.return_value.status_code = 200
        mock.return_value.json.return_value = {"countryName": "Venezuela"}
        result = i.get_info_country("8.8.8.8")
        self.assertEqual(result,"Venezuela")

        
        