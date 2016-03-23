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

trait NumericOpsExp extends NumericOps with BaseFatExp with EffectExp {
  this: SimpleVectorExp => 

  case class Numeric_Zero[T:Numeric:Manifest]()(implicit val __pos: SourceContext) extends Def[T] {
    val _numT = implicitly[Numeric[T]]
    val _mT = implicitly[Manifest[T]]
  }

  case class Numeric146_Pl[T:Numeric:Manifest](__arg0: Rep[T],__arg1: Rep[T])(implicit val __pos: SourceContext) extends Def[T] {
    val _numT = implicitly[Numeric[T]]
    val _mT = implicitly[Manifest[T]]
  }

  case class Numeric129_Sub[T:Numeric:Manifest](__arg0: Rep[T],__arg1: Rep[T])(implicit val __pos: SourceContext) extends Def[T] {
    val _numT = implicitly[Numeric[T]]
    val _mT = implicitly[Manifest[T]]
  }

  case class Numeric130_Mul[T:Numeric:Manifest](__arg0: Rep[T],__arg1: Rep[T])(implicit val __pos: SourceContext) extends Def[T] {
    val _numT = implicitly[Numeric[T]]
    val _mT = implicitly[Manifest[T]]
  }



  def numeric_zero[T:Numeric:Manifest]()(implicit __pos: SourceContext) = {
    reflectPure(Numeric_Zero[T]()(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos))
  }
  def numeric_pl[T:Numeric:Manifest](__arg0: Rep[T],__arg1: Rep[T])(implicit __pos: SourceContext) = {
    reflectPure(Numeric146_Pl[T](__arg0,__arg1)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos))
  }
  def numeric_sub[T:Numeric:Manifest](__arg0: Rep[T],__arg1: Rep[T])(implicit __pos: SourceContext) = {
    reflectPure(Numeric129_Sub[T](__arg0,__arg1)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos))
  }
  def numeric_mul[T:Numeric:Manifest](__arg0: Rep[T],__arg1: Rep[T])(implicit __pos: SourceContext) = {
    reflectPure(Numeric130_Mul[T](__arg0,__arg1)(implicitly[Numeric[T]],implicitly[Manifest[T]],__pos))
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Numeric_Zero() => numeric_zero()(ntype(mn._numT),mtype(mn._mT),mn.__pos)
    case Reflect(mn@Numeric_Zero(), u, es) => reflectMirrored(Reflect(Numeric_Zero()(ntype(mn._numT),mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Numeric146_Pl(__arg0,__arg1) => numeric_pl(f(__arg0),f(__arg1))(ntype(mn._numT),mtype(mn._mT),mn.__pos)
    case Reflect(mn@Numeric146_Pl(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Numeric146_Pl(f(__arg0),f(__arg1))(ntype(mn._numT),mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Numeric129_Sub(__arg0,__arg1) => numeric_sub(f(__arg0),f(__arg1))(ntype(mn._numT),mtype(mn._mT),mn.__pos)
    case Reflect(mn@Numeric129_Sub(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Numeric129_Sub(f(__arg0),f(__arg1))(ntype(mn._numT),mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Numeric130_Mul(__arg0,__arg1) => numeric_mul(f(__arg0),f(__arg1))(ntype(mn._numT),mtype(mn._mT),mn.__pos)
    case Reflect(mn@Numeric130_Mul(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Numeric130_Mul(f(__arg0),f(__arg1))(ntype(mn._numT),mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


}

/**
 * Code generators
 */

trait ScalaGenNumericOps extends ScalaGenFat {
  val IR: NumericOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Numeric_Zero() => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("implicitly[Numeric["+remap(mn._mT)+"]].zero")
      stream.println("}")

    case mn@Numeric146_Pl(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println("}")

    case mn@Numeric129_Sub(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println("}")

    case mn@Numeric130_Mul(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CudaGenNumericOps extends CudaGenFat {
  val IR: NumericOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Numeric_Zero() => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("0")
      stream.println(";")

    case mn@Numeric146_Pl(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println(";")

    case mn@Numeric129_Sub(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println(";")

    case mn@Numeric130_Mul(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println(";")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CGenNumericOps extends CGenFat {
  val IR: NumericOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Numeric_Zero() => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print("0")
      stream.println(";")

    case mn@Numeric146_Pl(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" + "+quote(__arg1)+"")
      stream.println(";")

    case mn@Numeric129_Sub(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" - "+quote(__arg1)+"")
      stream.println(";")

    case mn@Numeric130_Mul(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" * "+quote(__arg1)+"")
      stream.println(";")

    case _ => super.emitNode(sym, rhs)
  }
}
