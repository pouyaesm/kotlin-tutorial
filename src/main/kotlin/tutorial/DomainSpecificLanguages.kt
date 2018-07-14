package tutorial

/**
 * DSLs are built using
 * Lambdas With Receivers (LWR) that are higher-order functions that
 * receive extension function (of classes)
 * LWR is invented in kotlin for the first time (Hadi Hariri @ Devoxx - Kotlin 102)
 * Example: gradle, Groovy html builder
 */
fun main(args: Array<String>){
  // {..} in 'html {..}' or  'html ({..})'
  // is the input 'f' function of html: html(f)
  // In 'html' definition '{..}', the members' of HTML class
  // are accessible since 'f' is the extension function of HTML
  val html = HTML()
  html {
    head {
      title = "Creating DSL"
      imports = listOf("script1.js", "script2.js", "theme.css")
    }
    body {
      content = "This is the procedure of doing so."
    }
  }
  println(html)
}

class Head(var title : String = "", var imports : List<String> = emptyList()){
  /**
   * Lambda with receiver (LWR)
   * Head.invoke(f) <=> head(f) <=> f()
   * If '()' is used instead of 'Head.()'
   * Head members (title and imports) are not accessible inside 'f'
   */
  operator fun invoke(f: Head.() -> Unit) = f()
}

class Body(var content : String = ""){
  operator fun invoke(f: Body.() -> Unit) = f()
}
class HTML(var head : Head = Head(), var body : Body = Body()){
  operator fun invoke(f: HTML.() -> Unit) = f()
  override fun toString(): String {
    return """|begin
      | ${head.title}
      | ${head.imports}
      | ${body.content}
      |end""".trimMargin()
  }
}