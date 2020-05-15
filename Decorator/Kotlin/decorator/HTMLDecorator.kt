package decorator

abstract class HTMLDecorator(textArg: IText): IText{
    private var textComponent: IText = textArg

    override fun getHtml(): String{
        return textComponent.getHtml()
    }
}

class BoldDecorator(textArg: IText): HTMLDecorator(textArg){
    override fun getHtml(): String {
        //return "<B>${super.getHtml()}</B>"
        return "<B>${super.getHtml()}</B>"
    }
}

class ItalicDecorator(textArg: IText): HTMLDecorator(textArg){
    override fun getHtml(): String {
        return "<I>${super.getHtml()}</I>"
    }
}