import os
import pytest
from faker import Faker
from src.app_banck_account import BanckAccount, Client
   
@pytest.fixture
def setup():
    fake = Faker(locale="es")
    client = Client(name=fake.name(),age=str(fake.random_int(min=18, max=100)),address=fake.address())    
    account = BanckAccount(balance=1000,client=client)
    yield account
    if os.path.exists("audit.txt"):
        os.remove("audit.txt")

def test_file_audit(setup):    
    with open("audit.txt","r") as f:
        assert len(f.readlines()) == 1

@pytest.mark.parametrize("amount, expected",[
    (1000, 2000),
    (3000, 4000),
    (0, 1000)
])
def test_deposits_different_instances(amount, expected, setup):
    account = setup
    balance = account.deposit(amount)
    assert balance == expected

def test_withdraw(setup):
    account = setup
    assert account.withdraw(500) == 500

def test_get_balance(setup):
    account = setup
    assert account.get_balance() == 1000

def test_get_client(setup):
    account = setup    
    assert account.get_client() is not None