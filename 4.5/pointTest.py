import unittest
from point import Point
from hamcrest import *

class pointTest(unittest.TestCase):
    def setUp(self):
        self.temp = Point(1, 0.1)
        self.temp2 = Point(1, 0.3)

    def testEquals(self):
        assert_that(self.temp.X, equal_to(1))

    def testEqualsY(self):
        assert_that(self.temp.Y, equal_to(0.1))

    def testDistanceLessThan(self):
        assert_that(self.temp.distance(self.temp2), less_than(0.2))

    def testDistanceGreaterThan(self):
        assert_that(self.temp.distance(self.temp2), greater_than(0.19))

    def testDistanceCloseToDelta(self):
        assert_that(self.temp.distance(self.temp2), close_to(0.2, 0.01))

    def testInstance(self):
        assert_that(self.temp, is_(Point))

    def testInstance2(self):
        assert_that(self.temp, instance_of(Point))

    def tearDown(self):
        self.temp = None
        self.temp2 = None