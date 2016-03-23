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

trait SByteBufferOpsExp extends SByteBufferOps with BaseFatExp with EffectExp {
  this: SimpleVectorExp => 

  case class SByteBuffer_ByteBuffer(__arg0: Rep[Int])(implicit val __pos: SourceContext) extends Def[java.nio.ByteBuffer] {
  }

  case class SByteBuffer_ByteBufferWrap(__arg0: Rep[ForgeArray[Byte]])(implicit val __pos: SourceContext) extends Def[java.nio.ByteBuffer] {
  }

  case class SByteBuffer_Rewind(__arg0: Rep[java.nio.ByteBuffer])(implicit val __pos: SourceContext) extends Def[Unit] {
  }

  case class SByteBuffer_Array(__arg0: Rep[java.nio.ByteBuffer])(implicit val __pos: SourceContext) extends Def[ForgeArray[Byte]] {
  }

  case class SByteBuffer_GetInt(__arg0: Rep[java.nio.ByteBuffer])(implicit val __pos: SourceContext) extends Def[Int] {
  }

  case class SByteBuffer_GetDouble(__arg0: Rep[java.nio.ByteBuffer])(implicit val __pos: SourceContext) extends Def[Double] {
  }

  case class SByteBuffer_PutInt(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[Int])(implicit val __pos: SourceContext) extends Def[java.nio.ByteBuffer] {
  }

  case class SByteBuffer_PutDouble(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[Double])(implicit val __pos: SourceContext) extends Def[java.nio.ByteBuffer] {
  }

