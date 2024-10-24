class Pet:
    def __init__(self,name,type,tricks,health,energy):
        self.name=name
        self.type=type
        self.tricks=tricks
        self.health=health
        self.energy=energy
    def sleep(self):
        self.energy+=25
    def eat(self):
        self.energy+=5
        self.health+=10
    def play(self):
        self.health+=5
    def noise():
        print(f"hawhaw")