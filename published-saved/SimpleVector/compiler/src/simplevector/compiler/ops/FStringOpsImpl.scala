package simplevector.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import simplevector.shared._
import simplevector.shared.ops._
import simplevector.compiler._
import simplevector.compiler.ops._

/**
 * Op Impls
 */

trait FStringOpsImpl {
  this: SimpleVectorCompiler with SimpleVectorLift => 

  def fstring_split_impl(__arg0: Rep[String],__arg1: Rep[String],numSplits: Rep[Int] = unit(0))(implicit __pos: SourceContext): Rep[ForgeArray[String]] = {
    array_string_split(__arg0,__arg1,numSplits)
  }

}
