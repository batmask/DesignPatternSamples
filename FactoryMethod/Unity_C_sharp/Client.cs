using UnityEngine;
using FactoryMethod;

public class HTMLClient : MonoBehaviour
{
    // Start is called before the first frame update
    void Start()
    {
        Building factory = new Factory();

        StarUnit unit1 = factory.FactoryMethod(FactoryUnit.VURTURE);
        StarUnit unit2 = factory.FactoryMethod(FactoryUnit.VURTURE);
        StarUnit unit3 = factory.FactoryMethod(FactoryUnit.TANK);

        unit1.Move(new Vector3(10, 5, 15));
        unit2.Attack(new Vector3(3, 20, 4));
        unit3.Move(new Vector3(7, 7, 4));
        unit3.Attack(new Vector3(10, 20, 30));
    }

}
