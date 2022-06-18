import scala.collection.mutable.Buffer
package object bwt {
  def transform(s: String): String = {
    var i = s.takeWhile(_ != '|') + "|"
    var j = Buffer[String]()
    var y = 0
    while(y < i.length) {
      j.append(i)
      i = f1(i)
      y += 1
    }
    j = j.sorted
    var r = new StringBuilder(i.length())
    j.foreach(x => r+(x(i.length() - 1)))
    r.toString()
  }

  def inverse(s: String): String = {
    var a: Buffer[Buffer[Char]] = Buffer()
    s.foreach( x => a.append( Buffer[Char]() ))
    for (i <- 0 until s.length()) {
      for (i <- 0 until s.length()) {
        a(i).prepend(s(i))
      }
      a = f2(a)
    }
    val b = a.find( x => x(s.length() - 1) == '|').get    
    val r = new StringBuilder(s.length())
    b.foreach( x => r.append(x)).toString()
    r.toString()
  }
  
  def f1(s: String): String = {
    return s.drop(1) + s(0)
  }
  
  def f2(a: Buffer[Buffer[Char]]): Buffer[Buffer[Char]] = {
    return a.sortBy( _(0))
  }
}

