import unittest
from src.simple_calculator_arithmetic import SimpleCalculatorArithmetic as c

class SimpleCalculatorArithmeticTest(unittest.TestCase):

    def test_sum(self):
        self.assertEqual(c.sum(2,2),4)

    
