using System.Collections;
using System.Collections.Generic;
using UnityEngine;

namespace Decorator
{
    abstract class HTMLDecorator : IText
    {
        private IText textComponent;

        public HTMLDecorator(IText textObj)
        {
            textComponent = textObj;
        }

        public virtual string getHtml()
        {
            return textComponent.getHtml();
        }
    }

    class BoldDecorator : HTMLDecorator
    {
        public BoldDecorator(IText textObj) : base(textObj) { }

        public override string getHtml()
        {
            return "<B>" + base.getHtml() + "</B>";
        }

    }

    class ItalicDecorator : HTMLDecorator
    {
        public ItalicDecorator(IText textObj) : base(textObj) { }

        public override string getHtml()
        {
            return "<I>" + base.getHtml() + "</I>";
        }
    }
}


