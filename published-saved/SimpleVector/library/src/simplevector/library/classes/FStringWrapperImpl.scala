package simplevector.library.classes

import scala.reflect.{Manifest,SourceContext}
import scala.math.Ordering.Implicits._
import scala.math.Numeric.Implicits._
import simplevector.shared._
import simplevector.shared.ops._
import simplevector.library._
import simplevector.library.classes._

/**
 * SingleTask and Composite Impls
 */

trait FStringWrapperImpl {
  this: SimpleVectorApplication with SimpleVectorCompilerOps => 

  def fstring_split_impl(__arg0: Rep[String],__arg1: Rep[String],numSplits: Rep[Int] = unit(0))(implicit __pos: SourceContext): Rep[ForgeArray[String]] = {
    array_string_split(__arg0,__arg1,numSplits)
  }

}
