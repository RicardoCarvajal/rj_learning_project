#Alcances de las variables en Python

var_1 = 100 #scope global

def increment():
    var_1 = 200 #scope de la funcion
    result = var_1 + 1
    print(result)#de igual forma result tampoco se podra usar fuera de la funcion

print(var_1)
increment()
