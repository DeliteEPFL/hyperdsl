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

trait Tup3WrapperImpl {
  this: SimpleVectorApplication with SimpleVectorCompilerOps => 

  def tup3_unpack_impl1[A:Manifest,B:Manifest,C:Manifest](t: Rep[Tup3[A,B,C]])(implicit __pos: SourceContext): Tuple3[Rep[A],Rep[B],Rep[C]] = {
    ((tup3__1(t),tup3__2(t),tup3__3(t)))
  }

  def tup3_pack_impl1[A:Manifest,B:Manifest,C:Manifest](t: Tuple3[Rep[A],Rep[B],Rep[C]])(implicit __pos: SourceContext): Rep[Tup3[A,B,C]] = {
    internal_pack3(t._1,t._2,t._3)
  }

  def tup3_tostring_impl1[A:Manifest,B:Manifest,C:Manifest](t: Rep[Tup3[A,B,C]]): Rep[String] = {
    "("+t._1+","+t._2+","+t._3+")"
  }

}
