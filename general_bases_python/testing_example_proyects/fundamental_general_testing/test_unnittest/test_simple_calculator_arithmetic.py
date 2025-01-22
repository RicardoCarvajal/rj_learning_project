import unittest
from src.simple_calculator_arithmetic import SimpleCalculatorArithmetic as c

class SimpleCalculatorArithmeticTest(unittest.TestCase):

    def test_sum(self):
        self.assertEqual(c.sum(2,2),4)

    def test_substrac(self):
        self.assertEqual(c.substrac(4,2),2)

    def test_multiply(self):
        self.assertEqual(c.multiply(2,2),4)

    def test_divide(self):
        self.assertEqual(c.divide(4,2),2)

    def test_divide_zero(self):
        with self.assertRaises(ValueError):
            c.divide(4,0)
    
