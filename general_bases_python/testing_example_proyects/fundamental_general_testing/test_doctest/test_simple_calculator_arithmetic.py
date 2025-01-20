def sum(a,b):
    """
    >>> sum(3,3)
    Sumando dos números
    6
    """
    print("Sumando dos números")
    return a + b

def substrac(a,b):
    """
    >>> substrac(3,4)
    -1
    """
    return a - b

def multiply(a,b):
    """
    >>> multiply(2,2)
    4
    """
    return a * b

def divide(dividend, divisor):
    """
    >>> divide(4,2)
    2.0

    >>> divide(4,0)
    Traceback (most recent call last):
    ValueError: No se puede dividir entre 0
    """
    if divisor == 0:
        raise ValueError("No se puede dividir entre 0")
    return dividend / divisor