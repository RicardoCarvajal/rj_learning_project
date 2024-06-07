def get_population():
    keys = ['col', 'ven']
    values = [300,152]
    return keys, values

def get_population_by_country(data, country):
    result = list(filter(lambda item : item['Country'] == country,data))
    return result

