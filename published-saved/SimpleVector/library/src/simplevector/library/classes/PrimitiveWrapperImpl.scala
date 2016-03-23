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

trait PrimitiveWrapperImpl {
  this: SimpleVectorApplication with SimpleVectorCompilerOps => 

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
