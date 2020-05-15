package factorymethod

data class Position(var x: Int = 0, var y: Int = 0, var z: Int = 0)
data class Size(var x: Int = 0, var y: Int = 0)
enum class FactoryUnit{VULTURE, TANK}