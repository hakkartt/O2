
package pairSum

import org.junit.Test
import org.junit.Assert._
import util.Random

/**
 * Some simple unit tests for hasPairSlow and hasPair.
 */
class UnitTests {
    def randArr(len: Int, range: Int): List[Int] =
    	List.fill(len)(Random.nextInt(range))

    val l1 = List(11, -30, 12, 7)
    val l2 = List(12, -2, 101)

  @Test def testSlowTrue() {
    assertEquals("did not find solution", Some((12,-2)), hasPairSlow(l1, l2, 10))
  }
  @Test def testSlowFalse() {
    assertEquals("found a bad solution", None, hasPairSlow(l1, l2, 11))
  }
  @Test def testFastTrue() {
    assertEquals("did not find solution", Some((12,-2)), hasPair(l1, l2, 10))
  }
  @Test def testFastFalse() {
    assertEquals("found a bad solution", None, hasPair(l1, l2, 11))
  }
  @Test def testFastEfficiency() {
    /* This test should finish in a bit less than a second in a good desktop machine with 3.1GHz CPU or similar */
    val n = 100000
    val r = 100
    val ll1 = randArr(n, r) ++ List(-1) ++ randArr(n, r)
    val ll2 = randArr(n, r) ++ List(-1) ++ randArr(n, r)
    assertEquals("did not find solution", Some(-1, -1), hasPair(ll1, ll2, -2))
  }
}


