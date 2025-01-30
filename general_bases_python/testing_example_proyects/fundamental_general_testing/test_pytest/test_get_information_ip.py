import pytest
import requests
from src.get_information_ip import InformationIp as i

class MockResponseInfoCountry:
    def __init__(self, *args, **kwargs):
        pass
    @staticmethod
    def json():
        return {"countryName": "United States of America"}
    @staticmethod
    def raise_for_status():
        None

class MockResponseRequestException:
    def __init__(self, *args, **kwargs):
        pass    
    @staticmethod
    def raise_for_status():
        raise requests.exceptions.RequestException("Error de conexion")

class MockResponseException:
    def __init__(self, *args, **kwargs):
        pass    
    @staticmethod
    def raise_for_status():
        raise Exception("Error al intentar extraer la informacion")

def test_get_info_country(monkeypatch):
    monkeypatch.setattr(requests,"get", MockResponseInfoCountry)
    result = i.get_info_country("8.8.8.8")
    assert result == "United States of America"

def test_get_info_country_exception(monkeypatch):
    monkeypatch.setattr(requests,"get", MockResponseException)
    with pytest.raises(Exception):
        i.get_info_country("8.8.8.8")

def test_get_info_country_catch_exception(monkeypatch):
    monkeypatch.setattr(requests,"get", MockResponseRequestException)
    result = i.get_info_country("8.8.8.8")
    assert result == "Error en la conexion Error de conexion"