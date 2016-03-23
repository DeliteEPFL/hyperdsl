package simplevector.cdeep.ops

import scala.reflect.{Manifest,SourceContext}
import simplevector.cdeep._

/**
 * Lift
 */

// trait LiftNumeric extends Base {

//   // implicit def NumericTToRep[T:Numeric:Manifest](x: T) = ???//unit(x)
// }

/**
 * Operations
 */

trait NumericsAPI extends Base
  with GenOverloadHack
{

  implicit def repToNumericTOpsCls[T:Manifest:Typ](x: T)(implicit __pos: SourceContext): NumericTOpsCls[T] = new NumericTOpsCls(x)(implicitly[Manifest[T]],implicitly[Typ[T]],__pos)
  implicit def varToNumericTOpsCls[T:Manifest:Typ](x: Var[T])(implicit __pos: SourceContext): NumericTOpsCls[T] = ??? //new NumericTOpsCls(readVar(x))(implicitly[Manifest[T]],__pos)

  class NumericTOpsCls[T:Manifest:Typ](val self: T)(implicit __pos: SourceContext) {
    def -(__arg1: T)(implicit __cb0: Numeric[T],__pos: SourceContext,__imp1: Overload129) = numeric_sub[T](self,__arg1)(implicitly[Numeric[T]],implicitly[Manifest[T]],implicitly[Typ[T]],__pos)
    def *(__arg1: T)(implicit __cb0: Numeric[T],__pos: SourceContext,__imp1: Overload130) = numeric_mul[T](self,__arg1)(implicitly[Numeric[T]],implicitly[Manifest[T]],implicitly[Typ[T]],__pos)
    def zero(implicit __cb0: Numeric[T],__pos: SourceContext,__imp1: Overload131) = numeric_zero[T]()(implicitly[Numeric[T]],implicitly[Manifest[T]],implicitly[Typ[T]],__pos)
    def +(__arg1: T)(implicit __cb0: Numeric[T],__pos: SourceContext,__imp1: Overload132) = numeric_pl[T](self,__arg1)(implicitly[Numeric[T]],implicitly[Manifest[T]],implicitly[Typ[T]],__pos)
  }

  def numeric_zero[T:Numeric:Manifest:Typ]()(implicit __pos: SourceContext): T
  def numeric_pl[T:Numeric:Manifest:Typ](__arg0: T,__arg1: T)(implicit __pos: SourceContext): T
  def numeric_sub[T:Numeric:Manifest:Typ](__arg0: T,__arg1: T)(implicit __pos: SourceContext): T
  def numeric_mul[T:Numeric:Manifest:Typ](__arg0: T,__arg1: T)(implicit __pos: SourceContext): T
}

trait NumericsImpl extends NumericsAPI {

  def numeric_zero[T:Numeric:Manifest:Typ]()(implicit __pos: SourceContext): T = ???
  def numeric_pl[T:Numeric:Manifest:Typ](__arg0: T,__arg1: T)(implicit __pos: SourceContext): T = ???
  def numeric_sub[T:Numeric:Manifest:Typ](__arg0: T,__arg1: T)(implicit __pos: SourceContext): T = ???
  def numeric_mul[T:Numeric:Manifest:Typ](__arg0: T,__arg1: T)(implicit __pos: SourceContext): T = ???
}
