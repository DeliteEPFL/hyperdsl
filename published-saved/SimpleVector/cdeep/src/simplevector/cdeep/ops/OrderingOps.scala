package simplevector.cdeep.ops

import scala.reflect.{Manifest,SourceContext}
import simplevector.cdeep._

/**
 * Operations
 */
trait OrderingsAPI extends Base
  with GenOverloadHack
{
  this: PrimitivesAPI => 

  // implicit val intNumeric: Numeric[Int] = implicitly[Numeric[scala.Int]].asInstanceOf[Numeric[Int]]
  implicit val intOrdering: Ordering[Int] = implicitly[Ordering[scala.Int]].asInstanceOf[Ordering[Int]]

  // def __equal[A:Manifest:Typ,B:Manifest:Typ](__arg0: A,__arg1: B)(implicit __pos: SourceContext,__imp1: Overload1) = ???//forge_equals[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos)
  // def __equal[A:Manifest,B:Manifest:Typ](__arg0: Var[A],__arg1: B)(implicit __pos: SourceContext,__imp1: ROverload2): Boolean = ???//{ forge_equals(readVar(__arg0), __arg1) }
  // def __equal[A:Manifest:Typ,B:Manifest](__arg0: A,__arg1: Var[B])(implicit __pos: SourceContext,__imp1: ROverload3): Boolean = ???//{ forge_equals(__arg0, readVar(__arg1)) }
  // def __equal[A:Manifest,B:Manifest](__arg0: Var[A],__arg1: Var[B])(implicit __pos: SourceContext,__imp1: ROverload4): Boolean = ???//{ forge_equals(readVar(__arg0), readVar(__arg1)) }
  def __equal[A:Manifest:Typ,B:Manifest](__arg0: A,__arg1: B)(implicit __pos: SourceContext,__imp1: ROverload5): Boolean = ???//{ forge_equals(__arg0, unit(__arg1)) }
  // def __equal[A:Manifest,B:Manifest](__arg0: Var[A],__arg1: B)(implicit __pos: SourceContext,__imp1: ROverload6): Boolean = ???//{ forge_equals(readVar(__arg0), unit(__arg1)) }
  // def __equal[A:Manifest,B:Manifest:Typ](__arg0: A,__arg1: B)(implicit __pos: SourceContext,__imp1: ROverload7): Boolean = ???//{ forge_equals(unit(__arg0), __arg1) }
  // def __equal[A:Manifest,B:Manifest](__arg0: A,__arg1: Var[B])(implicit __pos: SourceContext,__imp1: ROverload8): Boolean = ???//{ forge_equals(unit(__arg0), readVar(__arg1)) }

  implicit def repToOrderingAOpsCls[A:Manifest:Typ](x: A)(implicit __pos: SourceContext): OrderingAOpsCls[A] = new OrderingAOpsCls(x)(implicitly[Manifest[A]],implicitly[Typ[A]],__pos)
  implicit def varToOrderingAOpsCls[A:Manifest:Typ](x: Var[A])(implicit __pos: SourceContext): OrderingAOpsCls[A] = ???//new OrderingAOpsCls(readVar(x))(implicitly[Manifest[A]],__pos)

  class OrderingAOpsCls[A:Manifest:Typ](val self: A)(implicit __pos: SourceContext) {
    def <(__arg1: A)(implicit __cb0: Ordering[A],__pos: SourceContext): Boolean = ???//ordering_lt[A](self,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos)
    def <=(__arg1: A)(implicit __cb0: Ordering[A],__pos: SourceContext): Boolean = ???//ordering_lteq[A](self,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos)
    def >(__arg1: A)(implicit __cb0: Ordering[A],__pos: SourceContext): Boolean = ???//ordering_gt[A](self,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos)
    def >=(__arg1: A)(implicit __cb0: Ordering[A],__pos: SourceContext): Boolean = ???//ordering_gteq[A](self,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos)
    def !=[B:Manifest:Typ](__arg0: A,__arg1: B)(implicit __pos: SourceContext,__imp1: Overload1): Boolean = ???//forge_notequals[A,B](__arg0,__arg1)(implicitly[Manifest[A]],implicitly[Manifest[B]],__pos)
    def !=[B:Manifest:Typ](__arg0: Var[A],__arg1: B)(implicit __pos: SourceContext,__imp1: ROverload2): Boolean = ???//{ forge_notequals(readVar(__arg0), __arg1) }
    def !=[B:Manifest](__arg0: A,__arg1: Var[B])(implicit __pos: SourceContext,__imp1: ROverload3): Boolean = ???//{ forge_notequals(__arg0, readVar(__arg1)) }
    def !=[B:Manifest](__arg0: Var[A],__arg1: Var[B])(implicit __pos: SourceContext,__imp1: ROverload4): Boolean = ???//{ forge_notequals(readVar(__arg0), readVar(__arg1)) }
    def !=[B:Manifest](__arg0: A,__arg1: B)(implicit __pos: SourceContext,__imp1: ROverload5): Boolean = ???//{ forge_notequals(__arg0, unit(__arg1)) }
    def !=[B:Manifest](__arg0: Var[A],__arg1: B)(implicit __pos: SourceContext,__imp1: ROverload6): Boolean = ???//{ forge_notequals(readVar(__arg0), unit(__arg1)) }
    def !=[B:Manifest:Typ](__arg0: A,__arg1: B)(implicit __pos: SourceContext,__imp1: ROverload7): Boolean = ???//{ forge_notequals(unit(__arg0), __arg1) }
    def !=[B:Manifest](__arg0: A,__arg1: Var[B])(implicit __pos: SourceContext,__imp1: ROverload8): Boolean = ???//{ forge_notequals(unit(__arg0), readVar(__arg1)) }
  }

  def min[A:Ordering:Manifest:Typ](__arg0: A,__arg1: A)(implicit __pos: SourceContext) = ???//ordering_min[A](__arg0,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos)
  def max[A:Ordering:Manifest:Typ](__arg0: A,__arg1: A)(implicit __pos: SourceContext) = ???//ordering_max[A](__arg0,__arg1)(implicitly[Ordering[A]],implicitly[Manifest[A]],__pos)

  // def forge_equals[A:Manifest,B:Manifest](__arg0: A],__arg1: B])(implicit __pos: SourceContext): Boolean]
  // def forge_notequals[A:Manifest,B:Manifest](__arg0: A],__arg1: B])(implicit __pos: SourceContext): Boolean]
  // def ordering_min[A:Ordering:Manifest](__arg0: A],__arg1: A])(implicit __pos: SourceContext): A]
  // def ordering_max[A:Ordering:Manifest](__arg0: A],__arg1: A])(implicit __pos: SourceContext): A]
  // def ordering_lt[A:Ordering:Manifest](__arg0: A],__arg1: A])(implicit __pos: SourceContext): Boolean]
  // def ordering_lteq[A:Ordering:Manifest](__arg0: A],__arg1: A])(implicit __pos: SourceContext): Boolean]
  // def ordering_gt[A:Ordering:Manifest](__arg0: A],__arg1: A])(implicit __pos: SourceContext): Boolean]
  // def ordering_gteq[A:Ordering:Manifest](__arg0: A],__arg1: A])(implicit __pos: SourceContext): Boolean]
}

// trait OrderingsImpl extends OrderingsAPI