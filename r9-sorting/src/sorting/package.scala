
package object sorting {
  
  import scala.collection.mutable.Buffer
  // Returns a sorted copy of the array d
  def radixSortDirectImmutable(d: Array[Int]): Array[Int] = {
    val n = d.length
    val m = d.foldLeft(0)(_ max _)+1
    require(d.forall(_ >= 0) && m <= n)
    var a = d.groupBy(a => a)
    var b = (0 until m).toArray.map(x => a.getOrElse(x,Array()).length)
    var array1: Array[Int] = Array.ofDim(m)
    var y = 0
    while (y < m) {
      if (y != 0) {
        array1(y) = array1(y-1) + b(y-1)
      }
      y += 1
    }
    var array2: Array[Int] = Array.ofDim(n)
    
    y = 0
    while (y < m) {
      if (y < array1.length - 1) {
        (array1(y) until array1(y + 1)).foreach(x => array2(x) = y)
      } else {
        (array1(y) until array2.length).foreach(x => array2(x) = y)
      }
      y += 1
    }
    array2
  }
  
  // Sorts the array d
  def radixSortDirectMutable(d: Array[Int]) {
    val n = d.length
    val m = d.foldLeft(0)(_ max _)+1
    require(d.forall(_ >= 0) && m <= n)
    ???
  }

  // Returns a permutation that is a ranking of d
  def radixSortIndirect(d: Array[Int]): Array[Int] = {
    val n = d.length
    val m = d.foldLeft(0)(_ max _)+1
    require(d.forall(_ >= 0) && m <= n)
    val a = d.zipWithIndex
    val b = Buffer[Int]()
    var c = 0
    while (c < m) {
      a.filter( _._1 == c).map( _._2 ).foreach( b.append(_) )
      c += 1
    }
    b.toArray
  }
  
  // Returns a permutation that is a stable ranking of d
  def radixSortIndirectStable(d: Array[Int]): Array[Int] = {
    val n = d.length
    val m = d.foldLeft(0)(_ max _)+1
    require(d.forall(_ >= 0) && m <= n)
    val a = d.zipWithIndex
    val b = Buffer[Int]()
    var c = 0
    while(c < m) {
      a.filter( _._1 == c).map( _._2 ).foreach( b.append(_) )
      c += 1
    }
    b.toArray
  }
  
  // Returns a permutation that unranks d 
  def radixSortUnrankPerm(d: Array[Int]): Array[Int] = {
    val n = d.length
    val m = d.foldLeft(0)(_ max _)+1
    require(d.forall(_ >= 0) && m <= n)
    ???    
  }
  
  // Returns a cell unrank array for d
  def radixSortCellUnrankArray(d: Array[Int]): Array[Int] = {
    val n = d.length
    val m = d.foldLeft(0)(_ max _)+1
    require(d.forall(_ >= 0) && m <= n)
    ???    
  }
}

