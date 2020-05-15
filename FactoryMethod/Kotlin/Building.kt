package factorymethod

abstract  class Building{
    abstract fun factoryMethod(type: FactoryUnit): StarUnit
}

class Factory: Building() {
    override fun factoryMethod(type: FactoryUnit): StarUnit {
        when(type){
            FactoryUnit.TANK    ->  return Tank()
            FactoryUnit.VULTURE ->  return Vurture()
            else -> throw Exception("Can't produce $type unit.")
        }
    }
}