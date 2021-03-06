
package sorting

import org.junit.Test
import org.junit.Assert._

class UnitTests {

  def arrayEq(a: Array[Int], b: Array[Int]) = a.length == b.length && (a zip b).forall(x => x._1 == x._2)

  def checkPerm(p: Array[Int]) = {
    val n = p.length
    p.forall(j => (j >= 0) && (j < n)) &&
    { val b = new Array[Boolean](n); p.map(j => b(j) = true); b.forall(z => z) }
  }

  def checkRank(d: Array[Int], r: Array[Int]) =
    checkPerm(r) && d.length == r.length && (1 until d.length).forall(j => d(r(j-1)) <= d(r(j)))

  def checkUnrankArray(d: Array[Int], r: Array[Int], c: Array[Int]) =
    checkRank(d,r) && c.length == d.length && c.forall(j => (j >= 0) && (j < d.length)) && (1 until d.length).forall(j => (d(r(j-1)) != d(r(j))) || c(d(r(j-1))) == c(d(r(j))))

  def getInv(r: Array[Int]) = {
    val u = new Array[Int](r.length)
    (0 until r.length).foreach(j => u(r(j)) = j)
    u
  }

  @Test def testN123() {
    assertEquals("testN123() failed", Array(0).toSeq, radixSortIndirectStable(Array(0)).toSeq)
  }
  @Test def testN124() {
    assertEquals("testN124() failed", Array(0,1).toSeq, radixSortIndirectStable(Array(0,0)).toSeq)
  }
  @Test def testN125() {
    assertEquals("testN125() failed", Array(0,1,2).toSeq, radixSortIndirectStable(Array(0,0,0)).toSeq)
  }
  @Test def testN126() {
    assertEquals("testN126() failed", Array(0,1,2,3).toSeq, radixSortIndirectStable(Array(0,0,0,0)).toSeq)
  }
  @Test def testN127() {
    assertEquals("testN127() failed", Array(0,1,2,3,4).toSeq, radixSortIndirectStable(Array(0,0,0,0,0)).toSeq)
  }
  @Test def testN128() {
    assertEquals("testN128() failed", Array(0,1,2,3,4,5).toSeq, radixSortIndirectStable(Array(0,0,0,0,0,0)).toSeq)
  }
  @Test def testN129() {
    assertEquals("testN129() failed", Array(0,1,2,3,4,5,6).toSeq, radixSortIndirectStable(Array(0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN130() {
    assertEquals("testN130() failed", Array(0,1,2,3,4,5,6,7).toSeq, radixSortIndirectStable(Array(0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN131() {
    assertEquals("testN131() failed", Array(0,1,2,3,4,5,6,7,8).toSeq, radixSortIndirectStable(Array(0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN132() {
    assertEquals("testN132() failed", Array(0,1,2,3,4,5,6,7,8,9).toSeq, radixSortIndirectStable(Array(0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN133() {
    assertEquals("testN133() failed", Array(0,1,2,3,4,5,6,7,8,9,10).toSeq, radixSortIndirectStable(Array(0,0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN134() {
    assertEquals("testN134() failed", Array(0,1,2,3,4,5,6,7,8,9,10,11).toSeq, radixSortIndirectStable(Array(0,0,0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN135() {
    assertEquals("testN135() failed", Array(0,1,2,3,4,5,6,7,8,9,10,11,12).toSeq, radixSortIndirectStable(Array(0,0,0,0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN136() {
    assertEquals("testN136() failed", Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13).toSeq, radixSortIndirectStable(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN137() {
    assertEquals("testN137() failed", Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14).toSeq, radixSortIndirectStable(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN138() {
    assertEquals("testN138() failed", Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15).toSeq, radixSortIndirectStable(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN139() {
    assertEquals("testN139() failed", Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16).toSeq, radixSortIndirectStable(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN140() {
    assertEquals("testN140() failed", Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17).toSeq, radixSortIndirectStable(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN141() {
    assertEquals("testN141() failed", Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18).toSeq, radixSortIndirectStable(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN142() {
    assertEquals("testN142() failed", Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19).toSeq, radixSortIndirectStable(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN143() {
    assertEquals("testN143() failed", Array(0,1).toSeq, radixSortIndirectStable(Array(0,0)).toSeq)
  }
  @Test def testN144() {
    assertEquals("testN144() failed", Array(2,0,1).toSeq, radixSortIndirectStable(Array(1,1,0)).toSeq)
  }
  @Test def testN145() {
    assertEquals("testN145() failed", Array(0,2,3,1).toSeq, radixSortIndirectStable(Array(0,1,0,0)).toSeq)
  }
  @Test def testN146() {
    assertEquals("testN146() failed", Array(0,2,4,1,3).toSeq, radixSortIndirectStable(Array(0,1,0,1,0)).toSeq)
  }
  @Test def testN147() {
    assertEquals("testN147() failed", Array(0,1,2,3,4,5).toSeq, radixSortIndirectStable(Array(0,0,0,0,0,1)).toSeq)
  }
  @Test def testN148() {
    assertEquals("testN148() failed", Array(0,5,1,2,3,4,6).toSeq, radixSortIndirectStable(Array(0,1,1,1,1,0,1)).toSeq)
  }
  @Test def testN149() {
    assertEquals("testN149() failed", Array(0,2,4,5,1,3,6,7).toSeq, radixSortIndirectStable(Array(0,1,0,1,0,0,1,1)).toSeq)
  }
  @Test def testN150() {
    assertEquals("testN150() failed", Array(2,3,7,8,0,1,4,5,6).toSeq, radixSortIndirectStable(Array(1,1,0,0,1,1,1,0,0)).toSeq)
  }
  @Test def testN151() {
    assertEquals("testN151() failed", Array(5,8,9,0,1,2,3,4,6,7).toSeq, radixSortIndirectStable(Array(1,1,1,1,1,0,1,1,0,0)).toSeq)
  }
  @Test def testN152() {
    assertEquals("testN152() failed", Array(2,3,4,7,10,0,1,5,6,8,9).toSeq, radixSortIndirectStable(Array(1,1,0,0,0,1,1,0,1,1,0)).toSeq)
  }
  @Test def testN153() {
    assertEquals("testN153() failed", Array(3,4,6,10,0,1,2,5,7,8,9,11).toSeq, radixSortIndirectStable(Array(1,1,1,0,0,1,0,1,1,1,0,1)).toSeq)
  }
  @Test def testN154() {
    assertEquals("testN154() failed", Array(0,1,2,9,12,3,4,5,6,7,8,10,11).toSeq, radixSortIndirectStable(Array(0,0,0,1,1,1,1,1,1,0,1,1,0)).toSeq)
  }
  @Test def testN155() {
    assertEquals("testN155() failed", Array(2,5,6,7,11,12,13,0,1,3,4,8,9,10).toSeq, radixSortIndirectStable(Array(1,1,0,1,1,0,0,0,1,1,1,0,0,0)).toSeq)
  }
  @Test def testN156() {
    assertEquals("testN156() failed", Array(0,1,5,7,10,12,13,2,3,4,6,8,9,11,14).toSeq, radixSortIndirectStable(Array(0,0,1,1,1,0,1,0,1,1,0,1,0,0,1)).toSeq)
  }
  @Test def testN157() {
    assertEquals("testN157() failed", Array(4,5,6,9,11,13,15,0,1,2,3,7,8,10,12,14).toSeq, radixSortIndirectStable(Array(1,1,1,1,0,0,0,1,1,0,1,0,1,0,1,0)).toSeq)
  }
  @Test def testN158() {
    assertEquals("testN158() failed", Array(1,5,6,7,9,12,13,14,15,0,2,3,4,8,10,11,16).toSeq, radixSortIndirectStable(Array(1,0,1,1,1,0,0,0,1,0,1,1,0,0,0,0,1)).toSeq)
  }
  @Test def testN159() {
    assertEquals("testN159() failed", Array(2,3,4,5,6,7,10,11,12,0,1,8,9,13,14,15,16,17).toSeq, radixSortIndirectStable(Array(1,1,0,0,0,0,0,0,1,1,0,0,0,1,1,1,1,1)).toSeq)
  }
  @Test def testN160() {
    assertEquals("testN160() failed", Array(3,4,5,9,11,12,15,16,17,0,1,2,6,7,8,10,13,14,18).toSeq, radixSortIndirectStable(Array(1,1,1,0,0,0,1,1,1,0,1,0,0,1,1,0,0,0,1)).toSeq)
  }
  @Test def testN161() {
    assertEquals("testN161() failed", Array(0,1,3,5,6,8,11,15,17,2,4,7,9,10,12,13,14,16,18,19).toSeq, radixSortIndirectStable(Array(0,0,1,0,1,0,0,1,0,1,1,0,1,1,1,0,1,0,1,1)).toSeq)
  }
  @Test def testN162() {
    assertEquals("testN162() failed", Array(0).toSeq, radixSortIndirectStable(Array(0)).toSeq)
  }
  @Test def testN163() {
    assertEquals("testN163() failed", Array(0,1).toSeq, radixSortIndirectStable(Array(0,1)).toSeq)
  }
  @Test def testN164() {
    assertEquals("testN164() failed", Array(1,2,0).toSeq, radixSortIndirectStable(Array(2,0,1)).toSeq)
  }
  @Test def testN165() {
    assertEquals("testN165() failed", Array(2,0,3,1).toSeq, radixSortIndirectStable(Array(1,3,0,2)).toSeq)
  }
  @Test def testN166() {
    assertEquals("testN166() failed", Array(1,2,0,4,3).toSeq, radixSortIndirectStable(Array(2,1,1,4,3)).toSeq)
  }
  @Test def testN167() {
    assertEquals("testN167() failed", Array(0,1,2,4,3,5).toSeq, radixSortIndirectStable(Array(0,0,0,2,0,2)).toSeq)
  }
  @Test def testN168() {
    assertEquals("testN168() failed", Array(6,5,3,2,0,4,1).toSeq, radixSortIndirectStable(Array(5,6,4,3,5,2,1)).toSeq)
  }
  @Test def testN169() {
    assertEquals("testN169() failed", Array(4,6,0,3,1,7,5,2).toSeq, radixSortIndirectStable(Array(2,3,7,2,0,6,0,4)).toSeq)
  }
  @Test def testN170() {
    assertEquals("testN170() failed", Array(8,2,5,4,1,0,3,7,6).toSeq, radixSortIndirectStable(Array(7,6,2,7,4,3,8,7,0)).toSeq)
  }
  @Test def testN171() {
    assertEquals("testN171() failed", Array(5,7,1,3,9,4,2,0,8,6).toSeq, radixSortIndirectStable(Array(7,2,6,2,4,0,9,1,7,2)).toSeq)
  }
  @Test def testN172() {
    assertEquals("testN172() failed", Array(10,0,9,1,2,8,6,3,4,5,7).toSeq, radixSortIndirectStable(Array(1,2,4,8,8,8,6,10,4,1,0)).toSeq)
  }
  @Test def testN173() {
    assertEquals("testN173() failed", Array(8,4,10,5,6,7,9,11,1,0,3,2).toSeq, radixSortIndirectStable(Array(8,7,11,9,1,2,2,2,0,3,1,6)).toSeq)
  }
  @Test def testN174() {
    assertEquals("testN174() failed", Array(3,9,11,4,1,2,7,10,12,5,6,8,0).toSeq, radixSortIndirectStable(Array(10,4,6,1,3,9,9,6,9,1,7,1,8)).toSeq)
  }
  @Test def testN175() {
    assertEquals("testN175() failed", Array(5,11,6,10,7,12,13,1,0,8,4,9,2,3).toSeq, radixSortIndirectStable(Array(8,7,13,13,11,0,2,5,9,12,3,0,6,6)).toSeq)
  }
  @Test def testN176() {
    assertEquals("testN176() failed", Array(8,14,9,4,1,12,0,7,11,2,3,10,13,5,6).toSeq, radixSortIndirectStable(Array(5,4,9,9,3,14,14,5,0,2,11,8,4,11,1)).toSeq)
  }
  @Test def testN177() {
    assertEquals("testN177() failed", Array(0,1,2,13,4,5,11,6,9,14,3,7,8,10,12,15).toSeq, radixSortIndirectStable(Array(0,0,0,13,3,6,9,14,15,9,15,6,15,2,9,15)).toSeq)
  }
  @Test def testN178() {
    assertEquals("testN178() failed", Array(12,13,0,16,2,6,10,15,9,3,8,4,5,7,1,14,11).toSeq, radixSortIndirectStable(Array(4,12,6,10,11,11,6,11,10,9,6,13,3,3,12,6,4)).toSeq)
  }
  @Test def testN179() {
    assertEquals("testN179() failed", Array(0,1,5,7,6,9,17,3,13,14,8,4,2,16,10,11,12,15).toSeq, radixSortIndirectStable(Array(1,1,12,7,11,2,3,2,10,5,14,15,16,7,9,17,12,6)).toSeq)
  }
  @Test def testN180() {
    assertEquals("testN180() failed", Array(7,16,0,3,8,12,5,15,6,1,4,2,14,10,18,9,17,13,11).toSeq, radixSortIndirectStable(Array(5,9,10,5,9,6,8,3,5,14,12,17,5,15,10,6,4,14,13)).toSeq)
  }
  @Test def testN181() {
    assertEquals("testN181() failed", Array(3,15,19,14,2,10,12,8,18,16,1,4,5,0,7,9,6,17,11,13).toSeq, radixSortIndirectStable(Array(11,8,4,0,8,9,15,12,6,12,4,16,5,16,3,0,7,15,6,2)).toSeq)
  }
  @Test def testN182() {
    assertEquals("testN182() failed", Array(0,2,4,8,12,13,17,19,20,1,5,9,14,3,6,7,10,11,15,16,18).toSeq, radixSortIndirectStable(Array(0,1,0,2,0,1,2,2,0,1,2,2,0,0,1,2,2,0,2,0,0)).toSeq)
  }
  @Test def testN183() {
    assertEquals("testN183() failed", Array(4,13,14,15,16,17,19,1,3,5,10,12,20,0,2,6,7,8,9,11,18,21).toSeq, radixSortIndirectStable(Array(2,1,2,1,0,1,2,2,2,2,1,2,1,0,0,0,0,0,2,0,1,2)).toSeq)
  }
  @Test def testN184() {
    assertEquals("testN184() failed", Array(6,7,8,12,14,18,2,3,4,11,13,15,17,19,21,22,0,1,5,9,10,16,20).toSeq, radixSortIndirectStable(Array(2,2,1,1,1,2,0,0,0,2,2,1,0,1,0,1,2,1,0,1,2,1,1)).toSeq)
  }
  @Test def testN221() {
    assertTrue("testN221() failed", checkRank(Array(0),radixSortIndirect(Array(0))))
  }
  @Test def testN222() {
    assertTrue("testN222() failed", checkRank(Array(0,0),radixSortIndirect(Array(0,0))))
  }
  @Test def testN223() {
    assertTrue("testN223() failed", checkRank(Array(0,0,0),radixSortIndirect(Array(0,0,0))))
  }
  @Test def testN224() {
    assertTrue("testN224() failed", checkRank(Array(0,0,0,0),radixSortIndirect(Array(0,0,0,0))))
  }
  @Test def testN225() {
    assertTrue("testN225() failed", checkRank(Array(0,0,0,0,0),radixSortIndirect(Array(0,0,0,0,0))))
  }
  @Test def testN226() {
    assertTrue("testN226() failed", checkRank(Array(0,0,0,0,0,0),radixSortIndirect(Array(0,0,0,0,0,0))))
  }
  @Test def testN227() {
    assertTrue("testN227() failed", checkRank(Array(0,0,0,0,0,0,0),radixSortIndirect(Array(0,0,0,0,0,0,0))))
  }
  @Test def testN228() {
    assertTrue("testN228() failed", checkRank(Array(0,0,0,0,0,0,0,0),radixSortIndirect(Array(0,0,0,0,0,0,0,0))))
  }
  @Test def testN229() {
    assertTrue("testN229() failed", checkRank(Array(0,0,0,0,0,0,0,0,0),radixSortIndirect(Array(0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN230() {
    assertTrue("testN230() failed", checkRank(Array(0,0,0,0,0,0,0,0,0,0),radixSortIndirect(Array(0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN231() {
    assertTrue("testN231() failed", checkRank(Array(0,0,0,0,0,0,0,0,0,0,0),radixSortIndirect(Array(0,0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN232() {
    assertTrue("testN232() failed", checkRank(Array(0,0,0,0,0,0,0,0,0,0,0,0),radixSortIndirect(Array(0,0,0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN233() {
    assertTrue("testN233() failed", checkRank(Array(0,0,0,0,0,0,0,0,0,0,0,0,0),radixSortIndirect(Array(0,0,0,0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN234() {
    assertTrue("testN234() failed", checkRank(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0),radixSortIndirect(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN235() {
    assertTrue("testN235() failed", checkRank(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),radixSortIndirect(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN236() {
    assertTrue("testN236() failed", checkRank(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),radixSortIndirect(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN237() {
    assertTrue("testN237() failed", checkRank(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),radixSortIndirect(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN238() {
    assertTrue("testN238() failed", checkRank(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),radixSortIndirect(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN239() {
    assertTrue("testN239() failed", checkRank(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),radixSortIndirect(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN240() {
    assertTrue("testN240() failed", checkRank(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),radixSortIndirect(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN241() {
    assertTrue("testN241() failed", checkRank(Array(0,0),radixSortIndirect(Array(0,0))))
  }
  @Test def testN242() {
    assertTrue("testN242() failed", checkRank(Array(0,1,0),radixSortIndirect(Array(0,1,0))))
  }
  @Test def testN243() {
    assertTrue("testN243() failed", checkRank(Array(0,0,0,1),radixSortIndirect(Array(0,0,0,1))))
  }
  @Test def testN244() {
    assertTrue("testN244() failed", checkRank(Array(1,0,0,1,0),radixSortIndirect(Array(1,0,0,1,0))))
  }
  @Test def testN245() {
    assertTrue("testN245() failed", checkRank(Array(1,0,0,0,1,1),radixSortIndirect(Array(1,0,0,0,1,1))))
  }
  @Test def testN246() {
    assertTrue("testN246() failed", checkRank(Array(1,1,1,1,1,1,0),radixSortIndirect(Array(1,1,1,1,1,1,0))))
  }
  @Test def testN247() {
    assertTrue("testN247() failed", checkRank(Array(0,0,1,1,0,0,0,1),radixSortIndirect(Array(0,0,1,1,0,0,0,1))))
  }
  @Test def testN248() {
    assertTrue("testN248() failed", checkRank(Array(1,1,0,0,0,0,1,1,0),radixSortIndirect(Array(1,1,0,0,0,0,1,1,0))))
  }
  @Test def testN249() {
    assertTrue("testN249() failed", checkRank(Array(0,1,1,0,1,1,0,0,1,1),radixSortIndirect(Array(0,1,1,0,1,1,0,0,1,1))))
  }
  @Test def testN250() {
    assertTrue("testN250() failed", checkRank(Array(0,0,0,0,1,1,0,1,1,0,0),radixSortIndirect(Array(0,0,0,0,1,1,0,1,1,0,0))))
  }
  @Test def testN251() {
    assertTrue("testN251() failed", checkRank(Array(1,0,1,1,1,0,0,1,0,1,0,1),radixSortIndirect(Array(1,0,1,1,1,0,0,1,0,1,0,1))))
  }
  @Test def testN252() {
    assertTrue("testN252() failed", checkRank(Array(0,1,1,1,0,0,0,0,0,1,0,1,0),radixSortIndirect(Array(0,1,1,1,0,0,0,0,0,1,0,1,0))))
  }
  @Test def testN253() {
    assertTrue("testN253() failed", checkRank(Array(1,0,0,1,1,0,1,1,1,1,0,1,0,1),radixSortIndirect(Array(1,0,0,1,1,0,1,1,1,1,0,1,0,1))))
  }
  @Test def testN254() {
    assertTrue("testN254() failed", checkRank(Array(1,0,0,1,0,1,1,1,0,0,0,0,1,0,0),radixSortIndirect(Array(1,0,0,1,0,1,1,1,0,0,0,0,1,0,0))))
  }
  @Test def testN255() {
    assertTrue("testN255() failed", checkRank(Array(0,1,0,1,0,1,1,0,0,1,1,1,0,1,0,0),radixSortIndirect(Array(0,1,0,1,0,1,1,0,0,1,1,1,0,1,0,0))))
  }
  @Test def testN256() {
    assertTrue("testN256() failed", checkRank(Array(0,1,1,0,1,1,0,1,1,1,1,1,1,1,0,0,1),radixSortIndirect(Array(0,1,1,0,1,1,0,1,1,1,1,1,1,1,0,0,1))))
  }
  @Test def testN257() {
    assertTrue("testN257() failed", checkRank(Array(1,1,1,0,0,0,0,1,1,1,1,1,1,1,0,1,0,0),radixSortIndirect(Array(1,1,1,0,0,0,0,1,1,1,1,1,1,1,0,1,0,0))))
  }
  @Test def testN258() {
    assertTrue("testN258() failed", checkRank(Array(0,0,1,1,0,1,1,0,0,0,0,0,1,1,0,1,1,0,0),radixSortIndirect(Array(0,0,1,1,0,1,1,0,0,0,0,0,1,1,0,1,1,0,0))))
  }
  @Test def testN259() {
    assertTrue("testN259() failed", checkRank(Array(1,0,0,0,1,0,1,0,1,1,1,0,1,0,1,1,0,1,1,1),radixSortIndirect(Array(1,0,0,0,1,0,1,0,1,1,1,0,1,0,1,1,0,1,1,1))))
  }
  @Test def testN260() {
    assertTrue("testN260() failed", checkRank(Array(0),radixSortIndirect(Array(0))))
  }
  @Test def testN261() {
    assertTrue("testN261() failed", checkRank(Array(0,0),radixSortIndirect(Array(0,0))))
  }
  @Test def testN262() {
    assertTrue("testN262() failed", checkRank(Array(0,0,1),radixSortIndirect(Array(0,0,1))))
  }
  @Test def testN263() {
    assertTrue("testN263() failed", checkRank(Array(2,3,3,1),radixSortIndirect(Array(2,3,3,1))))
  }
  @Test def testN264() {
    assertTrue("testN264() failed", checkRank(Array(4,1,4,2,3),radixSortIndirect(Array(4,1,4,2,3))))
  }
  @Test def testN265() {
    assertTrue("testN265() failed", checkRank(Array(2,5,3,2,2,0),radixSortIndirect(Array(2,5,3,2,2,0))))
  }
  @Test def testN266() {
    assertTrue("testN266() failed", checkRank(Array(0,6,5,5,3,4,3),radixSortIndirect(Array(0,6,5,5,3,4,3))))
  }
  @Test def testN267() {
    assertTrue("testN267() failed", checkRank(Array(6,5,2,5,4,4,7,7),radixSortIndirect(Array(6,5,2,5,4,4,7,7))))
  }
  @Test def testN268() {
    assertTrue("testN268() failed", checkRank(Array(5,6,2,5,8,8,7,2,7),radixSortIndirect(Array(5,6,2,5,8,8,7,2,7))))
  }
  @Test def testN269() {
    assertTrue("testN269() failed", checkRank(Array(8,6,6,0,9,1,3,2,9,1),radixSortIndirect(Array(8,6,6,0,9,1,3,2,9,1))))
  }
  @Test def testN270() {
    assertTrue("testN270() failed", checkRank(Array(2,6,3,5,9,6,8,8,9,5,6),radixSortIndirect(Array(2,6,3,5,9,6,8,8,9,5,6))))
  }
  @Test def testN271() {
    assertTrue("testN271() failed", checkRank(Array(5,9,4,2,5,11,1,7,1,0,11,2),radixSortIndirect(Array(5,9,4,2,5,11,1,7,1,0,11,2))))
  }
  @Test def testN272() {
    assertTrue("testN272() failed", checkRank(Array(3,11,2,5,3,4,5,2,11,11,4,6,7),radixSortIndirect(Array(3,11,2,5,3,4,5,2,11,11,4,6,7))))
  }
  @Test def testN273() {
    assertTrue("testN273() failed", checkRank(Array(4,10,0,9,4,8,4,3,1,13,13,9,0,12),radixSortIndirect(Array(4,10,0,9,4,8,4,3,1,13,13,9,0,12))))
  }
  @Test def testN274() {
    assertTrue("testN274() failed", checkRank(Array(11,3,7,6,3,5,6,7,11,12,1,8,10,12,0),radixSortIndirect(Array(11,3,7,6,3,5,6,7,11,12,1,8,10,12,0))))
  }
  @Test def testN275() {
    assertTrue("testN275() failed", checkRank(Array(11,8,2,11,13,4,5,6,14,2,0,2,2,1,11,9),radixSortIndirect(Array(11,8,2,11,13,4,5,6,14,2,0,2,2,1,11,9))))
  }
  @Test def testN276() {
    assertTrue("testN276() failed", checkRank(Array(13,7,1,14,9,16,3,13,16,15,4,6,8,11,4,14,5),radixSortIndirect(Array(13,7,1,14,9,16,3,13,16,15,4,6,8,11,4,14,5))))
  }
  @Test def testN277() {
    assertTrue("testN277() failed", checkRank(Array(5,13,2,6,15,10,7,7,5,8,14,14,5,1,3,7,17,7),radixSortIndirect(Array(5,13,2,6,15,10,7,7,5,8,14,14,5,1,3,7,17,7))))
  }
  @Test def testN278() {
    assertTrue("testN278() failed", checkRank(Array(10,15,14,15,7,1,4,5,4,16,0,18,5,16,10,7,15,5,5),radixSortIndirect(Array(10,15,14,15,7,1,4,5,4,16,0,18,5,16,10,7,15,5,5))))
  }
  @Test def testN279() {
    assertTrue("testN279() failed", checkRank(Array(19,1,1,4,14,18,2,3,1,1,2,12,6,14,12,7,6,8,8,11),radixSortIndirect(Array(19,1,1,4,14,18,2,3,1,1,2,12,6,14,12,7,6,8,8,11))))
  }
  @Test def testN293() {
    assertEquals("testN293() failed", Array(0).toSeq, radixSortDirectImmutable(Array(0)).toSeq)
  }
  @Test def testN294() {
    assertEquals("testN294() failed", Array(0,0).toSeq, radixSortDirectImmutable(Array(0,0)).toSeq)
  }
  @Test def testN295() {
    assertEquals("testN295() failed", Array(0,0,0).toSeq, radixSortDirectImmutable(Array(0,0,0)).toSeq)
  }
  @Test def testN296() {
    assertEquals("testN296() failed", Array(0,0,0,0).toSeq, radixSortDirectImmutable(Array(0,0,0,0)).toSeq)
  }
  @Test def testN297() {
    assertEquals("testN297() failed", Array(0,0,0,0,0).toSeq, radixSortDirectImmutable(Array(0,0,0,0,0)).toSeq)
  }
  @Test def testN298() {
    assertEquals("testN298() failed", Array(0,0,0,0,0,0).toSeq, radixSortDirectImmutable(Array(0,0,0,0,0,0)).toSeq)
  }
  @Test def testN299() {
    assertEquals("testN299() failed", Array(0,0,0,0,0,0,0).toSeq, radixSortDirectImmutable(Array(0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN300() {
    assertEquals("testN300() failed", Array(0,0,0,0,0,0,0,0).toSeq, radixSortDirectImmutable(Array(0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN301() {
    assertEquals("testN301() failed", Array(0,0,0,0,0,0,0,0,0).toSeq, radixSortDirectImmutable(Array(0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN302() {
    assertEquals("testN302() failed", Array(0,0,0,0,0,0,0,0,0,0).toSeq, radixSortDirectImmutable(Array(0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN303() {
    assertEquals("testN303() failed", Array(0,0,0,0,0,0,0,0,0,0,0).toSeq, radixSortDirectImmutable(Array(0,0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN304() {
    assertEquals("testN304() failed", Array(0,0,0,0,0,0,0,0,0,0,0,0).toSeq, radixSortDirectImmutable(Array(0,0,0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN305() {
    assertEquals("testN305() failed", Array(0,0,0,0,0,0,0,0,0,0,0,0,0).toSeq, radixSortDirectImmutable(Array(0,0,0,0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN306() {
    assertEquals("testN306() failed", Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0).toSeq, radixSortDirectImmutable(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN307() {
    assertEquals("testN307() failed", Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0).toSeq, radixSortDirectImmutable(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN308() {
    assertEquals("testN308() failed", Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0).toSeq, radixSortDirectImmutable(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN309() {
    assertEquals("testN309() failed", Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0).toSeq, radixSortDirectImmutable(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN310() {
    assertEquals("testN310() failed", Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0).toSeq, radixSortDirectImmutable(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN311() {
    assertEquals("testN311() failed", Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0).toSeq, radixSortDirectImmutable(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN312() {
    assertEquals("testN312() failed", Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0).toSeq, radixSortDirectImmutable(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)).toSeq)
  }
  @Test def testN313() {
    assertEquals("testN313() failed", Array(0,0).toSeq, radixSortDirectImmutable(Array(0,0)).toSeq)
  }
  @Test def testN314() {
    assertEquals("testN314() failed", Array(0,1,1).toSeq, radixSortDirectImmutable(Array(0,1,1)).toSeq)
  }
  @Test def testN315() {
    assertEquals("testN315() failed", Array(0,0,1,1).toSeq, radixSortDirectImmutable(Array(0,1,0,1)).toSeq)
  }
  @Test def testN316() {
    assertEquals("testN316() failed", Array(0,1,1,1,1).toSeq, radixSortDirectImmutable(Array(1,0,1,1,1)).toSeq)
  }
  @Test def testN317() {
    assertEquals("testN317() failed", Array(0,1,1,1,1,1).toSeq, radixSortDirectImmutable(Array(1,1,0,1,1,1)).toSeq)
  }
  @Test def testN318() {
    assertEquals("testN318() failed", Array(0,0,0,0,0,1,1).toSeq, radixSortDirectImmutable(Array(0,0,0,0,1,1,0)).toSeq)
  }
  @Test def testN319() {
    assertEquals("testN319() failed", Array(0,0,0,1,1,1,1,1).toSeq, radixSortDirectImmutable(Array(1,0,0,1,1,1,1,0)).toSeq)
  }
  @Test def testN320() {
    assertEquals("testN320() failed", Array(0,0,0,1,1,1,1,1,1).toSeq, radixSortDirectImmutable(Array(1,1,0,1,0,1,0,1,1)).toSeq)
  }
  @Test def testN321() {
    assertEquals("testN321() failed", Array(0,0,0,1,1,1,1,1,1,1).toSeq, radixSortDirectImmutable(Array(1,1,0,0,1,1,1,1,0,1)).toSeq)
  }
  @Test def testN322() {
    assertEquals("testN322() failed", Array(0,0,0,0,1,1,1,1,1,1,1).toSeq, radixSortDirectImmutable(Array(1,0,1,0,1,1,0,1,0,1,1)).toSeq)
  }
  @Test def testN323() {
    assertEquals("testN323() failed", Array(0,0,0,0,0,0,0,0,1,1,1,1).toSeq, radixSortDirectImmutable(Array(0,1,0,0,1,0,0,0,1,0,1,0)).toSeq)
  }
  @Test def testN324() {
    assertEquals("testN324() failed", Array(0,0,0,0,1,1,1,1,1,1,1,1,1).toSeq, radixSortDirectImmutable(Array(1,1,0,1,1,0,1,1,0,1,1,0,1)).toSeq)
  }
  @Test def testN325() {
    assertEquals("testN325() failed", Array(0,0,0,0,0,0,1,1,1,1,1,1,1,1).toSeq, radixSortDirectImmutable(Array(0,0,1,1,1,1,0,1,1,1,1,0,0,0)).toSeq)
  }
  @Test def testN326() {
    assertEquals("testN326() failed", Array(0,0,0,0,0,0,0,0,0,1,1,1,1,1,1).toSeq, radixSortDirectImmutable(Array(0,0,1,1,0,1,0,0,0,0,1,1,0,0,1)).toSeq)
  }
  @Test def testN327() {
    assertEquals("testN327() failed", Array(0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1).toSeq, radixSortDirectImmutable(Array(1,1,1,0,1,1,1,1,0,0,1,0,1,1,1,0)).toSeq)
  }
  @Test def testN328() {
    assertEquals("testN328() failed", Array(0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1).toSeq, radixSortDirectImmutable(Array(0,0,0,0,0,1,1,1,1,1,0,0,1,1,0,0,0)).toSeq)
  }
  @Test def testN329() {
    assertEquals("testN329() failed", Array(0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1).toSeq, radixSortDirectImmutable(Array(1,1,1,0,1,1,1,0,0,1,0,0,1,0,1,0,0,0)).toSeq)
  }
  @Test def testN330() {
    assertEquals("testN330() failed", Array(0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1).toSeq, radixSortDirectImmutable(Array(1,1,0,0,0,0,0,1,0,1,1,0,0,1,0,1,1,1,1)).toSeq)
  }
  @Test def testN331() {
    assertEquals("testN331() failed", Array(0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1).toSeq, radixSortDirectImmutable(Array(1,1,0,0,1,1,0,1,0,1,0,0,0,1,0,1,1,0,1,1)).toSeq)
  }
  @Test def testN332() {
    assertEquals("testN332() failed", Array(0).toSeq, radixSortDirectImmutable(Array(0)).toSeq)
  }
  @Test def testN333() {
    assertEquals("testN333() failed", Array(0,0).toSeq, radixSortDirectImmutable(Array(0,0)).toSeq)
  }
  @Test def testN334() {
    assertEquals("testN334() failed", Array(1,2,2).toSeq, radixSortDirectImmutable(Array(2,2,1)).toSeq)
  }
  @Test def testN335() {
    assertEquals("testN335() failed", Array(1,1,2,3).toSeq, radixSortDirectImmutable(Array(3,1,2,1)).toSeq)
  }
  @Test def testN336() {
    assertEquals("testN336() failed", Array(0,2,3,3,4).toSeq, radixSortDirectImmutable(Array(3,0,4,3,2)).toSeq)
  }
  @Test def testN337() {
    assertEquals("testN337() failed", Array(0,0,1,1,4,5).toSeq, radixSortDirectImmutable(Array(5,1,1,0,4,0)).toSeq)
  }
  @Test def testN338() {
    assertEquals("testN338() failed", Array(0,0,1,2,2,3,4).toSeq, radixSortDirectImmutable(Array(2,3,1,0,4,0,2)).toSeq)
  }
  @Test def testN339() {
    assertEquals("testN339() failed", Array(0,0,2,4,4,4,5,6).toSeq, radixSortDirectImmutable(Array(4,0,6,2,0,4,4,5)).toSeq)
  }
  @Test def testN340() {
    assertEquals("testN340() failed", Array(0,1,1,1,3,3,3,5,6).toSeq, radixSortDirectImmutable(Array(3,1,1,3,1,6,3,0,5)).toSeq)
  }
  @Test def testN341() {
    assertEquals("testN341() failed", Array(1,1,3,3,3,5,5,5,7,8).toSeq, radixSortDirectImmutable(Array(5,1,3,7,3,1,5,8,3,5)).toSeq)
  }
  @Test def testN342() {
    assertEquals("testN342() failed", Array(0,0,0,1,4,5,5,8,9,10,10).toSeq, radixSortDirectImmutable(Array(0,4,10,8,9,0,5,1,0,5,10)).toSeq)
  }
  @Test def testN343() {
    assertEquals("testN343() failed", Array(0,2,3,5,6,6,6,7,8,8,8,11).toSeq, radixSortDirectImmutable(Array(6,6,2,7,8,8,0,3,11,5,6,8)).toSeq)
  }
  @Test def testN344() {
    assertEquals("testN344() failed", Array(2,2,3,4,5,5,5,6,6,7,10,11,12).toSeq, radixSortDirectImmutable(Array(7,5,2,10,11,5,2,3,6,4,12,5,6)).toSeq)
  }
  @Test def testN345() {
    assertEquals("testN345() failed", Array(0,0,2,2,2,5,7,7,9,9,9,10,13,13).toSeq, radixSortDirectImmutable(Array(5,2,9,9,13,7,0,9,2,10,0,2,13,7)).toSeq)
  }
  @Test def testN346() {
    assertEquals("testN346() failed", Array(0,1,2,2,4,5,6,7,8,11,11,12,12,14,14).toSeq, radixSortDirectImmutable(Array(2,12,12,4,5,0,2,14,14,8,11,6,1,7,11)).toSeq)
  }
  @Test def testN347() {
    assertEquals("testN347() failed", Array(0,0,1,2,2,2,3,3,5,6,12,13,14,14,15,15).toSeq, radixSortDirectImmutable(Array(3,15,1,0,2,0,2,12,15,14,13,3,2,6,5,14)).toSeq)
  }
  @Test def testN348() {
    assertEquals("testN348() failed", Array(0,0,2,3,8,10,13,13,13,15,16,16,16,16,16,16,16).toSeq, radixSortDirectImmutable(Array(16,16,16,16,16,13,2,16,0,0,13,13,10,16,3,8,15)).toSeq)
  }
  @Test def testN349() {
    assertEquals("testN349() failed", Array(0,1,1,2,3,5,5,6,7,8,8,9,9,9,12,14,15,17).toSeq, radixSortDirectImmutable(Array(7,5,8,9,8,1,9,1,9,5,2,15,3,12,14,17,6,0)).toSeq)
  }
  @Test def testN350() {
    assertEquals("testN350() failed", Array(0,0,2,3,4,4,6,8,8,8,11,12,12,14,14,14,14,15,17).toSeq, radixSortDirectImmutable(Array(2,4,6,12,8,14,0,8,8,14,4,12,14,15,3,0,14,11,17)).toSeq)
  }
  @Test def testN351() {
    assertEquals("testN351() failed", Array(2,2,2,2,3,3,4,5,5,6,6,9,10,13,13,15,15,16,19,19).toSeq, radixSortDirectImmutable(Array(9,5,2,3,6,2,19,6,4,10,2,3,2,15,15,13,5,13,16,19)).toSeq)
  }
  @Test def testN379() {
    assertTrue("testN379() failed", { val t = Array(0); radixSortDirectMutable(t); arrayEq(t,Array(0)) })
  }
  @Test def testN380() {
    assertTrue("testN380() failed", { val t = Array(0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0)) })
  }
  @Test def testN381() {
    assertTrue("testN381() failed", { val t = Array(0,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0)) })
  }
  @Test def testN382() {
    assertTrue("testN382() failed", { val t = Array(0,0,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0)) })
  }
  @Test def testN383() {
    assertTrue("testN383() failed", { val t = Array(0,0,0,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0)) })
  }
  @Test def testN384() {
    assertTrue("testN384() failed", { val t = Array(0,0,0,0,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0)) })
  }
  @Test def testN385() {
    assertTrue("testN385() failed", { val t = Array(0,0,0,0,0,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,0)) })
  }
  @Test def testN386() {
    assertTrue("testN386() failed", { val t = Array(0,0,0,0,0,0,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,0,0)) })
  }
  @Test def testN387() {
    assertTrue("testN387() failed", { val t = Array(0,0,0,0,0,0,0,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,0,0,0)) })
  }
  @Test def testN388() {
    assertTrue("testN388() failed", { val t = Array(0,0,0,0,0,0,0,0,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,0,0,0,0)) })
  }
  @Test def testN389() {
    assertTrue("testN389() failed", { val t = Array(0,0,0,0,0,0,0,0,0,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,0,0,0,0,0)) })
  }
  @Test def testN390() {
    assertTrue("testN390() failed", { val t = Array(0,0,0,0,0,0,0,0,0,0,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,0,0,0,0,0,0)) })
  }
  @Test def testN391() {
    assertTrue("testN391() failed", { val t = Array(0,0,0,0,0,0,0,0,0,0,0,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,0,0,0,0,0,0,0)) })
  }
  @Test def testN392() {
    assertTrue("testN392() failed", { val t = Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0)) })
  }
  @Test def testN393() {
    assertTrue("testN393() failed", { val t = Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)) })
  }
  @Test def testN394() {
    assertTrue("testN394() failed", { val t = Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)) })
  }
  @Test def testN395() {
    assertTrue("testN395() failed", { val t = Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)) })
  }
  @Test def testN396() {
    assertTrue("testN396() failed", { val t = Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)) })
  }
  @Test def testN397() {
    assertTrue("testN397() failed", { val t = Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)) })
  }
  @Test def testN398() {
    assertTrue("testN398() failed", { val t = Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)) })
  }
  @Test def testN399() {
    assertTrue("testN399() failed", { val t = Array(1,0); radixSortDirectMutable(t); arrayEq(t,Array(0,1)) })
  }
  @Test def testN400() {
    assertTrue("testN400() failed", { val t = Array(1,1,1); radixSortDirectMutable(t); arrayEq(t,Array(1,1,1)) })
  }
  @Test def testN401() {
    assertTrue("testN401() failed", { val t = Array(1,0,1,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,1,1)) })
  }
  @Test def testN402() {
    assertTrue("testN402() failed", { val t = Array(1,1,0,1,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,1,1,1)) })
  }
  @Test def testN403() {
    assertTrue("testN403() failed", { val t = Array(1,0,0,1,0,1); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,1,1,1)) })
  }
  @Test def testN404() {
    assertTrue("testN404() failed", { val t = Array(0,1,1,0,0,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,1,1)) })
  }
  @Test def testN405() {
    assertTrue("testN405() failed", { val t = Array(1,0,0,0,0,1,1,1); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,1,1,1,1)) })
  }
  @Test def testN406() {
    assertTrue("testN406() failed", { val t = Array(0,1,1,0,1,1,1,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,1,1,1,1,1)) })
  }
  @Test def testN407() {
    assertTrue("testN407() failed", { val t = Array(0,0,1,1,1,1,0,0,0,1); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,1,1,1,1,1)) })
  }
  @Test def testN408() {
    assertTrue("testN408() failed", { val t = Array(1,0,0,1,1,0,1,1,1,1,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,1,1,1,1,1,1,1)) })
  }
  @Test def testN409() {
    assertTrue("testN409() failed", { val t = Array(0,0,0,0,0,0,1,1,1,1,1,1); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,1,1,1,1,1,1)) })
  }
  @Test def testN410() {
    assertTrue("testN410() failed", { val t = Array(0,1,0,0,0,0,0,0,1,1,0,1,1); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,0,0,1,1,1,1,1)) })
  }
  @Test def testN411() {
    assertTrue("testN411() failed", { val t = Array(0,0,0,0,0,1,1,1,1,0,0,1,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,0,0,0,1,1,1,1,1)) })
  }
  @Test def testN412() {
    assertTrue("testN412() failed", { val t = Array(0,1,1,1,0,1,1,0,0,1,1,1,1,1,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,1,1,1,1,1,1,1,1,1,1)) })
  }
  @Test def testN413() {
    assertTrue("testN413() failed", { val t = Array(1,0,1,1,0,1,1,1,0,0,1,0,0,1,1,1); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1)) })
  }
  @Test def testN414() {
    assertTrue("testN414() failed", { val t = Array(1,0,1,1,0,0,0,1,1,0,1,0,0,0,0,1,1); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1)) })
  }
  @Test def testN415() {
    assertTrue("testN415() failed", { val t = Array(1,1,1,1,1,0,1,0,0,1,0,1,1,1,0,0,0,1); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1)) })
  }
  @Test def testN416() {
    assertTrue("testN416() failed", { val t = Array(0,0,1,0,1,0,1,1,0,1,0,1,0,1,0,1,1,1,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1)) })
  }
  @Test def testN417() {
    assertTrue("testN417() failed", { val t = Array(0,1,0,0,0,1,1,0,1,1,0,0,0,1,1,1,1,0,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1)) })
  }
  @Test def testN418() {
    assertTrue("testN418() failed", { val t = Array(0); radixSortDirectMutable(t); arrayEq(t,Array(0)) })
  }
  @Test def testN419() {
    assertTrue("testN419() failed", { val t = Array(0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0)) })
  }
  @Test def testN420() {
    assertTrue("testN420() failed", { val t = Array(0,1,2); radixSortDirectMutable(t); arrayEq(t,Array(0,1,2)) })
  }
  @Test def testN421() {
    assertTrue("testN421() failed", { val t = Array(3,3,1,1); radixSortDirectMutable(t); arrayEq(t,Array(1,1,3,3)) })
  }
  @Test def testN422() {
    assertTrue("testN422() failed", { val t = Array(4,1,4,4,0); radixSortDirectMutable(t); arrayEq(t,Array(0,1,4,4,4)) })
  }
  @Test def testN423() {
    assertTrue("testN423() failed", { val t = Array(0,0,2,0,0,1); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,0,1,2)) })
  }
  @Test def testN424() {
    assertTrue("testN424() failed", { val t = Array(2,0,1,5,3,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,0,1,2,3,5)) })
  }
  @Test def testN425() {
    assertTrue("testN425() failed", { val t = Array(4,7,5,3,5,7,1,7); radixSortDirectMutable(t); arrayEq(t,Array(1,3,4,5,5,7,7,7)) })
  }
  @Test def testN426() {
    assertTrue("testN426() failed", { val t = Array(8,8,6,3,8,2,4,1,8); radixSortDirectMutable(t); arrayEq(t,Array(1,2,3,4,6,8,8,8,8)) })
  }
  @Test def testN427() {
    assertTrue("testN427() failed", { val t = Array(5,2,9,8,9,4,0,8,8,1); radixSortDirectMutable(t); arrayEq(t,Array(0,1,2,4,5,8,8,8,9,9)) })
  }
  @Test def testN428() {
    assertTrue("testN428() failed", { val t = Array(8,0,4,2,10,1,8,6,5,6,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,1,2,4,5,6,6,8,8,10)) })
  }
  @Test def testN429() {
    assertTrue("testN429() failed", { val t = Array(0,7,2,5,9,7,11,7,1,5,7,5); radixSortDirectMutable(t); arrayEq(t,Array(0,1,2,5,5,5,7,7,7,7,9,11)) })
  }
  @Test def testN430() {
    assertTrue("testN430() failed", { val t = Array(1,2,11,11,5,8,8,7,8,11,11,11,5); radixSortDirectMutable(t); arrayEq(t,Array(1,2,5,5,7,8,8,8,11,11,11,11,11)) })
  }
  @Test def testN431() {
    assertTrue("testN431() failed", { val t = Array(7,13,11,5,7,2,1,3,5,4,8,6,6,7); radixSortDirectMutable(t); arrayEq(t,Array(1,2,3,4,5,5,6,6,7,7,7,8,11,13)) })
  }
  @Test def testN432() {
    assertTrue("testN432() failed", { val t = Array(7,5,8,9,9,8,6,13,12,14,14,14,8,8,13); radixSortDirectMutable(t); arrayEq(t,Array(5,6,7,8,8,8,8,9,9,12,13,13,14,14,14)) })
  }
  @Test def testN433() {
    assertTrue("testN433() failed", { val t = Array(1,13,11,5,1,1,4,8,1,4,11,15,4,5,1,11); radixSortDirectMutable(t); arrayEq(t,Array(1,1,1,1,1,4,4,4,5,5,8,11,11,11,13,15)) })
  }
  @Test def testN434() {
    assertTrue("testN434() failed", { val t = Array(13,3,2,15,6,7,13,14,3,7,12,5,13,13,12,0,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,2,3,3,5,6,7,7,12,12,13,13,13,13,14,15)) })
  }
  @Test def testN435() {
    assertTrue("testN435() failed", { val t = Array(1,8,2,1,0,13,1,3,16,17,0,17,16,16,8,13,5,16); radixSortDirectMutable(t); arrayEq(t,Array(0,0,1,1,1,2,3,5,8,8,13,13,16,16,16,16,17,17)) })
  }
  @Test def testN436() {
    assertTrue("testN436() failed", { val t = Array(3,15,15,18,4,3,4,16,14,3,14,0,11,15,10,16,4,6,0); radixSortDirectMutable(t); arrayEq(t,Array(0,0,3,3,3,4,4,4,6,10,11,14,14,15,15,15,16,16,18)) })
  }
  @Test def testN437() {
    assertTrue("testN437() failed", { val t = Array(8,7,16,14,0,14,4,8,17,18,6,1,16,18,0,5,6,6,17,8); radixSortDirectMutable(t); arrayEq(t,Array(0,0,1,4,5,6,6,6,7,8,8,8,14,14,16,16,17,17,18,18)) })
  }
  @Test def testN452() {
    assertTrue("testN452() failed", { val u = radixSortUnrankPerm(Array(0)); checkPerm(u) && checkRank(Array(0),getInv(u)) })
  }
Array(0,1)
  @Test def testN453() {
    assertTrue("testN453() failed", { val u = radixSortUnrankPerm(Array(0,0)); checkPerm(u) && checkRank(Array(0,0),getInv(u)) })
  }
Array(0,1,2)
  @Test def testN454() {
    assertTrue("testN454() failed", { val u = radixSortUnrankPerm(Array(0,0,0)); checkPerm(u) && checkRank(Array(0,0,0),getInv(u)) })
  }
Array(0,1,2,3)
  @Test def testN455() {
    assertTrue("testN455() failed", { val u = radixSortUnrankPerm(Array(0,0,0,0)); checkPerm(u) && checkRank(Array(0,0,0,0),getInv(u)) })
  }
Array(0,1,2,3,4)
  @Test def testN456() {
    assertTrue("testN456() failed", { val u = radixSortUnrankPerm(Array(0,0,0,0,0)); checkPerm(u) && checkRank(Array(0,0,0,0,0),getInv(u)) })
  }
Array(0,1,2,3,4,5)
  @Test def testN457() {
    assertTrue("testN457() failed", { val u = radixSortUnrankPerm(Array(0,0,0,0,0,0)); checkPerm(u) && checkRank(Array(0,0,0,0,0,0),getInv(u)) })
  }
Array(0,1,2,3,4,5,6)
  @Test def testN458() {
    assertTrue("testN458() failed", { val u = radixSortUnrankPerm(Array(0,0,0,0,0,0,0)); checkPerm(u) && checkRank(Array(0,0,0,0,0,0,0),getInv(u)) })
  }
Array(0,1,2,3,4,5,6,7)
  @Test def testN459() {
    assertTrue("testN459() failed", { val u = radixSortUnrankPerm(Array(0,0,0,0,0,0,0,0)); checkPerm(u) && checkRank(Array(0,0,0,0,0,0,0,0),getInv(u)) })
  }
Array(0,1,2,3,4,5,6,7,8)
  @Test def testN460() {
    assertTrue("testN460() failed", { val u = radixSortUnrankPerm(Array(0,0,0,0,0,0,0,0,0)); checkPerm(u) && checkRank(Array(0,0,0,0,0,0,0,0,0),getInv(u)) })
  }
Array(0,1,2,3,4,5,6,7,8,9)
  @Test def testN461() {
    assertTrue("testN461() failed", { val u = radixSortUnrankPerm(Array(0,0,0,0,0,0,0,0,0,0)); checkPerm(u) && checkRank(Array(0,0,0,0,0,0,0,0,0,0),getInv(u)) })
  }
Array(0,1,2,3,4,5,6,7,8,9,10)
  @Test def testN462() {
    assertTrue("testN462() failed", { val u = radixSortUnrankPerm(Array(0,0,0,0,0,0,0,0,0,0,0)); checkPerm(u) && checkRank(Array(0,0,0,0,0,0,0,0,0,0,0),getInv(u)) })
  }
Array(0,1,2,3,4,5,6,7,8,9,10,11)
  @Test def testN463() {
    assertTrue("testN463() failed", { val u = radixSortUnrankPerm(Array(0,0,0,0,0,0,0,0,0,0,0,0)); checkPerm(u) && checkRank(Array(0,0,0,0,0,0,0,0,0,0,0,0),getInv(u)) })
  }
Array(0,1,2,3,4,5,6,7,8,9,10,11,12)
  @Test def testN464() {
    assertTrue("testN464() failed", { val u = radixSortUnrankPerm(Array(0,0,0,0,0,0,0,0,0,0,0,0,0)); checkPerm(u) && checkRank(Array(0,0,0,0,0,0,0,0,0,0,0,0,0),getInv(u)) })
  }
Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13)
  @Test def testN465() {
    assertTrue("testN465() failed", { val u = radixSortUnrankPerm(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0)); checkPerm(u) && checkRank(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0),getInv(u)) })
  }
Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14)
  @Test def testN466() {
    assertTrue("testN466() failed", { val u = radixSortUnrankPerm(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)); checkPerm(u) && checkRank(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),getInv(u)) })
  }
Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15)
  @Test def testN467() {
    assertTrue("testN467() failed", { val u = radixSortUnrankPerm(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)); checkPerm(u) && checkRank(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),getInv(u)) })
  }
Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16)
  @Test def testN468() {
    assertTrue("testN468() failed", { val u = radixSortUnrankPerm(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)); checkPerm(u) && checkRank(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),getInv(u)) })
  }
Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17)
  @Test def testN469() {
    assertTrue("testN469() failed", { val u = radixSortUnrankPerm(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)); checkPerm(u) && checkRank(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),getInv(u)) })
  }
Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18)
  @Test def testN470() {
    assertTrue("testN470() failed", { val u = radixSortUnrankPerm(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)); checkPerm(u) && checkRank(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),getInv(u)) })
  }
Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19)
  @Test def testN471() {
    assertTrue("testN471() failed", { val u = radixSortUnrankPerm(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)); checkPerm(u) && checkRank(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),getInv(u)) })
  }
Array(0,1)
  @Test def testN472() {
    assertTrue("testN472() failed", { val u = radixSortUnrankPerm(Array(0,0)); checkPerm(u) && checkRank(Array(0,0),getInv(u)) })
  }
Array(2,0,1)
  @Test def testN473() {
    assertTrue("testN473() failed", { val u = radixSortUnrankPerm(Array(1,1,0)); checkPerm(u) && checkRank(Array(1,1,0),getInv(u)) })
  }
Array(0,1,2,3)
  @Test def testN474() {
    assertTrue("testN474() failed", { val u = radixSortUnrankPerm(Array(0,0,0,0)); checkPerm(u) && checkRank(Array(0,0,0,0),getInv(u)) })
  }
Array(1,2,3,0,4)
  @Test def testN475() {
    assertTrue("testN475() failed", { val u = radixSortUnrankPerm(Array(1,0,0,0,1)); checkPerm(u) && checkRank(Array(1,0,0,0,1),getInv(u)) })
  }
Array(2,4,5,0,1,3)
  @Test def testN476() {
    assertTrue("testN476() failed", { val u = radixSortUnrankPerm(Array(1,1,0,1,0,0)); checkPerm(u) && checkRank(Array(1,1,0,1,0,0),getInv(u)) })
  }
Array(0,1,2,3,4,5,6)
  @Test def testN477() {
    assertTrue("testN477() failed", { val u = radixSortUnrankPerm(Array(0,0,0,0,0,0,0)); checkPerm(u) && checkRank(Array(0,0,0,0,0,0,0),getInv(u)) })
  }
Array(0,2,4,7,1,3,5,6)
  @Test def testN478() {
    assertTrue("testN478() failed", { val u = radixSortUnrankPerm(Array(0,1,0,1,0,1,1,0)); checkPerm(u) && checkRank(Array(0,1,0,1,0,1,1,0),getInv(u)) })
  }
Array(2,6,7,8,0,1,3,4,5)
  @Test def testN479() {
    assertTrue("testN479() failed", { val u = radixSortUnrankPerm(Array(1,1,0,1,1,1,0,0,0)); checkPerm(u) && checkRank(Array(1,1,0,1,1,1,0,0,0),getInv(u)) })
  }
Array(0,4,8,1,2,3,5,6,7,9)
  @Test def testN480() {
    assertTrue("testN480() failed", { val u = radixSortUnrankPerm(Array(0,1,1,1,0,1,1,1,0,1)); checkPerm(u) && checkRank(Array(0,1,1,1,0,1,1,1,0,1),getInv(u)) })
  }
Array(2,3,6,9,0,1,4,5,7,8,10)
  @Test def testN481() {
    assertTrue("testN481() failed", { val u = radixSortUnrankPerm(Array(1,1,0,0,1,1,0,1,1,0,1)); checkPerm(u) && checkRank(Array(1,1,0,0,1,1,0,1,1,0,1),getInv(u)) })
  }
Array(0,1,5,8,9,10,2,3,4,6,7,11)
  @Test def testN482() {
    assertTrue("testN482() failed", { val u = radixSortUnrankPerm(Array(0,0,1,1,1,0,1,1,0,0,0,1)); checkPerm(u) && checkRank(Array(0,0,1,1,1,0,1,1,0,0,0,1),getInv(u)) })
  }
Array(0,2,5,6,7,8,11,12,1,3,4,9,10)
  @Test def testN483() {
    assertTrue("testN483() failed", { val u = radixSortUnrankPerm(Array(0,1,0,1,1,0,0,0,0,1,1,0,0)); checkPerm(u) && checkRank(Array(0,1,0,1,1,0,0,0,0,1,1,0,0),getInv(u)) })
  }
Array(0,4,5,10,11,13,1,2,3,6,7,8,9,12)
  @Test def testN484() {
    assertTrue("testN484() failed", { val u = radixSortUnrankPerm(Array(0,1,1,1,0,0,1,1,1,1,0,0,1,0)); checkPerm(u) && checkRank(Array(0,1,1,1,0,0,1,1,1,1,0,0,1,0),getInv(u)) })
  }
Array(1,3,5,6,8,9,11,12,13,0,2,4,7,10,14)
  @Test def testN485() {
    assertTrue("testN485() failed", { val u = radixSortUnrankPerm(Array(1,0,1,0,1,0,0,1,0,0,1,0,0,0,1)); checkPerm(u) && checkRank(Array(1,0,1,0,1,0,0,1,0,0,1,0,0,0,1),getInv(u)) })
  }
Array(4,5,6,8,9,10,11,13,14,0,1,2,3,7,12,15)
  @Test def testN486() {
    assertTrue("testN486() failed", { val u = radixSortUnrankPerm(Array(1,1,1,1,0,0,0,1,0,0,0,0,1,0,0,1)); checkPerm(u) && checkRank(Array(1,1,1,1,0,0,0,1,0,0,0,0,1,0,0,1),getInv(u)) })
  }
Array(1,7,8,9,10,11,12,13,14,15,16,0,2,3,4,5,6)
  @Test def testN487() {
    assertTrue("testN487() failed", { val u = radixSortUnrankPerm(Array(1,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0)); checkPerm(u) && checkRank(Array(1,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0),getInv(u)) })
  }
Array(1,4,5,6,7,9,13,15,16,0,2,3,8,10,11,12,14,17)
  @Test def testN488() {
    assertTrue("testN488() failed", { val u = radixSortUnrankPerm(Array(1,0,1,1,0,0,0,0,1,0,1,1,1,0,1,0,0,1)); checkPerm(u) && checkRank(Array(1,0,1,1,0,0,0,0,1,0,1,1,1,0,1,0,0,1),getInv(u)) })
  }
Array(0,1,3,5,7,8,9,10,12,14,16,2,4,6,11,13,15,17,18)
  @Test def testN489() {
    assertTrue("testN489() failed", { val u = radixSortUnrankPerm(Array(0,0,1,0,1,0,1,0,0,0,0,1,0,1,0,1,0,1,1)); checkPerm(u) && checkRank(Array(0,0,1,0,1,0,1,0,0,0,0,1,0,1,0,1,0,1,1),getInv(u)) })
  }
Array(0,3,5,6,7,9,10,12,17,19,1,2,4,8,11,13,14,15,16,18)
  @Test def testN490() {
    assertTrue("testN490() failed", { val u = radixSortUnrankPerm(Array(0,1,1,0,1,0,0,0,1,0,0,1,0,1,1,1,1,0,1,0)); checkPerm(u) && checkRank(Array(0,1,1,0,1,0,0,0,1,0,0,1,0,1,1,1,1,0,1,0),getInv(u)) })
  }
Array(0)
  @Test def testN491() {
    assertTrue("testN491() failed", { val u = radixSortUnrankPerm(Array(0)); checkPerm(u) && checkRank(Array(0),getInv(u)) })
  }
Array(0,1)
  @Test def testN492() {
    assertTrue("testN492() failed", { val u = radixSortUnrankPerm(Array(0,1)); checkPerm(u) && checkRank(Array(0,1),getInv(u)) })
  }
Array(0,2,1)
  @Test def testN493() {
    assertTrue("testN493() failed", { val u = radixSortUnrankPerm(Array(0,2,0)); checkPerm(u) && checkRank(Array(0,2,0),getInv(u)) })
  }
Array(1,3,0,2)
  @Test def testN494() {
    assertTrue("testN494() failed", { val u = radixSortUnrankPerm(Array(1,0,1,0)); checkPerm(u) && checkRank(Array(1,0,1,0),getInv(u)) })
  }
Array(0,1,2,3,4)
  @Test def testN495() {
    assertTrue("testN495() failed", { val u = radixSortUnrankPerm(Array(1,1,2,3,3)); checkPerm(u) && checkRank(Array(1,1,2,3,3),getInv(u)) })
  }
Array(4,3,1,0,2,5)
  @Test def testN496() {
    assertTrue("testN496() failed", { val u = radixSortUnrankPerm(Array(4,2,5,1,0,5)); checkPerm(u) && checkRank(Array(4,2,5,1,0,5),getInv(u)) })
  }
Array(0,2,6,1,4,3,5)
  @Test def testN497() {
    assertTrue("testN497() failed", { val u = radixSortUnrankPerm(Array(0,3,0,4,3,4,0)); checkPerm(u) && checkRank(Array(0,3,0,4,3,4,0),getInv(u)) })
  }
Array(4,6,2,5,3,0,7,1)
  @Test def testN498() {
    assertTrue("testN498() failed", { val u = radixSortUnrankPerm(Array(5,6,1,4,0,3,0,5)); checkPerm(u) && checkRank(Array(5,6,1,4,0,3,0,5),getInv(u)) })
  }
Array(2,4,6,5,1,0,7,8,3)
  @Test def testN499() {
    assertTrue("testN499() failed", { val u = radixSortUnrankPerm(Array(4,3,0,7,1,2,1,5,6)); checkPerm(u) && checkRank(Array(4,3,0,7,1,2,1,5,6),getInv(u)) })
  }
Array(6,2,7,4,8,3,9,1,0,5)
  @Test def testN500() {
    assertTrue("testN500() failed", { val u = radixSortUnrankPerm(Array(9,6,2,5,4,9,0,3,4,5)); checkPerm(u) && checkRank(Array(9,6,2,5,4,9,0,3,4,5),getInv(u)) })
  }
Array(2,7,4,0,1,3,9,10,5,6,8)
  @Test def testN501() {
    assertTrue("testN501() failed", { val u = radixSortUnrankPerm(Array(6,6,2,7,4,9,10,3,10,7,8)); checkPerm(u) && checkRank(Array(6,6,2,7,4,9,10,3,10,7,8),getInv(u)) })
  }
Array(2,7,8,0,4,5,9,3,6,1,11,10)
  @Test def testN502() {
    assertTrue("testN502() failed", { val u = radixSortUnrankPerm(Array(3,10,0,6,4,4,7,2,2,5,11,10)); checkPerm(u) && checkRank(Array(3,10,0,6,4,4,7,2,2,5,11,10),getInv(u)) })
  }
Array(2,3,5,1,0,12,11,8,6,7,4,9,10)
  @Test def testN503() {
    assertTrue("testN503() failed", { val u = radixSortUnrankPerm(Array(2,1,0,0,11,0,9,10,8,12,12,7,6)); checkPerm(u) && checkRank(Array(2,1,0,0,11,0,9,10,8,12,12,7,6),getInv(u)) })
  }
Array(2,4,0,9,10,8,11,5,13,7,12,1,3,6)
  @Test def testN504() {
    assertTrue("testN504() failed", { val u = radixSortUnrankPerm(Array(3,10,0,10,2,5,10,7,4,3,3,4,9,5)); checkPerm(u) && checkRank(Array(3,10,0,10,2,5,10,7,4,3,3,4,9,5),getInv(u)) })
  }
Array(2,9,13,3,11,14,6,5,1,4,7,12,0,10,8)
  @Test def testN505() {
    assertTrue("testN505() failed", { val u = radixSortUnrankPerm(Array(13,8,0,2,8,7,5,10,14,0,13,3,11,0,3)); checkPerm(u) && checkRank(Array(13,8,0,2,8,7,5,10,14,0,13,3,11,0,3),getInv(u)) })
  }
Array(1,5,0,4,9,6,7,11,14,8,3,10,12,2,13,15)
  @Test def testN506() {
    assertTrue("testN506() failed", { val u = radixSortUnrankPerm(Array(2,0,14,12,2,1,5,8,10,4,12,9,13,14,9,15)); checkPerm(u) && checkRank(Array(2,0,14,12,2,1,5,8,10,4,12,9,13,14,9,15),getInv(u)) })
  }
Array(0,8,11,16,15,5,4,10,6,14,3,1,7,13,2,9,12)
  @Test def testN507() {
    assertTrue("testN507() failed", { val u = radixSortUnrankPerm(Array(1,13,16,12,8,7,9,13,3,16,8,3,16,14,11,5,4)); checkPerm(u) && checkRank(Array(1,13,16,12,8,7,9,13,3,16,8,3,16,14,11,5,4),getInv(u)) })
  }
Array(0,16,6,4,7,10,12,13,2,5,17,11,14,3,15,1,9,8)
  @Test def testN508() {
    assertTrue("testN508() failed", { val u = radixSortUnrankPerm(Array(0,15,8,14,4,9,3,6,17,15,6,12,6,7,12,14,0,11)); checkPerm(u) && checkRank(Array(0,15,8,14,4,9,3,6,17,15,6,12,6,7,12,14,0,11),getInv(u)) })
  }
Array(8,9,12,15,17,16,6,13,0,2,11,10,14,3,4,5,7,18,1)
  @Test def testN509() {
    assertTrue("testN509() failed", { val u = radixSortUnrankPerm(Array(6,18,7,14,16,17,5,17,0,0,11,10,1,5,12,1,3,2,17)); checkPerm(u) && checkRank(Array(6,18,7,14,16,17,5,17,0,0,11,10,1,5,12,1,3,2,17),getInv(u)) })
  }
Array(3,19,11,2,6,18,4,17,9,15,0,5,13,16,12,14,7,1,8,10)
  @Test def testN510() {
    assertTrue("testN510() failed", { val u = radixSortUnrankPerm(Array(10,16,3,0,6,10,3,15,17,8,18,2,13,11,14,9,11,7,5,1)); checkPerm(u) && checkRank(Array(10,16,3,0,6,10,3,15,17,8,18,2,13,11,14,9,11,7,5,1),getInv(u)) })
  }
  @Test def testN531() {
    assertTrue("testN531() failed", checkUnrankArray(Array(0),Array(0),radixSortCellUnrankArray(Array(0))))
  }
  @Test def testN532() {
    assertTrue("testN532() failed", checkUnrankArray(Array(0,0),Array(0,1),radixSortCellUnrankArray(Array(0,0))))
  }
  @Test def testN533() {
    assertTrue("testN533() failed", checkUnrankArray(Array(0,0,0),Array(0,1,2),radixSortCellUnrankArray(Array(0,0,0))))
  }
  @Test def testN534() {
    assertTrue("testN534() failed", checkUnrankArray(Array(0,0,0,0),Array(0,1,2,3),radixSortCellUnrankArray(Array(0,0,0,0))))
  }
  @Test def testN535() {
    assertTrue("testN535() failed", checkUnrankArray(Array(0,0,0,0,0),Array(0,1,2,3,4),radixSortCellUnrankArray(Array(0,0,0,0,0))))
  }
  @Test def testN536() {
    assertTrue("testN536() failed", checkUnrankArray(Array(0,0,0,0,0,0),Array(0,1,2,3,4,5),radixSortCellUnrankArray(Array(0,0,0,0,0,0))))
  }
  @Test def testN537() {
    assertTrue("testN537() failed", checkUnrankArray(Array(0,0,0,0,0,0,0),Array(0,1,2,3,4,5,6),radixSortCellUnrankArray(Array(0,0,0,0,0,0,0))))
  }
  @Test def testN538() {
    assertTrue("testN538() failed", checkUnrankArray(Array(0,0,0,0,0,0,0,0),Array(0,1,2,3,4,5,6,7),radixSortCellUnrankArray(Array(0,0,0,0,0,0,0,0))))
  }
  @Test def testN539() {
    assertTrue("testN539() failed", checkUnrankArray(Array(0,0,0,0,0,0,0,0,0),Array(0,1,2,3,4,5,6,7,8),radixSortCellUnrankArray(Array(0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN540() {
    assertTrue("testN540() failed", checkUnrankArray(Array(0,0,0,0,0,0,0,0,0,0),Array(0,1,2,3,4,5,6,7,8,9),radixSortCellUnrankArray(Array(0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN541() {
    assertTrue("testN541() failed", checkUnrankArray(Array(0,0,0,0,0,0,0,0,0,0,0),Array(0,1,2,3,4,5,6,7,8,9,10),radixSortCellUnrankArray(Array(0,0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN542() {
    assertTrue("testN542() failed", checkUnrankArray(Array(0,0,0,0,0,0,0,0,0,0,0,0),Array(0,1,2,3,4,5,6,7,8,9,10,11),radixSortCellUnrankArray(Array(0,0,0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN543() {
    assertTrue("testN543() failed", checkUnrankArray(Array(0,0,0,0,0,0,0,0,0,0,0,0,0),Array(0,1,2,3,4,5,6,7,8,9,10,11,12),radixSortCellUnrankArray(Array(0,0,0,0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN544() {
    assertTrue("testN544() failed", checkUnrankArray(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0),Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13),radixSortCellUnrankArray(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN545() {
    assertTrue("testN545() failed", checkUnrankArray(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14),radixSortCellUnrankArray(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN546() {
    assertTrue("testN546() failed", checkUnrankArray(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15),radixSortCellUnrankArray(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN547() {
    assertTrue("testN547() failed", checkUnrankArray(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16),radixSortCellUnrankArray(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN548() {
    assertTrue("testN548() failed", checkUnrankArray(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17),radixSortCellUnrankArray(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN549() {
    assertTrue("testN549() failed", checkUnrankArray(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18),radixSortCellUnrankArray(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN550() {
    assertTrue("testN550() failed", checkUnrankArray(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0),Array(0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19),radixSortCellUnrankArray(Array(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0))))
  }
  @Test def testN551() {
    assertTrue("testN551() failed", checkUnrankArray(Array(1,1),Array(0,1),radixSortCellUnrankArray(Array(1,1))))
  }
  @Test def testN552() {
    assertTrue("testN552() failed", checkUnrankArray(Array(1,1,0),Array(2,0,1),radixSortCellUnrankArray(Array(1,1,0))))
  }
  @Test def testN553() {
    assertTrue("testN553() failed", checkUnrankArray(Array(1,1,0,1),Array(2,0,1,3),radixSortCellUnrankArray(Array(1,1,0,1))))
  }
  @Test def testN554() {
    assertTrue("testN554() failed", checkUnrankArray(Array(0,0,1,1,0),Array(0,1,4,2,3),radixSortCellUnrankArray(Array(0,0,1,1,0))))
  }
  @Test def testN555() {
    assertTrue("testN555() failed", checkUnrankArray(Array(0,1,1,0,1,0),Array(0,3,5,1,2,4),radixSortCellUnrankArray(Array(0,1,1,0,1,0))))
  }
  @Test def testN556() {
    assertTrue("testN556() failed", checkUnrankArray(Array(1,0,0,1,0,0,1),Array(1,2,4,5,0,3,6),radixSortCellUnrankArray(Array(1,0,0,1,0,0,1))))
  }
  @Test def testN557() {
    assertTrue("testN557() failed", checkUnrankArray(Array(1,1,0,1,0,0,1,0),Array(2,4,5,7,0,1,3,6),radixSortCellUnrankArray(Array(1,1,0,1,0,0,1,0))))
  }
  @Test def testN558() {
    assertTrue("testN558() failed", checkUnrankArray(Array(0,0,1,0,0,1,0,1,0),Array(0,1,3,4,6,8,2,5,7),radixSortCellUnrankArray(Array(0,0,1,0,0,1,0,1,0))))
  }
  @Test def testN559() {
    assertTrue("testN559() failed", checkUnrankArray(Array(0,1,0,0,0,0,1,1,1,1),Array(0,2,3,4,5,1,6,7,8,9),radixSortCellUnrankArray(Array(0,1,0,0,0,0,1,1,1,1))))
  }
  @Test def testN560() {
    assertTrue("testN560() failed", checkUnrankArray(Array(1,0,1,0,0,0,0,1,1,0,0),Array(1,3,4,5,6,9,10,0,2,7,8),radixSortCellUnrankArray(Array(1,0,1,0,0,0,0,1,1,0,0))))
  }
  @Test def testN561() {
    assertTrue("testN561() failed", checkUnrankArray(Array(0,0,0,0,0,1,1,1,0,1,0,0),Array(0,1,2,3,4,8,10,11,5,6,7,9),radixSortCellUnrankArray(Array(0,0,0,0,0,1,1,1,0,1,0,0))))
  }
  @Test def testN562() {
    assertTrue("testN562() failed", checkUnrankArray(Array(0,0,0,1,0,0,0,1,1,0,0,1,0),Array(0,1,2,4,5,6,9,10,12,3,7,8,11),radixSortCellUnrankArray(Array(0,0,0,1,0,0,0,1,1,0,0,1,0))))
  }
  @Test def testN563() {
    assertTrue("testN563() failed", checkUnrankArray(Array(1,0,1,0,0,0,1,1,0,1,1,0,0,0),Array(1,3,4,5,8,11,12,13,0,2,6,7,9,10),radixSortCellUnrankArray(Array(1,0,1,0,0,0,1,1,0,1,1,0,0,0))))
  }
  @Test def testN564() {
    assertTrue("testN564() failed", checkUnrankArray(Array(1,0,1,1,0,0,0,1,1,0,0,1,0,1,0),Array(1,4,5,6,9,10,12,14,0,2,3,7,8,11,13),radixSortCellUnrankArray(Array(1,0,1,1,0,0,0,1,1,0,0,1,0,1,0))))
  }
  @Test def testN565() {
    assertTrue("testN565() failed", checkUnrankArray(Array(1,1,0,1,0,0,1,1,1,1,0,0,1,0,1,1),Array(2,4,5,10,11,13,0,1,3,6,7,8,9,12,14,15),radixSortCellUnrankArray(Array(1,1,0,1,0,0,1,1,1,1,0,0,1,0,1,1))))
  }
  @Test def testN566() {
    assertTrue("testN566() failed", checkUnrankArray(Array(1,1,1,1,0,1,1,0,1,0,0,0,0,1,0,0,0),Array(4,7,9,10,11,12,14,15,16,0,1,2,3,5,6,8,13),radixSortCellUnrankArray(Array(1,1,1,1,0,1,1,0,1,0,0,0,0,1,0,0,0))))
  }
  @Test def testN567() {
    assertTrue("testN567() failed", checkUnrankArray(Array(0,0,0,0,0,1,0,0,1,0,0,1,1,1,0,0,1,1),Array(0,1,2,3,4,6,7,9,10,14,15,5,8,11,12,13,16,17),radixSortCellUnrankArray(Array(0,0,0,0,0,1,0,0,1,0,0,1,1,1,0,0,1,1))))
  }
  @Test def testN568() {
    assertTrue("testN568() failed", checkUnrankArray(Array(1,1,0,1,0,1,1,0,1,0,0,1,0,0,0,0,0,0,1),Array(2,4,7,9,10,12,13,14,15,16,17,0,1,3,5,6,8,11,18),radixSortCellUnrankArray(Array(1,1,0,1,0,1,1,0,1,0,0,1,0,0,0,0,0,0,1))))
  }
  @Test def testN569() {
    assertTrue("testN569() failed", checkUnrankArray(Array(1,1,0,0,0,1,1,0,1,0,0,1,1,1,0,1,0,0,1,1),Array(2,3,4,7,9,10,14,16,17,0,1,5,6,8,11,12,13,15,18,19),radixSortCellUnrankArray(Array(1,1,0,0,0,1,1,0,1,0,0,1,1,1,0,1,0,0,1,1))))
  }
  @Test def testN570() {
    assertTrue("testN570() failed", checkUnrankArray(Array(0),Array(0),radixSortCellUnrankArray(Array(0))))
  }
  @Test def testN571() {
    assertTrue("testN571() failed", checkUnrankArray(Array(0,1),Array(0,1),radixSortCellUnrankArray(Array(0,1))))
  }
  @Test def testN572() {
    assertTrue("testN572() failed", checkUnrankArray(Array(1,0,0),Array(1,2,0),radixSortCellUnrankArray(Array(1,0,0))))
  }
  @Test def testN573() {
    assertTrue("testN573() failed", checkUnrankArray(Array(2,1,1,3),Array(1,2,0,3),radixSortCellUnrankArray(Array(2,1,1,3))))
  }
  @Test def testN574() {
    assertTrue("testN574() failed", checkUnrankArray(Array(4,2,1,1,3),Array(2,3,1,4,0),radixSortCellUnrankArray(Array(4,2,1,1,3))))
  }
  @Test def testN575() {
    assertTrue("testN575() failed", checkUnrankArray(Array(1,2,3,5,3,2),Array(0,1,5,2,4,3),radixSortCellUnrankArray(Array(1,2,3,5,3,2))))
  }
  @Test def testN576() {
    assertTrue("testN576() failed", checkUnrankArray(Array(2,1,1,6,4,6,3),Array(1,2,0,6,4,3,5),radixSortCellUnrankArray(Array(2,1,1,6,4,6,3))))
  }
  @Test def testN577() {
    assertTrue("testN577() failed", checkUnrankArray(Array(7,5,4,3,3,0,5,4),Array(5,3,4,2,7,1,6,0),radixSortCellUnrankArray(Array(7,5,4,3,3,0,5,4))))
  }
  @Test def testN578() {
    assertTrue("testN578() failed", checkUnrankArray(Array(3,6,1,4,5,0,2,5,2),Array(5,2,6,8,0,3,4,7,1),radixSortCellUnrankArray(Array(3,6,1,4,5,0,2,5,2))))
  }
  @Test def testN579() {
    assertTrue("testN579() failed", checkUnrankArray(Array(3,1,6,7,5,7,3,7,9,6),Array(1,0,6,4,2,9,3,5,7,8),radixSortCellUnrankArray(Array(3,1,6,7,5,7,3,7,9,6))))
  }
  @Test def testN580() {
    assertTrue("testN580() failed", checkUnrankArray(Array(3,6,7,10,6,0,0,0,10,7,3),Array(5,6,7,0,10,1,4,2,9,3,8),radixSortCellUnrankArray(Array(3,6,7,10,6,0,0,0,10,7,3))))
  }
  @Test def testN581() {
    assertTrue("testN581() failed", checkUnrankArray(Array(8,8,2,9,1,5,1,5,8,4,5,1),Array(4,6,11,2,9,5,7,10,0,1,8,3),radixSortCellUnrankArray(Array(8,8,2,9,1,5,1,5,8,4,5,1))))
  }
  @Test def testN582() {
    assertTrue("testN582() failed", checkUnrankArray(Array(8,11,7,12,4,5,8,0,3,1,11,3,9),Array(7,9,8,11,4,5,2,0,6,12,1,10,3),radixSortCellUnrankArray(Array(8,11,7,12,4,5,8,0,3,1,11,3,9))))
  }
  @Test def testN583() {
    assertTrue("testN583() failed", checkUnrankArray(Array(6,5,2,9,2,2,0,12,6,6,6,11,7,1),Array(6,13,2,4,5,1,0,8,9,10,12,3,11,7),radixSortCellUnrankArray(Array(6,5,2,9,2,2,0,12,6,6,6,11,7,1))))
  }
  @Test def testN584() {
    assertTrue("testN584() failed", checkUnrankArray(Array(12,12,4,4,5,8,6,13,4,0,4,9,2,3,7),Array(9,12,13,2,3,8,10,4,6,14,5,11,0,1,7),radixSortCellUnrankArray(Array(12,12,4,4,5,8,6,13,4,0,4,9,2,3,7))))
  }
  @Test def testN585() {
    assertTrue("testN585() failed", checkUnrankArray(Array(10,2,14,4,1,2,12,0,5,12,5,1,1,7,3,7),Array(7,4,11,12,1,5,14,3,8,10,13,15,0,6,9,2),radixSortCellUnrankArray(Array(10,2,14,4,1,2,12,0,5,12,5,1,1,7,3,7))))
  }
  @Test def testN586() {
    assertTrue("testN586() failed", checkUnrankArray(Array(3,1,15,2,9,6,6,6,6,12,14,10,7,6,4,4,5),Array(1,3,0,14,15,16,5,6,7,8,13,12,4,11,9,10,2),radixSortCellUnrankArray(Array(3,1,15,2,9,6,6,6,6,12,14,10,7,6,4,4,5))))
  }
  @Test def testN587() {
    assertTrue("testN587() failed", checkUnrankArray(Array(7,9,3,10,4,9,0,15,10,2,0,6,14,5,10,1,11,2),Array(6,10,15,9,17,2,4,13,11,0,1,5,3,8,14,16,12,7),radixSortCellUnrankArray(Array(7,9,3,10,4,9,0,15,10,2,0,6,14,5,10,1,11,2))))
  }
  @Test def testN588() {
    assertTrue("testN588() failed", checkUnrankArray(Array(17,17,3,12,5,17,2,16,3,11,5,0,7,8,14,14,8,12,7),Array(11,6,2,8,4,10,12,18,13,16,9,3,17,14,15,7,0,1,5),radixSortCellUnrankArray(Array(17,17,3,12,5,17,2,16,3,11,5,0,7,8,14,14,8,12,7))))
  }
  @Test def testN589() {
    assertTrue("testN589() failed", checkUnrankArray(Array(6,1,15,18,7,4,18,5,6,11,4,13,14,14,12,10,8,18,7,17),Array(1,5,10,7,0,8,4,18,16,15,9,14,11,12,13,2,19,3,6,17),radixSortCellUnrankArray(Array(6,1,15,18,7,4,18,5,6,11,4,13,14,14,12,10,8,18,7,17))))
  }
}

