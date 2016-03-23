package simplevector.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import simplevector.shared._
import simplevector.shared.ops._
import simplevector.compiler._
import simplevector.compiler.ops._

/**
 * Op Impls
 */

trait Tup6OpsImpl {
  this: SimpleVectorCompiler with SimpleVectorLift => 

  def tup6_unpack_impl3[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Rep[Tup6[A,B,C,D,E,F]])(implicit __pos: SourceContext): Tuple6[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F]] = {
    ((tup6__1(t),tup6__2(t),tup6__3(t),tup6__4(t),tup6__5(t),tup6__6(t)))
  }

  def tup6_pack_impl3[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Tuple6[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F]])(implicit __pos: SourceContext): Rep[Tup6[A,B,C,D,E,F]] = {
    internal_pack6(t._1,t._2,t._3,t._4,t._5,t._6)
  }

  def tup6_tostring_impl3[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Rep[Tup6[A,B,C,D,E,F]]): Rep[String] = {
    "("+t._1+","+t._2+","+t._3+","+t._4+","+t._5+","+t._6+")"
  }

}
