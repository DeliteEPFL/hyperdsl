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

trait FractionalWrapper {
  this: SimpleVectorBase with SimpleVectorClasses => 

  def fractional_div[T:Manifest,R:Fractional:Manifest](__arg0: Rep[T],__arg1: Rep[R])(implicit __pos: SourceContext,__imp0: (Rep[T]) => Rep[R]) = {
    implicitly[Fractional[R]].div(__arg0,__arg1)
  }

}

