
namespace FactoryMethod
{
    public enum FactoryUnit { VURTURE, TANK }

    public abstract class Building
    {
        public abstract StarUnit FactoryMethod(FactoryUnit type);
    }

    public class Factory : Building
    {
        public override StarUnit FactoryMethod(FactoryUnit type)
        {
            switch (type)
            {
                case FactoryUnit.TANK:
                    return new Tank();
                case FactoryUnit.VURTURE:
                    return new Vurture();
                default:
                    throw new System.Exception();
            }
        }
    }
}
