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

trait LiftFString {
  this: SimpleVector => 

  implicit def FStringStringToRep(x: String) = unit(x)
}

/**
 * Operations
 */

trait FStringOps extends Base {
  this: SimpleVector => 

  def forge_string_plus[T:Manifest,B:Manifest](__arg0: Rep[T],__arg1: Rep[B])(implicit __pos: SourceContext) = fstring_forge_string_plus[T,B](__arg0,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[B]],__pos)

  def infix_toInt(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload1) = fstring_toint(__arg0)(__pos)
  def infix_toLong(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload1) = fstring_tolong(__arg0)(__pos)
  def infix_toFloat(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload1) = fstring_tofloat(__arg0)(__pos)
  def infix_toDouble(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload1) = fstring_todouble(__arg0)(__pos)
  def infix_toBoolean(__arg0: Rep[String])(implicit __pos: SourceContext) = fstring_toboolean(__arg0)(__pos)
  def infix_trim(__arg0: Rep[String])(implicit __pos: SourceContext) = fstring_trim(__arg0)(__pos)
  def infix_fcharAt(__arg0: Rep[String],__arg1: Rep[Int])(implicit __pos: SourceContext) = fstring_fcharat(__arg0,__arg1)(__pos)
  def infix_length(__arg0: Rep[String])(implicit __pos: SourceContext,__imp1: Overload1) = fstring_length(__arg0)(__pos)
  def infix_startsWith(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext) = fstring_startswith(__arg0,__arg1)(__pos)
  def infix_slice(__arg0: Rep[String],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[String] = { fstring_substring(__arg0,__arg1,__arg2) }
  def infix_endsWith(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext) = fstring_endswith(__arg0,__arg1)(__pos)
  def infix_contains(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: Overload1) = fstring_contains(__arg0,__arg1)(__pos)
  def infix_substring(__arg0: Rep[String],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = fstring_substring(__arg0,__arg1)(__pos,overload1)
  def infix_substring(__arg0: Rep[String],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = fstring_substring(__arg0,__arg1,__arg2)(__pos,overload2)
  def infix_toLowerCase(__arg0: Rep[String])(implicit __pos: SourceContext) = fstring_tolowercase(__arg0)(__pos)
  def infix_toUpperCase(__arg0: Rep[String])(implicit __pos: SourceContext) = fstring_touppercase(__arg0)(__pos)
  def infix_getBytes(__arg0: Rep[String])(implicit __pos: SourceContext) = fstring_getbytes(__arg0)(__pos)
  def infix_replaceAllLiterally(__arg0: Rep[String],__arg1: Rep[String],__arg2: Rep[String])(implicit __pos: SourceContext) = fstring_replaceallliterally(__arg0,__arg1,__arg2)(__pos)
  def infix_fsplit(__arg0: Rep[String],__arg1: Rep[String],numSplits: Rep[Int] = unit(0))(implicit __pos: SourceContext): Rep[ForgeArray[String]] = { __arg0.split(__arg1, numSplits) }
  def infix_split(__arg0: Rep[String],__arg1: Rep[String],numSplits: Rep[Int] = unit(0))(implicit __pos: SourceContext) = fstring_split(__arg0,__arg1,numSplits)(__pos)
  def infix_+[T:Manifest](__arg0: String,__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: ROverload1): Rep[String] = { forge_string_plus(unit(__arg0), __arg1) }
  def infix_+[T:Manifest](__arg0: Rep[String],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: ROverload2): Rep[String] = { forge_string_plus(__arg0, __arg1) }
  def infix_+[T:Manifest](__arg0: String,__arg1: Var[T])(implicit __pos: SourceContext,__imp1: ROverload3): Rep[String] = { forge_string_plus(unit(__arg0), readVar(__arg1)) }
  def infix_+[T:Manifest](__arg0: Rep[String],__arg1: Var[T])(implicit __pos: SourceContext,__imp1: ROverload4): Rep[String] = { forge_string_plus(__arg0, readVar(__arg1)) }
  def infix_+[T:Manifest](__arg0: Var[String],__arg1: Rep[T])(implicit __pos: SourceContext,__imp1: ROverload5): Rep[String] = { forge_string_plus(readVar(__arg0), __arg1) }
  def infix_+[T:Manifest](__arg0: Var[String],__arg1: Var[T])(implicit __pos: SourceContext,__imp1: ROverload6): Rep[String] = { forge_string_plus(readVar(__arg0), readVar(__arg1)) }
  def infix_+[T:Manifest](__arg0: Rep[T],__arg1: String)(implicit __pos: SourceContext,__imp1: ROverload7): Rep[String] = { forge_string_plus(__arg0, unit(__arg1)) }
  def infix_+[T:Manifest](__arg0: Rep[T],__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: ROverload8): Rep[String] = { forge_string_plus(__arg0, __arg1) }
  def infix_+[T:Manifest](__arg0: Var[T],__arg1: String)(implicit __pos: SourceContext,__imp1: ROverload9): Rep[String] = { forge_string_plus(readVar(__arg0), unit(__arg1)) }
  def infix_+[T:Manifest](__arg0: Var[T],__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: ROverload10): Rep[String] = { forge_string_plus(readVar(__arg0), __arg1) }
  def infix_+[T:Manifest](__arg0: Var[T],__arg1: Var[String])(implicit __pos: SourceContext,__imp1: ROverload11): Rep[String] = { forge_string_plus(readVar(__arg0), readVar(__arg1)) }
  def infix_+(__arg0: String,__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: ROverload12): Rep[String] = { forge_string_plus(unit(__arg0), __arg1) }
  def infix_+(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: ROverload13): Rep[String] = { forge_string_plus(__arg0, __arg1) }
  def infix_+(__arg0: Rep[String],__arg1: Var[String])(implicit __pos: SourceContext,__imp1: ROverload14): Rep[String] = { forge_string_plus(__arg0, readVar(__arg1)) }
  def infix_+(__arg0: Var[String],__arg1: Rep[String])(implicit __pos: SourceContext,__imp1: ROverload15): Rep[String] = { forge_string_plus(readVar(__arg0), __arg1) }
  def infix_+(__arg0: Var[String],__arg1: Var[String])(implicit __pos: SourceContext,__imp1: ROverload16): Rep[String] = { forge_string_plus(readVar(__arg0), readVar(__arg1)) }

  def fstring_toint(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[Int]
  def fstring_tolong(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[Long]
  def fstring_tofloat(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[Float]
  def fstring_todouble(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[Double]
  def fstring_toboolean(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[Boolean]
  def fstring_trim(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[String]
  def fstring_fcharat(__arg0: Rep[String],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Char]
  def fstring_length(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[Int]
  def fstring_startswith(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext): Rep[Boolean]
  def fstring_endswith(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext): Rep[Boolean]
  def fstring_contains(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext): Rep[Boolean]
  def fstring_substring(__arg0: Rep[String],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1): Rep[String]
  def fstring_substring(__arg0: Rep[String],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2): Rep[String]
  def fstring_tolowercase(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[String]
  def fstring_touppercase(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[String]
  def fstring_getbytes(__arg0: Rep[String])(implicit __pos: SourceContext): Rep[ForgeArray[Byte]]
  def fstring_replaceallliterally(__arg0: Rep[String],__arg1: Rep[String],__arg2: Rep[String])(implicit __pos: SourceContext): Rep[String]
  def fstring_split(__arg0: Rep[String],__arg1: Rep[String],numSplits: Rep[Int] = unit(0))(implicit __pos: SourceContext): Rep[ForgeArray[String]]
  def fstring_forge_string_plus[T:Manifest,B:Manifest](__arg0: Rep[T],__arg1: Rep[B])(implicit __pos: SourceContext): Rep[String]
}
