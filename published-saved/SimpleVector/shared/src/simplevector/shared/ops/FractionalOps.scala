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

trait FractionalOps extends Base {
  this: SimpleVector => 

  implicit def repToFractionalTOpsCls[T:Manifest](x: Rep[T])(implicit __pos: SourceContext) = new FractionalTOpsCls(x)(implicitly[Manifest[T]],__pos)
  implicit def varToFractionalTOpsCls[T:Manifest](x: Var[T])(implicit __pos: SourceContext) = new FractionalTOpsCls(readVar(x))(implicitly[Manifest[T]],__pos)

  class FractionalTOpsCls[T:Manifest](val self: Rep[T])(implicit __pos: SourceContext) {
    def /[R:Fractional:Manifest](__arg1: Rep[R])(implicit __pos: SourceContext,__imp0: (Rep[T]) => Rep[R],__imp2: Overload129) = fractional_div[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Fractional[R]],implicitly[Manifest[R]],__pos,__imp0)
  }



  def fractional_div[T:Manifest,R:Fractional:Manifest](__arg0: Rep[T],__arg1: Rep[R])(implicit __pos: SourceContext,__imp0: (Rep[T]) => Rep[R]): Rep[R]
}
