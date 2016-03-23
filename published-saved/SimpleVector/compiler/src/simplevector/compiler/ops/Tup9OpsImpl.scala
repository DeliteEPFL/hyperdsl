package simplevector.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import simplevector.shared._
import simplevector.shared.ops._
import simplevector.compiler._
import simplevector.compiler.ops._

/**
 * Op Impls
 */

trait Tup9OpsImpl {
  this: SimpleVectorCompiler with SimpleVectorLift => 

  def tup9_unpack_impl4[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](t: Rep[Tup9[A,B,C,D,E,F,G,H,I]])(implicit __pos: SourceContext): Tuple9[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G],Rep[H],Rep[I]] = {
    ((tup9__1(t),tup9__2(t),tup9__3(t),tup9__4(t),tup9__5(t),tup9__6(t),tup9__7(t),tup9__8(t),tup9__9(t)))
  }

  def tup9_pack_impl4[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](t: Tuple9[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G],Rep[H],Rep[I]])(implicit __pos: SourceContext): Rep[Tup9[A,B,C,D,E,F,G,H,I]] = {
    internal_pack9(t._1,t._2,t._3,t._4,t._5,t._6,t._7,t._8,t._9)
  }

  def tup9_tostring_impl4[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](t: Rep[Tup9[A,B,C,D,E,F,G,H,I]]): Rep[String] = {
    "("+t._1+","+t._2+","+t._3+","+t._4+","+t._5+","+t._6+","+t._7+","+t._8+","+t._9+")"
  }

}
