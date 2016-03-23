package simplevector.library

import java.io.{BufferedWriter, FileWriter, PrintWriter}
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

trait SimpleVectorREPL extends SimpleVectorApplicationInterpreter

abstract class SimpleVectorApplicationInterpreter extends SimpleVectorApplication with SimpleVectorLib {
  var args: Rep[Array[String]] = _
  var stagingArgs: Array[String] = _
  final def main(argsIn: Array[String]) {
    this.args = argsIn
    this.stagingArgs = argsIn
    main()
  }

  /**
   * Dismabiguations for interpreter mode
   */
  override def infix_toInt(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload1) = fstring_toint(__arg0)(__pos)
  override def infix_toLong(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload1) = fstring_tolong(__arg0)(__pos)
  override def infix_toFloat(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload1) = fstring_tofloat(__arg0)(__pos)
  override def infix_toDouble(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload1) = fstring_todouble(__arg0)(__pos)
  override def infix_length(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload1) = fstring_length(__arg0)(__pos)
  override def infix_slice(__arg0: Rep[String],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[String] = { fstring_substring(__arg0,__arg1,__arg2) }
  override def infix_contains(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: Overload1) = fstring_contains(__arg0,__arg1)(__pos)
  override def infix_substring(__arg0: Rep[String],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = fstring_substring(__arg0,__arg1)(__pos,overload1)
  override def infix_substring(__arg0: Rep[String],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = fstring_substring(__arg0,__arg1,__arg2)(__pos,overload2)
  override def infix_+[T:Manifest](__arg0: String,__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[String] = { forge_string_plus(unit(__arg0), __arg1) }
  override def infix_+[T:Manifest](__arg0: Rep[T],__arg1: String)(implicit __pos: SourceContext,__imp1: ROverload7): Rep[String] = { forge_string_plus(__arg0, unit(__arg1)) }
  override def infix_+(__arg0: String,__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: ROverload12): Rep[String] = { forge_string_plus(unit(__arg0), __arg1) }
  override def infix__1[A:Manifest](__arg0: Rep[Tup3[A,_,_]])(implicit __pos: SourceContext,__imp1: Overload1) = tup3__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  override def infix__2[B:Manifest](__arg0: Rep[Tup3[_,B,_]])(implicit __pos: SourceContext,__imp1: Overload1) = tup3__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  override def infix__3[C:Manifest](__arg0: Rep[Tup3[_,_,C]])(implicit __pos: SourceContext,__imp1: Overload1) = tup3__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  override def unpack[A:Manifest,B:Manifest,C:Manifest](t: Rep[Tup3[A,B,C]])(implicit __pos: SourceContext,__imp1: Overload1) = tup3_unpack[A,B,C](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],__pos)
  override def pack[A:Manifest,B:Manifest,C:Manifest](t: Tuple3[Rep[A],Rep[B],Rep[C]])(implicit __pos: SourceContext,__imp1: Overload1) = tup3_pack[A,B,C](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],__pos)
  override def infix_toString[A:Manifest,B:Manifest,C:Manifest](t: Rep[Tup3[A,B,C]])(implicit __imp0: Overload1) = tup3_tostring[A,B,C](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]])
  override def infix_length[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = vector_length[T](self)(implicitly[Manifest[T]],__pos)
  override def infix_slice[T:Manifest](self: Rep[Vector[T]],start: Rep[Int] = unit(0),end: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = vector_slice[T](self,start,end)(implicitly[Manifest[T]],__pos)
  override def infix_+[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Vector[T]])(implicit __pos: SourceContext,__imp0: Numeric[T],__imp2: Overload17) = vector_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  override def infix_unary_-(__arg0: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { unit(-1)*__arg0 }
  override def infix_unary_-(__arg0: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { unit(-1L)*__arg0 }
  override def infix_unary_-(__arg0: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload3): Rep[Float] = { unit(-1f)*__arg0 }
  override def infix_unary_-(__arg0: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[Double] = { unit(-1)*__arg0 }
  override def infix_toInt[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext,__imp1: Overload2) = primitive_toint[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  override def infix_toFloat[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext,__imp1: Overload2) = primitive_tofloat[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  override def infix_toDouble[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext,__imp1: Overload2) = primitive_todouble[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  override def infix_toLong[T:Numeric:Manifest](__arg0: Rep[T])(implicit __pos: SourceContext,__imp1: Overload2) = primitive_tolong[T](__arg0)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  override def infix_%(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = primitive_%(__arg0,__arg1)(__pos,overload1)
  override def infix_unary_~(__arg0: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = primitive_unary_~(__arg0)(__pos,overload1)
  override def infix_%(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext,__imp1: Overload2) = primitive_%(__arg0,__arg1)(__pos,overload2)
  override def infix_unary_~(__arg0: Rep[Long])(implicit __pos: SourceContext,__imp1: Overload2) = primitive_unary_~(__arg0)(__pos,overload2)
  override def infix_<<(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { forge_int_shift_left(__arg0,__arg1) }
  override def infix_>>(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { forge_int_shift_right(__arg0,__arg1) }
  override def infix_>>>(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { forge_int_shift_right_unsigned(__arg0,__arg1) }
  override def infix_&(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { forge_int_and(__arg0,__arg1) }
  override def infix_|(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[Int] = { forge_int_or(__arg0,__arg1) }
  override def infix_&(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { forge_long_and(__arg0,__arg1) }
  override def infix_|(__arg0: Rep[Long],__arg1: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { forge_long_or(__arg0,__arg1) }
  override def infix_>>>(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { forge_long_shift_right_unsigned(__arg0,__arg1) }
  override def infix_<<(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { forge_long_shift_left(__arg0,__arg1) }
  override def infix_>>(__arg0: Rep[Long],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[Long] = { forge_long_shift_right(__arg0,__arg1) }
  override def infix_+(lhs: Double,rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload18): Rep[Double] = { forge_double_plus(unit(lhs), rhs) }
  override def infix_+(lhs: Double,rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload20): Rep[Double] = { forge_double_plus(unit(lhs), rhs.toDouble) }
  override def infix_+(lhs: Double,rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload22): Rep[Double] = { forge_double_plus(unit(lhs), rhs.toDouble) }
  override def infix_+(lhs: Double,rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload24): Rep[Double] = { forge_double_plus(unit(lhs), rhs.toDouble) }
  override def infix_+(lhs: Float,rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload50): Rep[Double] = { forge_double_plus(unit(lhs.toDouble), rhs) }
  override def infix_+(lhs: Float,rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload52): Rep[Float] = { forge_float_plus(unit(lhs), rhs) }
  override def infix_+(lhs: Float,rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload54): Rep[Float] = { forge_float_plus(unit(lhs), rhs.toFloat) }
  override def infix_+(lhs: Float,rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload56): Rep[Float] = { forge_float_plus(unit(lhs), rhs.toFloat) }
  override def infix_+(lhs: Int,rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload82): Rep[Double] = { forge_double_plus(unit(lhs.toDouble), rhs) }
  override def infix_+(lhs: Int,rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload84): Rep[Float] = { forge_float_plus(unit(lhs.toFloat), rhs) }
  override def infix_+(lhs: Int,rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload86): Rep[Int] = { forge_int_plus(unit(lhs), rhs) }
  override def infix_+(lhs: Int,rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload88): Rep[Long] = { forge_long_plus(unit(lhs.toLong), rhs) }
  override def infix_+(lhs: Long,rhs: Rep[Double])(implicit __pos: SourceContext,__imp1: ROverload114): Rep[Double] = { forge_double_plus(unit(lhs.toDouble), rhs) }
  override def infix_+(lhs: Long,rhs: Rep[Float])(implicit __pos: SourceContext,__imp1: ROverload116): Rep[Float] = { forge_float_plus(unit(lhs.toFloat), rhs) }
  override def infix_+(lhs: Long,rhs: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload118): Rep[Long] = { forge_long_plus(unit(lhs), rhs.toLong) }
  override def infix_+(lhs: Long,rhs: Rep[Long])(implicit __pos: SourceContext,__imp1: ROverload120): Rep[Long] = { forge_long_plus(unit(lhs), rhs) }
  override def println(__arg0: Rep[Any])(implicit __pos: SourceContext,__imp1: Overload1) = misc_println(__arg0)(__pos,overload1)
  override def println()(implicit __pos: SourceContext,__imp1: Overload2) = misc_println()(__pos,overload2)
  override def infix_contains[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]],__arg1: Rep[K])(implicit __pos: SourceContext,__imp1: Overload2) = shashmap_contains[K,V](__arg0,__arg1)(implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  override def infix__1[A:Manifest](__arg0: Rep[Tup4[A,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup4__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  override def infix__2[B:Manifest](__arg0: Rep[Tup4[_,B,_,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup4__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  override def infix__3[C:Manifest](__arg0: Rep[Tup4[_,_,C,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup4__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  override def infix__4[D:Manifest](__arg0: Rep[Tup4[_,_,_,D]])(implicit __pos: SourceContext,__imp1: Overload1) = tup4__4[D](__arg0)(implicitly[Manifest[D]],__pos)
  override def unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Rep[Tup4[A,B,C,D]])(implicit __pos: SourceContext,__imp1: Overload2) = tup4_unpack[A,B,C,D](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],__pos)
  override def pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Tuple4[Rep[A],Rep[B],Rep[C],Rep[D]])(implicit __pos: SourceContext,__imp1: Overload2) = tup4_pack[A,B,C,D](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],__pos)
  override def infix_toString[A:Manifest,B:Manifest,C:Manifest,D:Manifest](t: Rep[Tup4[A,B,C,D]])(implicit __imp0: Overload2) = tup4_tostring[A,B,C,D](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]])
  override def infix_get(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Int]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = sbytebuffer_get(__arg0,__arg1,__arg2,__arg3)(__pos,overload1)
  override def infix_get(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Double]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = sbytebuffer_get(__arg0,__arg1,__arg2,__arg3)(__pos,overload2)
  override def infix_put(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Int]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = sbytebuffer_put(__arg0,__arg1,__arg2,__arg3)(__pos,overload1)
  override def infix_put(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Double]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = sbytebuffer_put(__arg0,__arg1,__arg2,__arg3)(__pos,overload2)
  override def infix_+[T:Numeric:Manifest](__arg0: Rep[T],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: Overload146) = numeric_pl[T](__arg0,__arg1)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos)
  override def infix__1[A:Manifest](__arg0: Rep[Tup6[A,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload3) = tup6__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  override def infix__2[B:Manifest](__arg0: Rep[Tup6[_,B,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload3) = tup6__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  override def infix__3[C:Manifest](__arg0: Rep[Tup6[_,_,C,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload3) = tup6__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  override def infix__4[D:Manifest](__arg0: Rep[Tup6[_,_,_,D,_,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup6__4[D](__arg0)(implicitly[Manifest[D]],__pos)
  override def infix__5[E:Manifest](__arg0: Rep[Tup6[_,_,_,_,E,_]])(implicit __pos: SourceContext,__imp1: Overload1) = tup6__5[E](__arg0)(implicitly[Manifest[E]],__pos)
  override def infix__6[F:Manifest](__arg0: Rep[Tup6[_,_,_,_,_,F]])(implicit __pos: SourceContext,__imp1: Overload1) = tup6__6[F](__arg0)(implicitly[Manifest[F]],__pos)
  override def unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Rep[Tup6[A,B,C,D,E,F]])(implicit __pos: SourceContext,__imp1: Overload3) = tup6_unpack[A,B,C,D,E,F](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],__pos)
  override def pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Tuple6[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F]])(implicit __pos: SourceContext,__imp1: Overload3) = tup6_pack[A,B,C,D,E,F](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],__pos)
  override def infix_toString[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest](t: Rep[Tup6[A,B,C,D,E,F]])(implicit __imp0: Overload3) = tup6_tostring[A,B,C,D,E,F](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]])
  override def infix__1[A:Manifest](__arg0: Rep[Tup9[A,_,_,_,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload4) = tup9__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  override def infix__2[B:Manifest](__arg0: Rep[Tup9[_,B,_,_,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload4) = tup9__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  override def infix__3[C:Manifest](__arg0: Rep[Tup9[_,_,C,_,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload4) = tup9__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  override def infix__4[D:Manifest](__arg0: Rep[Tup9[_,_,_,D,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload3) = tup9__4[D](__arg0)(implicitly[Manifest[D]],__pos)
  override def infix__5[E:Manifest](__arg0: Rep[Tup9[_,_,_,_,E,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup9__5[E](__arg0)(implicitly[Manifest[E]],__pos)
  override def infix__6[F:Manifest](__arg0: Rep[Tup9[_,_,_,_,_,F,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup9__6[F](__arg0)(implicitly[Manifest[F]],__pos)
  override def infix__7[G:Manifest](__arg0: Rep[Tup9[_,_,_,_,_,_,G,_,_]])(implicit __pos: SourceContext,__imp1: Overload1) = tup9__7[G](__arg0)(implicitly[Manifest[G]],__pos)
  override def infix__8[H:Manifest](__arg0: Rep[Tup9[_,_,_,_,_,_,_,H,_]])(implicit __pos: SourceContext,__imp1: Overload1) = tup9__8[H](__arg0)(implicitly[Manifest[H]],__pos)
  override def unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](t: Rep[Tup9[A,B,C,D,E,F,G,H,I]])(implicit __pos: SourceContext,__imp1: Overload4) = tup9_unpack[A,B,C,D,E,F,G,H,I](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],implicitly[Manifest[I]],__pos)
  override def pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](t: Tuple9[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G],Rep[H],Rep[I]])(implicit __pos: SourceContext,__imp1: Overload4) = tup9_pack[A,B,C,D,E,F,G,H,I](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],implicitly[Manifest[I]],__pos)
  override def infix_toString[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest](t: Rep[Tup9[A,B,C,D,E,F,G,H,I]])(implicit __imp0: Overload4) = tup9_tostring[A,B,C,D,E,F,G,H,I](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],implicitly[Manifest[I]])
  override def infix__1[A:Manifest](__arg0: Rep[Tup8[A,_,_,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload5) = tup8__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  override def infix__2[B:Manifest](__arg0: Rep[Tup8[_,B,_,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload5) = tup8__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  override def infix__3[C:Manifest](__arg0: Rep[Tup8[_,_,C,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload5) = tup8__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  override def infix__4[D:Manifest](__arg0: Rep[Tup8[_,_,_,D,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload4) = tup8__4[D](__arg0)(implicitly[Manifest[D]],__pos)
  override def infix__5[E:Manifest](__arg0: Rep[Tup8[_,_,_,_,E,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload3) = tup8__5[E](__arg0)(implicitly[Manifest[E]],__pos)
  override def infix__6[F:Manifest](__arg0: Rep[Tup8[_,_,_,_,_,F,_,_]])(implicit __pos: SourceContext,__imp1: Overload3) = tup8__6[F](__arg0)(implicitly[Manifest[F]],__pos)
  override def infix__7[G:Manifest](__arg0: Rep[Tup8[_,_,_,_,_,_,G,_]])(implicit __pos: SourceContext,__imp1: Overload2) = tup8__7[G](__arg0)(implicitly[Manifest[G]],__pos)
  override def infix__8[H:Manifest](__arg0: Rep[Tup8[_,_,_,_,_,_,_,H]])(implicit __pos: SourceContext,__imp1: Overload2) = tup8__8[H](__arg0)(implicitly[Manifest[H]],__pos)
  override def unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Rep[Tup8[A,B,C,D,E,F,G,H]])(implicit __pos: SourceContext,__imp1: Overload5) = tup8_unpack[A,B,C,D,E,F,G,H](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],__pos)
  override def pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Tuple8[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G],Rep[H]])(implicit __pos: SourceContext,__imp1: Overload5) = tup8_pack[A,B,C,D,E,F,G,H](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]],__pos)
  override def infix_toString[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest](t: Rep[Tup8[A,B,C,D,E,F,G,H]])(implicit __imp0: Overload5) = tup8_tostring[A,B,C,D,E,F,G,H](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],implicitly[Manifest[H]])
  override def infix__1[A:Manifest](__arg0: Rep[Tup5[A,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload6) = tup5__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  override def infix__2[B:Manifest](__arg0: Rep[Tup5[_,B,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload6) = tup5__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  override def infix__3[C:Manifest](__arg0: Rep[Tup5[_,_,C,_,_]])(implicit __pos: SourceContext,__imp1: Overload6) = tup5__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  override def infix__4[D:Manifest](__arg0: Rep[Tup5[_,_,_,D,_]])(implicit __pos: SourceContext,__imp1: Overload5) = tup5__4[D](__arg0)(implicitly[Manifest[D]],__pos)
  override def infix__5[E:Manifest](__arg0: Rep[Tup5[_,_,_,_,E]])(implicit __pos: SourceContext,__imp1: Overload4) = tup5__5[E](__arg0)(implicitly[Manifest[E]],__pos)
  override def unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Rep[Tup5[A,B,C,D,E]])(implicit __pos: SourceContext,__imp1: Overload6) = tup5_unpack[A,B,C,D,E](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],__pos)
  override def pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Tuple5[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E]])(implicit __pos: SourceContext,__imp1: Overload6) = tup5_pack[A,B,C,D,E](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],__pos)
  override def infix_toString[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest](t: Rep[Tup5[A,B,C,D,E]])(implicit __imp0: Overload6) = tup5_tostring[A,B,C,D,E](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]])
  override def __equal[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: Overload1) = forge_equals[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos)
  override def infix_!=[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext,__imp1: Overload1) = forge_notequals[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos)
  override def infix__1[A:Manifest](__arg0: Rep[Tup7[A,_,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload7) = tup7__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  override def infix__2[B:Manifest](__arg0: Rep[Tup7[_,B,_,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload7) = tup7__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  override def infix__3[C:Manifest](__arg0: Rep[Tup7[_,_,C,_,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload7) = tup7__3[C](__arg0)(implicitly[Manifest[C]],__pos)
  override def infix__4[D:Manifest](__arg0: Rep[Tup7[_,_,_,D,_,_,_]])(implicit __pos: SourceContext,__imp1: Overload6) = tup7__4[D](__arg0)(implicitly[Manifest[D]],__pos)
  override def infix__5[E:Manifest](__arg0: Rep[Tup7[_,_,_,_,E,_,_]])(implicit __pos: SourceContext,__imp1: Overload5) = tup7__5[E](__arg0)(implicitly[Manifest[E]],__pos)
  override def infix__6[F:Manifest](__arg0: Rep[Tup7[_,_,_,_,_,F,_]])(implicit __pos: SourceContext,__imp1: Overload4) = tup7__6[F](__arg0)(implicitly[Manifest[F]],__pos)
  override def infix__7[G:Manifest](__arg0: Rep[Tup7[_,_,_,_,_,_,G]])(implicit __pos: SourceContext,__imp1: Overload3) = tup7__7[G](__arg0)(implicitly[Manifest[G]],__pos)
  override def unpack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](t: Rep[Tup7[A,B,C,D,E,F,G]])(implicit __pos: SourceContext,__imp1: Overload7) = tup7_unpack[A,B,C,D,E,F,G](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],__pos)
  override def pack[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](t: Tuple7[Rep[A],Rep[B],Rep[C],Rep[D],Rep[E],Rep[F],Rep[G]])(implicit __pos: SourceContext,__imp1: Overload7) = tup7_pack[A,B,C,D,E,F,G](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]],__pos)
  override def infix_toString[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest](t: Rep[Tup7[A,B,C,D,E,F,G]])(implicit __imp0: Overload7) = tup7_tostring[A,B,C,D,E,F,G](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],implicitly[Manifest[C]],implicitly[Manifest[D]],implicitly[Manifest[E]],implicitly[Manifest[F]],implicitly[Manifest[G]])
  override def infix__1[A:Manifest](__arg0: Rep[Tup2[A,_]])(implicit __pos: SourceContext,__imp1: Overload8) = tup2__1[A](__arg0)(implicitly[Manifest[A]],__pos)
  override def infix__2[B:Manifest](__arg0: Rep[Tup2[_,B]])(implicit __pos: SourceContext,__imp1: Overload8) = tup2__2[B](__arg0)(implicitly[Manifest[B]],__pos)
  override def unpack[A:Manifest,B:Manifest](t: Rep[Tup2[A,B]])(implicit __pos: SourceContext,__imp1: Overload8) = tup2_unpack[A,B](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos)
  override def pack[A:Manifest,B:Manifest](t: Tuple2[Rep[A],Rep[B]])(implicit __pos: SourceContext,__imp1: Overload8) = tup2_pack[A,B](t)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos,overload8)
  override def infix_toString[A:Manifest,B:Manifest](t: Rep[Tup2[A,B]])(implicit __imp0: Overload8) = tup2_tostring[A,B](t)(implicitly[Manifest[A]],implicitly[Manifest[B]])
  override def pack[A:Manifest,B:Manifest](__arg0: Tuple2[Var[A],Rep[B]])(implicit __pos: SourceContext,__imp1: ROverload9): Rep[Tup2[A,B]] = { tup2_pack((__arg0._1,__arg0._2)) }
  override def pack[A:Manifest,B:Manifest](__arg0: Tuple2[Rep[A],Var[B]])(implicit __pos: SourceContext,__imp1: ROverload10): Rep[Tup2[A,B]] = { tup2_pack((__arg0._1,__arg0._2)) }
  override def pack[A:Manifest,B:Manifest](__arg0: Tuple2[Var[A],Var[B]])(implicit __pos: SourceContext,__imp1: ROverload11): Rep[Tup2[A,B]] = { tup2_pack((__arg0._1,__arg0._2)) }
  override def __newVar[T](x: T) = super.__newVar(x)
  def infix_!=(x: Int, y: Int) = forge_notequals(x,y)
  def infix_!=(x: Int, y: Float) = forge_notequals(x,y)
  def infix_!=(x: Int, y: Double) = forge_notequals(x,y)
  def infix_!=(x: Float, y: Int) = forge_notequals(x,y)
  def infix_!=(x: Float, y: Float) = forge_notequals(x,y)
  def infix_!=(x: Float, y: Double) = forge_notequals(x,y)
  def infix_!=(x: Double, y: Int) = forge_notequals(x,y)
  def infix_!=(x: Double, y: Float) = forge_notequals(x,y)
  def infix_!=(x: Double, y: Double) = forge_notequals(x,y)
  def infix_!=(x: Boolean, y: Boolean) = forge_notequals(x,y)
}

/**
 * dsl library definition
 */
trait SimpleVectorBase extends SimpleVectorIdentifiers {
  type Rep[+T] = T
  protected def unit[T:Manifest](x: T) = x
}

trait SimpleVectorCompilerOps extends SimpleVectorApplication
 with Tup3CompilerOps with VectorCompilerOps with SHashMapCompilerOps with Tup4CompilerOps with Tup6CompilerOps with Tup9CompilerOps with Tup8CompilerOps with Tup5CompilerOps with Tup7CompilerOps with Tup2CompilerOps with ForgeArrayCompilerOps with ForgeArrayBufferCompilerOps with ForgeHashMapCompilerOps with VarCompilerOps with LambdaCompilerOps with RecordCompilerOps with InputOutputCompilerOps with ProfilingCompilerOps with ReppableCompilerOps with TestsCompilerOps with AssertsCompilerOps

trait SimpleVectorLib extends SimpleVectorBase with SimpleVectorCompilerOps with SimpleVectorClasses {
  this: SimpleVectorApplication => 

  // override required due to mix-in
  override type Rep[+T] = T

  /**
   * dsl types
   */
  def m_Tup2[A:Manifest,B:Manifest] = manifest[Tup2[A,B]]
  def m_Tup3[A:Manifest,B:Manifest,C:Manifest] = manifest[Tup3[A,B,C]]
  def m_Tup4[A:Manifest,B:Manifest,C:Manifest,D:Manifest] = manifest[Tup4[A,B,C,D]]
  def m_Tup5[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest] = manifest[Tup5[A,B,C,D,E]]
  def m_Tup6[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest] = manifest[Tup6[A,B,C,D,E,F]]
  def m_Tup7[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest] = manifest[Tup7[A,B,C,D,E,F,G]]
  def m_Tup8[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest] = manifest[Tup8[A,B,C,D,E,F,G,H]]
  def m_Tup9[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest] = manifest[Tup9[A,B,C,D,E,F,G,H,I]]
  def m_Vector[T:Manifest] = manifest[Vector[T]]

}

