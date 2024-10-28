class Player:
    def __init__(self,player_data):
        self.name = player_data['name']
        self.age = player_data['age']
        self.position = player_data['position']
        self.team = player_data['team']
    @classmethod
    def get_team(cls, team_list):
        new_team=[]
        for player in  team_list:
            temps=Player(player)
            new_team.append(temps)
        return new_team  
    def display(self):
        print("*"*50)
        return f"name: {self.name}, age: {self.age}, position: {self.position}, team: {self.team}"



kevin = {
        "name": "Kevin Durant", 
        "age":34, 
        "position": "small forward", 
        "team": "Brooklyn Nets"
}
jason = {
        "name": "Jason Tatum", 
        "age":24, 
        "position": "small forward", 
        "team": "Boston Celtics"
}
kyrie = {
        "name": "Kyrie Irving", 
        "age":32,
        "position": "Point Guard", 
        "team": "Brooklyn Nets"
}
playerjason=Player(jason)
playerkevin=Player(kevin)
playerkyrie=Player(kyrie)

players = [
    {
        "name": "Kevin Durant", 
        "age":34, 
        "position": "small forward", 
        "team": "Brooklyn Nets"
    },
    {
        "name": "Jason Tatum", 
        "age":24, 
        "position": "small forward", 
        "team": "Boston Celtics"
    },
    {
        "name": "Kyrie Irving", 
        "age":32,
        "position": "Point Guard", 
        "team": "Brooklyn Nets"
    },
    {
        "name": "Damian Lillard", 
        "age":33,
        "position": "Point Guard", 
        "team": "Portland Trailblazers"
    },
    {
        "name": "Joel Embiid", 
        "age":32,
        "position": "Power Foward", 
        "team": "Philidelphia 76ers"
    },
    {
        "name": "DeMar DeRozan",
        "age": 32,
        "position": "Shooting Guard",
        "team": "Chicago Bulls"
    }
]
teamlist=Player.get_team(players)
for player in teamlist:
    print(player.display())
