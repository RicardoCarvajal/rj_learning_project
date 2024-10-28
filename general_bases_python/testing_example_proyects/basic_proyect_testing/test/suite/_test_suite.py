import unittest
from test.test_all_asserts import ClassTest

def all_test_asserts_suites():
    suite = unittest.TestSuite()
    suite.addTest(ClassTest("test_assert_equal"))
    suite.addTest(ClassTest("test_assert_rises"))
    return suite


if __name__=="__main__":
    runner = unittest.TextTestRunner()
    runner.run(all_test_asserts_suites())
