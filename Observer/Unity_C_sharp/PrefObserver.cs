using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

namespace Observer
{
    public class PrefObserver : MonoBehaviour, IObserver<ObserverData>
    {
        private IDisposable unsubscriber;

        public virtual void Subscribe(IObservable<ObserverData> provider)
        {
            unsubscriber = provider.Subscribe(this);
        }

        public virtual void Unsubscribe()
        {
            unsubscriber.Dispose();
        }

        public void OnCompleted()
        {
            // Not used here
            Debug.Log("Observable data transfer complete.");
        }

        public void OnError(Exception error)
        {
            // Not used here
            Debug.Log("Observable data transfer error.");
        }

        public void OnNext(ObserverData data)
        {
            Debug.Log(gameObject.name + ":" + data.volume + ", " + data.color1 + ", " + data.color2);
        }

        private void OnEnable()
        {
            GamePreference pref = GamePreference.Instance;
            unsubscriber = pref.Subscribe(this);
        }
        private void OnDisable()
        {
            if (unsubscriber != null) unsubscriber.Dispose();
        }

    }

}
