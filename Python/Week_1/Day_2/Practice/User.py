class User :
    def __init__(self,first_name,last_name,email,age,reword=False):
        self.first_name=first_name
        self.last_name=last_name
        self.email=email
        self.age=age
        self.is_rewards_member=reword
        self.gold_card_points=0
    def display_info(self):
        print(f"first_name :{self.first_name},\nlast_name:{self.last_name}, \nemail :{self.email}, \nage :{self.age}, \nis_rewards_member :{self.is_rewards_member} , \ngold_card_points: {self.gold_card_points}.")    
    def enroll(self):
        if (self.is_rewards_member==True):
            print ("User already a member.")
        else:
            self.is_rewards_member=True
            self.gold_card_points=200
    def spend_points(self,amount):
        if(self.gold_card_points>=amount):
            self.gold_card_points=self.gold_card_points-amount
        else:
            print("you don't have  points")    
user1=User("helmi","hamaraoui","helmihamraoui54@gmail.com",20) 
user1.display_info()
user1.enroll()
user1.spend_points(50)
user2=User("ahmed","marweni","ahmedmr@gmail.com",22) 
user2.display_info()
user2.enroll()
user2.spend_points(80)