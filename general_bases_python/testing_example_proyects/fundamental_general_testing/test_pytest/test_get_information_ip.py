import pytest
import requests
from src.get_information_ip import InformationIp as i


class MockResponse:
    @staticmethod
    def json():
        return {"countryName": "United States of America"}
    
    @staticmethod
    def raise_for_status():
        pass

def mockreturn(*args, **kwargs):
    return MockResponse()

def test_get_info_country(monkeypatch):
  
    monkeypatch.setattr(requests,"get", mockreturn)
    result = i.get_info_country("8.8.8.8")
    assert result == "United States of America"
