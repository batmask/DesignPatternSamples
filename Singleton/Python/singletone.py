
class Singleton(type):
    _instances = {}

    def __call__(cls, *args, **kwargs):
        if cls not in cls._instances:
            cls._instances[cls] = super(Singleton, cls).__call__(*args, **kwargs)
        return cls._instances[cls]


class Logger(metaclass=Singleton):
    def __init__(self):
        self.name = "Bato"

    def who_are_you(self):
        print(f"I'm {self.name}")


a = Logger()
a.who_are_you()

a.name = "John"
b = Logger()
b.who_are_you()

