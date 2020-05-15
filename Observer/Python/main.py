import threading

from observer.chatroom import ChatRoom
from observer.chatclient import ChatClient
import time

def client1_thread(client: ChatClient):
    time.sleep(0.1)
    client.talk("hi! I'm bato")
    time.sleep(1)
    client.disconnect()

def client2_thread(client: ChatClient):
    time.sleep(0.5)
    client.talk("Do you see my chat?")
    time.sleep(2)
    client.talk("Hello?")


def client3_thread(client: ChatClient):
    time.sleep(0.7)
    client.talk("hi! I'm jung-a")
    time.sleep(0.1)
    client.disconnect()

def main():
    room1 = ChatRoom()
    client1 = ChatClient()
    client1.connect("bato", room1)
    client2 = ChatClient()
    client2.connect("wan-tae", room1)
    client3 = ChatClient()
    client3.connect("jung-a", room1)

    thread1 = threading.Thread(target=client1_thread, args=(client1,))
    thread2 = threading.Thread(target=client2_thread, args=(client2,))
    thread3 = threading.Thread(target=client3_thread, args=(client3,))

    thread1.start()
    thread2.start()
    thread3.start()


if __name__ == "__main__":
    main()
