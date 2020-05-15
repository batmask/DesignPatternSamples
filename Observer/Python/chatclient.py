from abc import ABC, abstractmethod
from observer.chatroom import ChatRoom
from observer.data import SingleChat
from datetime import datetime
import time
from observer.abc_observer import IObserver

class ChatClient(IObserver):
    def __init__(self):
        self.name: str = None
        self.room: ChatRoom = None

    def update(self, data: SingleChat):
        print(f"[{self.name}] {data.name}, {data.chat} - {datetime.fromtimestamp(data.timestamp)}")

    def connect(self, name: str, room: ChatRoom):
        self.name = name
        self.room = room
        self.room.attach(self)

    def disconnect(self):
        self.room.detach(self)
        self.room = None

    def talk(self, msg: str):
        if self.room is not None:
            self.room.talk(SingleChat(self.name, msg, time.time()))
