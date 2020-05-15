def my_decorator(func):
    def wrapper():
        print("before func")
        func()
        print("after func")
    return wrapper

def plain_func():
    print("I'm here!")


decorated = my_decorator(plain_func)
decorated()

print("")

@my_decorator
def plain_func2():
    print("Who am I?")


plain_func2()

