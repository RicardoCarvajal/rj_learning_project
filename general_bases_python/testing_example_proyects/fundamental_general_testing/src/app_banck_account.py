
class BanckAccount():

    def __init__(self, balance = 0, client = None):
        self.balance = balance
        self.client: Client = client
        self.write_audit_file_transaction("##########INICIANDO REGISTRO DE CUENTA#############")

    def write_audit_file_transaction(self, message):
        with open("audit.txt","a") as f:
            f.write(f"{message}\n")

    def deposit(self, amount):
        if amount > 0:
            self.balance += amount
            self.write_audit_file_transaction(f"##########DEPOSITO = {amount}######################")
            self.write_audit_file_transaction(f"##########SALDO = {self.balance}###################")
        return self.balance

    def withdraw(self, amount):
        if amount > 0:
            self.balance -= amount
            self.write_audit_file_transaction(f"##########RETIRO = {amount}########################")
            self.write_audit_file_transaction(f"##########SALDO = {self.balance}###################")
        return self.balance

    def get_balance(self):
        self.write_audit_file_transaction(f"##########CONSULTA = {self.balance}################")
        return self.balance    

    def get_client(self):
        self.write_audit_file_transaction(f"##########CLIENTE = {self.client}#################")        
        return self.client

class Client():
    def __init__(self, name, age, address):
        self.name = name
        self.age = age
        self.address = address