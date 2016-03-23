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

trait OrderingWrapper {
  this: SimpleVectorBase with SimpleVectorClasses => 

  def forge_equals[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext) = {
    __arg0 == __arg1
  }
  def forge_notequals[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext) = {
    __arg0 != __arg1
  }
  def ordering_min[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    __arg0 min __arg1
  }
  def ordering_max[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    __arg0 max __arg1
  }
  def ordering_lt[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    __arg0 < __arg1
  }
  def ordering_lteq[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    __arg0 <= __arg1
  }
  def ordering_gt[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    __arg0 > __arg1
  }
  def ordering_gteq[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    __arg0 >= __arg1
  }

}

