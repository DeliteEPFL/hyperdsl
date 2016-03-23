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

trait FStringWrapper {
  this: SimpleVectorBase with SimpleVectorClasses => 

  def fstring_toint(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.toInt
  }
  def fstring_tolong(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.toLong
  }
  def fstring_tofloat(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.toFloat
  }
  def fstring_todouble(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.toDouble
  }
  def fstring_toboolean(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.toBoolean
  }
  def fstring_trim(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.trim
  }
  def fstring_fcharat(__arg0: Rep[String],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0.charAt(__arg1)
  }
  def fstring_length(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.length
  }
  def fstring_startswith(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.startsWith(__arg1)
  }
  def fstring_endswith(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.endsWith(__arg1)
  }
  def fstring_contains(__arg0: Rep[String],__arg1: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.contains(__arg1)
  }
  def fstring_substring(__arg0: Rep[String],__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = {
    __arg0.substring(__arg1)
  }
  def fstring_substring(__arg0: Rep[String],__arg1: Rep[Int],__arg2: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = {
    __arg0.substring(__arg1,__arg2)
  }
  def fstring_tolowercase(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.toLowerCase
  }
  def fstring_touppercase(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.toUpperCase
  }
  def fstring_getbytes(__arg0: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.getBytes()
  }
  def fstring_replaceallliterally(__arg0: Rep[String],__arg1: Rep[String],__arg2: Rep[String])(implicit __pos: SourceContext) = {
    __arg0.replaceAllLiterally(__arg1,__arg2)
  }
  def fstring_split(__arg0: Rep[String],__arg1: Rep[String],numSplits: Rep[Int] = unit(0))(implicit __pos: SourceContext) = {
    fstring_split_impl(__arg0,__arg1,numSplits)(__pos)
  }
  def fstring_forge_string_plus[T:Manifest,B:Manifest](__arg0: Rep[T],__arg1: Rep[B])(implicit __pos: SourceContext) = {
    __arg0.toString + __arg1.toString
  }

}

