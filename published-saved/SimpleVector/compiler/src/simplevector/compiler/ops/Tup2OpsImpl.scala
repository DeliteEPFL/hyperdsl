package simplevector.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import simplevector.shared._
import simplevector.shared.ops._
import simplevector.compiler._
import simplevector.compiler.ops._

/**
 * Op Impls
 */

trait Tup2OpsImpl {
  this: SimpleVectorCompiler with SimpleVectorLift => 

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
