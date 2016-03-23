package simplevector.library.classes

import scala.reflect.{Manifest,SourceContext}
import scala.math.Ordering.Implicits._
import scala.math.Numeric.Implicits._
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import simplevector.shared._
import simplevector.shared.ops._
import simplevector.library._
import simplevector.library.classes._

trait NumericWrapper {
  this: SimpleVectorBase with SimpleVectorClasses => 

  def numeric_zero[T:Numeric:Manifest]()(implicit __pos: SourceContext) = {
    implicitly[Numeric[T]].zero
  }
  def numeric_pl[T:Numeric:Manifest](__arg0: Rep[T],__arg1: Rep[T])(implicit __pos: SourceContext) = {
    __arg0 + __arg1
  }
  def numeric_sub[T:Numeric:Manifest](__arg0: Rep[T],__arg1: Rep[T])(implicit __pos: SourceContext) = {
    __arg0 - __arg1
  }
  def numeric_mul[T:Numeric:Manifest](__arg0: Rep[T],__arg1: Rep[T])(implicit __pos: SourceContext) = {
    __arg0 * __arg1
  }

}

