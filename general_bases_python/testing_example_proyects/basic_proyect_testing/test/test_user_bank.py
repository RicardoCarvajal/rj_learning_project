import unittest
import os
from faker import Faker
from src.bank_account import BankAccount
from src.user_bank import UserBank 


class UserBankTest(unittest.TestCase):

    def setUp(self):
        self.fake = Faker(locale="es")
        self.user = UserBank(self.fake.name(), self.fake.email())

    def test_user_creation(self):
        name_generated = self.fake.name()
        email_generated = self.fake.email()
        user = UserBank(name_generated, email_generated)
        self.assertEqual(name_generated,user.name)
        self.assertEqual(email_generated,user.email)

    def test_user_with_several_accounts(self):

        for _ in range(5):
            bank_account = BankAccount(balance=self.fake.random_int(min=500,max=2000, step=120), log_file=self.fake.file_name(extension=".txt"))
            self.user.add_account(bank_account)
        
        expected = sum(account.get_balance() for account in self.user.accounts)
        value = self.user.get_total_balance()

        self.assertEqual(expected, value)

    def tearDown(self):
        for account in self.user.accounts:
            if os.path.exists(account.log_file):
                os.remove(account.log_file)        