import unittest

from Planet import Planet
from assertpy import *
from assertpy import add_extension


class PlanetsTest(unittest.TestCase):

    def is_5(self):
        if self.val != 5:
            self.error(f'{self.val} is NOT 5!')
        return self

    def setUp(self):
        self.temp = Planet()

    def testMercury(self):
        assert_that(float(self.temp.get_age_on_planet("merkury", 1000000))).is_equal_to(0.13)

    def testMercuryCloseTo(self):
        assert_that(float(self.temp.get_age_on_planet("merkury", 20000000))).is_close_to(2.6, 0.5)

    def testMercuryIs5(self):
        assert_that(float(self.temp.get_age_on_planet("merkury", 20000000))).is_5(2.6, 0.5)

    def testMercuryIsGreaterThat(self):
        assert_that(float(self.temp.get_age_on_planet("merkury", 30000000))).is_greater_than(2)

    def testMercuryIsLessThan(self):
        assert_that(float(self.temp.get_age_on_planet("merkury", 400000000))).is_less_than(5)

    def testRaiseExceptionOnWrongPlanet(self):
        assert_that(self.temp.get_age_on_planet).raises(Exception).when_called_with("merkuy", 10)

    def testRaiseExceptionOnWrongNumberType(self):
        assert_that(self.temp.get_age_on_planet).raises(Exception).when_called_with("merkury", "10")

    def tearDown(self):
        self.temp = None
