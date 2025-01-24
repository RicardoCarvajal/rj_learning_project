import requests

class InformationIp():

    def get_info_country(ip):
        url = f"https://freeipapi.com/api/json/{ip}"
        response = requests.get(url,timeout=5)
        response.raise_for_status()
        data = response.json()
        return data["countryName"]

    def get_info_ipVersion(self,ip):
        url = f"https://freeipapi.com/api/json/{ip}"
        response = requests.get(url,timeout=5)
        response.raise_for_status()
        data = response.json()
        return data["ipVersion"]

    def get_info_continent(self,ip):
        url = f"https://freeipapi.com/api/json/{ip}"
        response = requests.get(url,timeout=5)
        response.raise_for_status()
        data = response.json()
        return data["continent"]