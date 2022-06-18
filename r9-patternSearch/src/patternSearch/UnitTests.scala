
package patternSearch

import org.junit.Test
import org.junit.Assert._

class UnitTests {
  @Test def testN123() {
    assertEquals("TestN123() failed", (0, 11), search("", "mississippi", Vector(10, 7, 4, 1, 0, 9, 8, 6, 3, 5, 2)))
    }
  @Test def testN124() {
    assertEquals("testN124() failed", (0,4), search("i","mississippi",Vector(10, 7, 4, 1, 0, 9, 8, 6, 3, 5, 2)))
  }
  @Test def testN125() {
    assertEquals("testN125() failed", (4,5), search("m","mississippi",Vector(10, 7, 4, 1, 0, 9, 8, 6, 3, 5, 2)))
  }
  @Test def testN126() {
    assertEquals("testN126() failed", (7,11), search("s","mississippi",Vector(10, 7, 4, 1, 0, 9, 8, 6, 3, 5, 2)))
  }
  @Test def testN127() {
    assertEquals("testN127() failed", (5,7),search("p","mississippi",Vector(10, 7, 4, 1, 0, 9, 8, 6, 3, 5, 2)))
  }
  @Test def testN128() {
    assertTrue("testN128() failed, values not equal when pattern doesn't occur", { val (a,b) = search("a","mississippi",Vector(10, 7, 4, 1, 0, 9, 8, 6, 3, 5, 2));  a == b } )
  }
  @Test def testN129() {
    assertTrue("testN129() failed, values not equal when pattern doesn't occur", { val (a,b) = search("q","mississippi",Vector(10, 7, 4, 1, 0, 9, 8, 6, 3, 5, 2));  a == b } )
  }
  @Test def testN130() {
    assertTrue("testN130() failed, values not equal when pattern doesn't occur", { val (a,b) = search("z","mississippi",Vector(10, 7, 4, 1, 0, 9, 8, 6, 3, 5, 2));  a == b } )
  }
  @Test def testN131() {
    assertTrue("testN131() failed, values not equal when pattern doesn't occur", { val (a,b) = search("sisss","mississippi",Vector(10, 7, 4, 1, 0, 9, 8, 6, 3, 5, 2));  a == b } )
  }
  @Test def testN132() {
    assertTrue("testN132() failed, values not equal when pattern doesn't occur", { val (a,b) = search("isis","mississippi",Vector(10, 7, 4, 1, 0, 9, 8, 6, 3, 5, 2));  a == b } )
  }
  @Test def testN133() {
    assertEquals("testN133() failed", (2,4), search("issi","mississippi",Vector(10, 7, 4, 1, 0, 9, 8, 6, 3, 5, 2)))
  }
  @Test def testN134() {
    assertEquals("testN134() failed", (4,5), search("mississippi","mississippi",Vector(10, 7, 4, 1, 0, 9, 8, 6, 3, 5, 2)))
  }
  @Test def testN135() {
    assertTrue("testN135() failed, values not equal when pattern doesn't occur", { val (a,b) = search("mississippiz","mississippi",Vector(10, 7, 4, 1, 0, 9, 8, 6, 3, 5, 2));  a == b } )
  }
  @Test def testN136() {
    assertTrue("testN136() failed, values not equal when pattern doesn't occur", { val (a,b) = search("mississippiz","mississippi",Vector(10, 7, 4, 1, 0, 9, 8, 6, 3, 5, 2));  a == b } )
  }
}

