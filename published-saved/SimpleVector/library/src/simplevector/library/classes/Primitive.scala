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

trait PrimitiveWrapper {
  this: SimpleVectorBase with SimpleVectorClasses => 

  def primitive_unary_bang(__arg0: Rep[Boolean])(implicit __pos: SourceContext) = {
    !__arg0
  }
  def primitive_oror(__arg0: Rep[Boolean],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = {
    __arg0 || __arg1
  }
  def primitive_andand(__arg0: Rep[Boolean],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = {
    __arg0 && __arg1
  }
  def primitive_toint[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    __arg0.toInt
  }
  def primitive_tofloat[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    __arg0.toFloat
  }
  def primitive_todouble[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    __arg0.toDouble
  }
  def primitive_tolong[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    __arg0.toLong
  }
  def primitive_repint2torepdouble(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    primitive_repint2torepdouble_impl(__arg0)(__pos)
  }
  def primitive_repint2torepfloat(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    primitive_repint2torepfloat_impl(__arg0)(__pos)
  }
  def primitive_repint2toreplong(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    primitive_repint2toreplong_impl(__arg0)(__pos)
  }
  def primitive_repfloat2torepdouble(__arg0: Rep[Float])(implicit __pos: SourceContext) = {
    primitive_repfloat2torepdouble_impl(__arg0)(__pos)
  }
  def primitive_forge_int_plus(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 + __arg1
  }
  def primitive_forge_int_minus(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 - __arg1
  }
  def primitive_forge_int_times(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 * __arg1
  }
  def primitive_forge_int_divide(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 / __arg1
  }
  def primitive_forge_int_shift_left(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 << __arg1
  }
  def primitive_forge_int_shift_right_unsigned(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 >>> __arg1
  }
  def primitive_forge_int_and(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 & __arg1
  }
  def primitive_forge_int_or(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 | __arg1
  }
  def primitive_forge_int_shift_right(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 >> __arg1
  }
  def primitive_%(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = {
    __arg0 % __arg1
  }
  def primitive_unary_~(__arg0: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = {
    ~__arg0
  }
  def primitive_forge_float_plus(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = {
    __arg0 + __arg1
  }
  def primitive_forge_float_minus(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = {
    __arg0 - __arg1
  }
  def primitive_forge_float_times(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = {
    __arg0 * __arg1
  }
  def primitive_forge_float_divide(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = {
    __arg0 / __arg1
  }
  def primitive_forge_double_plus(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    __arg0 + __arg1
  }
  def primitive_forge_double_minus(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    __arg0 - __arg1
  }
  def primitive_forge_double_times(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    __arg0 * __arg1
  }
  def primitive_forge_double_divide(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    __arg0 / __arg1
  }
  def primitive_forge_long_plus(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    __arg0 + __arg1
  }
  def primitive_forge_long_minus(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    __arg0 - __arg1
  }
  def primitive_forge_long_times(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    __arg0 * __arg1
  }
  def primitive_forge_long_divide(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    __arg0 / __arg1
  }
  def primitive_forge_long_divide_double(__arg0: Rep[Long],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    __arg0 / __arg1
  }
  def primitive_forge_long_and(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    __arg0 & __arg1
  }
  def primitive_forge_long_or(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    __arg0 | __arg1
  }
  def primitive_forge_long_xor(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    __arg0 ^ __arg1
  }
  def primitive_forge_long_shift_right_unsigned(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 >>> __arg1
  }
  def primitive_forge_long_shift_right(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 >> __arg1
  }
  def primitive_forge_long_shift_left(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0 << __arg1
  }
  def primitive_%(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext,__imp1: Overload2) = {
    __arg0 % __arg1
  }
  def primitive_unary_~(__arg0: Rep[Long])(implicit __pos: SourceContext,__imp1: Overload2) = {
    ~__arg0
  }

}

