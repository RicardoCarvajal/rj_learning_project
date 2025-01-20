class SimpleCalculatorArithmetic():      

    def sum(a,b):
        return a + b

    def substrac(a,b):
        return a - b

    def multiply(a,b):
        return a * b

    def divide(dividend, divisor):
        if divisor == 0:
            raise ValueError("No se puede dividir entre 0")
        return dividend / divisor