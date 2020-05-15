using UnityEngine;

namespace FactoryMethod
{
    public abstract class StarUnit
    {
        protected Vector3 pos = new Vector3();
        public abstract int Speed { get; }
        public abstract int Health { get; set; }

        public abstract void Move(Vector3 newPos);
        public abstract void Attack(Vector3 attackPos);
    }

    public class Vurture : StarUnit
    {
        private int _health = 10;
        private int _speed = 3;
        public override int Speed { get{ return _speed; } }
        public override int Health { get { return _health; } set { _health = value; } }

        public override void Attack(Vector3 attackPos)
        {
            Debug.Log("Vurture attack");
        }

        public override void Move(Vector3 newPos)
        {
            Debug.Log("Vurture move");
        }

        public void mineInstall()
        {
            Debug.Log("mine install at " + pos);
        }
    }

    public class Tank : StarUnit
    {
        private int _health = 30;
        private int _speed = 1;
        private bool _siege = false;

        public override int Speed { get { return _speed; } }
        public override int Health { get { return _health; } set { _speed = value; } }

        public override void Attack(Vector3 attackPos)
        {
            if (_siege)
            {
                Debug.Log("Siegemode. Artillery fire.");
            }
            else
            {
                Debug.Log("Tank normal fire.");
            }
        }

        public override void Move(Vector3 newPos)
        {
            if (_siege)
            {
                Debug.Log("Siegemode. Can't move.");
            }
            else
            {
                Debug.Log("Tank move.");
            }
        }

        public void modeChange()
        {
            _siege = !_siege;
        }
    }
}
