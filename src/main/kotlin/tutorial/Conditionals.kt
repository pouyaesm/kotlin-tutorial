package tutorial

import java.util.*

fun main(args: Array<String>){
    // Using when() switch case
    val ages = 1..20
    for(age in ages) {
        print("Age $age: ")
        when (age) {
            0, 1, 2, 3, 4 -> println("Go to Preschool")
            5 -> println("Go to kindergarten")
            in 6..17 -> {
                val grade = age - 5
                println("Go to Grade $grade")
            }
            else -> println("Go to college")
        }
    }

    // Using java libraries
    val rand = Random()
    println("rand (1, 50): ${rand.nextInt(50) + 1}")
}