import requests

class InformationIp():

    def get_info_country(ip):
        try:
            url = f"https://freeipapi.com/api/json/{ip}"
            response = requests.get(url,timeout=5)
            response.raise_for_status()
            print(response)
            data = response.json()
            return data["countryName"]
        except requests.exceptions.ConnectTimeout as e:
            return f"Error en la conexion {e}"
        except requests.exceptions.RequestException as e:
            return f"Error en la conexion {e}"

    def get_info_ipVersion(ip):
        url = f"https://freeipapi.com/api/json/{ip}"
        response = requests.get(url,timeout=5)
        response.raise_for_status()
        data = response.json()
        return data["ipVersion"]

    def get_info_continent(ip):
        url = f"https://freeipapi.com/api/json/{ip}"
        response = requests.get(url,timeout=5)
        response.raise_for_status()
        data = response.json()
        return data["continent"]
    
print(InformationIp.get_info_country("8.8.8.8"))