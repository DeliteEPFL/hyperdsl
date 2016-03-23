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

trait Tup7WrapperImpl {
  this: SimpleVectorApplication with SimpleVectorCompilerOps => 

  def tup7_unpack_impl7[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](t: Rep[Tup7[A,B,C,D,E,F,G]])(implicit __pos: SourceContext): Tuple7[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G]] = {
    ((tup7__1(t),tup7__2(t),tup7__3(t),tup7__4(t),tup7__5(t),tup7__6(t),tup7__7(t)))
  }

  def tup7_pack_impl7[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](t: Tuple7[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G]])(implicit __pos: SourceContext): Rep[Tup7[A,B,C,D,E,F,G]] = {
    internal_pack7(t._1,t._2,t._3,t._4,t._5,t._6,t._7)
  }

  def tup7_tostring_impl7[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](t: Rep[Tup7[A,B,C,D,E,F,G]]): Rep[String] = {
    "("+t._1+","+t._2+","+t._3+","+t._4+","+t._5+","+t._6+","+t._7+")"
  }

}
