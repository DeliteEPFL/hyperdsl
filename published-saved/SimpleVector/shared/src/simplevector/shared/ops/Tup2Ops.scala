package simplevector.shared.ops

import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import simplevector.shared._
import simplevector.shared.ops._

/**
 * Operations
 */

trait Tup2Ops extends Base {
  this: SimpleVector => 

  def unpack[A:Manifest,B:Manifest](t: Rep[Tup2[A,B]])(implicit __pos: SourceContext,__imp1: Overload8) = tup2_unpack[A,B](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos)
  def pack[A:Manifest,B:Manifest](t: Tuple2[Rep[A],Rep[B]])(implicit __pos: SourceContext,__imp1: Overload8) = tup2_pack[A,B](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload8)
  def pack[A:Manifest,B:Manifest](__arg0: Tuple2[Var[A],Rep[B]])(implicit __pos: SourceContext,__imp1: ROverload9): Rep[Tup2[A,B]] = { tup2_pack((__arg0._1,__arg0._2)) }
  def pack[A:Manifest,B:Manifest](__arg0: Tuple2[Rep[A],Var[B]])(implicit __pos: SourceContext,__imp1: ROverload10): Rep[Tup2[A,B]] = { tup2_pack((__arg0._1,__arg0._2)) }
  def pack[A:Manifest,B:Manifest](__arg0: Tuple2[Var[A],Var[B]])(implicit __pos: SourceContext,__imp1: ROverload11): Rep[Tup2[A,B]] = { tup2_pack((__arg0._1,__arg0._2)) }

  def infix__1[A:Manifest](__arg0: Rep[Tup2[A,_]])(implicit __pos: SourceContext,__imp1: Overload8) = tup2__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  def infix__2[B:Manifest](__arg0: Rep[Tup2[_,B]])(implicit __pos: SourceContext,__imp1: Overload8) = tup2__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  def infix_toString[A:Manifest,B:Manifest](t: Rep[Tup2[A,B]])(implicit __imp0: Overload8) = tup2_tostring[A,B](t)(implicitly[Manifest[A]],implicitly[Manifest[B]])

  def tup2__1[A:Manifest](__arg0: Rep[Tup2[A,_]])(implicit __pos: SourceContext): Rep[A]
  def tup2__2[B:Manifest](__arg0: Rep[Tup2[_,B]])(implicit __pos: SourceContext): Rep[B]
  def tup2_unpack[A:Manifest,B:Manifest](t: Rep[Tup2[A,B]])(implicit __pos: SourceContext): Tuple2[Rep[A],Rep[B]]
  def tup2_pack[A:Manifest,B:Manifest](t: Tuple2[Rep[A],Rep[B]])(implicit __pos: SourceContext,__imp1: Overload8): Rep[Tup2[A,B]]
  def tup2_tostring[A:Manifest,B:Manifest](t: Rep[Tup2[A,B]]): Rep[String]
}
trait Tup2CompilerOps extends Tup2Ops {
  this: SimpleVector => 

  def internal_pack2[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext): Rep[Tup2[A,B]]
}

