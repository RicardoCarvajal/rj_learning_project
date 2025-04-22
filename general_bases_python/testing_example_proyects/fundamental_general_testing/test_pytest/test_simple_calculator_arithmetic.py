import pytest
from src.simple_calculator_arithmetic import SimpleCalculatorArithmetic as c

def test_sum():
    assert c.sum(2,2) == 4

def test_substrac():
    assert c.substrac(4,2) == 2

def test_multiply():
    assert c.multiply(2,2) == 4

def test_divide():
    assert c.divide(4,2) == 2

def test_divide_zero():
    with pytest.raises(ValueError):
        c.divide(4,0)