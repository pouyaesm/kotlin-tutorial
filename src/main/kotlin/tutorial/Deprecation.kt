package tutorial

fun main(args: Array<String>){
  // Not found (but compilable)
//  noMoreUse()
  // Raises error
//  seeButNoMoreUse()
  // Raises IDE warning
  betterNotToUse()
}

@Deprecated("Use useThis()", level = DeprecationLevel.HIDDEN)
fun noMoreUse() = println("Function is usable, but not visible to IDE any more")

@Deprecated("Use useThis()", level = DeprecationLevel.ERROR,
        replaceWith = ReplaceWith("useThis()"))
fun seeButNoMoreUse() = println("Usage raises error")

@Deprecated("Use useThis().", level = DeprecationLevel.WARNING,
        replaceWith = ReplaceWith("useThis()"))
fun betterNotToUse() = println("Better not to use this function")

fun useThis() = println("Use this")