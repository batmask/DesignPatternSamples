package observer

fun main(args: Array<String>){
    val room: ChatRoom = MyChatRoom()
    val client1: ChatClient = ChatClient()
    client1.connect("bato", room)

    val client2: ChatClient = ChatClient()
    client2.connect("wan-tae", room)

    val client3: ChatClient = ChatClient()
    client3.connect("jung-a", room)

    client1.talk("hi! I'm bato")
    Thread.sleep(100)
    client3.talk("hi! I'm jung-a")
    Thread.sleep(100)
    client2.talk("Do you see my chat?")
    Thread.sleep(100)
    client1.disconnect()
    client3.disconnect()
    client2.talk("Hello?")
}