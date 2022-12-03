class Planet:
    def __init__(self):
        self.planet_list = {
            "merkury": 0.2408467,
            "wenus": 0.61519726,
            "ziemia": 1.0000000,
            "mars": 1.8808158,
            "jowisz": 11.862615,
            "saturn": 29.447498,
            "uran": 84.016846,
            "neptun": 164.79132
        }

    def get_input(self):
        planet = input("Provide a planet name: ")
        age = input("Provide the age: ")
        print(self.get_age_on_planet(planet, age))

    def get_age_on_planet(self, planet, age):
        if planet in self.planet_list.keys() and age > 0:
            return "{:.2f}".format(age / 31557600 / self.planet_list[planet])
        else:
            raise Exception("Wrong Planet")