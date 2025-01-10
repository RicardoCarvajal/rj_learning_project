def sum(a,b):
    """
    >>> sum(7,2)
    9

    >>> sum(4,-4)
    1
    """
    return a + b

def subtract(a, b):
    return a - b

def multiply(a, b):
    return a * b


def divide(a, b):
    """
    >>> divide(10,0)
    Traceback (most recent call last):
    ValueError: Cannot divide by zero
    """
    if b == 0:
        raise ValueError('Cannot divide by zero')
    return a / b