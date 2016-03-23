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

trait OrderingOps extends Base {
  this: SimpleVector => 

  def __equal[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: Overload1) = forge_equals[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos)
  def __equal[A:Manifest,B:Manifest](__arg0: Var[A],__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Boolean] = { forge_equals(readVar(__arg0), __arg1) }
  def __equal[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Var[B])(implicit __pos: SourceContext,__imp1: ROverload3): Rep[Boolean] = { forge_equals(__arg0, readVar(__arg1)) }
  def __equal[A:Manifest,B:Manifest](__arg0: Var[A],__arg1: Var[B])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[Boolean] = { forge_equals(readVar(__arg0), readVar(__arg1)) }
  def __equal[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: B)(implicit __pos: SourceContext,__imp1: ROverload5): Rep[Boolean] = { forge_equals(__arg0, unit(__arg1)) }
  def __equal[A:Manifest,B:Manifest](__arg0: Var[A],__arg1: B)(implicit __pos: SourceContext,__imp1: ROverload6): Rep[Boolean] = { forge_equals(readVar(__arg0), unit(__arg1)) }
  def __equal[A:Manifest,B:Manifest](__arg0: A,__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: ROverload7): Rep[Boolean] = { forge_equals(unit(__arg0), __arg1) }
  def __equal[A:Manifest,B:Manifest](__arg0: A,__arg1: Var[B])(implicit __pos: SourceContext,__imp1: ROverload8): Rep[Boolean] = { forge_equals(unit(__arg0), readVar(__arg1)) }

  implicit def repToOrderingAOpsCls[A:Manifest](x: Rep[A])(implicit __pos: SourceContext) = new OrderingAOpsCls(x)(implicitly[Manifest[A]],__pos)
  implicit def varToOrderingAOpsCls[A:Manifest](x: Var[A])(implicit __pos: SourceContext) = new OrderingAOpsCls(readVar(x))(implicitly[Manifest[A]],__pos)

  class OrderingAOpsCls[A:Manifest](val self: Rep[A])(implicit __pos: SourceContext) {
    def <(__arg1: Rep[A])(implicit __cb0: Ordering[A],__pos: SourceContext) = ordering_lt[A](self,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos)
    def <=(__arg1: Rep[A])(implicit __cb0: Ordering[A],__pos: SourceContext) = ordering_lteq[A](self,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos)
    def >(__arg1: Rep[A])(implicit __cb0: Ordering[A],__pos: SourceContext) = ordering_gt[A](self,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos)
    def >=(__arg1: Rep[A])(implicit __cb0: Ordering[A],__pos: SourceContext) = ordering_gteq[A](self,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos)
  }


  def infix_!=[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: Overload1) = forge_notequals[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos)
  def infix_!=[A:Manifest,B:Manifest](__arg0: Var[A],__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Boolean] = { forge_notequals(readVar(__arg0), __arg1) }
  def infix_!=[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Var[B])(implicit __pos: SourceContext,__imp1: ROverload3): Rep[Boolean] = { forge_notequals(__arg0, readVar(__arg1)) }
  def infix_!=[A:Manifest,B:Manifest](__arg0: Var[A],__arg1: Var[B])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[Boolean] = { forge_notequals(readVar(__arg0), readVar(__arg1)) }
  def infix_!=[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: B)(implicit __pos: SourceContext,__imp1: ROverload5): Rep[Boolean] = { forge_notequals(__arg0, unit(__arg1)) }
  def infix_!=[A:Manifest,B:Manifest](__arg0: Var[A],__arg1: B)(implicit __pos: SourceContext,__imp1: ROverload6): Rep[Boolean] = { forge_notequals(readVar(__arg0), unit(__arg1)) }
  def infix_!=[A:Manifest,B:Manifest](__arg0: A,__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: ROverload7): Rep[Boolean] = { forge_notequals(unit(__arg0), __arg1) }
  def infix_!=[A:Manifest,B:Manifest](__arg0: A,__arg1: Var[B])(implicit __pos: SourceContext,__imp1: ROverload8): Rep[Boolean] = { forge_notequals(unit(__arg0), readVar(__arg1)) }
  def infix_min[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = ordering_min[A](__arg0,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos)
  def infix_max[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = ordering_max[A](__arg0,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos)

  def forge_equals[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext): Rep[Boolean]
  def forge_notequals[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext): Rep[Boolean]
  def ordering_min[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext): Rep[A]
  def ordering_max[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext): Rep[A]
  def ordering_lt[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext): Rep[Boolean]
  def ordering_lteq[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext): Rep[Boolean]
  def ordering_gt[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext): Rep[Boolean]
  def ordering_gteq[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext): Rep[Boolean]
}
