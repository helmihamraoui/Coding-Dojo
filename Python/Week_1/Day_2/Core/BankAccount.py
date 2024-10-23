class BankAccount:
    # don't forget to add some default values for these parameters!
    list_of_bankaccount=[]
    def __init__(self, int_rate, balance):  
        self.int_rate=int_rate
        self.balance=balance
        BankAccount.list_of_bankaccount.append(self)
        # don't worry about user info here; we'll involve the User class soon
    def deposit(self, amount):
        self.balance=self.balance+amount
        return self
    def withdraw(self, amount):
        if (self.balance>=amount):
            self.balance=self.balance-amount
        else:
            self.balance=self.balance-5
            print('Fonds insuffisants : frais de 5 $ facturés') 
        return self    
    def display_account_info(self):
        print(f'balance : {self.balance}')
        return self
    def yield_interest(self):
        if (self.balance>0):
            self.balance=self.balance+self.balance*self.int_rate
        return self
    @classmethod
    def Bank_Accounts_info(cls):
        for i in range(len(cls.list_of_bankaccount)):
            cls.list_of_bankaccount[i].display_account_info()
acount1=BankAccount(0.02,0)
acount2=BankAccount(0.02,0)
acount1.deposit(50).deposit(50).deposit(80).withdraw(100).yield_interest().display_account_info()
acount2.deposit(50).deposit(80).withdraw(200).withdraw(200).withdraw(200).withdraw(200).yield_interest().display_account_info()
print('*'*70)
acount1.Bank_Accounts_info()