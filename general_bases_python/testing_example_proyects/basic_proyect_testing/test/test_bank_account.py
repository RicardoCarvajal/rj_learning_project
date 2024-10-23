import os
import unittest
from src.bank_account import BankAccount

class TestBankAccount(unittest.TestCase):

    def setUp(self):
        self.account = BankAccount(balance=1000, log_file="transaction.txt")

    def tearDown(self):
        if os.path.exists(self.account.log_file):
            os.remove(self.account.log_file)

    def _count_lines(self, filename):
        with open(filename, "r") as f:
            return len(f.readlines())
    
    def test_deposit(self):
        new_balance = self.account.deposit(500)
        self.assertEqual(new_balance, 1500,"El saldo no es igual")
    
    def test_withdraw(self):
        new_balance = self.account.withdraw(500)
        self.assertEqual(new_balance, 500,"El saldo no es igual")

    def test_get_balance(self):
        self.assertEqual(self.account.get_balance(), 1000,"El saldo no es igual")

    def test_log_transaction(self):
        self.account.deposit(500)
        self.assertTrue(os.path.exists("transaction.txt"))

    def test_log_transaction_count_line(self):
        self.assertEqual(self._count_lines(self.account.log_file), 1, "La cantidad de lineas es diferente")
        self.account.deposit(500)
        self.assertEqual(self._count_lines(self.account.log_file), 2, "La cantidad de lineas es diferente")        