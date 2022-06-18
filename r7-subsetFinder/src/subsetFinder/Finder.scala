
package subsetFinder

import scala.collection.immutable.Set

object Finder {
  /**
   * Find one "important" element in the domain of the tester.
   * If the domain contains no important elements, return None.
   * Use binary search to implement this.
   * Sets can be split with splitAt method (see http://www.scala-lang.org/api/current/index.html#scala.collection.immutable.Set).
   * Must make at most ceil(log(tester.domain)*2)+1 calls to tester.contains.
   */
  def findOne[T](tester: Tester[T]): Option[T] = {
    
    def search(set: Set[T]): T = {
      if(set.size == 1) set.head
      else { 
        var (a,b) = set.splitAt(set.size / 2)
        if(tester.contains(a)) search(a)
        else search(b)
        }
       }
    
    if(!tester.contains(tester.domain)) None
    else Option(search(tester.domain))
    
  }
 
  /**
   * Find all the k "important" elements in the domain of the tester
   * (the value k is not known in advance!).
   * If the domain contains no important elements, return an empty set.
   * Use binary search to implement this.
   * Must make at most k*ceil(log(tester.domain)*2)+1 calls to tester.contains.
   */
  def findAll[T](tester: Tester[T]): Set[T] = {
    
    var all: Set[T] = tester.domain
    var importants: Set[T] = Set()
    
    def search(set: Set[T]): T = {
      if(set.size == 1) set.head
      else { 
        var (a,b) = set.splitAt(set.size / 2)
        if(tester.contains(a)) search(a)
        else search(b)
        }
       }
        
    while(tester.contains(all)) {
      val x = search(all)
      importants  += x
      all  -= x
    }
    importants
  }
  
}

