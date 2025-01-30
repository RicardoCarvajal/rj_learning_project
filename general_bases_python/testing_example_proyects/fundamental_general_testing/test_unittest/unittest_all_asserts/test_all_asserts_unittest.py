import unittest

env="prod"

class ClassTest(unittest.TestCase):
    
    def test_assert_equal(self):
        self.assertEqual("Hola","Hola")
        self.assertNotEqual("Hola","Chao")

    def test_assert_true_or_false(self):
        self.assertFalse(False)
        self.assertTrue(True)
        self.assertTrue(True, "La condicion es falsa")

    def test_assert_rises(self):
        with self.assertRaises(Exception):
            int("no_soy_un_numero")

    def test_assert_in(self):
        self.assertIn(10,[1,25,10,68])
        self.assertNotIn(33,[1,25,10,68])
    
    def test_assert_dicts(self):
        person = {"name":"ricardo","age":"30"}
        self.assertDictEqual({"name":"ricardo","age":"30"},person)
    
    def test_assert_set(self):
        numbers = {1,2,2}
        self.assertSetEqual({1,2,2},numbers)

    @unittest.skip("Saltando prueba de función test_assert_skip")
    def test_assert_skip(self):
        self.assertEqual(100,100)

    @unittest.skipIf(env == "prod",f"Saltando prueba de función test_assert_skip_if cuando el ambiente sea {env}")
    def test_assert_skip_if(self):
        self.assertEqual(100,100)

    @unittest.skipUnless(env == "dev",f"Saltando prueba de función test_assert_skip_if cuando el ambiente sea diferente a dev")
    def test_assert_skip_unless(self):
        self.assertEqual(10,"10")   

    @unittest.expectedFailure
    def test_assert_skip_expected(self):
        self.assertEqual(10,"10")

    def test_assert_skip_no_decorator(self):
       if env == "prod":
           raise unittest.SkipTest("Se salta la prueba test_assert_skip_no_decorator por no cumplir con la condicion")
       self.assertEqual(10,"10")
