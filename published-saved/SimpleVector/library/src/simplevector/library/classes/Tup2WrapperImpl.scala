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

trait Tup2WrapperImpl {
  this: SimpleVectorApplication with SimpleVectorCompilerOps => 

  def tup2_unpack_impl8[A:Manifest,B:Manifest](t: Rep[Tup2[A,B]])(implicit __pos: SourceContext): Tuple2[Rep[A],Rep[B]] = {
    ((tup2__1(t),tup2__2(t)))
  }

  def tup2_pack_impl8[A:Manifest,B:Manifest](t: Tuple2[Rep[A],Rep[B]])(implicit __pos: SourceContext): Rep[Tup2[A,B]] = {
    internal_pack2(t._1,t._2)
  }

  def tup2_tostring_impl8[A:Manifest,B:Manifest](t: Rep[Tup2[A,B]]): Rep[String] = {
    "("+t._1+","+t._2+")"
  }

}
