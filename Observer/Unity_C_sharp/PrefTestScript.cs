using System.Collections;
using System.Collections.Generic;
using UnityEngine;

namespace Observer
{
    public class PrefTestScript : MonoBehaviour
    {
        private List<ObserverData> sample = new List<ObserverData>();
        private int index = 0;
        // Start is called before the first frame update
        void Start()
        {
            sample.Add(new ObserverData(30, Color.green, Color.cyan));
            sample.Add(new ObserverData(100, Color.gray, Color.magenta));
            sample.Add(new ObserverData(10, Color.yellow, Color.magenta));
        }

        // Update is called once per frame
        void Update()
        {
            if (Input.GetKeyDown(KeyCode.Space))
            {
                if(index < sample.Count)
                {
                    GamePreference.Instance.PrefData = sample[index];
                    index++;
                }
            }
        }

    }

}
