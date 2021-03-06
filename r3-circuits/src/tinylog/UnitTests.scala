
package tinylog

import org.junit.Test
import org.junit.Assert._

class UnitTests {
  @Test def testEqual() {
    val a1 = new InputElement()
    val a2 = new ConstantGate(true)
    val aa = Bus(a1, a2)
    val b1 = new InputElement()
    val b2 = new InputElement()
    val bb = Bus(b1, b2)
    // Build the circuit
    val out = factory.buildEqual(aa, bb)
    // OK the circuit is now built, so test it 
    // by feeding in some input & check that the output is
    // what it is supposed to be 

    a1.set(true)
    b1.set(true)
    b2.set(false)
    assertEquals("Circuit gives invalid output", false, out.value)
    b2.set(true)
    assertEquals("Circuit gives invalid output", true, out.value)
  }

  @Test def testUnsignedLess() {
    val a0 = new InputElement()
    val a1 = new InputElement()
    val a2 = new InputElement()
    val aa = Bus(a0, a1, a2)
    val b0 = new InputElement()
    val b1 = new InputElement()
    val b2 = new InputElement()
    val bb = Bus(b0, b1, b2)
    // Build the circuits
    val out = factory.buildUnsignedLess(aa, bb)
    val out2 = factory.buildUnsignedLess(bb, aa)
    // OK the circuits are now built, so test them
    // by feeding in some input & check that the outputs are
    // what they are supposed to be 

    // Set aa to 100 (4 in decimal)
    a0.set(false)
    a1.set(false)
    a2.set(true)
    // Set bb to 110 (6 in decimal)
    b0.set(false)
    b1.set(true)
    b2.set(true)
    // Tests
    assertEquals("Circuit gives invalid output", true, out.value)
    assertEquals("Circuit gives invalid output", false, out2.value)
    // Set aa to 110 so they're equal
    a1.set(true)
    assertEquals("Circuit gives invalid output when equal", false, out.value)
    assertEquals("Circuit gives invalid output when equal", false, out2.value)
  }

  @Test def testUnsignedLessOrEqual() {
    val a0 = new InputElement()
    val a1 = new InputElement()
    val a2 = new InputElement()
    val aa = Bus(a0, a1, a2)
    val b0 = new InputElement()
    val b1 = new InputElement()
    val b2 = new InputElement()
    val bb = Bus(b0, b1, b2)
    // Build the circuit
    val out = factory.buildUnsignedLessOrEqual(aa, bb)
    val out2 = factory.buildUnsignedLessOrEqual(bb, aa)
    // OK the circuit is now built, so test it 
    // by feeding in some input & check that the output is
    // what it is supposed to be 

    // Set aa to 101 (5 in decimal)
    a0.set(true)
    a1.set(false)
    a2.set(true)
    // Set bb to 101 (5 in decimal)
    b0.set(true)
    b1.set(false)
    b2.set(true)
    // Test
    assertEquals("Circuit gives invalid output", true, out.value)
    assertEquals("Circuit gives invalid output", true, out2.value)

    // Set bb to 100 (4 in decimal)
    b2.set(false)
    // Test
    assertEquals("Circuit gives invalid output", false, out.value)
    assertEquals("Circuit gives invalid output", true, out2.value)
  }

  @Test def testIncrementer1() {
    // Input bus aa
    val a0 = new InputElement()
    val a1 = new InputElement()
    val a2 = new InputElement()
    val aa = Bus(a0, a1, a2)
    // Build the circuit
    val out = factory.buildIncrementer(aa)
    // OK the circuit is now built, so test it 
    // by feeding in some input & check that the output is
    // what it is supposed to be 

    // Set aa to 011, i.e. the binary encoded number 3
    a0.set(true)
    a1.set(true)
    a2.set(false)
    // We expect the answer to be 4, i.e. 100
    var expected = Seq(false, false, true)
    assertEquals("Circuit gives invalid output", expected, out.values)
  }

  @Test def testIncrementer2() {
    val a0 = new InputElement()
    val a1 = new InputElement()
    val a2 = new InputElement()
    val aa = Bus(a0, a1, a2)
    // Build the circuit
    val out = factory.buildIncrementer(aa)
    // OK the circuit is now built, so test it 
    // by feeding in some input & check that the output is
    // what it is supposed to be 

    // Set aa to 111, i.e. the binary encoded number 7
    a0.set(true)
    a1.set(true)
    a2.set(true)
    // We expect the answer to be 7+1 mod 8 = 0, i.e. 000
    val expected = Seq(false, false, false)
    assertEquals("Circuit gives invalid output", expected, out.values)
  }

  @Test def testAdder() {
    val a0 = new InputElement()
    val a1 = new InputElement()
    val a2 = new InputElement()
    val aa = Bus(a0, a1, a2)
    val b0 = new InputElement()
    val b1 = new InputElement()
    val b2 = new InputElement()
    val bb = Bus(b0, b1, b2)
    // Build the circuit
    val out = factory.buildAdder(aa, bb)
    // OK the circuit is now built, so test it 
    // by feeding in some input & check that the output is
    // what it is supposed to be 

    // Set aa to 111, i.e. the signed binary encoded number 7
    a0.set(true)
    a1.set(true)
    a2.set(true)
    // Set bb to 110, i.e. the unsigned binary encoded number 6
    b0.set(false)
    b1.set(true)
    b2.set(true)
    // We expect the answer to be 5 
    // (13 mod 8, i.e. 101 in unsigned binary with 3 bits)
    val expected = Seq(true, false, true)
    assertEquals("Circuit gives invalid output", expected, out.values)
  }

