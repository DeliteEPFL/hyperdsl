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

trait OrderingOpsExp extends OrderingOps with BaseFatExp with EffectExp {
  this: SimpleVectorExp => 

  case class Forge_equals[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit val __pos: SourceContext) extends Def[Boolean] {
    val _mA = implicitly[Manifest[A]]
    val _mB = implicitly[Manifest[B]]
  }

  case class Forge_notequals[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit val __pos: SourceContext) extends Def[Boolean] {
    val _mA = implicitly[Manifest[A]]
    val _mB = implicitly[Manifest[B]]
  }

  case class Ordering_Min[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit val __pos: SourceContext) extends Def[A] {
    val _ordA = implicitly[Ordering[A]]
    val _mA = implicitly[Manifest[A]]
  }

  case class Ordering_Max[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit val __pos: SourceContext) extends Def[A] {
    val _ordA = implicitly[Ordering[A]]
    val _mA = implicitly[Manifest[A]]
  }

  case class Ordering_Lt[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit val __pos: SourceContext) extends Def[Boolean] {
    val _ordA = implicitly[Ordering[A]]
    val _mA = implicitly[Manifest[A]]
  }

  case class Ordering_Lteq[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit val __pos: SourceContext) extends Def[Boolean] {
    val _ordA = implicitly[Ordering[A]]
    val _mA = implicitly[Manifest[A]]
  }

  case class Ordering_Gt[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit val __pos: SourceContext) extends Def[Boolean] {
    val _ordA = implicitly[Ordering[A]]
    val _mA = implicitly[Manifest[A]]
  }

  case class Ordering_Gteq[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit val __pos: SourceContext) extends Def[Boolean] {
    val _ordA = implicitly[Ordering[A]]
    val _mA = implicitly[Manifest[A]]
  }



  def forge_equals[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext) = {
    reflectPure(Forge_equals[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos))
  }
  def forge_notequals[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext) = {
    reflectPure(Forge_notequals[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos))
  }
  def ordering_min[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    reflectPure(Ordering_Min[A](__arg0,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos))
  }
  def ordering_max[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    reflectPure(Ordering_Max[A](__arg0,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos))
  }
  def ordering_lt[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    reflectPure(Ordering_Lt[A](__arg0,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos))
  }
  def ordering_lteq[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    reflectPure(Ordering_Lteq[A](__arg0,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos))
  }
  def ordering_gt[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    reflectPure(Ordering_Gt[A](__arg0,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos))
  }
  def ordering_gteq[A:Ordering:Manifest](__arg0: Rep[A],__arg1: Rep[A])(implicit __pos: SourceContext) = {
    reflectPure(Ordering_Gteq[A](__arg0,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos))
  }



  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@Forge_equals(__arg0,__arg1) => forge_equals(f(__arg0),f(__arg1))(mtype(mn._mA),mtype(mn._mB),mn.__pos)
    case Reflect(mn@Forge_equals(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Forge_equals(f(__arg0),f(__arg1))(mtype(mn._mA),mtype(mn._mB),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Forge_notequals(__arg0,__arg1) => forge_notequals(f(__arg0),f(__arg1))(mtype(mn._mA),mtype(mn._mB),mn.__pos)
    case Reflect(mn@Forge_notequals(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Forge_notequals(f(__arg0),f(__arg1))(mtype(mn._mA),mtype(mn._mB),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Ordering_Min(__arg0,__arg1) => ordering_min(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos)
    case Reflect(mn@Ordering_Min(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Ordering_Min(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Ordering_Max(__arg0,__arg1) => ordering_max(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos)
    case Reflect(mn@Ordering_Max(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Ordering_Max(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Ordering_Lt(__arg0,__arg1) => ordering_lt(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos)
    case Reflect(mn@Ordering_Lt(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Ordering_Lt(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Ordering_Lteq(__arg0,__arg1) => ordering_lteq(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos)
    case Reflect(mn@Ordering_Lteq(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Ordering_Lteq(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Ordering_Gt(__arg0,__arg1) => ordering_gt(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos)
    case Reflect(mn@Ordering_Gt(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Ordering_Gt(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Ordering_Gteq(__arg0,__arg1) => ordering_gteq(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos)
    case Reflect(mn@Ordering_Gteq(__arg0,__arg1), u, es) => reflectMirrored(Reflect(Ordering_Gteq(f(__arg0),f(__arg1))(otype(mn._ordA),mtype(mn._mA),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]


}

/**
 * Code generators
 */

trait ScalaGenOrderingOps extends ScalaGenFat {
  val IR: OrderingOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Forge_equals(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" == "+quote(__arg1)+"")
      stream.println("}")

    case mn@Forge_notequals(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" != "+quote(__arg1)+"")
      stream.println("}")

    case mn@Ordering_Min(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" min "+quote(__arg1)+"")
      stream.println("}")

    case mn@Ordering_Max(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" max "+quote(__arg1)+"")
      stream.println("}")

    case mn@Ordering_Lt(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" < "+quote(__arg1)+"")
      stream.println("}")

    case mn@Ordering_Lteq(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" <= "+quote(__arg1)+"")
      stream.println("}")

    case mn@Ordering_Gt(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" > "+quote(__arg1)+"")
      stream.println("}")

    case mn@Ordering_Gteq(__arg0,__arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print(""+quote(__arg0)+" >= "+quote(__arg1)+"")
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CudaGenOrderingOps extends CudaGenFat {
  val IR: OrderingOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Forge_equals(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" == "+quote(__arg1)+"")
      stream.println(";")

    case mn@Forge_notequals(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" != "+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering_Min(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" < "+quote(__arg1)+"?"+quote(__arg0)+":"+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering_Max(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" > "+quote(__arg1)+"?"+quote(__arg0)+":"+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering_Lt(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" < "+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering_Lteq(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" <= "+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering_Gt(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" > "+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering_Gteq(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" >= "+quote(__arg1)+"")
      stream.println(";")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CGenOrderingOps extends CGenFat {
  val IR: OrderingOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Forge_equals(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" == "+quote(__arg1)+"")
      stream.println(";")

    case mn@Forge_notequals(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" != "+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering_Min(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" < "+quote(__arg1)+"?"+quote(__arg0)+":"+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering_Max(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" > "+quote(__arg1)+"?"+quote(__arg0)+":"+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering_Lt(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" < "+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering_Lteq(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" <= "+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering_Gt(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" > "+quote(__arg1)+"")
      stream.println(";")

    case mn@Ordering_Gteq(__arg0,__arg1) => 
      stream.print(remapWithRef(sym.tp) + " " + quote(sym) + " = ")
      stream.print(""+quote(__arg0)+" >= "+quote(__arg1)+"")
      stream.println(";")

    case _ => super.emitNode(sym, rhs)
  }
}
