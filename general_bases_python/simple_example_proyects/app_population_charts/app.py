#Aplñicacion que analiza y grafica la poblacion mundial
import csv
import matplotlib.pyplot as ptl

NAME_FILE = 'world_population.csv'

def read_csv_population_percentage(path):
    with open(path,'r') as file:
        reader = csv.reader(file)
        header = next(reader)
        data = []
        for row in reader:
            iterable = zip(header,row)
            country_dictionary_list = {key: value for key,value in iterable}
            data.append(country_dictionary_list)
        percentages = list(map(lambda dict: (
            dict['Country/Territory'] , float(dict['World Population Percentage'])
        ),data))
        percentages_dictionary = {country: percentage for country, percentage in percentages if percentage>1}
        return percentages_dictionary

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

list_percentage = read_csv_population_percentage(NAME_FILE)

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
    ax.set_title(f'Population of {country}')
    ax.bar(labels,values)
    ptl.savefig(f'1_{country.lower()}_graf.png')
    ptl.close()

def chart_country_population_percentage(list_percentage):
    labels = list(list_percentage.keys())
    values = list(list_percentage.values())
    fig,ax = ptl.subplots()
    ax.set_title('Percentage Population')
    ax.pie(values, labels=labels)
    ax.axis('equal')
    ptl.savefig('2_all_graf.png')
    ptl.close()    

chart_country_population('Venezuela',list_anios_populations_countrys)
chart_country_population_percentage(list_percentage)