  @Test def testAdderNoOverflow() {
    val a0 = new InputElement()
    val a1 = new InputElement()
    val a2 = new InputElement()
    val aa = Bus(a0, a1, a2)
    val b0 = new InputElement()
    val b1 = new InputElement()
    val b2 = new InputElement()
    val b3 = new InputElement()
    val bb = Bus(b0, b1, b2, b3)
    // Build the circuit
    val out = factory.buildAdderNoOverflow(aa, bb)
    // OK the circuit is now built, so test it 
    // by feeding in some input & check that the output is
    // what it is supposed to be 

    // Set aa to 111, i.e. the signed binary encoded number 7
    a0.set(true)
    a1.set(true)
    a2.set(true)
    // Set bb to 1100, i.e. the unsigned binary encoded number 12
    b0.set(false)
    b1.set(false)
    b2.set(true)
    b3.set(true)
    // We expect the answer to be 19 (10011 in unsigned binary with 5 bits)
    val expected = Seq(true, true, false, false, true)
    assertEquals("Circuit gives invalid output", expected, out.values)
  }

  @Test def testCountTrueBits1() {
    // Input bus aa
    val a0 = new InputElement()
    val a1 = new InputElement()
    val a2 = new InputElement()
    val aa = Bus(a0, a1, a2)
    // Build the circuit
    val out = factory.buildCountTrueBits(aa)
    // OK the circuit is now built, so test it 
    // by feeding in some input & check that the output is
    // what it is supposed to be 

    // Set aa to 101
    a0.set(true)
    a1.set(false)
    a2.set(true)
    // We expect the answer to be 2, i.e. 10
    var expected = Seq(false, true)
    assertEquals("Circuit gives invalid output", expected, out.values)
  }

  @Test def testCountTrueBits2() {
    // Input bus aa
    val a0 = new InputElement()
    val a1 = new InputElement()
    val a2 = new InputElement()
    val a3 = new InputElement()
    val aa = Bus(a0, a1, a2, a3)
    // Build the circuit
    val out = factory.buildCountTrueBits(aa)
    // OK the circuit is now built, so test it 
    // by feeding in some input & check that the output is
    // what it is supposed to be 

    // Set aa to 1111
    a0.set(true)
    a1.set(true)
    a2.set(true)
    a3.set(true)
    // We expect the answer to be 4, i.e. 100
    val expected = Seq(false, false, true)
    assertEquals("Circuit gives invalid output", expected, out.values)
  }

  @Test def testMajorityTester1() {
    val a0 = new InputElement()
    val a1 = new InputElement()
    val a2 = new InputElement()
    val aa = Bus(a0, a1, a2)
    // Build the circuit
    val out = factory.buildMajorityTester(aa)
    // OK the circuit is now built, so test it 
    // by feeding in some input & check that the output is
    // what it is supposed to be 

    // Set aa to 101
    a0.set(true)
    a1.set(false)
    a2.set(true)
    // Test
    assertEquals("Circuit gives invalid output", true, out.value)
  }

  @Test def testMajorityTester2() {
    val a0 = new InputElement()
    val a1 = new InputElement()
    val a2 = new InputElement()
    val a3 = new InputElement()
    val aa = Bus(a0, a1, a2, a3)
    // Build the circuit
    val out = factory.buildMajorityTester(aa)
    // OK the circuit is now built, so test it 
    // by feeding in some input & check that the output is
    // what it is supposed to be 

    // Set aa to 1001
    a0.set(true)
    a1.set(false)
    a2.set(false)
    a3.set(true)
    // Test
    assertEquals("Circuit gives invalid output", false, out.value)
  }

  @Test def testMultiplier() {
    val a0 = new InputElement()
    val a1 = new InputElement()
    val a2 = new InputElement()
    val aa = Bus(a0, a1, a2)

    val b0 = new InputElement()
    val b1 = new InputElement()
    val b2 = new InputElement()
    val b3 = new InputElement()
    val bb = Bus(b0, b1, b2, b3)

    val c0 = new InputElement()
    val c1 = new InputElement()
    val c2 = new InputElement()
    val c3 = new InputElement()
    val cc = Bus(c0, c1, c2, c3)

    // Build the circuits
    val out = factory.buildMultiplier(aa, bb)
    val out2 = factory.buildMultiplier(aa, cc)
    val out3 = factory.buildMultiplier(bb, cc)
    // OK the circuits are now built, so test them
    // by feeding in some input & check that their output is
    // what it is supposed to be 

    // Set aa to 011, i.e. the signed binary encoded number 3
    a0.set(true)
    a1.set(true)
    a2.set(false)
    // Set bb to 1100, i.e. the unsigned binary encoded number 12
    b0.set(false)
    b1.set(false)
    b2.set(true)
    b3.set(true)
    // We expect the answer to be 36 (0100100 in unsigned binary with 7 bits)
    var expected = Seq(false, false, true, false, false, true, false)
    assertEquals("Circuit gives invalid output", expected, out.values)

    // Set cc to 0001, i.e. the unsigned binary encoded number 1
    c0.set(true)
    // We expect the answer to be 3 (0000011 in unsigned binary with 7 bits)
    expected = Seq(true, true, false, false, false, false, false)
    assertEquals("Circuit gives invalid output", expected, out2.values)

    // Set cc to 1001, i.e. the unsigned binary encoded number 9
    c3.set(true)
    // We expect the answer to be 108 (01101100 in unsigned binary with 8 bits)
    expected = Seq(false, false, true, true, false, true, true, false)
    assertEquals("Circuit gives invalid output", expected, out3.values)
  }
}

