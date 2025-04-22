import os
import unittest
from faker import Faker
from src.app_banck_account import BanckAccount, Client

class TestBanckAccount(unittest.TestCase):
    
    def setUp(self): # Este metodo se ejecutara siempre al inicio de las pruebas
        self.fake = Faker(locale="es")
        client = Client(name=self.fake.name(),age=str(self.fake.random_int(min=18, max=100)),address=self.fake.address()) # Generando datos de pruebas con faker
        self.account = BanckAccount(balance=1000,client=client)
    
    def tearDown(self): # Este metodo se ejecutara siempre al final de las pruebas
        if os.path.exists("audit.txt"):
            os.remove("audit.txt")

    def test_file_audit(self):
        with open("audit.txt","r") as f:
            self.assertEqual(len(f.readlines()),1)        

    def test_deposits_different_instances(self):
        deposits = [
            {"amount": 1000,"expected": 2000},
            {"amount": 3000,"expected": 4000},
            {"amount": 0,"expected": 1000}]
        for deposit in deposits:
            with self.subTest(case=deposit): # Parametrizando la pruebas con subtest, aca tendremos tres pruebas en una 
                self.setUp() # Debido a que estamos llamando a la funcion setup manualmente la prueba se ejecutara con una instancia diferente de BanckAccount en cada oportunidad
                balance = self.account.deposit(deposit["amount"])
                self.assertEqual(balance, deposit["expected"])

    def test_deposits_same_instances(self):
        deposits = [
            {"amount": 1000,"expected": 2000},
            {"amount": 3000,"expected": 5000},
            {"amount": 0,"expected": 5000}]
        for deposit in deposits:
            with self.subTest(case=deposit): # Debido a que NO estamos llamando a la funcion setup manualmente la prueba se ejecutara con la misma instancia de BanckAccount en cada oportunidad
                balance = self.account.deposit(deposit["amount"])
                self.assertEqual(balance, deposit["expected"])

    def test_withdraw(self):
        self.assertEqual(self.account.withdraw(500), 500)

    def test_get_balance(self):
        self.assertEqual(self.account.get_balance(), 1000)

    def test_get_client(self):
        self.assertIsNotNone(self.account.get_client())