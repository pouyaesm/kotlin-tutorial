package tutorial

fun main(args: Array<String>){
  var blocks1 = Blocks(1)
  val blocks2 = Blocks (2)
  println("blocks1: $blocks1")
  println("++blocks1: ${++blocks1}")
  println("blocks1 ($blocks1) + blocks2 ($blocks2): ${blocks1 + blocks2}")
  println("blocks1 plus blocks2: ${blocks1 plus blocks2}")  // due to 'infix' identifier
}

class Blocks (var count: Int = 0){

  /**
   * Return count '#' as a symbol of blocks
   */
  override fun toString(): String {
    var string = ""
    (1..count).forEach {  string += "#" }
    return string
  }

  /**
   * Add two blocks (block1 + block2)
   * See the full list of available operators to overload
   * <a href="https://kotlinlang.org/docs/reference/operator-overloading.html">here</a>
   */
  infix operator fun plus(other: Blocks) : Blocks{
    val newBlocks = Blocks()
    newBlocks.count = this.count + other.count
    return newBlocks
  }

  /**
   * Increment a block (++block or block++)
   */
  operator fun inc() : Blocks{
    count++
    return this
  }
}