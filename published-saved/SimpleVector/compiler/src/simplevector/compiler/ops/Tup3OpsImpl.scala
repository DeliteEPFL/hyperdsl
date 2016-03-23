package simplevector.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import simplevector.shared._
import simplevector.shared.ops._
import simplevector.compiler._
import simplevector.compiler.ops._

/**
 * Op Impls
 */

trait Tup3OpsImpl {
  this: SimpleVectorCompiler with SimpleVectorLift => 

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
