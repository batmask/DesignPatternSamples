using System;
using System.Collections;
using System.Collections.Generic;
using UnityEngine;

namespace Observer
{
    public struct ObserverData
    {
        public int volume;
        public Color color1;
        public Color color2;

        public ObserverData(int vol, Color color1, Color color2)
        {
            this.volume = vol;
            this.color1 = color1;
            this.color2 = color2;
        }

    }

    public class GamePreference: IObservable<ObserverData>
    {
        private static readonly Lazy<GamePreference> lazy = new Lazy<GamePreference>(() => new GamePreference());

        private ObserverData _prefData;
        private List<IObserver<ObserverData>> observers;

        public ObserverData PrefData
        {
            get => _prefData;
            set
            {
                _prefData = value;
                PrefChangeNotify(_prefData);
            }
        }

        private GamePreference()
        {
            _prefData = new ObserverData(0, Color.white, Color.white);
            observers = new List<IObserver<ObserverData>>();
        }

        public static GamePreference Instance { get { return lazy.Value; } }

        public IDisposable Subscribe(IObserver<ObserverData> observer)
        {
            if (!observers.Contains(observer)) observers.Add(observer);
            return new Unsubscriber(observers, observer);
        }

        public void PrefChangeNotify(ObserverData data)
        {
            foreach(IObserver<ObserverData> observer in observers)
            {
                observer.OnNext(data);
            }
        }

        private class Unsubscriber: IDisposable
        {
            private List<IObserver<ObserverData>> _observers;
            private IObserver<ObserverData> _observer;

            public Unsubscriber(List<IObserver<ObserverData>> observers, IObserver<ObserverData> observer)
            {
                this._observers = observers;
                this._observer = observer;
            }

            public void Dispose()
            {
                if (_observer != null) _observers.Remove(_observer);
            }
        }
    }

}
