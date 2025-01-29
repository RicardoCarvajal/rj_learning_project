## Proyecto de test Python

## Temas que se practican

* Ejemplos de todos los casos de uso con sus versiones en DOCTEST, UNITTEST PYTEST
* Mockeo de pruebas
* Atajos de excepciones en pruebas unitarias

### Comandos de pruebas

#### DOCTEST

* python3 -m doctest test_doctest/test_simple_calculator_arithmetic.py
* python3 -m doctest test_doctest/test_get_information_ip.py 
  (Interesante resaltar que si un doctest como este no tenemos buena conexion la prueba fallara)

#### UNITTEST

* python3 -m unittest test_unnittest.test_simple_calculator_arithmetic
* python3 -m unittest test_unnittest.test_get_information_ip

#### PYTEST

* python3 -m pytest test_pytest/test_simple_calculator_arithmetic.py
* python3 -m pytest test_pytest/test_get_information_ip.py