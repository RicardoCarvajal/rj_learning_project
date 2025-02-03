
class BanckAccount():

    def __init__(self, balance = 0):
        self.balance = balance
        self.write_audit_file_transaction("##########INICIANDO REGISTRO DE CUENTA#############")

    def write_audit_file_transaction(self, message):
        with open("audit.txt","a") as f:
            f.write(f"{message}\n")

    def deposit(self, amount):
        """
        >>> import os
        >>> accout = BanckAccount(balance = 1000)
        >>> accout.deposit(2000)
        3000
        >>> if os.path.exists("audit.txt"): os.remove("audit.txt")        
        """
        if amount > 0:
            self.balance += amount
            self.write_audit_file_transaction(f"##########DEPOSITO = {amount}######################")
            self.write_audit_file_transaction(f"##########SALDO = {self.balance}###################")
        return self.balance

    def withdraw(self, amount):
        """
        >>> import os                
        >>> accout = BanckAccount(balance = 1000)
        >>> accout.deposit(2000)
        3000
        >>> if os.path.exists("audit.txt"): os.remove("audit.txt")                
        """        
        if amount > 0:
            self.balance -= amount
            self.write_audit_file_transaction(f"##########RETIRO = {amount}########################")
            self.write_audit_file_transaction(f"##########SALDO = {self.balance}###################")
        return self.balance

    def get_balance(self):
        """
        >>> import os                
        >>> accout = BanckAccount(balance = 1000)
        >>> accout.get_balance()
        1000
        >>> if os.path.exists("audit.txt"): os.remove("audit.txt")                
        """                
        self.write_audit_file_transaction(f"##########CONSULTA = {self.balance}################")
        return self.balance    
    