from BankAccount import BankAccount
class User:
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account = []
        self.account.append(BankAccount(int_rate=0.02, balance=0))
    # other methods
    
    def make_deposit(self, amount,accountnb):
        self.account[accountnb].balance+=amount
    def make_withdrawal(self,amount,accountnb):
        if (amount<=self.account[accountnb].balance):
            self.account[accountnb].balance-=amount
        else:
            self.account[accountnb].balance-=5
            print('Fonds insuffisants : frais de 5 $ facturés')
    def display_user_balance (self):
        for i in range (len(self.account)):
            print(f"user: {self.name} and balence : {self.account[i].balance}")
    def transfer_money(self, amount, other_user,accountnb):
        if (amount<=self.account[accountnb].balance):
            self.account[accountnb].balance-=amount
            other_user.account[0].balance+=amount
User1=User("ahmed","ahmed@gmail.com")
User1.display_user_balance()
            

