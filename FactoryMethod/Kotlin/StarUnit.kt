package factorymethod

abstract class StarUnit {
    var pos: Position = Position()
    abstract var speed: Int
    abstract val health: Int

    abstract fun move(newPos: Position)
    abstract  fun attack(attackPos: Position)
}

class Vurture: StarUnit() {
    override var speed: Int = 3
    override val health: Int = 10

    override fun move(newPos: Position) {
        println("Vurture move")
    }

    override fun attack(attackPos: Position) {
        println("Vurture attack")
    }

    fun mineInstall(){
        println("mine install at $pos")
    }
}

class Tank: StarUnit() {
    override var speed: Int = 1
    override val health: Int = 30
    private var siegeMode: Boolean = false

    override fun move(newPos: Position) {
        if(siegeMode){
            println("Siegemode. Can't move")
        }else{
            println("Tank move")
        }
    }

    override fun attack(attackPos: Position) {
        if(siegeMode){
            println("Siegemode. Artillery fire.")
        }else{
            println("Tank nomal fire.")
        }
    }

    fun modeChange(){
        siegeMode = !siegeMode
    }
}