import unittest
from src.calculator import sum, subtract, divide, multiply

class CalculatorUnitTest(unittest.TestCase):
    def test_sum(self):
        assert sum(2,3) == 5

    def test_subtract(self):
        assert subtract(5, 3) == 2    

    def test_multiply(self):
        assert multiply(2, 3) == 6

    def test_divide(self):
        assert divide(6, 3) == 2
    
    def test_divide_by_zero(self):
        try:
            divide(6,0)
        except Exception as e:    
            assert isinstance(e,ValueError)  

    