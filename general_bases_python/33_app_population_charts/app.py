#Aplñicacion que analiza y grafica la poblacion mundial
import csv
import matplotlib.pyplot as ptl


NAME_FILE = 'world_population.csv'

def read_csv_population(path):
    with open(path,'r') as file:
        reader = csv.reader(file)
        header = next(reader)
        data = []
        for row in reader:
            iterable = zip(header,row)
            country_dictonary = {key: value for key, value in iterable}
            data.append(country_dictonary)
        anios = list(map(lambda dict: {
            'Country':dict['Country/Territory'],
            '2022': int(dict['2022 Population']),
            '2020': int(dict['2020 Population']),
            '2015': int(dict['2015 Population']),
            '2010': int(dict['2010 Population']),
            '2000': int(dict['2000 Population']),
            '1990': int(dict['1990 Population']),
            '1980': int(dict['1980 Population']),
            '1970': int(dict['1970 Population'])
        },data))                     
        return anios     

list_anios_populations_countrys = read_csv_population(NAME_FILE)            

def chart_country_population(country,list_anios_populations_countrys):
    country_population = list(filter(lambda item : item['Country']==country,list_anios_populations_countrys))
    list(map(lambda dict: dict.pop('Country'),country_population))
    country_population = country_population[0]
    labels = list(country_population.keys())
    values = list(country_population.values())
    print(labels)
    print(values)
    labels.reverse()
    values.reverse()
    fig,ax = ptl.subplots()
    ax.bar(labels,values)
    ptl.show()

chart_country_population('Venezuela',list_anios_populations_countrys)


