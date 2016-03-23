package simplevector.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import ppl.delite.framework.ops.DeliteCollection
import ppl.delite.framework.datastructures._
import ppl.delite.framework.ops.{DeliteOpsExp, DeliteCollectionOpsExp}
import ppl.delite.framework.Util._
import simplevector.shared._
import simplevector.shared.ops._
import simplevector.compiler._
import simplevector.compiler.ops._

/**
 * IR Definitions
 */

trait PrimitiveOpsExp extends PrimitiveOps with BaseFatExp with EffectExp {
  this: SimpleVectorExp => 

  case class Primitive_Unary_bang(__arg0: Rep[Boolean])(implicit val __pos: SourceContext) extends Def[Boolean] {
  }

  case class Primitive_Oror(__arg0: Rep[Boolean],__arg1: Rep[Boolean])(implicit val __pos: SourceContext) extends Def[Boolean] {
  }

  case class Primitive_Andand(__arg0: Rep[Boolean],__arg1: Rep[Boolean])(implicit val __pos: SourceContext) extends Def[Boolean] {
  }

  case class Primitive2_ToInt[T:Numeric:Manifest](__arg0: Rep[T])(implicit val __pos: SourceContext) extends Def[Int] {
    val _numT = implicitly[Numeric[T]]
    val _mT = implicitly[Manifest[T]]
  }

  case class Primitive2_ToFloat[T:Numeric:Manifest](__arg0: Rep[T])(implicit val __pos: SourceContext) extends Def[Float] {
    val _numT = implicitly[Numeric[T]]
    val _mT = implicitly[Manifest[T]]
  }

  case class Primitive2_ToDouble[T:Numeric:Manifest](__arg0: Rep[T])(implicit val __pos: SourceContext) extends Def[Double] {
    val _numT = implicitly[Numeric[T]]
    val _mT = implicitly[Manifest[T]]
  }

  case class Primitive2_ToLong[T:Numeric:Manifest](__arg0: Rep[T])(implicit val __pos: SourceContext) extends Def[Long] {
    val _numT = implicitly[Numeric[T]]
    val _mT = implicitly[Manifest[T]]
  }

