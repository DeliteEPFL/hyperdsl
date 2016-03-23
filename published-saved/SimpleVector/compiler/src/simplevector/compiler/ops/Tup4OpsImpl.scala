package simplevector.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import simplevector.shared._
import simplevector.shared.ops._
import simplevector.compiler._
import simplevector.compiler.ops._

/**
 * Op Impls
 */

trait Tup4OpsImpl {
  this: SimpleVectorCompiler with SimpleVectorLift => 

  def tup4_unpack_impl2[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Rep[Tup4[A,B,C,D]])(implicit __pos: SourceContext): Tuple4[Rep[A],Rep[B],Rep[C],Rep[D]] = {
    ((tup4__1(t),tup4__2(t),tup4__3(t),tup4__4(t)))
  }

  def tup4_pack_impl2[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Tuple4[Rep[A],Rep[B],Rep[C],Rep[D]])(implicit __pos: SourceContext): Rep[Tup4[A,B,C,D]] = {
    internal_pack4(t._1,t._2,t._3,t._4)
  }

  def tup4_tostring_impl2[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Rep[Tup4[A,B,C,D]]): Rep[String] = {
    "("+t._1+","+t._2+","+t._3+","+t._4+")"
  }

}
