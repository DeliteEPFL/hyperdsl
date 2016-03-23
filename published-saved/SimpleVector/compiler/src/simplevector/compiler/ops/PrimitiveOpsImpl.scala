package simplevector.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import simplevector.shared._
import simplevector.shared.ops._
import simplevector.compiler._
import simplevector.compiler.ops._

/**
 * Op Impls
 */

trait PrimitiveOpsImpl {
  this: SimpleVectorCompiler with SimpleVectorLift => 

  def primitive_repint2torepdouble_impl(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[Double] = {
    __arg0.toDouble
  }

  def primitive_repint2torepfloat_impl(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[Float] = {
    __arg0.toFloat
  }

  def primitive_repint2toreplong_impl(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[Long] = {
    __arg0.toLong
  }

  def primitive_repfloat2torepdouble_impl(__arg0: Rep[Float])(implicit __pos: SourceContext): Rep[Double] = {
    __arg0.toDouble
  }

}
