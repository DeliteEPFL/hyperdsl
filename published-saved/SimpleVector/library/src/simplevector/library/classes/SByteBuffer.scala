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

trait SByteBufferWrapper {
  this: SimpleVectorBase with SimpleVectorClasses => 

  def sbytebuffer_bytebuffer(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    java.nio.ByteBuffer.allocate(__arg0)
  }
  def sbytebuffer_bytebufferwrap(__arg0: Rep[ForgeArray[Byte]])(implicit __pos: SourceContext) = {
    java.nio.ByteBuffer.wrap(__arg0)
  }
  def sbytebuffer_rewind(__arg0: Rep[java.nio.ByteBuffer])(implicit __pos: SourceContext) = {
    __arg0.rewind(); ()
  }
  def sbytebuffer_array(__arg0: Rep[java.nio.ByteBuffer])(implicit __pos: SourceContext) = {
    __arg0.array
  }
  def sbytebuffer_getint(__arg0: Rep[java.nio.ByteBuffer])(implicit __pos: SourceContext) = {
    __arg0.getInt()
  }
  def sbytebuffer_getdouble(__arg0: Rep[java.nio.ByteBuffer])(implicit __pos: SourceContext) = {
    __arg0.getDouble()
  }
  def sbytebuffer_putint(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    __arg0.putInt(__arg1)
  }
  def sbytebuffer_putdouble(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    __arg0.putDouble(__arg1)
  }
  def sbytebuffer_get(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Int]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = {
    __arg0.asIntBuffer.get(__arg1, __arg2, __arg3)
  }
  def sbytebuffer_get(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Double]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = {
    __arg0.asDoubleBuffer.get(__arg1, __arg2, __arg3)
  }
  def sbytebuffer_put(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Int]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = {
    __arg0.asIntBuffer.put(__arg1, __arg2, __arg3)
  }
  def sbytebuffer_put(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Double]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = {
    __arg0.asDoubleBuffer.put(__arg1, __arg2, __arg3)
  }

}

