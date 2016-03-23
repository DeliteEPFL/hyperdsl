package simplevector.shared.ops

import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import simplevector.shared._
import simplevector.shared.ops._

/**
 * Operations
 */

trait SByteBufferOps extends Base {
  this: SimpleVector => 

  def ByteBuffer(__arg0: Rep[Int])(implicit __pos: SourceContext) = sbytebuffer_bytebuffer(__arg0)(__pos)
  def ByteBufferWrap(__arg0: Rep[ForgeArray[Byte]])(implicit __pos: SourceContext) = sbytebuffer_bytebufferwrap(__arg0)(__pos)

  def infix_rewind(__arg0: Rep[java.nio.ByteBuffer])(implicit __pos: SourceContext) = sbytebuffer_rewind(__arg0)(__pos)
  def infix_array(__arg0: Rep[java.nio.ByteBuffer])(implicit __pos: SourceContext) = sbytebuffer_array(__arg0)(__pos)
  def infix_getInt(__arg0: Rep[java.nio.ByteBuffer])(implicit __pos: SourceContext) = sbytebuffer_getint(__arg0)(__pos)
  def infix_getDouble(__arg0: Rep[java.nio.ByteBuffer])(implicit __pos: SourceContext) = sbytebuffer_getdouble(__arg0)(__pos)
  def infix_putInt(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[Int])(implicit __pos: SourceContext) = sbytebuffer_putint(__arg0,__arg1)(__pos)
  def infix_putDouble(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[Double])(implicit __pos: SourceContext) = sbytebuffer_putdouble(__arg0,__arg1)(__pos)
  def infix_get(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Int]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = sbytebuffer_get(__arg0,__arg1,__arg2,__arg3)(__pos,overload1)
  def infix_get(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Double]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = sbytebuffer_get(__arg0,__arg1,__arg2,__arg3)(__pos,overload2)
  def infix_put(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Int]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = sbytebuffer_put(__arg0,__arg1,__arg2,__arg3)(__pos,overload1)
  def infix_put(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Double]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = sbytebuffer_put(__arg0,__arg1,__arg2,__arg3)(__pos,overload2)

  def sbytebuffer_bytebuffer(__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[java.nio.ByteBuffer]
  def sbytebuffer_bytebufferwrap(__arg0: Rep[ForgeArray[Byte]])(implicit __pos: SourceContext): Rep[java.nio.ByteBuffer]
  def sbytebuffer_rewind(__arg0: Rep[java.nio.ByteBuffer])(implicit __pos: SourceContext): Rep[Unit]
  def sbytebuffer_array(__arg0: Rep[java.nio.ByteBuffer])(implicit __pos: SourceContext): Rep[ForgeArray[Byte]]
  def sbytebuffer_getint(__arg0: Rep[java.nio.ByteBuffer])(implicit __pos: SourceContext): Rep[Int]
  def sbytebuffer_getdouble(__arg0: Rep[java.nio.ByteBuffer])(implicit __pos: SourceContext): Rep[Double]
  def sbytebuffer_putint(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[java.nio.ByteBuffer]
  def sbytebuffer_putdouble(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[Double])(implicit __pos: SourceContext): Rep[java.nio.ByteBuffer]
  def sbytebuffer_get(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Int]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1): Rep[java.nio.IntBuffer]
  def sbytebuffer_get(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Double]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2): Rep[java.nio.DoubleBuffer]
  def sbytebuffer_put(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Int]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1): Rep[java.nio.IntBuffer]
  def sbytebuffer_put(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Double]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2): Rep[java.nio.DoubleBuffer]
}
