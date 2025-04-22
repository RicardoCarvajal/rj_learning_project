import pytest
import requests
from src.get_information_ip import InformationIp as i

class MockResponseInfoCountry:
    def __init__(self, *args, **kwargs): #Es importante colocar estos argumentos en la definicion de la funcion init para que funcione dentro del setattr
        pass
    @staticmethod
    def json():
        return {"countryName": "United States of America"}
    @staticmethod
    def raise_for_status(): # Si la funcion a probar dentro de su respuesta contiene una funcion que se consulta tambien hay que mockearla dentro del mock response aunque no sea lo que se esta probando
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

def test_get_info_country(monkeypatch): # monkeypatch es el que hace la magia y siempre se debe respetar el nombre, el mismo contiene diferentes funciones a parte de setattr, lo cual podemos consultar en la documentación 
    monkeypatch.setattr(requests,"get", MockResponseInfoCountry) # setattr recibe 1) la clase a probar, 2) la funcion de la clase a probar, 3) la respuesta que queremos que de
    result = i.get_info_country("8.8.8.8")
    assert result == "United States of America"

def test_get_info_country_exception(monkeypatch): 
    monkeypatch.setattr(requests,"get", MockResponseException) 
    with pytest.raises(Exception): # De esta manera se prueba el lanzamiento de una excepcion con pytest
        i.get_info_country("8.8.8.8")

def test_get_info_country_catch_exception(monkeypatch): 
    monkeypatch.setattr(requests,"get", MockResponseRequestException) 
    result = i.get_info_country("8.8.8.8")
    assert result == "Error en la conexion Error de conexion"