package tutorial

fun main(args: Array<String>){
  // this gives error since a value cannot be null by default
  // That is, 'nullable String' is a different type than 'String'
//    var value : String = null
  var nullableValue : String? = null
  fun returnNull() : String? {return null}

  var value: String = "a"
  // This gives error since value cannot be null
  // value = returnNull()
  var valueWithDefault : String = returnNull() ?: "No Name"
  println("valueWithDefault: $valueWithDefault")
}