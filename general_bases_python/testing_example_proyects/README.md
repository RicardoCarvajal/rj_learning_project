## Proyecto de test Python

## Temas que se practican

* Ejemplos de todos los casos de uso con sus versiones en DOCTEST, UNITTEST PYTEST
* Mockeo de pruebas
* Atajos de excepciones en pruebas unitarias
* “Requesting” fixtures con pytest

### Comandos de pruebas

#### DOCTEST

* python3 -m doctest test_doctest/test_simple_calculator_arithmetic.py
* python3 -m doctest test_doctest/test_get_information_ip.py 
  (Interesante resaltar que si un doctest como este no tenemos buena conexion la prueba fallara)

#### UNITTEST

* python3 -m unittest test_unittest.test_simple_calculator_arithmetic
* python3 -m unittest test_unittest.test_get_information_ip
* python3 -m unittest test_unittest.unittest_all_asserts.test_all_asserts_unittest
  (Interesantes assert, algunos son utiles para probar diferentes ambientes)

#### PYTEST

* python3 -m pytest test_pytest/test_simple_calculator_arithmetic.py
* python3 -m pytest test_pytest/test_get_information_ip.py


---Construccion:

Hacer clase de BankAccount y empieza a hacer pruebas
Hacer el setUp y tearDown mas el parametrizer y todo para los tres tipos de pruebas