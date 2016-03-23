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

trait FStringOpsExp extends FStringOps with BaseFatExp with EffectExp {
  this: SimpleVectorExp => 

  case class FString1_ToInt(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class FString1_ToLong(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[Long] {
  }

  case class FString1_ToFloat(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[Float] {
  }

  case class FString1_ToDouble(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class FString_ToBoolean(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[Boolean] {
  }

  case class FString_Trim(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[String] {
  }

  case class FString_FcharAt(__arg0: Rep[String],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[Char] {
  }

  case class FString1_Length(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class FString_StartsWith(__arg0: Rep[String],__arg1: Rep[String])(implicit val __pos: SourceContext) extends Def[Boolean] {
  }

  case class FString_EndsWith(__arg0: Rep[String],__arg1: Rep[String])(implicit val __pos: SourceContext) extends Def[Boolean] {
  }

  case class FString1_Contains(__arg0: Rep[String],__arg1: Rep[String])(implicit val __pos: SourceContext) extends Def[Boolean] {
  }

  case class FString1_Substring(__arg0: Rep[String],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[String] {
  }

  case class FString2_Substring(__arg0: Rep[String],__arg1: Rep[Int],__arg2: Rep[Int])(implicit val __pos: SourceContext) extends Def[String] {
  }

  case class FString_ToLowerCase(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[String] {
  }

  case class FString_ToUpperCase(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[String] {
  }

  case class FString_GetBytes(__arg0: Rep[String])(implicit val __pos: SourceContext) extends Def[ForgeArray[Byte]] {
  }

  case class FString_ReplaceAllLiterally(__arg0: Rep[String],__arg1: Rep[String],__arg2: Rep[String])(implicit val __pos: SourceContext) extends Def[String] {
  }

  case class FString_Forge_string_plus[T:Manifest,B:Manifest](__arg0: Rep[T],__arg1: Rep[B])(implicit val __pos: SourceContext) extends Def[String] {
    val _mT = implicitly[Manifest[T]]
    val _mB = implicitly[Manifest[B]]
  }



  def fstring_toint(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString1_ToInt(__arg0)(__pos))
  }
  def fstring_tolong(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString1_ToLong(__arg0)(__pos))
  }
  def fstring_tofloat(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString1_ToFloat(__arg0)(__pos))
  }
  def fstring_todouble(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString1_ToDouble(__arg0)(__pos))
  }
  def fstring_toboolean(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString_ToBoolean(__arg0)(__pos))
  }
  def fstring_trim(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString_Trim(__arg0)(__pos))
  }
  def fstring_fcharat(__arg0: Rep[String],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(FString_FcharAt(__arg0,__arg1)(__pos))
  }
  def fstring_length(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString1_Length(__arg0)(__pos))
  }
  def fstring_startswith(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString_StartsWith(__arg0,__arg1)(__pos))
  }
  def fstring_endswith(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString_EndsWith(__arg0,__arg1)(__pos))
  }
  def fstring_contains(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString1_Contains(__arg0,__arg1)(__pos))
  }
  def fstring_substring(__arg0: Rep[String],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = {
    reflectPure(FString1_Substring(__arg0,__arg1)(__pos))
  }
  def fstring_substring(__arg0: Rep[String],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = {
    reflectPure(FString2_Substring(__arg0,__arg1,__arg2)(__pos))
  }
  def fstring_tolowercase(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString_ToLowerCase(__arg0)(__pos))
  }
  def fstring_touppercase(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString_ToUpperCase(__arg0)(__pos))
  }
  def fstring_getbytes(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString_GetBytes(__arg0)(__pos))
  }
  def fstring_replaceallliterally(__arg0: Rep[String],__arg1: Rep[String],__arg2: Rep[String])(implicit __pos: SourceContext) = {
    reflectPure(FString_ReplaceAllLiterally(__arg0,__arg1,__arg2)(__pos))
  }
  def fstring_split(__arg0: Rep[String],__arg1: Rep[String],numSplits: Rep[Int] = unit(0))(implicit __pos: SourceContext) = {
    fstring_split_impl(__arg0,__arg1,numSplits)(__pos)
  }
  def fstring_forge_string_plus[T:Manifest,B:Manifest](__arg0: Rep[T],__arg1: Rep[B])(implicit __pos: SourceContext) = {
    reflectPure(FString_Forge_string_plus[T,B](__arg0,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[B]],__pos))
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@FString1_ToInt(__arg0) => fstring_toint(f(__arg0))(mn.__pos)
    case Reflect(mn@FString1_ToInt(__arg0), u, es) => reflectMirrored(Reflect(FString1_ToInt(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString1_ToLong(__arg0) => fstring_tolong(f(__arg0))(mn.__pos)
    case Reflect(mn@FString1_ToLong(__arg0), u, es) => reflectMirrored(Reflect(FString1_ToLong(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString1_ToFloat(__arg0) => fstring_tofloat(f(__arg0))(mn.__pos)
    case Reflect(mn@FString1_ToFloat(__arg0), u, es) => reflectMirrored(Reflect(FString1_ToFloat(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString1_ToDouble(__arg0) => fstring_todouble(f(__arg0))(mn.__pos)
    case Reflect(mn@FString1_ToDouble(__arg0), u, es) => reflectMirrored(Reflect(FString1_ToDouble(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString_ToBoolean(__arg0) => fstring_toboolean(f(__arg0))(mn.__pos)
    case Reflect(mn@FString_ToBoolean(__arg0), u, es) => reflectMirrored(Reflect(FString_ToBoolean(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString_Trim(__arg0) => fstring_trim(f(__arg0))(mn.__pos)
    case Reflect(mn@FString_Trim(__arg0), u, es) => reflectMirrored(Reflect(FString_Trim(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString_FcharAt(__arg0,__arg1) => fstring_fcharat(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@FString_FcharAt(__arg0,__arg1), u, es) => reflectMirrored(Reflect(FString_FcharAt(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString1_Length(__arg0) => fstring_length(f(__arg0))(mn.__pos)
    case Reflect(mn@FString1_Length(__arg0), u, es) => reflectMirrored(Reflect(FString1_Length(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString_StartsWith(__arg0,__arg1) => fstring_startswith(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@FString_StartsWith(__arg0,__arg1), u, es) => reflectMirrored(Reflect(FString_StartsWith(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString_EndsWith(__arg0,__arg1) => fstring_endswith(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@FString_EndsWith(__arg0,__arg1), u, es) => reflectMirrored(Reflect(FString_EndsWith(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString1_Contains(__arg0,__arg1) => fstring_contains(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@FString1_Contains(__arg0,__arg1), u, es) => reflectMirrored(Reflect(FString1_Contains(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString1_Substring(__arg0,__arg1) => fstring_substring(f(__arg0),f(__arg1))(mn.__pos,overload1)
    case Reflect(mn@FString1_Substring(__arg0,__arg1), u, es) => reflectMirrored(Reflect(FString1_Substring(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString2_Substring(__arg0,__arg1,__arg2) => fstring_substring(f(__arg0),f(__arg1),f(__arg2))(mn.__pos,overload2)
    case Reflect(mn@FString2_Substring(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(FString2_Substring(f(__arg0),f(__arg1),f(__arg2))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString_ToLowerCase(__arg0) => fstring_tolowercase(f(__arg0))(mn.__pos)
    case Reflect(mn@FString_ToLowerCase(__arg0), u, es) => reflectMirrored(Reflect(FString_ToLowerCase(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString_ToUpperCase(__arg0) => fstring_touppercase(f(__arg0))(mn.__pos)
    case Reflect(mn@FString_ToUpperCase(__arg0), u, es) => reflectMirrored(Reflect(FString_ToUpperCase(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString_GetBytes(__arg0) => fstring_getbytes(f(__arg0))(mn.__pos)
    case Reflect(mn@FString_GetBytes(__arg0), u, es) => reflectMirrored(Reflect(FString_GetBytes(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString_ReplaceAllLiterally(__arg0,__arg1,__arg2) => fstring_replaceallliterally(f(__arg0),f(__arg1),f(__arg2))(mn.__pos)
    case Reflect(mn@FString_ReplaceAllLiterally(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(FString_ReplaceAllLiterally(f(__arg0),f(__arg1),f(__arg2))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@FString_Forge_string_plus(__arg0,__arg1) => fstring_forge_string_plus(f(__arg0),f(__arg1))(mtype(mn._mT),mtype(mn._mB),mn.__pos)
    case Reflect(mn@FString_Forge_string_plus(__arg0,__arg1), u, es) => reflectMirrored(Reflect(FString_Forge_string_plus(f(__arg0),f(__arg1))(mtype(mn._mT),mtype(mn._mB),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


}

/**
 * Code generators
 */

trait ScalaGenFStringOps extends ScalaGenFat {
  val IR: FStringOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@FString1_ToInt(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toInt")
      stream.println("}")

    case mn@FString1_ToLong(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toLong")
      stream.println("}")

    case mn@FString1_ToFloat(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toFloat")
      stream.println("}")

    case mn@FString1_ToDouble(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toDouble")
      stream.println("}")

    case mn@FString_ToBoolean(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toBoolean")
      stream.println("}")

    case mn@FString_Trim(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".trim")
      stream.println("}")

    case mn@FString_FcharAt(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".charAt("+quote(__arg1)+")")
      stream.println("}")

    case mn@FString1_Length(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".length")
      stream.println("}")

    case mn@FString_StartsWith(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".startsWith("+quote(__arg1)+")")
      stream.println("}")

    case mn@FString_EndsWith(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".endsWith("+quote(__arg1)+")")
      stream.println("}")

    case mn@FString1_Contains(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".contains("+quote(__arg1)+")")
      stream.println("}")

    case mn@FString1_Substring(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".substring("+quote(__arg1)+")")
      stream.println("}")

    case mn@FString2_Substring(__arg0,__arg1,__arg2) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".substring("+quote(__arg1)+","+quote(__arg2)+")")
      stream.println("}")

    case mn@FString_ToLowerCase(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toLowerCase")
      stream.println("}")

    case mn@FString_ToUpperCase(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toUpperCase")
      stream.println("}")

    case mn@FString_GetBytes(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".getBytes()")
      stream.println("}")

    case mn@FString_ReplaceAllLiterally(__arg0,__arg1,__arg2) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".replaceAllLiterally("+quote(__arg1)+","+quote(__arg2)+")")
      stream.println("}")

    case mn@FString_Forge_string_plus(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".toString + "+quote(__arg1)+".toString")
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CGenFStringOps extends CGenFat {
  val IR: FStringOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@FString1_ToInt(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_toInt("+quote(__arg0)+")")
      stream.println(";")

    case mn@FString1_ToLong(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_toLong("+quote(__arg0)+")")
      stream.println(";")

    case mn@FString1_ToFloat(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_toFloat("+quote(__arg0)+")")
      stream.println(";")

    case mn@FString1_ToDouble(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_toDouble("+quote(__arg0)+")")
      stream.println(";")

    case mn@FString_ToBoolean(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_toBoolean("+quote(__arg0)+")")
      stream.println(";")

    case mn@FString_Trim(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_trim("+quote(__arg0)+")")
      stream.println(";")

    case mn@FString_FcharAt(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_charAt("+quote(__arg0)+","+quote(__arg1)+")")
      stream.println(";")

    case mn@FString1_Length(__arg0) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_length("+quote(__arg0)+")")
      stream.println(";")

    case mn@FString_StartsWith(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_startsWith("+quote(__arg0)+","+quote(__arg1)+")")
      stream.println(";")

    case mn@FString_EndsWith(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_endsWith("+quote(__arg0)+","+quote(__arg1)+")")
      stream.println(";")

    case mn@FString1_Contains(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_contains("+quote(__arg0)+","+quote(__arg1)+")")
      stream.println(";")

    case mn@FString1_Substring(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_substr("+quote(__arg0)+","+quote(__arg1)+")")
      stream.println(";")

    case mn@FString2_Substring(__arg0,__arg1,__arg2) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_substr("+quote(__arg0)+","+quote(__arg1)+","+quote(__arg2)+")")
      stream.println(";")

    case mn@FString_Forge_string_plus(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("string_plus( convert_to_string< "+remapWithRef(__arg0.tp)+">("+quote(__arg0)+"), convert_to_string< "+remapWithRef(__arg1.tp)+">("+quote(__arg1)+"))")
      stream.println(";")

    case _ => super.emitNode(sym, rhs)
  }
}
