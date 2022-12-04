from hamcrest.core.base_matcher import BaseMatcher
from hamcrest.core.helpers.hasmethod import hasmethod


class AreTheSameAxis(BaseMatcher):

    def __init__(self, point):
        self.point = point

    def _matches(self, item):
        if (item.Y > 0 and self.point.Y > 0) or (item.Y < 0 and self.point.Y < 0):
            return True

    def describe_to(self, description):
        description.append_text('points in the same quarter')


def are_the_same_axis(point):
    return AreTheSameAxis(point)
