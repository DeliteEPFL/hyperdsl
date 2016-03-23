package simplevector.shared.ops

import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import simplevector.shared._
import simplevector.shared.ops._

/**
 * Lift
 */

trait LiftNumeric {
  this: SimpleVector => 

  implicit def NumericTToRep[T:Numeric:Manifest](x: T) = unit(x)
}

/**
 * Operations
 */

trait NumericOps extends Base {
  this: SimpleVector => 

  implicit def repToNumericTOpsCls[T:Manifest](x: Rep[T])(implicit __pos: SourceContext) = new NumericTOpsCls(x)(implicitly[Manifest[T]],__pos)
  implicit def varToNumericTOpsCls[T:Manifest](x: Var[T])(implicit __pos: SourceContext) = new NumericTOpsCls(readVar(x))(implicitly[Manifest[T]],__pos)

  class NumericTOpsCls[T:Manifest](val self: Rep[T])(implicit __pos: SourceContext) {
    def -(__arg1: Rep[T])(implicit __cb0: Numeric[T],__pos: SourceContext,__imp1: Overload129) = numeric_sub[T](self,__arg1)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
    def *(__arg1: Rep[T])(implicit __cb0: Numeric[T],__pos: SourceContext,__imp1: Overload130) = numeric_mul[T](self,__arg1)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  }


  def infix_zero[T:Numeric:Manifest](implicit __pos: SourceContext) = numeric_zero[T]()(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  def infix_+[T:Numeric:Manifest](__arg0: Rep[T],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload146) = numeric_pl[T](__arg0,__arg1)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)

  def numeric_zero[T:Numeric:Manifest]()(implicit __pos: SourceContext): Rep[T]
  def numeric_pl[T:Numeric:Manifest](__arg0: Rep[T],__arg1: Rep[T])(implicit __pos: SourceContext): Rep[T]
  def numeric_sub[T:Numeric:Manifest](__arg0: Rep[T],__arg1: Rep[T])(implicit __pos: SourceContext): Rep[T]
  def numeric_mul[T:Numeric:Manifest](__arg0: Rep[T],__arg1: Rep[T])(implicit __pos: SourceContext): Rep[T]
}
