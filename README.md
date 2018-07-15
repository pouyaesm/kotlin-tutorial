### Introduction

This is a collection of short programming examples to learn Kotlin from basic to advanced.

---
### List

1. Hello world ([Go to code](src/main/kotlin/tutorial/HelloWorld.kt))
1. String manipulation ([Go to code](src/main/kotlin/tutorial/Strings.kt))
1. Variables ([Go to code](src/main/kotlin/tutorial/Variables.kt))
1. Null Safety ([Go to code](src/main/kotlin/tutorial/NullSafety.kt))
    * For example, type `String?` can be null but cannot be assigned to non-null type `String`.
1. Arrays ([Go to code](src/main/kotlin/tutorial/Arrays.kt))
1. Conditionals ([Go to code](src/main/kotlin/tutorial/Conditionals.kt))
1. Functions ([Go to code](src/main/kotlin/tutorial/Functions.kt))
1. Classes ([Go to code](src/main/kotlin/tutorial/Classes.kt))
1. `object` keyword: static members, singleton, anonymous class ([Go to code](src/main/kotlin/tutorial/ClassesObjectKeyword.kt))
1. Operator overload ([Go to code](src/main/kotlin/tutorial/OperatorOverload.kt))
    * Define '+' or '++' for custom objects
1. Java in Kotlin ([Go to code](src/main/kotlin/tutorial/JavaInKotlin.kt)), and Kotlin in Java ([Go to code](src/main/java/tutorial/KotlinInJava.java))
    * See the referenced [Java class](src/main/java/tutorial/Person.java) in  Kotlin, and [Kotlin file](src/main/kotlin/tutorial/KotlinInJava.kt) in Java.
1. Diverse tricks ([Go to code](src/main/kotlin/tutorial/Tricks.kt))
1. Deprecating code ([Go to code](src/main/kotlin/tutorial/Deprecation.kt))
    * It is possible to deprecate a function in multiple levels, and defining an automated code for replacement.
1. Using co-routines, comparing co-routines with threads ([Go to code](src/main/kotlin/tutorial/CoroutinesThreads.kt))
    * Kotlin CoRoutines are very light-weight compared to java Thread.
1. Domain Specific Language (DSL) style programming using higher-order functions ([Go to code](src/main/kotlin/tutorial/DomainSpecificLanguages.kt))
1. Class property delegation ([Go to code](src/main/kotlin/tutorial/ClassPropertyDelegates.kt))
    * This is used to intercept the setting / getting of a class property
1. Using `Let` when there is concurrency ([Go to code](src/main/kotlin/tutorial/Let.kt))
    * Uses a local copy to ensure that a variable will not be null inside a block
 
---
### References

1. [Kotlin Tutorial - Derek Banas](https://www.youtube.com/watch?v=H_oGi8uuDpA&t=2432s)
1. [10 Kotlin Tricks in 10 ish minutes by Jake Wharton](https://www.youtube.com/watch?v=0sPzDwS55wM&t=269s)
1. [Kotlin 102 - Beyond the basics by Hadi Hariri](https://www.youtube.com/watch?v=a7QpoMj2uIA)
1. [Kotlin Tutorial - Telusko Learnings](https://www.youtube.com/watch?v=Org0vh-VSgA&list=PLsyeobzWxl7rooJFZhc3qPLwVROovGCfh&index=2&t=6s)
1. [KotlinConf 2017 - Introduction to Coroutines by Roman Elizarov](https://www.youtube.com/watch?v=_hfBv0a09Jc&t=4s)