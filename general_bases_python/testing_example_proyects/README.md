## Proyecto de test Python

## Temas que se practican

* Ejemplos de todos los casos de uso con sus versiones en DOCTEST, UNITTEST PYTEST
* Mockeo de pruebas
* Atajos de excepciones en pruebas unitarias
* “Requesting” fixtures con pytest
* Faker de python para data de pruebas

### Comandos de pruebas

#### DOCTEST

* python3 -m doctest test_doctest/test_simple_calculator_arithmetic.py
* python3 -m doctest test_doctest/test_app_banck_account.py
* python3 -m doctest test_doctest/test_get_information_ip.py 
  (Interesante resaltar que si un doctest como este no tenemos buena conexion la prueba fallara)

#### UNITTEST

* python3 -m unittest test_unittest.test_simple_calculator_arithmetic
* python3 -m unittest test_unittest.test_get_information_ip
* python3 -m unittest test_unittest.test_app_banck_account
* python3 -m unittest test_unittest.unittest_all_asserts.test_all_asserts_unittest
  (Interesantes assert, algunos son utiles para probar diferentes ambientes)

#### PYTEST

* python3 -m pytest -v test_pytest/test_simple_calculator_arithmetic.py
* python3 -m pytest -v test_pytest/test_get_information_ip.py
* python3 -m pytest -v test_pytest/test_app_banck_account.py

### Comandos para reportes de pruebas pruebas

#### UNITTEST

* Ejecutando la prueba

coverage run --source src -m unittest discover test_unittest

`--source` src (solo da u reporte del src sin incluir las carpetas de test)

`-m unittest` que tipo de pruebas unitarias

`discover test_unittest` donde estan las pruebas unitarias

* Generando reporte por consola

coverage report

* Generando reporte en HTML

coverage html

#### PYTEST

* Ejecutando la prueba

coverage run --source src -m pytest test_pytest

`--source` src (solo da u reporte del src sin incluir las carpetas de test)

`-m pytest` que tipo de pruebas unitarias

`discover test_pytest` donde estan las pruebas unitarias

* Generando reporte por consola

coverage report

* Generando reporte en HTML

coverage html

NOTA: En pytest el reporte nos dara una covertura de 85%, esto se hizo intencionalmente para mostrar como se ve en el reporte html las lineas que no tienen pruebas programadas