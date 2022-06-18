
package object pairSum {
  /**
   * Find whether there is an integer v1 in list l1 and an integer v2 in list l2
   * such that v1 + v2 == target.
   * If such a pair exists, return it [with "Some((v1,v2))"]; otherwise, return None.
   * This function is allowed to run in time O(l1.length * l2.length).
   */
  def hasPairSlow(l1: List[Int], l2: List[Int], target: Int): Option[(Int, Int)] = {
    var pair: Option[Pair[Int, Int]] = None 
    for (i <- l1) {
      for (j <- l2) {
        if (i + j == target) {
          pair = Option(i,j)
          return pair
        }
      }
    }
    pair
  }

  /**
   * A faster version of hasPairSlow, must run in time
   * O(l1.length*log(l1.length) + l2.length*log(l2.length)).
   * Find whether there is an integer v1 in list l1 and an integer v2 in list l2
   * such that v1 + v2 == target.
   * If such a pair exists, return it [with "Some(( v1,v2))"]; otherwise, return None.
   */
  def hasPair(l1: List[Int], l2: List[Int], target: Int): Option[(Int, Int)] = {
    var pair: Option[Pair[Int, Int]] = None
    var x = scala.collection.immutable.HashSet() ++ l2.toSet
    for (i <- l1) {
      if(x.contains(target-i)) {
        var y = x.find(i + _ == target)
        if(y.isDefined) {
          pair = Option(i, y.get)
          return pair
        }
      }
    }
    pair
  }

}


