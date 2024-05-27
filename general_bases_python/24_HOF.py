#Higher order function: una función dentro de otra función

def increment_one_v1(x):
    return x + 2

def more_increment_one_v1(x, fun):
    return abs(x + fun(x))

#Se llama la funcion sin el argumento
result = more_increment_one_v1(10, increment_one_v1)

print(result)

#Ahora podemos hacerlo con una lambda

more_increment_one_v2 = lambda x, fun: abs(x + fun(x))

result_2 = more_increment_one_v2(25,lambda x: x + 2)#Puedo hacer una declaracion de funcion lambda como argumento

print(result_2)
