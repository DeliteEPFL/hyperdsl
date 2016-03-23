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

trait FractionalOpsExp extends FractionalOps with BaseFatExp with EffectExp {
  this: SimpleVectorExp => 

  case class Fractional129_Div[T:Manifest,R:Fractional:Manifest](__arg0: Rep[T],__arg1: Rep[R])(implicit val __pos: SourceContext,val __imp0: (Rep[T]) => Rep[R]) extends Def[R] {
    val _mT = implicitly[Manifest[T]]
    val _fracR = implicitly[Fractional[R]]
    val _mR = implicitly[Manifest[R]]
  }



  def fractional_div[T:Manifest,R:Fractional:Manifest](__arg0: Rep[T],__arg1: Rep[R])(implicit __pos: SourceContext,__imp0: (Rep[T]) => Rep[R]) = {
    reflectPure(Fractional129_Div[T,R](__arg0,__arg1)(implicitly[Manifest[T]],implicitly[Fractional[R]],implicitly[Manifest[R]],__pos,__imp0))
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Fractional129_Div(__arg0,__arg1) => reflectPure(Fractional129_Div(f(__arg0),f(__arg1))(mtype(mn._mT),frtype(mn._fracR),mtype(mn._mR),mn.__pos,mn.__imp0))(mtype(manifest[A]), pos)
    case Reflect(mn@Fractional129_Div(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Fractional129_Div(f(__arg0),f(__arg1))(mtype(mn._mT),frtype(mn._fracR),mtype(mn._mR),mn.__pos,mn.__imp0), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


}

/**
 * Code generators
 */

trait ScalaGenFractionalOps extends ScalaGenFat {
  val IR: FractionalOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Fractional129_Div(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("implicitly[Fractional["+remap(mn._mR)+"]].div("+quote(__arg0)+","+quote(__arg1)+")")
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CudaGenFractionalOps extends CudaGenFat {
  val IR: FractionalOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Fractional129_Div(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println(";")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CGenFractionalOps extends CGenFat {
  val IR: FractionalOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Fractional129_Div(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" / "+quote(__arg1)+"")
      stream.println(";")

    case _ => super.emitNode(sym, rhs)
  }
}
