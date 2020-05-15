package decorator

interface IText{
    fun getHtml(): String;
}

class PlainText(argText: String): IText{
    private var text: String = argText

    override fun getHtml(): String {
        return text
    }

}