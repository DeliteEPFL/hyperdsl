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

trait Tup5WrapperImpl {
  this: SimpleVectorApplication with SimpleVectorCompilerOps => 

  def tup5_unpack_impl6[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Rep[Tup5[A,B,C,D,E]])(implicit __pos: SourceContext): Tuple5[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E]] = {
    ((tup5__1(t),tup5__2(t),tup5__3(t),tup5__4(t),tup5__5(t)))
  }

  def tup5_pack_impl6[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Tuple5[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E]])(implicit __pos: SourceContext): Rep[Tup5[A,B,C,D,E]] = {
    internal_pack5(t._1,t._2,t._3,t._4,t._5)
  }

  def tup5_tostring_impl6[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Rep[Tup5[A,B,C,D,E]]): Rep[String] = {
    "("+t._1+","+t._2+","+t._3+","+t._4+","+t._5+")"
  }

}