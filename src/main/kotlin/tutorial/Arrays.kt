package tutorial

fun main(args: Array<String>){
    val mixedArray = arrayOf(1, 3.14, "hello")

    // array access elements
    println("Element at 1: ${mixedArray[1]}")
    println("Index of 'hello': ${mixedArray.indexOf("hello")}")

    // copy array
    var arrayCopy = mixedArray.copyOfRange(1, 3)

    // construct array
    val squareArray = Array(5, {index -> index * index})
    println("square of 4: ${squareArray[4]}")

    // ranges
    val range = 1..10
    println("11 is in range: ${11 in range}")
    val skippedRange = range.step(3)
    for(v in skippedRange) println("skipped value: $v")

    // Loop over array indices / values
    val array = arrayOf(0, 3, 6, 9)
    for(i in array.indices){
        println("$i x 3 = ${array[i]}")
    }
    for((i, v) in array.withIndex()){
        println("($i, $v)")
    }
}