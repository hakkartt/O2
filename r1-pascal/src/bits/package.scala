

package object bits {
  def tellAboutByte(x: Byte) {
    print("I am an 8-bit word that Scala views as having format 'Byte' ...\n"
          ++ "... my bits are, in binary, ("
          ++ new String((0 to 7)
                          .toArray
                          .map(j => (x >> 7-j)&1)
                          .flatMap(b => "%d".format(b)))
          ++ ")_2\n"
       ++ "... or equivalently, in hexadecimal, 0x%02X\n"
            .format(x)
       ++ "... Scala prints me out as " ++ x.toString ++ "\n"
       ++ "... I represent the signed decimal integer %d\n"
            .format(x)
       ++ "... I represent the unsigned decimal integer %d\n"
            .format(if((x & 0x80) != 0) 0x100+x else x)
    )
  }
  
  def tellAboutShort(x: Short) {
    print("I am a 16-bit word that Scala views as having format 'Short' ...\n"
       ++ "... my bits are, in binary, ("
          ++ new String((0 to 15)
                          .toArray
                          .map(j => (x >> 15-j)&1)
                          .flatMap(b => "%d".format(b)))
          ++ ")_2\n"
       ++ "... or equivalently, in hexadecimal, 0x%04X\n"
            .format(x)
       ++ "... Scala prints me out as " ++ x.toString ++ "\n"
       ++ "... I represent the signed decimal integer %d\n"
            .format(x)
       ++ "... I represent the unsigned decimal integer %d\n"
            .format(if((x & 0x8000) != 0) 0x10000+x else x)
    )
  }
  
  def tellAboutInt(x: Int) {
    print("I am a 32-bit word that Scala views as having format 'Int' ...\n"
       ++ "... my bits are, in binary, ("
          ++ new String((0 to 31)
                          .toArray
                          .map(j => (x >> 31-j)&1)
                          .flatMap(b => "%d".format(b)))
          ++ ")_2\n"
       ++ "... or equivalently, in hexadecimal, 0x%08X\n"
            .format(x)
       ++ "... Scala prints me out as " ++ x.toString ++ "\n"
       ++ "... I represent the signed decimal integer %d\n"
            .format(x)
       ++ "... I represent the unsigned decimal integer %d\n"
            .format(if((x & 0x80000000) != 0) 0x100000000L+x else x)
    )
  }
  
  def tellAboutLong(x: Long) {
    print("I am a 64-bit word that Scala views as having format 'Long' ...\n"
       ++ "... my bits are, in binary, ("
          ++ new String((0 to 63)
                          .toArray
                          .map(j => (x >> 63-j)&1)
                          .flatMap(b => "%d".format(b)))
          ++ ")_2\n"
       ++ "... or equivalently, in hexadecimal, 0x%016X\n"
            .format(x)
       ++ "... Scala prints me out as " ++ x.toString ++ "\n"
       ++ "... I represent the signed decimal integer %d\n"
            .format(x)
       ++ "... I represent the unsigned decimal integer %s\n"
            .format(if((x & 0x8000000000000000L) != 0) BigInt("10000000000000000",16)+x else x)
    )
  }
  
  def tellAboutChar(x: Char) {
    val xx = x.toShort
    print("I am a 16-bit word that Scala views as having format 'Char' ...\n"
       ++ "... my bits are, in binary, ("
          ++ new String((0 to 15)
                          .toArray
                          .map(j => (xx >> 15-j)&1)
                          .flatMap(b => "%d".format(b)))
          ++ ")_2\n"
       ++ "... or equivalently, in hexadecimal, 0x%04X\n"
            .format(xx)
       ++ "... Scala prints me out as " ++ x.toString ++ "\n"
       ++ "... indeed, my bits acquire meaning via the Unicode standard\n"
       ++ "    http://www.unicode.org/\n"
       ++ "... I represent a single 16-bit Unicode character '\\u%04X'\n"
            .format(xx)
       ++ "... as a signed decimal integer, I am %d\n"
            .format(xx)
       ++ "... as an unsigned decimal integer, I am %d\n"
            .format(if((x & 0x8000) != 0) 0x10000+xx else xx)
    )
  }
  
  def tellAboutString(x: String) {
    val xx = x.toArray
    print("I am compound data that Scala views as having format 'String' ...\n"
       ++ "... in essence, I am a sequence of %d consecutive 16-bit words,\n"
            .format(xx.length)
       ++ "    each of which Scala views as having format 'Char'\n"
       ++ "... the bits of this sequence are, in binary, ("
          ++ new String(xx.flatMap(w => (0 to 15)
                                          .toArray
                                          .map(j => (w.toShort >> 15-j)&1)
                                          .flatMap(b => "%d".format(b))))
          ++ ")_2\n"
       ++ "... or equivalently, in hexadecimal, 0x%s\n"
            .format(new String(xx.flatMap(w => "%04X".format(w.toShort))))
       ++ "... Scala prints me out as " ++ x ++ "\n"
    )
  }
  
  def tellAboutFloat(x: Float) {
    val xx = java.lang.Float.floatToIntBits(x)
    val sign = (xx >> 31) & 0x1   // unpack sign
    val bexp = (xx >> 23) & 0xFF  // unpack biased exponent
    val tsig = xx & 0x007FFFFF    // unpack trailing significand
    val normalized = bexp > 0 && bexp < 254
    require(bexp < 254)
     // (no support for telling about NaNs or infinities
     //  -- consult the standard yourself for these!)
  
    // We are either normalized or subnormal at this point
    val exp = if(normalized) { bexp - 127 } else { -126 }
    val sig = if(normalized) { tsig | (1L << 23) } else { tsig }
    import java.math.{MathContext => jMC}
    def p2(j: Int): BigDecimal = { if(j < 0) { BigDecimal(1,jMC.UNLIMITED)/p2(-j) } else { BigDecimal(2,jMC.UNLIMITED).pow(j) } }
    val dd = (BigDecimal(0,jMC.UNLIMITED) /: (0 to 23).filter(j => ((sig >> (23-j))&1) != 0).map(j => p2(exp-j)))(_ + _).toString
    val sigstr = new String((0 to 23).map(j => (sig >> (23-j))&1).flatMap(b => "%1d".format(b)).toArray)
    val bb = "(" ++ sigstr.take(1) ++ "." ++ sigstr.drop(1) ++ ")_2 * 2^{%d}".format(exp)
    val sdd = "%s%s".format(if(sign == 1) "-" else "",dd)
    val sbb = "%s%s".format(if(sign == 1) "-" else "",bb)
    print("I am a 32-bit word that Scala views as having format 'Float' ...\n"
       ++ "... my bits are, in binary, ("
          ++ new String((0 to 31)
                          .toArray
                          .map(j => (xx >> 31-j)&1)
                          .flatMap(b => "%d".format(b)))
          ++ ")_2\n"
       ++ "... or equivalently, in hexadecimal, 0x%08X\n"
            .format(xx)
       ++ "... Scala prints me out as " ++ x.toString ++ "\n"
       ++ "... indeed, my bits acquire meaning as specified\n"
       ++ "    in the binary interchange format 'binary32' in the\n"
       ++ "    IEEE Std 754-2008 IEEE Standard for Floating-Point Arithmetic\n"
       ++ "    http://dx.doi.org/10.1109%2FIEEESTD.2008.4610935\n"
       ++ "... this format is a bit-packed format with three components:\n"
       ++ "                            ("
          ++ new String((0 to 31)
                          .toArray
                          .map(j => (xx >> 31-j)&1)
                          .flatMap(b => "%d".format(b)))
          ++ ")_2\n"
       ++ "    a) the sign\n"
       ++ "       (bit 31):             %d\n"
            .format(sign)
       ++ "    b) the biased exponent\n"
       ++ "       (bits 30 to 23):       "
          ++ new String((0 to 7)
                          .toArray
                          .map(j => (bexp >> 7-j)&1)
                          .flatMap(b => "%d".format(b)))
          ++ "\n"
       ++ "    c) the trailing significand\n"
       ++ "       (bits 22 to 0):                "
          ++ new String((0 to 22)
                          .toArray
                          .map(j => (tsig >> 22-j)&1)
                          .flatMap(b => "%d".format(b)))
          ++ "\n"
       ++ (if(normalized)
          "... my biased exponent %d indicates that I am a _normalized_ number\n"
            .format(bexp)
       ++ "    with a leading 1-digit in my significand and\n"
       ++ "    an unbiased exponent %d = %d - 127\n"
            .format(exp,bexp)
       else
          "... my biased exponent %d indicates that I am a _subnormal_ number\n"
            .format(bexp)
       ++ "    with a leading 0-digit in my significand and\n"
       ++ "    an unbiased exponent %d\n"
            .format(exp)
       )
  
       ++ "... that is, in _binary radix point notation_, I am exactly\n"
       ++ "                                  %s%s\n"
            .format(if(sign == 1) "" else " ",sbb)
       ++ "... or what is the same in _decimal radix point notation_, I am exactly\n"
       ++ "    %s\n"
            .format(sdd)
    )
  }
  
  def tellAboutDouble(x: Double) {
    val xx = java.lang.Double.doubleToLongBits(x)
    val sign = ((xx >> 63) & 0x1L).toInt    // unpack sign
    val bexp = ((xx >> 52) & 0x7FFL).toInt  // unpack biased exponent
    val tsig = xx & 0x000FFFFFFFFFFFFFL     // unpack trailing significand
    val normalized = bexp > 0 && bexp < 2047
    require(bexp < 2047)
     // (no support for telling about NaNs or infinities
     //  -- consult the standard yourself for these!)
  
    // We are either normalized or subnormal at this point
    val exp = if(normalized) { bexp - 1023 } else { -1022 }
    val sig = if(normalized) { tsig | (1L << 52) } else { tsig }
    import java.math.{MathContext => jMC}
    def p2(j: Int): BigDecimal = { if(j < 0) { BigDecimal(1,jMC.UNLIMITED)/p2(-j) } else { BigDecimal(2,jMC.UNLIMITED).pow(j) } }
    val dd = (BigDecimal(0,jMC.UNLIMITED) /: (0 to 52).filter(j => ((sig >> (52-j))&1) != 0).map(j => p2(exp-j)))(_ + _).toString
    val sigstr = new String((0 to 52).map(j => (sig >> (52-j))&1).flatMap(b => "%1d".format(b)).toArray)
    val bb = "(" ++ sigstr.take(1) ++ "." ++ sigstr.drop(1) ++ ")_2 * 2^{%d}".format(exp)
    val sdd = "%s%s".format(if(sign == 1) "-" else "",dd)
    val sbb = "%s%s".format(if(sign == 1) "-" else "",bb)
    print("I am a 64-bit word that Scala views as having format 'Double' ...\n"
       ++ "... my bits are, in binary, ("
          ++ new String((0 to 63)
                          .toArray
                          .map(j => (xx >> 63-j)&1)
                          .flatMap(b => "%d".format(b)))
          ++ ")_2\n"
       ++ "... or equivalently, in hexadecimal, 0x%016X\n"
            .format(xx)
       ++ "... Scala prints me out as " ++ x.toString ++ "\n"
       ++ "... indeed, my bits acquire meaning as specified\n"
       ++ "    in the binary interchange format 'binary64' in the\n"
       ++ "    IEEE Std 754-2008 IEEE Standard for Floating-Point Arithmetic\n"
       ++ "    http://dx.doi.org/10.1109%2FIEEESTD.2008.4610935\n"
       ++ "... this format is a bit-packed format with three components:\n"
       ++ "                            ("
          ++ new String((0 to 63)
                          .toArray
                          .map(j => (xx >> 63-j)&1)
                          .flatMap(b => "%d".format(b)))
          ++ ")_2\n"
       ++ "    a) the sign\n"
       ++ "       (bit 63):             %d\n"
            .format(sign)
       ++ "    b) the biased exponent\n"
       ++ "       (bits 62 to 52):       "
          ++ new String((0 to 10)
                          .toArray
                          .map(j => (bexp >> 10-j)&1)
                          .flatMap(b => "%d".format(b)))
          ++ "\n"
       ++ "    c) the trailing significand\n"
       ++ "       (bits 51 to 0):                   "
          ++ new String((0 to 51)
                          .toArray
                          .map(j => (tsig >> 51-j)&1)
                          .flatMap(b => "%d".format(b)))
          ++ "\n"
       ++ (if(normalized)
          "... my biased exponent %d indicates that I am a _normalized_ number\n"
            .format(bexp)
       ++ "    with a leading 1-digit in my significand and\n"
       ++ "    an unbiased exponent %d = %d - 1023\n"
            .format(exp,bexp)
       else
          "... my biased exponent %d indicates that I am a _subnormal_ number\n"
            .format(bexp)
       ++ "    with a leading 0-digit in my significand and\n"
       ++ "    an unbiased exponent %d\n"
            .format(exp)
       )
       ++ "... that is, in _binary radix point notation_, I am exactly\n"
       ++ "                                     %s%s\n"
            .format(if(sign == 1) "" else " ",sbb)
       ++ "... or what is the same in _decimal radix point notation_, I am exactly\n"
       ++ "    %s\n"
            .format(sdd)
    )
  }
}