  case class Primitive_Forge_int_plus(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive_Forge_int_minus(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive_Forge_int_times(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive_Forge_int_divide(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive_Forge_int_shift_left(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive_Forge_int_shift_right_unsigned(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive_Forge_int_and(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive_Forge_int_or(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive_Forge_int_shift_right(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive1_%(__arg0: Rep[Int],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive1_Unary_~(__arg0: Rep[Int])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class Primitive_Forge_float_plus(__arg0: Rep[Float],__arg1: Rep[Float])(implicit val __pos: SourceContext) extends Def[Float] {
  }

  case class Primitive_Forge_float_minus(__arg0: Rep[Float],__arg1: Rep[Float])(implicit val __pos: SourceContext) extends Def[Float] {
  }

  case class Primitive_Forge_float_times(__arg0: Rep[Float],__arg1: Rep[Float])(implicit val __pos: SourceContext) extends Def[Float] {
  }

  case class Primitive_Forge_float_divide(__arg0: Rep[Float],__arg1: Rep[Float])(implicit val __pos: SourceContext) extends Def[Float] {
  }

  case class Primitive_Forge_double_plus(__arg0: Rep[Double],__arg1: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class Primitive_Forge_double_minus(__arg0: Rep[Double],__arg1: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class Primitive_Forge_double_times(__arg0: Rep[Double],__arg1: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class Primitive_Forge_double_divide(__arg0: Rep[Double],__arg1: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class Primitive_Forge_long_plus(__arg0: Rep[Long],__arg1: Rep[Long])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive_Forge_long_minus(__arg0: Rep[Long],__arg1: Rep[Long])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive_Forge_long_times(__arg0: Rep[Long],__arg1: Rep[Long])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive_Forge_long_divide(__arg0: Rep[Long],__arg1: Rep[Long])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive_Forge_long_divide_double(__arg0: Rep[Long],__arg1: Rep[Double])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class Primitive_Forge_long_and(__arg0: Rep[Long],__arg1: Rep[Long])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive_Forge_long_or(__arg0: Rep[Long],__arg1: Rep[Long])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive_Forge_long_xor(__arg0: Rep[Long],__arg1: Rep[Long])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive_Forge_long_shift_right_unsigned(__arg0: Rep[Long],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive_Forge_long_shift_right(__arg0: Rep[Long],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive_Forge_long_shift_left(__arg0: Rep[Long],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive2_%(__arg0: Rep[Long],__arg1: Rep[Long])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class Primitive2_Unary_~(__arg0: Rep[Long])(implicit val __pos: SourceContext) extends Def[Long] {
  }



  def primitive_unary_bang(__arg0: Rep[Boolean])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Unary_bang(__arg0)(__pos))
  }
  def primitive_oror(__arg0: Rep[Boolean],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Oror(__arg0,__arg1)(__pos))
  }
  def primitive_andand(__arg0: Rep[Boolean],__arg1: Rep[Boolean])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Andand(__arg0,__arg1)(__pos))
  }
  def primitive_toint[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_ToInt[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos))
  }
  def primitive_tofloat[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_ToFloat[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos))
  }
  def primitive_todouble[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_ToDouble[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos))
  }
  def primitive_tolong[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext) = {
    reflectPure(Primitive2_ToLong[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos))
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
    reflectPure(Primitive_Forge_int_plus(__arg0,__arg1)(__pos))
  }
  def primitive_forge_int_minus(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_int_minus(__arg0,__arg1)(__pos))
  }
  def primitive_forge_int_times(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_int_times(__arg0,__arg1)(__pos))
  }
  def primitive_forge_int_divide(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_int_divide(__arg0,__arg1)(__pos))
  }
  def primitive_forge_int_shift_left(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_int_shift_left(__arg0,__arg1)(__pos))
  }
  def primitive_forge_int_shift_right_unsigned(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_int_shift_right_unsigned(__arg0,__arg1)(__pos))
  }
  def primitive_forge_int_and(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_int_and(__arg0,__arg1)(__pos))
  }
  def primitive_forge_int_or(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_int_or(__arg0,__arg1)(__pos))
  }
  def primitive_forge_int_shift_right(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_int_shift_right(__arg0,__arg1)(__pos))
  }
  def primitive_%(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = {
    reflectPure(Primitive1_%(__arg0,__arg1)(__pos))
  }
  def primitive_unary_~(__arg0: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = {
    reflectPure(Primitive1_Unary_~(__arg0)(__pos))
  }
  def primitive_forge_float_plus(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_float_plus(__arg0,__arg1)(__pos))
  }
  def primitive_forge_float_minus(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_float_minus(__arg0,__arg1)(__pos))
  }
  def primitive_forge_float_times(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_float_times(__arg0,__arg1)(__pos))
  }
  def primitive_forge_float_divide(__arg0: Rep[Float],__arg1: Rep[Float])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_float_divide(__arg0,__arg1)(__pos))
  }
  def primitive_forge_double_plus(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_double_plus(__arg0,__arg1)(__pos))
  }
  def primitive_forge_double_minus(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_double_minus(__arg0,__arg1)(__pos))
  }
  def primitive_forge_double_times(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_double_times(__arg0,__arg1)(__pos))
  }
  def primitive_forge_double_divide(__arg0: Rep[Double],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_double_divide(__arg0,__arg1)(__pos))
  }
  def primitive_forge_long_plus(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_long_plus(__arg0,__arg1)(__pos))
  }
  def primitive_forge_long_minus(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_long_minus(__arg0,__arg1)(__pos))
  }
  def primitive_forge_long_times(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_long_times(__arg0,__arg1)(__pos))
  }
  def primitive_forge_long_divide(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_long_divide(__arg0,__arg1)(__pos))
  }
  def primitive_forge_long_divide_double(__arg0: Rep[Long],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_long_divide_double(__arg0,__arg1)(__pos))
  }
  def primitive_forge_long_and(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_long_and(__arg0,__arg1)(__pos))
  }
  def primitive_forge_long_or(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_long_or(__arg0,__arg1)(__pos))
  }
  def primitive_forge_long_xor(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_long_xor(__arg0,__arg1)(__pos))
  }
  def primitive_forge_long_shift_right_unsigned(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_long_shift_right_unsigned(__arg0,__arg1)(__pos))
  }
  def primitive_forge_long_shift_right(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_long_shift_right(__arg0,__arg1)(__pos))
  }
  def primitive_forge_long_shift_left(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Primitive_Forge_long_shift_left(__arg0,__arg1)(__pos))
  }
  def primitive_%(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext,__imp1: Overload2) = {
    reflectPure(Primitive2_%(__arg0,__arg1)(__pos))
  }
  def primitive_unary_~(__arg0: Rep[Long])(implicit __pos: SourceContext,__imp1: Overload2) = {
    reflectPure(Primitive2_Unary_~(__arg0)(__pos))
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Primitive_Unary_bang(__arg0) => primitive_unary_bang(f(__arg0))(mn.__pos)
    case Reflect(mn@Primitive_Unary_bang(__arg0), u, es) => reflectMirrored(Reflect(Primitive_Unary_bang(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Oror(__arg0,__arg1) => primitive_oror(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Oror(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Oror(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Andand(__arg0,__arg1) => primitive_andand(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Andand(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Andand(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_ToInt(__arg0) => primitive_toint(f(__arg0))(ntype(mn._numT),mtype(mn._mT),mn.__pos)
    case Reflect(mn@Primitive2_ToInt(__arg0), u, es) => reflectMirrored(Reflect(Primitive2_ToInt(f(__arg0))(ntype(mn._numT),mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_ToFloat(__arg0) => primitive_tofloat(f(__arg0))(ntype(mn._numT),mtype(mn._mT),mn.__pos)
    case Reflect(mn@Primitive2_ToFloat(__arg0), u, es) => reflectMirrored(Reflect(Primitive2_ToFloat(f(__arg0))(ntype(mn._numT),mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_ToDouble(__arg0) => primitive_todouble(f(__arg0))(ntype(mn._numT),mtype(mn._mT),mn.__pos)
    case Reflect(mn@Primitive2_ToDouble(__arg0), u, es) => reflectMirrored(Reflect(Primitive2_ToDouble(f(__arg0))(ntype(mn._numT),mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_ToLong(__arg0) => primitive_tolong(f(__arg0))(ntype(mn._numT),mtype(mn._mT),mn.__pos)
    case Reflect(mn@Primitive2_ToLong(__arg0), u, es) => reflectMirrored(Reflect(Primitive2_ToLong(f(__arg0))(ntype(mn._numT),mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_int_plus(__arg0,__arg1) => primitive_forge_int_plus(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_int_plus(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_int_plus(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_int_minus(__arg0,__arg1) => primitive_forge_int_minus(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_int_minus(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_int_minus(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_int_times(__arg0,__arg1) => primitive_forge_int_times(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_int_times(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_int_times(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_int_divide(__arg0,__arg1) => primitive_forge_int_divide(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_int_divide(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_int_divide(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_int_shift_left(__arg0,__arg1) => primitive_forge_int_shift_left(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_int_shift_left(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_int_shift_left(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_int_shift_right_unsigned(__arg0,__arg1) => primitive_forge_int_shift_right_unsigned(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_int_shift_right_unsigned(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_int_shift_right_unsigned(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_int_and(__arg0,__arg1) => primitive_forge_int_and(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_int_and(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_int_and(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_int_or(__arg0,__arg1) => primitive_forge_int_or(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_int_or(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_int_or(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_int_shift_right(__arg0,__arg1) => primitive_forge_int_shift_right(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_int_shift_right(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_int_shift_right(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive1_%(__arg0,__arg1) => primitive_%(f(__arg0),f(__arg1))(mn.__pos,overload1)
    case Reflect(mn@Primitive1_%(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive1_%(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive1_Unary_~(__arg0) => primitive_unary_~(f(__arg0))(mn.__pos,overload1)
    case Reflect(mn@Primitive1_Unary_~(__arg0), u, es) => reflectMirrored(Reflect(Primitive1_Unary_~(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_float_plus(__arg0,__arg1) => primitive_forge_float_plus(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_float_plus(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_float_plus(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_float_minus(__arg0,__arg1) => primitive_forge_float_minus(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_float_minus(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_float_minus(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_float_times(__arg0,__arg1) => primitive_forge_float_times(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_float_times(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_float_times(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_float_divide(__arg0,__arg1) => primitive_forge_float_divide(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_float_divide(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_float_divide(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_double_plus(__arg0,__arg1) => primitive_forge_double_plus(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_double_plus(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_double_plus(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_double_minus(__arg0,__arg1) => primitive_forge_double_minus(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_double_minus(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_double_minus(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_double_times(__arg0,__arg1) => primitive_forge_double_times(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_double_times(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_double_times(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_double_divide(__arg0,__arg1) => primitive_forge_double_divide(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_double_divide(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_double_divide(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_long_plus(__arg0,__arg1) => primitive_forge_long_plus(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_long_plus(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_long_plus(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_long_minus(__arg0,__arg1) => primitive_forge_long_minus(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_long_minus(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_long_minus(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_long_times(__arg0,__arg1) => primitive_forge_long_times(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_long_times(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_long_times(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_long_divide(__arg0,__arg1) => primitive_forge_long_divide(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_long_divide(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_long_divide(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_long_divide_double(__arg0,__arg1) => primitive_forge_long_divide_double(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_long_divide_double(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_long_divide_double(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_long_and(__arg0,__arg1) => primitive_forge_long_and(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_long_and(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_long_and(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_long_or(__arg0,__arg1) => primitive_forge_long_or(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_long_or(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_long_or(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_long_xor(__arg0,__arg1) => primitive_forge_long_xor(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_long_xor(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_long_xor(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_long_shift_right_unsigned(__arg0,__arg1) => primitive_forge_long_shift_right_unsigned(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_long_shift_right_unsigned(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_long_shift_right_unsigned(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_long_shift_right(__arg0,__arg1) => primitive_forge_long_shift_right(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_long_shift_right(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_long_shift_right(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive_Forge_long_shift_left(__arg0,__arg1) => primitive_forge_long_shift_left(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@Primitive_Forge_long_shift_left(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive_Forge_long_shift_left(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_%(__arg0,__arg1) => primitive_%(f(__arg0),f(__arg1))(mn.__pos,overload2)
    case Reflect(mn@Primitive2_%(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Primitive2_%(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Primitive2_Unary_~(__arg0) => primitive_unary_~(f(__arg0))(mn.__pos,overload2)
    case Reflect(mn@Primitive2_Unary_~(__arg0), u, es) => reflectMirrored(Reflect(Primitive2_Unary_~(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


}

/**
 * Code generators
 */

trait ScalaGenPrimitiveOps extends ScalaGenFat {
  val IR: PrimitiveOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Primitive_Unary_bang(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("!"+quote(__arg0)+"")
      stream.println("}")

    case mn@Primitive_Oror(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" || "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Andand(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" && "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_ToInt(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toInt")
      stream.println("}")

    case mn@Primitive2_ToFloat(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toFloat")
      stream.println("}")

    case mn@Primitive2_ToDouble(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toDouble")
      stream.println("}")

    case mn@Primitive2_ToLong(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toLong")
      stream.println("}")

    case mn@Primitive_Forge_int_plus(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_int_minus(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_int_times(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_int_divide(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_int_shift_left(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" << "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_int_shift_right_unsigned(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" >>> "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_int_and(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" & "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_int_or(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" | "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_int_shift_right(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" >> "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive1_%(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" % "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive1_Unary_~(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("~"+quote(__arg0)+"")
      stream.println("}")

    case mn@Primitive_Forge_float_plus(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_float_minus(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_float_times(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_float_divide(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_double_plus(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_double_minus(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_double_times(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_double_divide(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_long_plus(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_long_minus(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_long_times(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_long_divide(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_long_divide_double(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_long_and(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" & "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_long_or(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" | "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_long_xor(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" ^ "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_long_shift_right_unsigned(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" >>> "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_long_shift_right(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" >> "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive_Forge_long_shift_left(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" << "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_%(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" % "+quote(__arg1)+"")
      stream.println("}")

    case mn@Primitive2_Unary_~(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("~"+quote(__arg0)+"")
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CudaGenPrimitiveOps extends CudaGenFat {
  val IR: PrimitiveOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Primitive_Unary_bang(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("!"+quote(__arg0)+"")
      stream.println(";")

    case mn@Primitive_Oror(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" || "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Andand(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" && "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_ToInt(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("(int32_t) "+quote(__arg0)+"")
      stream.println(";")

    case mn@Primitive2_ToFloat(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("(float) "+quote(__arg0)+"")
      stream.println(";")

    case mn@Primitive2_ToDouble(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("(double) "+quote(__arg0)+"")
      stream.println(";")

    case mn@Primitive2_ToLong(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("(int64_t) "+quote(__arg0)+"")
      stream.println(";")

    case mn@Primitive_Forge_int_plus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_int_minus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_int_times(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_int_divide(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_int_shift_left(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" << "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_int_and(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" & "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_int_or(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" | "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_int_shift_right(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" >> "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive1_%(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" % "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive1_Unary_~(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("~"+quote(__arg0)+"")
      stream.println(";")

    case mn@Primitive_Forge_float_plus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_float_minus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_float_times(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_float_divide(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_double_plus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_double_minus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_double_times(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_double_divide(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_long_plus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_long_minus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_long_times(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_long_divide(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_long_divide_double(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_long_and(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" & "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_long_or(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" | "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_long_xor(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" ^ "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_long_shift_right(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" >> "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_long_shift_left(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" << "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_%(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" % "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Unary_~(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("~"+quote(__arg0)+"")
      stream.println(";")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CGenPrimitiveOps extends CGenFat {
  val IR: PrimitiveOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Primitive_Unary_bang(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("!"+quote(__arg0)+"")
      stream.println(";")

    case mn@Primitive_Oror(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" || "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Andand(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" && "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_ToInt(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("(int32_t) "+quote(__arg0)+"")
      stream.println(";")

    case mn@Primitive2_ToFloat(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("(float) "+quote(__arg0)+"")
      stream.println(";")

    case mn@Primitive2_ToDouble(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("(double) "+quote(__arg0)+"")
      stream.println(";")

    case mn@Primitive2_ToLong(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("(int64_t) "+quote(__arg0)+"")
      stream.println(";")

    case mn@Primitive_Forge_int_plus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_int_minus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_int_times(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_int_divide(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_int_shift_left(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" << "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_int_and(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" & "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_int_or(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" | "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_int_shift_right(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" >> "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive1_%(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" % "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive1_Unary_~(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("~"+quote(__arg0)+"")
      stream.println(";")

    case mn@Primitive_Forge_float_plus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_float_minus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_float_times(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_float_divide(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_double_plus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_double_minus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_double_times(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_double_divide(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_long_plus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_long_minus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_long_times(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_long_divide(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_long_divide_double(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_long_and(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" & "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_long_or(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" | "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_long_xor(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" ^ "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_long_shift_right(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" >> "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive_Forge_long_shift_left(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" << "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_%(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" % "+quote(__arg1)+"")
      stream.println(";")

    case mn@Primitive2_Unary_~(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("~"+quote(__arg0)+"")
      stream.println(";")

    case _ => super.emitNode(sym, rhs)
  }
}
