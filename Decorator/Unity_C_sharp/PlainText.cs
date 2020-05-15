
namespace Decorator
{
    interface IText
    {
        string getHtml();
    }

    public class PlainText : IText
    {
        private string text;

        public PlainText(string argText)
        {
            text = argText;
        }

        public string getHtml()
        {
            return text;
        }
    }

}
