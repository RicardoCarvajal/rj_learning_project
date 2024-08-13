#Importacion de modulos directa

#from pkg.module_1 import func_1,func_2
#from pkg.module_2 import func_3,func_4

#print(func_1())
#print(func_2())
#print(func_3())
#print(func_4())


#Importacion de modulos por medio del archivo __init__.py

import pkg

print(pkg.URL)
print(pkg.module_1.func_1())
print(pkg.module_2.func_3())
