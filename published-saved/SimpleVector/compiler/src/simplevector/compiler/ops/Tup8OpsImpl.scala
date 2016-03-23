package simplevector.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import simplevector.shared._
import simplevector.shared.ops._
import simplevector.compiler._
import simplevector.compiler.ops._

/**
 * Op Impls
 */

trait Tup8OpsImpl {
  this: SimpleVectorCompiler with SimpleVectorLift => 

  def tup8_unpack_impl5[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Rep[Tup8[A,B,C,D,E,F,G,H]])(implicit __pos: SourceContext): Tuple8[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G],Rep[H]] = {
    ((tup8__1(t),tup8__2(t),tup8__3(t),tup8__4(t),tup8__5(t),tup8__6(t),tup8__7(t),tup8__8(t)))
  }

  def tup8_pack_impl5[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Tuple8[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G],Rep[H]])(implicit __pos: SourceContext): Rep[Tup8[A,B,C,D,E,F,G,H]] = {
    internal_pack8(t._1,t._2,t._3,t._4,t._5,t._6,t._7,t._8)
  }

  def tup8_tostring_impl5[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Rep[Tup8[A,B,C,D,E,F,G,H]]): Rep[String] = {
    "("+t._1+","+t._2+","+t._3+","+t._4+","+t._5+","+t._6+","+t._7+","+t._8+")"
  }

}
