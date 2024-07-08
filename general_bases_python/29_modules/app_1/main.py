import utils 

#Lista de diccionarios con poblacion de cada pais
countryList = [
    {
        'Country': 'Colombia',
        'population': 50
    },
    {
        'Country': 'Mexico',
        'population': 150
    },
    {
        'Country': 'Argentina',
        'population': 200
    },
    {
        'Country': 'Chile',
        'population': 300
    }
]


#Colocamos el codigo principal de main en un metodo para que 
#si necesitamos importar el main para usarlo en otro archivo
#como countryHandler, podamos acceder a la lista de paises
#sin necesidad de ejecutar todo el archivo main.
def searchCountry():
    keys, values = utils.get_population()

    print(keys, values)

    countryInput = input('Escriba el pais = ')

    country = utils.get_population_by_country(countryList, countryInput)

    print(country)

#Sin embargo esto anterior nos quita la posibilidad de ejecutar el main.py
#como un script ya que tendriamos que llamar el metodo desde otro archivo
#Para poder llamar main.py como un script y a su vez poder importar sus 
#atributos desde otros archivos podemos hacer lo siguiente:

if __name__ == '__main__':
    searchCountry()

#Con el uso de la palabra reservada __name__ podemos decirle a python
#que solo ejecute la linea "searchCountry()" cuando sea llamado desde 
#la ejecucion del archivo main.py