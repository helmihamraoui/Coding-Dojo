from Pets import*
class Ninja:
    def __init__(self,first_name,last_name,pet,treats,pet_food):
        self.first_name=first_name
        self.last_name=last_name
        self.pet=pet
        self.treats=treats
        self.pet_food=pet_food
    def walk(self):
        Pet.play()
    def feed(self):
        Pet.eat()
    def bathe(self):        
        Pet.noise()