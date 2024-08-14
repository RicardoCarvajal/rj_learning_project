from datetime import datetime
import pandas as pd
import json
import os

ENTITY = 'client'
SHEET_NAME = 'EPA 2'

input_path = input("Enter the path dir: ")
i = 0

def read_excel():
    file_dictionary = pd.read_excel(f'{input_path}/Datos Interfases.xlsx', sheet_name=SHEET_NAME).astype(str)
    file_dictionary['priceGroup'] = file_dictionary['priceGroup'].str.zfill(2)
    file_dictionary['salesArea'] = file_dictionary['salesArea'].str.zfill(6)
    file_dictionary['region'] = file_dictionary['region'].str.zfill(2)
    file_dictionary['canton'] = file_dictionary['canton'].str.zfill(3)
    file_dictionary['district'] = file_dictionary['district'].str.zfill(4)

    file_dictionary.drop(index=0,axis=1,inplace=True)
    return file_dictionary.to_dict(orient='records') 



def generate_json(json_data,diff):
    output_path = os.path.join(f'{input_path}/json', f'{ENTITY}-cr-qa-{int(datetime.now().timestamp() * 1000+diff)}.ate.json')

    with open(output_path, 'w', encoding='utf-8') as json_file:
        json.dump(json_data, json_file, ensure_ascii=False, indent=4)

data_list = read_excel()        

for data in data_list:
    i += 1
    print(data)
    json_data = {
            "entity": ENTITY,
            "environments": "qa",
            "timestamp": int(datetime.now().timestamp() * 1000),
            "country": "cr",
            "store": "CR00",
            "data": [data]  
        }
    generate_json(json_data,i)