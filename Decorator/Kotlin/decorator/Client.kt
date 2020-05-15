package decorator

fun main(args: Array<String>){
    val plainText: IText = PlainText("Decorator Pattern!")
    val decoratedText: IText = ItalicDecorator( BoldDecorator(plainText))
    println(plainText.getHtml())
    println(decoratedText.getHtml())
}