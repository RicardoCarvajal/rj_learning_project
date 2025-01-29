import requests

class InformationIp():

    def get_info_country(ip):
        """
        >>> InformationIp.get_info_country("8.8.8.8")
        'United States of America'
        """
        try:
            url = f"https://freeipapi.com/api/json/{ip}"
            response = requests.get(url,timeout=5)
            response.raise_for_status()
            data = response.json()
            return data["countryName"]
        except requests.exceptions.RequestException as e:
            return f"Error en la conexion {e}"

    def get_info_ipVersion(ip):
        """
        >>> InformationIp.get_info_ipVersion("8.8.8.8")
        4
        """        
        url = f"https://freeipapi.com/api/json/{ip}"
        response = requests.get(url,timeout=5)
        response.raise_for_status()
        data = response.json()
        return data["ipVersion"]

    def get_info_continent(ip):
        """
        >>> InformationIp.get_info_continent("8.8.8.8")
        'Americas'
        """        
        url = f"https://freeipapi.com/api/json/{ip}"
        response = requests.get(url,timeout=5)
        response.raise_for_status()
        data = response.json()
        return data["continent"]