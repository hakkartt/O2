
package object patternSearch {
  
  import scala.collection.mutable.Buffer
  
  def search(s1: String, s2: String, s3: Seq[Int]): (Int, Int) = {
   if (s1 == "") { return (0, s2.length)}
    var buf = Buffer[String]()
    s3.foreach(x => buf += s2.substring(x))
    var a = 0
    var b = buf.length - 1
    var c = (a + b) / 2
    var d = a
    while (c != a && buf(a).take(s1.length()) != s1) {
      if (buf(c) < s1) { a = c} 
      else { b = c }
      c = (b + a)/2
    }      
    if (buf(a).take(s1.length()) != s1) {a = a + 1}
    d = a
    a = 0
    b = buf.length - 1
    c = (a + b) / 2  
    while ((b - c) > 1 && buf(b).take(s1.length()) != s1) {
      if (buf(c) > s1) {
        b = c
      } else {
        a = c
      }
      c = (b + a)/2
    }
    try {
      if (buf(b + 1).take(s1.length()) == s1) {b = b + 2}
    } catch {
      case index: java.lang.IndexOutOfBoundsException => b = b + 1
    } finally { }
    if (buf(d).take(s1.length()) != s1) {
      return ((-1, -1))
    }
    (d, b)
    
  }
}


