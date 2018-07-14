package tutorial

fun main(args: Array<String>){
    val sentence = "This is a sentence"

    println("String: $sentence")
    println("String[0, 4]: ${sentence.subSequence(0, 4)}")
    println("Char at 3: ${sentence[3]}")
    println("Contains 'is': ${sentence.contains("is")}")
}