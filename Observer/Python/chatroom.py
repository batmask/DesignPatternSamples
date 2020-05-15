from observer.data import SingleChat
from observer.abc_observer import Observable


class ChatRoom(Observable):
    def talk(self, data: SingleChat):
        self.chat_notify(data)
