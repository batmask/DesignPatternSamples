package observer
import java.time.Instant

interface IObserver{
    fun update()
}

class ChatClient: IObserver{
    private var chatName: String = ""
    private var chatRoom: ChatRoom? = null

    fun connect(name: String, room: ChatRoom){
        chatName = name
        chatRoom = room
        room.attach(this)
    }

    fun disconnect(){
        chatRoom?.detach(this)
        chatRoom = null
    }

    fun talk(chat: String){
        chatRoom?.addChat(SingleChat(chatName, chat, Instant.now()))
    }

    override fun update() {
        if(chatRoom != null){
            val chatting = chatRoom!!.getChat(this)
            chatting.forEach{println("[client: $chatName] [${it.timestamp}] ${it.name}: ${it.chat}")}
        }
    }
}