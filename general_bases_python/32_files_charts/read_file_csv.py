#Lectura de csv con python
import csv

def read_csv(path):
    with open(path,'r') as csvfile:
        reader = csv.reader(csvfile,delimiter=',')
        header = next(reader)
        print(header)
        data = []
        for row in reader:
            iterable = zip(header,row)
            country_dictionary = {key: value for key, value in iterable}
            data.append(country_dictionary)
        return data

data = read_csv('world_population.csv')        
print(data)