package tutorial

fun main(args: Array<String>){
  println("Hello, world!")
}

/**
 * data is read once at the beginning
 * and is put into a local variable thus will not be set to null
 * by other threads
 * conventionally when checking if(user != null) {code}
 * user may become null by other threads during the execution of code
 * See also: apply, run, also
 */
fun calculate(data :  Data?){
  data?.let { d -> println(d.name)}
  fun subCalculate(data : Data?) : Data? {
    data?.name = "calculated"
    return data
  }
  // The same can be done for the returned value of a function
  subCalculate(data)?.let { d : Data? -> println(d?.name) }
}

class Data (var name : String?)