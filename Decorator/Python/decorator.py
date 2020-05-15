from typing import Callable


def bold_decorator(func: Callable[[str], str]) -> Callable[[str], str]:
    def wrapper(text: str):
        return f"<B>{func(text)}</B>"

    return wrapper

def italic_decorator(func: Callable[[str], str]) -> Callable[[str], str]:
    def wrapper(text: str):
        return f"<I>{func(text)}</I>"

    return wrapper

def plain_text(text: str) -> str:
    return text

# static usage
@italic_decorator
@bold_decorator
def decorated_text(text: str) -> str:
    return plain_text(text)


print(decorated_text("It's decorator!"))

# dynamic usage
dynamic_decorated_text = italic_decorator(bold_decorator(plain_text))
print(dynamic_decorated_text("It's decorator!"))
