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

    val rangeToList = range.toList()

    // Loop over array indices / values
    val array = arrayOf(0, 3, 6, 9)
    for(i in array.indices){
        println("$i x 3 = ${array[i]}")
    }
    for((i, v) in array.withIndex()){
        println("($i, $v)")
    }

    // Collection operators
    val numList = 1..5

    println("Sum of list: ${numList.reduce{a, b -> a + b}}")
    println("Sum of list + 10: ${numList.fold(10){a, b -> a + b}}")
    println("List has any Even: ${numList.any{it % 2 == 0}}")
    println("List has only Even: ${numList.all{it % 2 == 0}}")

    val smallerThan4 = numList.filter { it < 4 }
    smallerThan4.forEach {num -> println("Values < 4: $num")}

    var newList = numList.map {num -> num * 2}  // 1..5 -> 2..10
    newList.forEach {num -> println("New value: $num")}

    // Mutable List
    var mutableList = mutableListOf(1, 2, 3, 4)
    mutableList.add(5)
    println("Mutable list: $mutableList, " +
            "first item: ${mutableList.first()}, " +
            "subList: ${mutableList.subList(0, 2)}")

    // (key, value) map
    var mutableMap = mutableMapOf(Pair(1, "hello"), Pair(2, "bye"))
    println("Map: $mutableMap, Map[1]: ${mutableMap[1]}, Map[3]: ${mutableMap[3] ?: "null"}")
    for ((i, v) in mutableMap){
        println("Iterate map: ($i, $v)")
    }
}