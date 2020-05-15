package observer
import java.time.Instant

data class SingleChat(val name: String, val chat: String, val timestamp: Instant)

abstract class ChatRoom{
    private val observers = mutableListOf<IObserver>()

    public fun attach(observer: IObserver){
        observers.add(observer)
        observerChanged(observer, true)
    }

    public fun detach(observer: IObserver){
        observers.remove(observer)
        observerChanged(observer, false)
    }

    protected fun chatNotify(){
        observers.forEach { observer -> observer.update() }
    }

    protected open fun observerChanged(observer: IObserver, attached: Boolean){}
    abstract fun addChat(data: SingleChat)
    abstract fun getChat(observer: IObserver): List<SingleChat>
}

class MyChatRoom: ChatRoom() {
    private val chatting = mutableListOf<SingleChat>()
    private val timeline = mutableMapOf<IObserver, Instant>()

    override fun observerChanged(observer: IObserver, attached: Boolean) {
        if(!attached){
            timeline.remove(observer)
        }
    }

    public override fun addChat(data: SingleChat){
        chatting.add(data)
        chatNotify()
    }

    public override fun getChat(observer: IObserver): List<SingleChat>{
        val timestamp = timeline.get(observer)
        timeline[observer] = Instant.now()

        return if(timestamp != null){
            chatting.filter{it.timestamp > timestamp}
        }else
            chatting
    }
}



