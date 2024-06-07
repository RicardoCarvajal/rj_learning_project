import utils 

keys, values = utils.get_population()

print(keys, values)

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

countryInput = input('Escriba el pais = ')

country = utils.get_population_by_country(countryList, countryInput)

print(country)