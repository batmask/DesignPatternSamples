package factorymethod

fun main(args: Array<String>){
    val factory:Building = Factory()

    val unit1: StarUnit = factory.factoryMethod(FactoryUnit.VULTURE)
    val unit2: StarUnit =  factory.factoryMethod(FactoryUnit.VULTURE)
    val unit3: StarUnit = factory.factoryMethod(FactoryUnit.TANK)

    unit1.move(Position(10, 5, 15))
    unit2.attack(Position(3, 20, 4))
    unit3.move(Position(7, 7, 4))
    unit3.attack(Position(10, 20, 30))
}