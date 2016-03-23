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

trait LiftPrimitive {
  this: SimpleVector => 

  implicit def PrimitiveBooleanToRep(x: Boolean) = unit(x)
  implicit def PrimitiveShortToRep(x: Short) = unit(x)
  implicit def PrimitiveIntToRep(x: Int) = unit(x)
  implicit def PrimitiveLongToRep(x: Long) = unit(x)
  implicit def PrimitiveFloatToRep(x: Float) = unit(x)
  implicit def PrimitiveDoubleToRep(x: Double) = unit(x)
}

/**
 * Operations
 */

trait PrimitiveOpsBase extends Base {
  this: SimpleVector => 

  implicit def repInt2ToRepDouble(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[Double] = primitive_repint2torepdouble(__arg0)(__pos)
  implicit def repInt2ToRepFloat(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[Float] = primitive_repint2torepfloat(__arg0)(__pos)
  implicit def repInt2ToRepLong(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[Long] = primitive_repint2toreplong(__arg0)(__pos)
  implicit def repFloat2ToRepDouble(__arg0: Rep[Float])(implicit __pos: SourceContext): Rep[Double] = primitive_repfloat2torepdouble(__arg0)(__pos)

  def primitive_repint2torepdouble(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[Double]
  def primitive_repint2torepfloat(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[Float]
  def primitive_repint2toreplong(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[Long]
  def primitive_repfloat2torepdouble(__arg0: Rep[Float])(implicit __pos: SourceContext): Rep[Double]
}

trait PrimitiveOps extends PrimitiveOpsBase {
  this: SimpleVector => 

  def forge_int_plus(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive_forge_int_plus(__arg0,__arg1)(__pos)
  def forge_int_minus(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive_forge_int_minus(__arg0,__arg1)(__pos)
  def forge_int_times(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive_forge_int_times(__arg0,__arg1)(__pos)
  def forge_int_divide(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive_forge_int_divide(__arg0,__arg1)(__pos)
  def forge_int_shift_left(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive_forge_int_shift_left(__arg0,__arg1)(__pos)
  def forge_int_shift_right_unsigned(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive_forge_int_shift_right_unsigned(__arg0,__arg1)(__pos)
  def forge_int_and(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive_forge_int_and(__arg0,__arg1)(__pos)
  def forge_int_or(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive_forge_int_or(__arg0,__arg1)(__pos)
  def forge_int_shift_right(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive_forge_int_shift_right(__arg0,__arg1)(__pos)
  def forge_float_plus(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = primitive_forge_float_plus(__arg0,__arg1)(__pos)
  def forge_float_minus(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = primitive_forge_float_minus(__arg0,__arg1)(__pos)
  def forge_float_times(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = primitive_forge_float_times(__arg0,__arg1)(__pos)
  def forge_float_divide(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = primitive_forge_float_divide(__arg0,__arg1)(__pos)
  def forge_double_plus(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = primitive_forge_double_plus(__arg0,__arg1)(__pos)
  def forge_double_minus(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = primitive_forge_double_minus(__arg0,__arg1)(__pos)
  def forge_double_times(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = primitive_forge_double_times(__arg0,__arg1)(__pos)
  def forge_double_divide(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = primitive_forge_double_divide(__arg0,__arg1)(__pos)
  def forge_long_plus(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = primitive_forge_long_plus(__arg0,__arg1)(__pos)
  def forge_long_minus(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = primitive_forge_long_minus(__arg0,__arg1)(__pos)
  def forge_long_times(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = primitive_forge_long_times(__arg0,__arg1)(__pos)
  def forge_long_divide(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = primitive_forge_long_divide(__arg0,__arg1)(__pos)
  def forge_long_divide_double(__arg0: Rep[Long],__arg1: Rep[Double])(implicit __pos: SourceContext) = primitive_forge_long_divide_double(__arg0,__arg1)(__pos)
  def forge_long_and(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = primitive_forge_long_and(__arg0,__arg1)(__pos)
  def forge_long_or(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = primitive_forge_long_or(__arg0,__arg1)(__pos)
  def forge_long_xor(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = primitive_forge_long_xor(__arg0,__arg1)(__pos)
  def forge_long_shift_right_unsigned(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive_forge_long_shift_right_unsigned(__arg0,__arg1)(__pos)
  def forge_long_shift_right(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive_forge_long_shift_right(__arg0,__arg1)(__pos)
  def forge_long_shift_left(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext) = primitive_forge_long_shift_left(__arg0,__arg1)(__pos)

  implicit def repToPrimitiveDoubleOpsCls(x: Rep[Double])(implicit __pos: SourceContext) = new PrimitiveDoubleOpsCls(x)(__pos)
  implicit def liftToPrimitiveDoubleOpsCls(x: Double)(implicit __pos: SourceContext) = new PrimitiveDoubleOpsCls(unit(x))(__pos)
  implicit def varToPrimitiveDoubleOpsCls(x: Var[Double])(implicit __pos: SourceContext) = new PrimitiveDoubleOpsCls(readVar(x))(__pos)

  class PrimitiveDoubleOpsCls(val self: Rep[Double])(implicit __pos: SourceContext) {
    def -(rhs: Double)(implicit __pos: SourceContext,__imp1: ROverload9) = { forge_double_minus(self, unit(rhs)) }
    def *(rhs: Double)(implicit __pos: SourceContext,__imp1: ROverload10) = { forge_double_times(self, unit(rhs)) }
    def /(rhs: Double)(implicit __pos: SourceContext,__imp1: ROverload9) = { forge_double_divide(self, unit(rhs)) }
    def -(rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload10) = { forge_double_minus(self, rhs) }
    def *(rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload11) = { forge_double_times(self, rhs) }
    def /(rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload10) = { forge_double_divide(self, rhs) }
    def -(rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload11) = { forge_double_minus(self, readVar(rhs)) }
    def *(rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload12) = { forge_double_times(self, readVar(rhs)) }
    def /(rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload11) = { forge_double_divide(self, readVar(rhs)) }
    def -(rhs: Float)(implicit __pos: SourceContext,__imp1: ROverload12) = { forge_double_minus(self, unit(rhs.toDouble)) }
    def *(rhs: Float)(implicit __pos: SourceContext,__imp1: ROverload13) = { forge_double_times(self, unit(rhs.toDouble)) }
    def /(rhs: Float)(implicit __pos: SourceContext,__imp1: ROverload12) = { forge_double_divide(self, unit(rhs.toDouble)) }
    def -(rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload13) = { forge_double_minus(self, rhs.toDouble) }
    def *(rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload14) = { forge_double_times(self, rhs.toDouble) }
    def /(rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload13) = { forge_double_divide(self, rhs.toDouble) }
    def -(rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload14) = { forge_double_minus(self, readVar(rhs).toDouble) }
    def *(rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload15) = { forge_double_times(self, readVar(rhs).toDouble) }
    def /(rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload14) = { forge_double_divide(self, readVar(rhs).toDouble) }
    def -(rhs: Int)(implicit __pos: SourceContext,__imp1: ROverload15) = { forge_double_minus(self, unit(rhs.toDouble)) }
    def *(rhs: Int)(implicit __pos: SourceContext,__imp1: ROverload16) = { forge_double_times(self, unit(rhs.toDouble)) }
    def /(rhs: Int)(implicit __pos: SourceContext,__imp1: ROverload15) = { forge_double_divide(self, unit(rhs.toDouble)) }
    def -(rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload16) = { forge_double_minus(self, rhs.toDouble) }
    def *(rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload17) = { forge_double_times(self, rhs.toDouble) }
    def /(rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload16) = { forge_double_divide(self, rhs.toDouble) }
    def -(rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload17) = { forge_double_minus(self, readVar(rhs).toDouble) }
    def *(rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload18) = { forge_double_times(self, readVar(rhs).toDouble) }
    def /(rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload17) = { forge_double_divide(self, readVar(rhs).toDouble) }
    def -(rhs: Long)(implicit __pos: SourceContext,__imp1: ROverload18) = { forge_double_minus(self, unit(rhs.toDouble)) }
    def *(rhs: Long)(implicit __pos: SourceContext,__imp1: ROverload19) = { forge_double_times(self, unit(rhs.toDouble)) }
    def /(rhs: Long)(implicit __pos: SourceContext,__imp1: ROverload18) = { forge_double_divide(self, unit(rhs.toDouble)) }
    def -(rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload19) = { forge_double_minus(self, rhs.toDouble) }
    def *(rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload20) = { forge_double_times(self, rhs.toDouble) }
    def /(rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload19) = { forge_double_divide(self, rhs.toDouble) }
    def -(rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload20) = { forge_double_minus(self, readVar(rhs).toDouble) }
    def *(rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload21) = { forge_double_times(self, readVar(rhs).toDouble) }
    def /(rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload20) = { forge_double_divide(self, readVar(rhs).toDouble) }
  }

  implicit def repToPrimitiveFloatOpsCls(x: Rep[Float])(implicit __pos: SourceContext) = new PrimitiveFloatOpsCls(x)(__pos)
  implicit def liftToPrimitiveFloatOpsCls(x: Float)(implicit __pos: SourceContext) = new PrimitiveFloatOpsCls(unit(x))(__pos)
  implicit def varToPrimitiveFloatOpsCls(x: Var[Float])(implicit __pos: SourceContext) = new PrimitiveFloatOpsCls(readVar(x))(__pos)

  class PrimitiveFloatOpsCls(val self: Rep[Float])(implicit __pos: SourceContext) {
    def -(rhs: Double)(implicit __pos: SourceContext,__imp1: ROverload41) = { forge_double_minus(self.toDouble, unit(rhs)) }
    def *(rhs: Double)(implicit __pos: SourceContext,__imp1: ROverload42) = { forge_double_times(self.toDouble, unit(rhs)) }
    def /(rhs: Double)(implicit __pos: SourceContext,__imp1: ROverload41) = { forge_double_divide(self.toDouble, unit(rhs)) }
    def -(rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload42) = { forge_double_minus(self.toDouble, rhs) }
    def *(rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload43) = { forge_double_times(self.toDouble, rhs) }
    def /(rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload42) = { forge_double_divide(self.toDouble, rhs) }
    def -(rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload43) = { forge_double_minus(self.toDouble, readVar(rhs)) }
    def *(rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload44) = { forge_double_times(self.toDouble, readVar(rhs)) }
    def /(rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload43) = { forge_double_divide(self.toDouble, readVar(rhs)) }
    def -(rhs: Float)(implicit __pos: SourceContext,__imp1: ROverload44) = { forge_float_minus(self, unit(rhs)) }
    def *(rhs: Float)(implicit __pos: SourceContext,__imp1: ROverload45) = { forge_float_times(self, unit(rhs)) }
    def /(rhs: Float)(implicit __pos: SourceContext,__imp1: ROverload44) = { forge_float_divide(self, unit(rhs)) }
    def -(rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload45) = { forge_float_minus(self, rhs) }
    def *(rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload46) = { forge_float_times(self, rhs) }
    def /(rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload45) = { forge_float_divide(self, rhs) }
    def -(rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload46) = { forge_float_minus(self, readVar(rhs)) }
    def *(rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload47) = { forge_float_times(self, readVar(rhs)) }
    def /(rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload46) = { forge_float_divide(self, readVar(rhs)) }
    def -(rhs: Int)(implicit __pos: SourceContext,__imp1: ROverload47) = { forge_float_minus(self, unit(rhs.toFloat)) }
    def *(rhs: Int)(implicit __pos: SourceContext,__imp1: ROverload48) = { forge_float_times(self, unit(rhs.toFloat)) }
    def /(rhs: Int)(implicit __pos: SourceContext,__imp1: ROverload47) = { forge_float_divide(self, unit(rhs.toFloat)) }
    def -(rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload48) = { forge_float_minus(self, rhs.toFloat) }
    def *(rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload49) = { forge_float_times(self, rhs.toFloat) }
    def /(rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload48) = { forge_float_divide(self, rhs.toFloat) }
    def -(rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload49) = { forge_float_minus(self, readVar(rhs).toFloat) }
    def *(rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload50) = { forge_float_times(self, readVar(rhs).toFloat) }
    def /(rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload49) = { forge_float_divide(self, readVar(rhs).toFloat) }
    def -(rhs: Long)(implicit __pos: SourceContext,__imp1: ROverload50) = { forge_float_minus(self, unit(rhs.toFloat)) }
    def *(rhs: Long)(implicit __pos: SourceContext,__imp1: ROverload51) = { forge_float_times(self, unit(rhs.toFloat)) }
    def /(rhs: Long)(implicit __pos: SourceContext,__imp1: ROverload50) = { forge_float_divide(self, unit(rhs.toFloat)) }
    def -(rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload51) = { forge_float_minus(self, rhs.toFloat) }
    def *(rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload52) = { forge_float_times(self, rhs.toFloat) }
    def /(rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload51) = { forge_float_divide(self, rhs.toFloat) }
    def -(rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload52) = { forge_float_minus(self, readVar(rhs).toFloat) }
    def *(rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload53) = { forge_float_times(self, readVar(rhs).toFloat) }
    def /(rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload52) = { forge_float_divide(self, readVar(rhs).toFloat) }
  }

  implicit def repToPrimitiveIntOpsCls(x: Rep[Int])(implicit __pos: SourceContext) = new PrimitiveIntOpsCls(x)(__pos)
  implicit def liftToPrimitiveIntOpsCls(x: Int)(implicit __pos: SourceContext) = new PrimitiveIntOpsCls(unit(x))(__pos)
  implicit def varToPrimitiveIntOpsCls(x: Var[Int])(implicit __pos: SourceContext) = new PrimitiveIntOpsCls(readVar(x))(__pos)

  class PrimitiveIntOpsCls(val self: Rep[Int])(implicit __pos: SourceContext) {
    def -(rhs: Double)(implicit __pos: SourceContext,__imp1: ROverload73) = { forge_double_minus(self.toDouble, unit(rhs)) }
    def *(rhs: Double)(implicit __pos: SourceContext,__imp1: ROverload74) = { forge_double_times(self.toDouble, unit(rhs)) }
    def /(rhs: Double)(implicit __pos: SourceContext,__imp1: ROverload73) = { forge_double_divide(self.toDouble, unit(rhs)) }
    def -(rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload74) = { forge_double_minus(self.toDouble, rhs) }
    def *(rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload75) = { forge_double_times(self.toDouble, rhs) }
    def /(rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload74) = { forge_double_divide(self.toDouble, rhs) }
    def -(rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload75) = { forge_double_minus(self.toDouble, readVar(rhs)) }
    def *(rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload76) = { forge_double_times(self.toDouble, readVar(rhs)) }
    def /(rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload75) = { forge_double_divide(self.toDouble, readVar(rhs)) }
    def -(rhs: Float)(implicit __pos: SourceContext,__imp1: ROverload76) = { forge_float_minus(self.toFloat, unit(rhs)) }
    def *(rhs: Float)(implicit __pos: SourceContext,__imp1: ROverload77) = { forge_float_times(self.toFloat, unit(rhs)) }
    def /(rhs: Float)(implicit __pos: SourceContext,__imp1: ROverload76) = { forge_float_divide(self.toFloat, unit(rhs)) }
    def -(rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload77) = { forge_float_minus(self.toFloat, rhs) }
    def *(rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload78) = { forge_float_times(self.toFloat, rhs) }
    def /(rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload77) = { forge_float_divide(self.toFloat, rhs) }
    def -(rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload78) = { forge_float_minus(self.toFloat, readVar(rhs)) }
    def *(rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload79) = { forge_float_times(self.toFloat, readVar(rhs)) }
    def /(rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload78) = { forge_float_divide(self.toFloat, readVar(rhs)) }
    def -(rhs: Int)(implicit __pos: SourceContext,__imp1: ROverload79) = { forge_int_minus(self, unit(rhs)) }
    def *(rhs: Int)(implicit __pos: SourceContext,__imp1: ROverload80) = { forge_int_times(self, unit(rhs)) }
    def /(rhs: Int)(implicit __pos: SourceContext,__imp1: ROverload79) = { forge_int_divide(self, unit(rhs)) }
    def -(rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload80) = { forge_int_minus(self, rhs) }
    def *(rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload81) = { forge_int_times(self, rhs) }
    def /(rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload80) = { forge_int_divide(self, rhs) }
    def -(rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload81) = { forge_int_minus(self, readVar(rhs)) }
    def *(rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload82) = { forge_int_times(self, readVar(rhs)) }
    def /(rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload81) = { forge_int_divide(self, readVar(rhs)) }
    def -(rhs: Long)(implicit __pos: SourceContext,__imp1: ROverload82) = { forge_long_minus(self.toLong, unit(rhs)) }
    def *(rhs: Long)(implicit __pos: SourceContext,__imp1: ROverload83) = { forge_long_times(self.toLong, unit(rhs)) }
    def /(rhs: Long)(implicit __pos: SourceContext,__imp1: ROverload82) = { forge_long_divide(self.toLong, unit(rhs)) }
    def -(rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload83) = { forge_long_minus(self.toLong, rhs) }
    def *(rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload84) = { forge_long_times(self.toLong, rhs) }
    def /(rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload83) = { forge_long_divide(self.toLong, rhs) }
    def -(rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload84) = { forge_long_minus(self.toLong, readVar(rhs)) }
    def *(rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload85) = { forge_long_times(self.toLong, readVar(rhs)) }
    def /(rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload84) = { forge_long_divide(self.toLong, readVar(rhs)) }
  }

  implicit def repToPrimitiveLongOpsCls(x: Rep[Long])(implicit __pos: SourceContext) = new PrimitiveLongOpsCls(x)(__pos)
  implicit def liftToPrimitiveLongOpsCls(x: Long)(implicit __pos: SourceContext) = new PrimitiveLongOpsCls(unit(x))(__pos)
  implicit def varToPrimitiveLongOpsCls(x: Var[Long])(implicit __pos: SourceContext) = new PrimitiveLongOpsCls(readVar(x))(__pos)

  class PrimitiveLongOpsCls(val self: Rep[Long])(implicit __pos: SourceContext) {
    def -(rhs: Double)(implicit __pos: SourceContext,__imp1: ROverload105) = { forge_double_minus(self.toDouble, unit(rhs)) }
    def *(rhs: Double)(implicit __pos: SourceContext,__imp1: ROverload106) = { forge_double_times(self.toDouble, unit(rhs)) }
    def /(rhs: Double)(implicit __pos: SourceContext,__imp1: ROverload105) = { forge_double_divide(self.toDouble, unit(rhs)) }
    def -(rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload106) = { forge_double_minus(self.toDouble, rhs) }
    def *(rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload107) = { forge_double_times(self.toDouble, rhs) }
    def /(rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload106) = { forge_double_divide(self.toDouble, rhs) }
    def -(rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload107) = { forge_double_minus(self.toDouble, readVar(rhs)) }
    def *(rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload108) = { forge_double_times(self.toDouble, readVar(rhs)) }
    def /(rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload107) = { forge_double_divide(self.toDouble, readVar(rhs)) }
    def -(rhs: Float)(implicit __pos: SourceContext,__imp1: ROverload108) = { forge_float_minus(self.toFloat, unit(rhs)) }
    def *(rhs: Float)(implicit __pos: SourceContext,__imp1: ROverload109) = { forge_float_times(self.toFloat, unit(rhs)) }
    def /(rhs: Float)(implicit __pos: SourceContext,__imp1: ROverload108) = { forge_float_divide(self.toFloat, unit(rhs)) }
    def -(rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload109) = { forge_float_minus(self.toFloat, rhs) }
    def *(rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload110) = { forge_float_times(self.toFloat, rhs) }
    def /(rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload109) = { forge_float_divide(self.toFloat, rhs) }
    def -(rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload110) = { forge_float_minus(self.toFloat, readVar(rhs)) }
    def *(rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload111) = { forge_float_times(self.toFloat, readVar(rhs)) }
    def /(rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload110) = { forge_float_divide(self.toFloat, readVar(rhs)) }
    def -(rhs: Int)(implicit __pos: SourceContext,__imp1: ROverload111) = { forge_long_minus(self, unit(rhs.toLong)) }
    def *(rhs: Int)(implicit __pos: SourceContext,__imp1: ROverload112) = { forge_long_times(self, unit(rhs.toLong)) }
    def /(rhs: Int)(implicit __pos: SourceContext,__imp1: ROverload111) = { forge_long_divide(self, unit(rhs.toLong)) }
    def -(rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload112) = { forge_long_minus(self, rhs.toLong) }
    def *(rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload113) = { forge_long_times(self, rhs.toLong) }
    def /(rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload112) = { forge_long_divide(self, rhs.toLong) }
    def -(rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload113) = { forge_long_minus(self, readVar(rhs).toLong) }
    def *(rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload114) = { forge_long_times(self, readVar(rhs).toLong) }
    def /(rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload113) = { forge_long_divide(self, readVar(rhs).toLong) }
    def -(rhs: Long)(implicit __pos: SourceContext,__imp1: ROverload114) = { forge_long_minus(self, unit(rhs)) }
    def *(rhs: Long)(implicit __pos: SourceContext,__imp1: ROverload115) = { forge_long_times(self, unit(rhs)) }
    def /(rhs: Long)(implicit __pos: SourceContext,__imp1: ROverload114) = { forge_long_divide(self, unit(rhs)) }
    def -(rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload115) = { forge_long_minus(self, rhs) }
    def *(rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload116) = { forge_long_times(self, rhs) }
    def /(rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload115) = { forge_long_divide(self, rhs) }
    def -(rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload116) = { forge_long_minus(self, readVar(rhs)) }
    def *(rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload117) = { forge_long_times(self, readVar(rhs)) }
    def /(rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload116) = { forge_long_divide(self, readVar(rhs)) }
  }


  def infix_unary_!(__arg0: Rep[Boolean])(implicit __pos: SourceContext) = primitive_unary_bang(__arg0)(__pos)
  def infix_||(__arg0: Rep[Boolean],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = primitive_oror(__arg0,__arg1)(__pos)
  def infix_&&(__arg0: Rep[Boolean],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = primitive_andand(__arg0,__arg1)(__pos)
  def infix_unary_-(__arg0: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { unit(-1)*__arg0 }
  def infix_unary_-(__arg0: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { unit(-1L)*__arg0 }
  def infix_unary_-(__arg0: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload3): Rep[Float] = { unit(-1f)*__arg0 }
  def infix_unary_-(__arg0: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[Double] = { unit(-1)*__arg0 }
  def infix_toInt[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext,__imp1: Overload2) = primitive_toint[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  def infix_toFloat[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext,__imp1: Overload2) = primitive_tofloat[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  def infix_toDouble[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext,__imp1: Overload2) = primitive_todouble[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  def infix_toLong[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext,__imp1: Overload2) = primitive_tolong[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  def infix_%(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = primitive_%(__arg0,__arg1)(__pos,overload1)
  def infix_unary_~(__arg0: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = primitive_unary_~(__arg0)(__pos,overload1)
  def infix_%(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext,__imp1: Overload2) = primitive_%(__arg0,__arg1)(__pos,overload2)
  def infix_unary_~(__arg0: Rep[Long])(implicit __pos: SourceContext,__imp1: Overload2) = primitive_unary_~(__arg0)(__pos,overload2)
  def infix_<<(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { forge_int_shift_left(__arg0,__arg1) }
  def infix_>>(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { forge_int_shift_right(__arg0,__arg1) }
  def infix_>>>(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { forge_int_shift_right_unsigned(__arg0,__arg1) }
  def infix_&(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { forge_int_and(__arg0,__arg1) }
  def infix_|(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { forge_int_or(__arg0,__arg1) }
  def infix_&(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { forge_long_and(__arg0,__arg1) }
  def infix_|(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { forge_long_or(__arg0,__arg1) }
  def infix_^(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext): Rep[Long] = { forge_long_xor(__arg0,__arg1) }
  def infix_>>>(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { forge_long_shift_right_unsigned(__arg0,__arg1) }
  def infix_<<(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { forge_long_shift_left(__arg0,__arg1) }
  def infix_>>(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { forge_long_shift_right(__arg0,__arg1) }
  def infix_+(lhs: Double,rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload18): Rep[Double] = { forge_double_plus(unit(lhs), rhs) }
  def infix_+(lhs: Double,rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload19): Rep[Double] = { forge_double_plus(unit(lhs), readVar(rhs)) }
  def infix_+(lhs: Double,rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload20): Rep[Double] = { forge_double_plus(unit(lhs), rhs.toDouble) }
  def infix_+(lhs: Double,rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload21): Rep[Double] = { forge_double_plus(unit(lhs), readVar(rhs).toDouble) }
  def infix_+(lhs: Double,rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload22): Rep[Double] = { forge_double_plus(unit(lhs), rhs.toDouble) }
  def infix_+(lhs: Double,rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload23): Rep[Double] = { forge_double_plus(unit(lhs), readVar(rhs).toDouble) }
  def infix_+(lhs: Double,rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload24): Rep[Double] = { forge_double_plus(unit(lhs), rhs.toDouble) }
  def infix_+(lhs: Double,rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload25): Rep[Double] = { forge_double_plus(unit(lhs), readVar(rhs).toDouble) }
  def infix_+(lhs: Rep[Double],rhs: Double)(implicit __pos: SourceContext,__imp1: ROverload26): Rep[Double] = { forge_double_plus(lhs, unit(rhs)) }
  def infix_+(lhs: Rep[Double],rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload27): Rep[Double] = { forge_double_plus(lhs, rhs) }
  def infix_+(lhs: Rep[Double],rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload28): Rep[Double] = { forge_double_plus(lhs, readVar(rhs)) }
  def infix_+(lhs: Rep[Double],rhs: Float)(implicit __pos: SourceContext,__imp1: ROverload29): Rep[Double] = { forge_double_plus(lhs, unit(rhs.toDouble)) }
  def infix_+(lhs: Rep[Double],rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload30): Rep[Double] = { forge_double_plus(lhs, rhs.toDouble) }
  def infix_+(lhs: Rep[Double],rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload31): Rep[Double] = { forge_double_plus(lhs, readVar(rhs).toDouble) }
  def infix_+(lhs: Rep[Double],rhs: Int)(implicit __pos: SourceContext,__imp1: ROverload32): Rep[Double] = { forge_double_plus(lhs, unit(rhs.toDouble)) }
  def infix_+(lhs: Rep[Double],rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload33): Rep[Double] = { forge_double_plus(lhs, rhs.toDouble) }
  def infix_+(lhs: Rep[Double],rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload34): Rep[Double] = { forge_double_plus(lhs, readVar(rhs).toDouble) }
  def infix_+(lhs: Rep[Double],rhs: Long)(implicit __pos: SourceContext,__imp1: ROverload35): Rep[Double] = { forge_double_plus(lhs, unit(rhs.toDouble)) }
  def infix_+(lhs: Rep[Double],rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload36): Rep[Double] = { forge_double_plus(lhs, rhs.toDouble) }
  def infix_+(lhs: Rep[Double],rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload37): Rep[Double] = { forge_double_plus(lhs, readVar(rhs).toDouble) }
  def infix_+(lhs: Var[Double],rhs: Double)(implicit __pos: SourceContext,__imp1: ROverload38): Rep[Double] = { forge_double_plus(readVar(lhs), unit(rhs)) }
  def infix_+(lhs: Var[Double],rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload39): Rep[Double] = { forge_double_plus(readVar(lhs), rhs) }
  def infix_+(lhs: Var[Double],rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload40): Rep[Double] = { forge_double_plus(readVar(lhs), readVar(rhs)) }
  def infix_+(lhs: Var[Double],rhs: Float)(implicit __pos: SourceContext,__imp1: ROverload41): Rep[Double] = { forge_double_plus(readVar(lhs), unit(rhs.toDouble)) }
  def infix_+(lhs: Var[Double],rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload42): Rep[Double] = { forge_double_plus(readVar(lhs), rhs.toDouble) }
  def infix_+(lhs: Var[Double],rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload43): Rep[Double] = { forge_double_plus(readVar(lhs), readVar(rhs).toDouble) }
  def infix_+(lhs: Var[Double],rhs: Int)(implicit __pos: SourceContext,__imp1: ROverload44): Rep[Double] = { forge_double_plus(readVar(lhs), unit(rhs.toDouble)) }
  def infix_+(lhs: Var[Double],rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload45): Rep[Double] = { forge_double_plus(readVar(lhs), rhs.toDouble) }
  def infix_+(lhs: Var[Double],rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload46): Rep[Double] = { forge_double_plus(readVar(lhs), readVar(rhs).toDouble) }
  def infix_+(lhs: Var[Double],rhs: Long)(implicit __pos: SourceContext,__imp1: ROverload47): Rep[Double] = { forge_double_plus(readVar(lhs), unit(rhs.toDouble)) }
  def infix_+(lhs: Var[Double],rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload48): Rep[Double] = { forge_double_plus(readVar(lhs), rhs.toDouble) }
  def infix_+(lhs: Var[Double],rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload49): Rep[Double] = { forge_double_plus(readVar(lhs), readVar(rhs).toDouble) }
  def infix_+(lhs: Float,rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload50): Rep[Double] = { forge_double_plus(unit(lhs.toDouble), rhs) }
  def infix_+(lhs: Float,rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload51): Rep[Double] = { forge_double_plus(unit(lhs.toDouble), readVar(rhs)) }
  def infix_+(lhs: Float,rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload52): Rep[Float] = { forge_float_plus(unit(lhs), rhs) }
  def infix_+(lhs: Float,rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload53): Rep[Float] = { forge_float_plus(unit(lhs), readVar(rhs)) }
  def infix_+(lhs: Float,rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload54): Rep[Float] = { forge_float_plus(unit(lhs), rhs.toFloat) }
  def infix_+(lhs: Float,rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload55): Rep[Float] = { forge_float_plus(unit(lhs), readVar(rhs).toFloat) }
  def infix_+(lhs: Float,rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload56): Rep[Float] = { forge_float_plus(unit(lhs), rhs.toFloat) }
  def infix_+(lhs: Float,rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload57): Rep[Float] = { forge_float_plus(unit(lhs), readVar(rhs).toFloat) }
  def infix_+(lhs: Rep[Float],rhs: Double)(implicit __pos: SourceContext,__imp1: ROverload58): Rep[Double] = { forge_double_plus(lhs.toDouble, unit(rhs)) }
  def infix_+(lhs: Rep[Float],rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload59): Rep[Double] = { forge_double_plus(lhs.toDouble, rhs) }
  def infix_+(lhs: Rep[Float],rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload60): Rep[Double] = { forge_double_plus(lhs.toDouble, readVar(rhs)) }
  def infix_+(lhs: Rep[Float],rhs: Float)(implicit __pos: SourceContext,__imp1: ROverload61): Rep[Float] = { forge_float_plus(lhs, unit(rhs)) }
  def infix_+(lhs: Rep[Float],rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload62): Rep[Float] = { forge_float_plus(lhs, rhs) }
  def infix_+(lhs: Rep[Float],rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload63): Rep[Float] = { forge_float_plus(lhs, readVar(rhs)) }
  def infix_+(lhs: Rep[Float],rhs: Int)(implicit __pos: SourceContext,__imp1: ROverload64): Rep[Float] = { forge_float_plus(lhs, unit(rhs.toFloat)) }
  def infix_+(lhs: Rep[Float],rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload65): Rep[Float] = { forge_float_plus(lhs, rhs.toFloat) }
  def infix_+(lhs: Rep[Float],rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload66): Rep[Float] = { forge_float_plus(lhs, readVar(rhs).toFloat) }
  def infix_+(lhs: Rep[Float],rhs: Long)(implicit __pos: SourceContext,__imp1: ROverload67): Rep[Float] = { forge_float_plus(lhs, unit(rhs.toFloat)) }
  def infix_+(lhs: Rep[Float],rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload68): Rep[Float] = { forge_float_plus(lhs, rhs.toFloat) }
  def infix_+(lhs: Rep[Float],rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload69): Rep[Float] = { forge_float_plus(lhs, readVar(rhs).toFloat) }
  def infix_+(lhs: Var[Float],rhs: Double)(implicit __pos: SourceContext,__imp1: ROverload70): Rep[Double] = { forge_double_plus(readVar(lhs).toDouble, unit(rhs)) }
  def infix_+(lhs: Var[Float],rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload71): Rep[Double] = { forge_double_plus(readVar(lhs).toDouble, rhs) }
  def infix_+(lhs: Var[Float],rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload72): Rep[Double] = { forge_double_plus(readVar(lhs).toDouble, readVar(rhs)) }
  def infix_+(lhs: Var[Float],rhs: Float)(implicit __pos: SourceContext,__imp1: ROverload73): Rep[Float] = { forge_float_plus(readVar(lhs), unit(rhs)) }
  def infix_+(lhs: Var[Float],rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload74): Rep[Float] = { forge_float_plus(readVar(lhs), rhs) }
  def infix_+(lhs: Var[Float],rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload75): Rep[Float] = { forge_float_plus(readVar(lhs), readVar(rhs)) }
  def infix_+(lhs: Var[Float],rhs: Int)(implicit __pos: SourceContext,__imp1: ROverload76): Rep[Float] = { forge_float_plus(readVar(lhs), unit(rhs.toFloat)) }
  def infix_+(lhs: Var[Float],rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload77): Rep[Float] = { forge_float_plus(readVar(lhs), rhs.toFloat) }
  def infix_+(lhs: Var[Float],rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload78): Rep[Float] = { forge_float_plus(readVar(lhs), readVar(rhs).toFloat) }
  def infix_+(lhs: Var[Float],rhs: Long)(implicit __pos: SourceContext,__imp1: ROverload79): Rep[Float] = { forge_float_plus(readVar(lhs), unit(rhs.toFloat)) }
  def infix_+(lhs: Var[Float],rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload80): Rep[Float] = { forge_float_plus(readVar(lhs), rhs.toFloat) }
  def infix_+(lhs: Var[Float],rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload81): Rep[Float] = { forge_float_plus(readVar(lhs), readVar(rhs).toFloat) }
  def infix_+(lhs: Int,rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload82): Rep[Double] = { forge_double_plus(unit(lhs.toDouble), rhs) }
  def infix_+(lhs: Int,rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload83): Rep[Double] = { forge_double_plus(unit(lhs.toDouble), readVar(rhs)) }
  def infix_+(lhs: Int,rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload84): Rep[Float] = { forge_float_plus(unit(lhs.toFloat), rhs) }
  def infix_+(lhs: Int,rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload85): Rep[Float] = { forge_float_plus(unit(lhs.toFloat), readVar(rhs)) }
  def infix_+(lhs: Int,rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload86): Rep[Int] = { forge_int_plus(unit(lhs), rhs) }
  def infix_+(lhs: Int,rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload87): Rep[Int] = { forge_int_plus(unit(lhs), readVar(rhs)) }
  def infix_+(lhs: Int,rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload88): Rep[Long] = { forge_long_plus(unit(lhs.toLong), rhs) }
  def infix_+(lhs: Int,rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload89): Rep[Long] = { forge_long_plus(unit(lhs.toLong), readVar(rhs)) }
  def infix_+(lhs: Rep[Int],rhs: Double)(implicit __pos: SourceContext,__imp1: ROverload90): Rep[Double] = { forge_double_plus(lhs.toDouble, unit(rhs)) }
  def infix_+(lhs: Rep[Int],rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload91): Rep[Double] = { forge_double_plus(lhs.toDouble, rhs) }
  def infix_+(lhs: Rep[Int],rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload92): Rep[Double] = { forge_double_plus(lhs.toDouble, readVar(rhs)) }
  def infix_+(lhs: Rep[Int],rhs: Float)(implicit __pos: SourceContext,__imp1: ROverload93): Rep[Float] = { forge_float_plus(lhs.toFloat, unit(rhs)) }
  def infix_+(lhs: Rep[Int],rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload94): Rep[Float] = { forge_float_plus(lhs.toFloat, rhs) }
  def infix_+(lhs: Rep[Int],rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload95): Rep[Float] = { forge_float_plus(lhs.toFloat, readVar(rhs)) }
  def infix_+(lhs: Rep[Int],rhs: Int)(implicit __pos: SourceContext,__imp1: ROverload96): Rep[Int] = { forge_int_plus(lhs, unit(rhs)) }
  def infix_+(lhs: Rep[Int],rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload97): Rep[Int] = { forge_int_plus(lhs, rhs) }
  def infix_+(lhs: Rep[Int],rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload98): Rep[Int] = { forge_int_plus(lhs, readVar(rhs)) }
  def infix_+(lhs: Rep[Int],rhs: Long)(implicit __pos: SourceContext,__imp1: ROverload99): Rep[Long] = { forge_long_plus(lhs.toLong, unit(rhs)) }
  def infix_+(lhs: Rep[Int],rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload100): Rep[Long] = { forge_long_plus(lhs.toLong, rhs) }
  def infix_+(lhs: Rep[Int],rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload101): Rep[Long] = { forge_long_plus(lhs.toLong, readVar(rhs)) }
  def infix_+(lhs: Var[Int],rhs: Double)(implicit __pos: SourceContext,__imp1: ROverload102): Rep[Double] = { forge_double_plus(readVar(lhs).toDouble, unit(rhs)) }
  def infix_+(lhs: Var[Int],rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload103): Rep[Double] = { forge_double_plus(readVar(lhs).toDouble, rhs) }
  def infix_+(lhs: Var[Int],rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload104): Rep[Double] = { forge_double_plus(readVar(lhs).toDouble, readVar(rhs)) }
  def infix_+(lhs: Var[Int],rhs: Float)(implicit __pos: SourceContext,__imp1: ROverload105): Rep[Float] = { forge_float_plus(readVar(lhs).toFloat, unit(rhs)) }
  def infix_+(lhs: Var[Int],rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload106): Rep[Float] = { forge_float_plus(readVar(lhs).toFloat, rhs) }
  def infix_+(lhs: Var[Int],rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload107): Rep[Float] = { forge_float_plus(readVar(lhs).toFloat, readVar(rhs)) }
  def infix_+(lhs: Var[Int],rhs: Int)(implicit __pos: SourceContext,__imp1: ROverload108): Rep[Int] = { forge_int_plus(readVar(lhs), unit(rhs)) }
  def infix_+(lhs: Var[Int],rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload109): Rep[Int] = { forge_int_plus(readVar(lhs), rhs) }
  def infix_+(lhs: Var[Int],rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload110): Rep[Int] = { forge_int_plus(readVar(lhs), readVar(rhs)) }
  def infix_+(lhs: Var[Int],rhs: Long)(implicit __pos: SourceContext,__imp1: ROverload111): Rep[Long] = { forge_long_plus(readVar(lhs).toLong, unit(rhs)) }
  def infix_+(lhs: Var[Int],rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload112): Rep[Long] = { forge_long_plus(readVar(lhs).toLong, rhs) }
  def infix_+(lhs: Var[Int],rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload113): Rep[Long] = { forge_long_plus(readVar(lhs).toLong, readVar(rhs)) }
  def infix_+(lhs: Long,rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload114): Rep[Double] = { forge_double_plus(unit(lhs.toDouble), rhs) }
  def infix_+(lhs: Long,rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload115): Rep[Double] = { forge_double_plus(unit(lhs.toDouble), readVar(rhs)) }
  def infix_+(lhs: Long,rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload116): Rep[Float] = { forge_float_plus(unit(lhs.toFloat), rhs) }
  def infix_+(lhs: Long,rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload117): Rep[Float] = { forge_float_plus(unit(lhs.toFloat), readVar(rhs)) }
  def infix_+(lhs: Long,rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload118): Rep[Long] = { forge_long_plus(unit(lhs), rhs.toLong) }
  def infix_+(lhs: Long,rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload119): Rep[Long] = { forge_long_plus(unit(lhs), readVar(rhs).toLong) }
  def infix_+(lhs: Long,rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload120): Rep[Long] = { forge_long_plus(unit(lhs), rhs) }
  def infix_+(lhs: Long,rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload121): Rep[Long] = { forge_long_plus(unit(lhs), readVar(rhs)) }
  def infix_+(lhs: Rep[Long],rhs: Double)(implicit __pos: SourceContext,__imp1: ROverload122): Rep[Double] = { forge_double_plus(lhs.toDouble, unit(rhs)) }
  def infix_+(lhs: Rep[Long],rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload123): Rep[Double] = { forge_double_plus(lhs.toDouble, rhs) }
  def infix_+(lhs: Rep[Long],rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload124): Rep[Double] = { forge_double_plus(lhs.toDouble, readVar(rhs)) }
  def infix_+(lhs: Rep[Long],rhs: Float)(implicit __pos: SourceContext,__imp1: ROverload125): Rep[Float] = { forge_float_plus(lhs.toFloat, unit(rhs)) }
  def infix_+(lhs: Rep[Long],rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload126): Rep[Float] = { forge_float_plus(lhs.toFloat, rhs) }
  def infix_+(lhs: Rep[Long],rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload127): Rep[Float] = { forge_float_plus(lhs.toFloat, readVar(rhs)) }
  def infix_+(lhs: Rep[Long],rhs: Int)(implicit __pos: SourceContext,__imp1: ROverload128): Rep[Long] = { forge_long_plus(lhs, unit(rhs.toLong)) }
  def infix_+(lhs: Rep[Long],rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload129): Rep[Long] = { forge_long_plus(lhs, rhs.toLong) }
  def infix_+(lhs: Rep[Long],rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload130): Rep[Long] = { forge_long_plus(lhs, readVar(rhs).toLong) }
  def infix_+(lhs: Rep[Long],rhs: Long)(implicit __pos: SourceContext,__imp1: ROverload131): Rep[Long] = { forge_long_plus(lhs, unit(rhs)) }
  def infix_+(lhs: Rep[Long],rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload132): Rep[Long] = { forge_long_plus(lhs, rhs) }
  def infix_+(lhs: Rep[Long],rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload133): Rep[Long] = { forge_long_plus(lhs, readVar(rhs)) }
  def infix_+(lhs: Var[Long],rhs: Double)(implicit __pos: SourceContext,__imp1: ROverload134): Rep[Double] = { forge_double_plus(readVar(lhs).toDouble, unit(rhs)) }
  def infix_+(lhs: Var[Long],rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload135): Rep[Double] = { forge_double_plus(readVar(lhs).toDouble, rhs) }
  def infix_+(lhs: Var[Long],rhs: Var[Double])(implicit __pos: SourceContext,__imp1: ROverload136): Rep[Double] = { forge_double_plus(readVar(lhs).toDouble, readVar(rhs)) }
  def infix_+(lhs: Var[Long],rhs: Float)(implicit __pos: SourceContext,__imp1: ROverload137): Rep[Float] = { forge_float_plus(readVar(lhs).toFloat, unit(rhs)) }
  def infix_+(lhs: Var[Long],rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload138): Rep[Float] = { forge_float_plus(readVar(lhs).toFloat, rhs) }
  def infix_+(lhs: Var[Long],rhs: Var[Float])(implicit __pos: SourceContext,__imp1: ROverload139): Rep[Float] = { forge_float_plus(readVar(lhs).toFloat, readVar(rhs)) }
  def infix_+(lhs: Var[Long],rhs: Int)(implicit __pos: SourceContext,__imp1: ROverload140): Rep[Long] = { forge_long_plus(readVar(lhs), unit(rhs.toLong)) }
  def infix_+(lhs: Var[Long],rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload141): Rep[Long] = { forge_long_plus(readVar(lhs), rhs.toLong) }
  def infix_+(lhs: Var[Long],rhs: Var[Int])(implicit __pos: SourceContext,__imp1: ROverload142): Rep[Long] = { forge_long_plus(readVar(lhs), readVar(rhs).toLong) }
  def infix_+(lhs: Var[Long],rhs: Long)(implicit __pos: SourceContext,__imp1: ROverload143): Rep[Long] = { forge_long_plus(readVar(lhs), unit(rhs)) }
  def infix_+(lhs: Var[Long],rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload144): Rep[Long] = { forge_long_plus(readVar(lhs), rhs) }
  def infix_+(lhs: Var[Long],rhs: Var[Long])(implicit __pos: SourceContext,__imp1: ROverload145): Rep[Long] = { forge_long_plus(readVar(lhs), readVar(rhs)) }

  def primitive_unary_bang(__arg0: Rep[Boolean])(implicit __pos: SourceContext): Rep[Boolean]
  def primitive_oror(__arg0: Rep[Boolean],__arg1: Rep[Boolean])(implicit __pos: SourceContext): Rep[Boolean]
  def primitive_andand(__arg0: Rep[Boolean],__arg1: Rep[Boolean])(implicit __pos: SourceContext): Rep[Boolean]
  def primitive_toint[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext): Rep[Int]
  def primitive_tofloat[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext): Rep[Float]
  def primitive_todouble[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext): Rep[Double]
  def primitive_tolong[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext): Rep[Long]
  def primitive_forge_int_plus(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def primitive_forge_int_minus(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def primitive_forge_int_times(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def primitive_forge_int_divide(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def primitive_forge_int_shift_left(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def primitive_forge_int_shift_right_unsigned(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def primitive_forge_int_and(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def primitive_forge_int_or(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def primitive_forge_int_shift_right(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Int]
  def primitive_%(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1): Rep[Int]
  def primitive_unary_~(__arg0: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1): Rep[Int]
  def primitive_forge_float_plus(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext): Rep[Float]
  def primitive_forge_float_minus(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext): Rep[Float]
  def primitive_forge_float_times(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext): Rep[Float]
  def primitive_forge_float_divide(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext): Rep[Float]
  def primitive_forge_double_plus(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext): Rep[Double]
  def primitive_forge_double_minus(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext): Rep[Double]
  def primitive_forge_double_times(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext): Rep[Double]
  def primitive_forge_double_divide(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext): Rep[Double]
  def primitive_forge_long_plus(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext): Rep[Long]
  def primitive_forge_long_minus(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext): Rep[Long]
  def primitive_forge_long_times(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext): Rep[Long]
  def primitive_forge_long_divide(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext): Rep[Long]
  def primitive_forge_long_divide_double(__arg0: Rep[Long],__arg1: Rep[Double])(implicit __pos: SourceContext): Rep[Double]
  def primitive_forge_long_and(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext): Rep[Long]
  def primitive_forge_long_or(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext): Rep[Long]
  def primitive_forge_long_xor(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext): Rep[Long]
  def primitive_forge_long_shift_right_unsigned(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Long]
  def primitive_forge_long_shift_right(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Long]
  def primitive_forge_long_shift_left(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Long]
  def primitive_%(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext,__imp1: Overload2): Rep[Long]
  def primitive_unary_~(__arg0: Rep[Long])(implicit __pos: SourceContext,__imp1: Overload2): Rep[Long]
}
