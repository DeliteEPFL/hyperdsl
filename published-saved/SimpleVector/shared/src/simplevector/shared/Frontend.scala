package simplevector.shared

import java.io.{BufferedWriter, FileWriter, PrintWriter}
import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import simplevector.shared._
import simplevector.shared.ops._

// the trait that all SimpleVector applications must extend
trait SimpleVectorApplication extends SimpleVector with SimpleVectorLift {
  var args: Rep[Array[String]]
  var stagingArgs: Array[String]
  def main()
}

/**
 * dsl definition
 */
trait SimpleVectorLift
  extends LiftFString with LiftPrimitive with LiftNumeric with LiftVar {  this: SimpleVector =>
}


trait SimpleVectorIdentifiers extends Base with GenOverloadHack {
  /**
   * singleton identifiers
   */

  /**
   * types with no associated data structure
   */
}

trait SimpleVector extends SimpleVectorIdentifiers
 with FStringOps with Tup3Ops with VectorOps with PrimitiveOps with MiscOps with FractionalOps with SHashMapOps with CastOps with Tup4Ops with SByteBufferOps with NumericOps with MathOps with Tup6Ops with Tup9Ops with Tup8Ops with Tup5Ops with OrderingOps with Tup7Ops with Tup2Ops with ForgeArrayOps with ForgeArrayBufferOps with ForgeHashMapOps with VarOps with LambdaOps with RecordOps with InputOutputOps with ProfilingOps with ReppableOps with TestsOps with AssertsOps {
  this: SimpleVectorApplication => 

  /**
   * abstract types
   */
  type Tup2[A,B]
  implicit def m_Tup2[A:Manifest,B:Manifest]: Manifest[Tup2[A,B]]
  type Tup3[A,B,C]
  implicit def m_Tup3[A:Manifest,B:Manifest,C:Manifest]: Manifest[Tup3[A,B,C]]
  type Tup4[A,B,C,D]
  implicit def m_Tup4[A:Manifest,B:Manifest,C:Manifest,D:Manifest]: Manifest[Tup4[A,B,C,D]]
  type Tup5[A,B,C,D,E]
  implicit def m_Tup5[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest]: Manifest[Tup5[A,B,C,D,E]]
  type Tup6[A,B,C,D,E,F]
  implicit def m_Tup6[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest]: Manifest[Tup6[A,B,C,D,E,F]]
  type Tup7[A,B,C,D,E,F,G]
  implicit def m_Tup7[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest]: Manifest[Tup7[A,B,C,D,E,F,G]]
  type Tup8[A,B,C,D,E,F,G,H]
  implicit def m_Tup8[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest]: Manifest[Tup8[A,B,C,D,E,F,G,H]]
  type Tup9[A,B,C,D,E,F,G,H,I]
  implicit def m_Tup9[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest]: Manifest[Tup9[A,B,C,D,E,F,G,H,I]]
  type Vector[T]
  implicit def m_Vector[T:Manifest]: Manifest[Vector[T]]

  /**
   * hacks for Scala-Virtualized
   */
  override def __ifThenElse[T](cond: => Boolean, thenp: => T, elsep: => T) = cond match {
    case true => thenp
    case false => elsep
  }

}

