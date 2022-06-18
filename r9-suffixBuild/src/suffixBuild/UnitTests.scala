
package suffixBuild

import org.junit.Test
import org.junit.Assert._

class UnitTests {
  @Test def testN123() {
    assertEquals("testN123() failed", suffixArray("alpakkajakkasakkavakkanakka"), Vector(26, 6, 23, 3, 18, 8, 13, 0, 21, 11, 16, 7, 25, 5, 20, 10, 15, 24, 4, 19, 9, 14, 1, 22, 2, 12, 17))
  }
  @Test def testN124() {
    assertEquals("testN124() failed", suffixArray("donau"), Vector(3, 0, 2, 1, 4))
  }
  @Test def testN125() {
    assertEquals("testN125() failed", suffixArray("nilenil"), Vector(3, 5, 1, 6, 2, 4, 0))
  }
  @Test def testN126() {
    assertEquals("testN126() failed", suffixArray("danube"), Vector(1, 4, 0, 5, 2, 3))
  }
  @Test def testN127() {
    assertEquals("testN127() failed", suffixArray("aavankaavanjaavanlaavanhaavan"), Vector(24, 18, 6, 0, 12, 27, 21, 9, 3, 15, 25, 19, 7, 1, 13, 23, 11, 5, 17, 28, 22, 10, 4, 16, 26, 20, 8, 2, 14))
  }
  @Test def testN128() {
    assertEquals("testN128() failed", suffixArray("xyzw"), Vector(3, 0, 1, 2))
  }
  @Test def testN129() {
    assertEquals("testN129() failed", suffixArray("abracadabra"), Vector(10, 7, 0, 3, 5, 8, 1, 4, 6, 9, 2))
  }
  @Test def testN130() {
    assertEquals("testN130() failed", suffixArray("foobar"), Vector(4, 3, 0, 2, 1, 5))
  }
  @Test def testN131() {
    assertEquals("testN131() failed", suffixArray("mississippi"), Vector(10, 7, 4, 1, 0, 9, 8, 6, 3, 5, 2))
  }
  @Test def testN132() {
    assertEquals("testN132() failed", suffixArray(""), Vector[Int]())
  }
}


