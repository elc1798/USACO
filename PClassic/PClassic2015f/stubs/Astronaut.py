class Astronaut(object):

    def __init__(self, s1=None, s2=None, s3=None, my_vote=False):
        self.__one = s1
        self.__two = s2
        self.__three = s3
        self.__no_subordinates = (s1 is None and s2 is None and s3 is None)
        self.__vote = my_vote
        self.__accessed = False

    @property
    def no_subordinates(self):
        self.__accessed = True
        return self.__no_subordinates

    @property
    def one(self):
        raise AttributeError("Use get_sub to get one")

    @property
    def two(self):
        raise AttributeError("Use get_sub to get two")

    @property
    def three(self):
        raise AttributeError("Use get_sub to get three")

    def get_vote(self):
        self.__accessed = True
        if self.no_subordinates:
            return self.__vote
        raise Exception("Tried to get vote of astronaut with subordinate")

    def get_sub(self, i):
        self.__accessed = True
        if i == 1:
            return self.__one
        if i == 2:
            return self.__two
        if i == 3:
            return self.__three

    def all_accessed(self):
        if self.no_subordinates:
            return self.__accessed
        else:
            return self.__one.all_accessed() and self.__two.all_accessed() \
                   and self.__three.all_accessed()
