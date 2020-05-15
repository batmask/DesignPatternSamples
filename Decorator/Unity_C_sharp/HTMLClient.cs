using UnityEngine;

namespace Decorator
{
    public class HTMLClient : MonoBehaviour
    {
        // Start is called before the first frame update
        void Start()
        {
            IText plainText = new PlainText("Decorator Pattern!");
            IText decoratedText = new ItalicDecorator(new BoldDecorator(plainText));

            Debug.Log(plainText.getHtml());
            Debug.Log(decoratedText.getHtml());
        }

    }

}