  case class SByteBuffer1_Get(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Int]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit val __pos: SourceContext) extends Def[java.nio.IntBuffer] {
  }

  case class SByteBuffer2_Get(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Double]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit val __pos: SourceContext) extends Def[java.nio.DoubleBuffer] {
  }

  case class SByteBuffer1_Put(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Int]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit val __pos: SourceContext) extends Def[java.nio.IntBuffer] {
  }

  case class SByteBuffer2_Put(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Double]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit val __pos: SourceContext) extends Def[java.nio.DoubleBuffer] {
  }



  def sbytebuffer_bytebuffer(__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    reflectMutable[java.nio.ByteBuffer](SByteBuffer_ByteBuffer(__arg0)(__pos))
  }
  def sbytebuffer_bytebufferwrap(__arg0: Rep[ForgeArray[Byte]])(implicit __pos: SourceContext) = {
    reflectMutable[java.nio.ByteBuffer](SByteBuffer_ByteBufferWrap(__arg0)(__pos))
  }
  def sbytebuffer_rewind(__arg0: Rep[java.nio.ByteBuffer])(implicit __pos: SourceContext) = {
    reflectWrite[Unit](__arg0)(SByteBuffer_Rewind(__arg0)(__pos))
  }
  def sbytebuffer_array(__arg0: Rep[java.nio.ByteBuffer])(implicit __pos: SourceContext) = {
    reflectPure(SByteBuffer_Array(__arg0)(__pos))
  }
  def sbytebuffer_getint(__arg0: Rep[java.nio.ByteBuffer])(implicit __pos: SourceContext) = {
    reflectPure(SByteBuffer_GetInt(__arg0)(__pos))
  }
  def sbytebuffer_getdouble(__arg0: Rep[java.nio.ByteBuffer])(implicit __pos: SourceContext) = {
    reflectPure(SByteBuffer_GetDouble(__arg0)(__pos))
  }
  def sbytebuffer_putint(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    reflectWrite[java.nio.ByteBuffer](__arg0)(SByteBuffer_PutInt(__arg0,__arg1)(__pos))
  }
  def sbytebuffer_putdouble(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[Double])(implicit __pos: SourceContext) = {
    reflectWrite[java.nio.ByteBuffer](__arg0)(SByteBuffer_PutDouble(__arg0,__arg1)(__pos))
  }
  def sbytebuffer_get(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Int]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = {
    reflectWrite[java.nio.IntBuffer](__arg1)(SByteBuffer1_Get(__arg0,__arg1,__arg2,__arg3)(__pos))
  }
  def sbytebuffer_get(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Double]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = {
    reflectWrite[java.nio.DoubleBuffer](__arg1)(SByteBuffer2_Get(__arg0,__arg1,__arg2,__arg3)(__pos))
  }
  def sbytebuffer_put(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Int]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = {
    reflectWrite[java.nio.IntBuffer](__arg0)(SByteBuffer1_Put(__arg0,__arg1,__arg2,__arg3)(__pos))
  }
  def sbytebuffer_put(__arg0: Rep[java.nio.ByteBuffer],__arg1: Rep[ForgeArray[Double]],__arg2: Rep[Int],__arg3: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = {
    reflectWrite[java.nio.DoubleBuffer](__arg0)(SByteBuffer2_Put(__arg0,__arg1,__arg2,__arg3)(__pos))
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@SByteBuffer_ByteBuffer(__arg0) => sbytebuffer_bytebuffer(f(__arg0))(mn.__pos)
    case Reflect(mn@SByteBuffer_ByteBuffer(__arg0), u, es) => reflectMirrored(Reflect(SByteBuffer_ByteBuffer(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SByteBuffer_ByteBufferWrap(__arg0) => sbytebuffer_bytebufferwrap(f(__arg0))(mn.__pos)
    case Reflect(mn@SByteBuffer_ByteBufferWrap(__arg0), u, es) => reflectMirrored(Reflect(SByteBuffer_ByteBufferWrap(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SByteBuffer_Rewind(__arg0) => sbytebuffer_rewind(f(__arg0))(mn.__pos)
    case Reflect(mn@SByteBuffer_Rewind(__arg0), u, es) => reflectMirrored(Reflect(SByteBuffer_Rewind(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SByteBuffer_Array(__arg0) => sbytebuffer_array(f(__arg0))(mn.__pos)
    case Reflect(mn@SByteBuffer_Array(__arg0), u, es) => reflectMirrored(Reflect(SByteBuffer_Array(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SByteBuffer_GetInt(__arg0) => sbytebuffer_getint(f(__arg0))(mn.__pos)
    case Reflect(mn@SByteBuffer_GetInt(__arg0), u, es) => reflectMirrored(Reflect(SByteBuffer_GetInt(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SByteBuffer_GetDouble(__arg0) => sbytebuffer_getdouble(f(__arg0))(mn.__pos)
    case Reflect(mn@SByteBuffer_GetDouble(__arg0), u, es) => reflectMirrored(Reflect(SByteBuffer_GetDouble(f(__arg0))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SByteBuffer_PutInt(__arg0,__arg1) => sbytebuffer_putint(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@SByteBuffer_PutInt(__arg0,__arg1), u, es) => reflectMirrored(Reflect(SByteBuffer_PutInt(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SByteBuffer_PutDouble(__arg0,__arg1) => sbytebuffer_putdouble(f(__arg0),f(__arg1))(mn.__pos)
    case Reflect(mn@SByteBuffer_PutDouble(__arg0,__arg1), u, es) => reflectMirrored(Reflect(SByteBuffer_PutDouble(f(__arg0),f(__arg1))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SByteBuffer1_Get(__arg0,__arg1,__arg2,__arg3) => sbytebuffer_get(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mn.__pos,overload1)
    case Reflect(mn@SByteBuffer1_Get(__arg0,__arg1,__arg2,__arg3), u, es) => reflectMirrored(Reflect(SByteBuffer1_Get(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SByteBuffer2_Get(__arg0,__arg1,__arg2,__arg3) => sbytebuffer_get(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mn.__pos,overload2)
    case Reflect(mn@SByteBuffer2_Get(__arg0,__arg1,__arg2,__arg3), u, es) => reflectMirrored(Reflect(SByteBuffer2_Get(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SByteBuffer1_Put(__arg0,__arg1,__arg2,__arg3) => sbytebuffer_put(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mn.__pos,overload1)
    case Reflect(mn@SByteBuffer1_Put(__arg0,__arg1,__arg2,__arg3), u, es) => reflectMirrored(Reflect(SByteBuffer1_Put(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@SByteBuffer2_Put(__arg0,__arg1,__arg2,__arg3) => sbytebuffer_put(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mn.__pos,overload2)
    case Reflect(mn@SByteBuffer2_Put(__arg0,__arg1,__arg2,__arg3), u, es) => reflectMirrored(Reflect(SByteBuffer2_Put(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


}

/**
 * Code generators
 */

trait ScalaGenSByteBufferOps extends ScalaGenFat {
  val IR: SByteBufferOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@SByteBuffer_ByteBuffer(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.nio.ByteBuffer.allocate("+quote(__arg0)+")")
      stream.println("}")

    case mn@SByteBuffer_ByteBufferWrap(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("java.nio.ByteBuffer.wrap("+quote(__arg0)+")")
      stream.println("}")

    case mn@SByteBuffer_Rewind(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".rewind(); ()")
      stream.println("}")

    case mn@SByteBuffer_Array(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".array")
      stream.println("}")

    case mn@SByteBuffer_GetInt(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".getInt()")
      stream.println("}")

    case mn@SByteBuffer_GetDouble(__arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".getDouble()")
      stream.println("}")

    case mn@SByteBuffer_PutInt(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".putInt("+quote(__arg1)+")")
      stream.println("}")

    case mn@SByteBuffer_PutDouble(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".putDouble("+quote(__arg1)+")")
      stream.println("}")

    case mn@SByteBuffer1_Get(__arg0,__arg1,__arg2,__arg3) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".asIntBuffer.get("+quote(__arg1)+", "+quote(__arg2)+", "+quote(__arg3)+")")
      stream.println("}")

    case mn@SByteBuffer2_Get(__arg0,__arg1,__arg2,__arg3) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".asDoubleBuffer.get("+quote(__arg1)+", "+quote(__arg2)+", "+quote(__arg3)+")")
      stream.println("}")

    case mn@SByteBuffer1_Put(__arg0,__arg1,__arg2,__arg3) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".asIntBuffer.put("+quote(__arg1)+", "+quote(__arg2)+", "+quote(__arg3)+")")
      stream.println("}")

    case mn@SByteBuffer2_Put(__arg0,__arg1,__arg2,__arg3) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+".asDoubleBuffer.put("+quote(__arg1)+", "+quote(__arg2)+", "+quote(__arg3)+")")
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
