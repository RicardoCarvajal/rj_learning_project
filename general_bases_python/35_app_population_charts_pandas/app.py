#Aplicacion que analiza y grafica la poblacion mundial pero ahora usando la libreria pandas
import csv
import matplotlib.pyplot as ptl
import pandas as pd

NAME_FILE = 'world_population.csv'

file_dictionary = pd.read_csv(NAME_FILE)

file_dictionary = file_dictionary[file_dictionary['Continent']=='South America']

countries = file_dictionary['Country/Territory'].values
percentages = file_dictionary['World Population Percentage'].values

print(file_dictionary)

print(countries)
print(percentages)

def chart_country_population_percentage(countries, percentages):
    labels = countries
    values = percentages
    fig,ax = ptl.subplots()
    ax.set_title('Percentage Population')
    ax.pie(values, labels=labels)
    ax.axis('equal')
    ptl.savefig('graf.png')
    ptl.close()    

chart_country_population_percentage(countries, percentages)    