
package object suffixBuild {
  def suffixArray(s: String): Seq[Int] = s.tails.toArray.zipWithIndex.sortBy(_._1).map(n => n._2).tail
}


