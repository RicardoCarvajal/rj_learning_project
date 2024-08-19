from datetime import datetime
import pandas as pd
import json
import os
from shutil import rmtree

NAME_FILE='datos_interfaces.xlsx'

def review_sheets():
   excel_file =  pd.ExcelFile(NAME_FILE)
   list_entitys = excel_file.sheet_names
   print(list_entitys) 

   for entity in list_entitys:
      sheet_dictionary = pd.read_excel(NAME_FILE, sheet_name=entity)
      sheet_dictionary = sheet_dictionary.astype(str)
      sheet_dictionary.drop(index=0,axis=1,inplace=True)
      entity_list_dic = sheet_dictionary.to_dict(orient='records') 
      i = 0
      createdir(entity)
      for entity_dic in entity_list_dic:
         i += 1
         store = "CR00"
         if 'branchOfficeId' in entity_dic.keys():
            if entity_dic['branchOfficeId'] != 'nan':
               store = entity_dic['branchOfficeId']
         json_data = {
            "entity": entity,
            "environments": "qa",
            "timestamp": int(datetime.now().timestamp() * 1000),
            "country": "cr",
            "store": store,
            "data": [conditions(entity_dic,entity)]  
        }
         output_path = os.path.join(f'json/{entity}', f'{entity}-cr-qa-{int(datetime.now().timestamp() * 1000+i)}.ate.json')
         with open(output_path, 'w', encoding='utf-8') as json_file:
            json.dump(json_data, json_file, ensure_ascii=False, indent=4)

def conditions(entity_dic,entity):  
    for clave, valor in entity_dic.items():
        if valor == 'nan':
            entity_dic[clave] = None
    if 'externalCode' in entity_dic.keys() and entity == 'product':
        entity_dic['externalCode'] = str(entity_dic['externalCode']).split(",")
    return entity_dic    

def createdir(entity):
   if os.path.exists('json') == False:
         os.mkdir('json')

   if os.path.exists(f'json/{entity}') == False:
         os.mkdir(f'json/{entity}')
   else:
      rmtree(f'json/{entity}')
      os.mkdir(f'json/{entity}')

review_sheets()   



#file_dictionary['priceGroup'] = file_dictionary['priceGroup'].str.zfill(2)
