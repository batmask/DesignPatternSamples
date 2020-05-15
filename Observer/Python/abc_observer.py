from abc import ABC, abstractmethod
from typing import List
import threading
import copy


class IObserver(ABC):
    @abstractmethod
    def update(self, data):
        pass

class Observable:
    def __init__(self):
        self.observers: List[IObserver] = []
        # self._observers_copy: List[IObserver] = []
        self.lock = threading.Lock()

    def attach(self, observer: IObserver):
        with self.lock:
            self.observers.append(observer)

    def detach(self, observer: IObserver):
        with self.lock:
            self.observers.remove(observer)

    def chat_notify(self, data):
        with self.lock:
            observers_copy = self.observers[:]

        for observer in observers_copy:
            observer.update(data)
