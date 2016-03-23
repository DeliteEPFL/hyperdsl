package simplevector.compiler

import java.io.{BufferedWriter, FileWriter, PrintWriter}
import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import simplevector.shared._
import simplevector.shared.ops._
import simplevector.compiler._
import simplevector.compiler.ops._
import scala.tools.nsc.io._
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import ppl.delite.framework.{Config, DeliteApplication, ExpressionsOpt}
import ppl.delite.framework.codegen.Target
import ppl.delite.framework.codegen.scala.TargetScala
import ppl.delite.framework.codegen.cuda.TargetCuda
import ppl.delite.framework.codegen.cpp.TargetCpp
import ppl.delite.framework.codegen.opencl.TargetOpenCL
import ppl.delite.framework.ops._
import ppl.delite.framework.datastructures._
import ppl.delite.framework.codegen.delite.overrides._
import ppl.delite.framework.transform._
import ppl.delite.framework.ops.DeliteCollection
import ppl.delite.framework.datastructures._
import ppl.delite.framework.ops.{DeliteOpsExp, DeliteCollectionOpsExp}
import ppl.delite.framework.Util._
import ppl.delite.framework.codegen.restage.{DeliteCodeGenRestage,TargetRestage}
import ppl.delite.framework.{DeliteInteractive, DeliteInteractiveRunner, DeliteRestageOps, DeliteRestageOpsExp, DeliteRestageRunner}
import ppl.tests.scalatest._

trait SimpleVectorApplicationCompilerTrait extends SimpleVectorApplication with DeliteApplication with SimpleVectorExp
abstract class SimpleVectorApplicationCompiler extends SimpleVectorApplication with DeliteApplication with SimpleVectorExp

/**
 * dsl compiler definition
 */
trait SimpleVectorCompiler extends SimpleVector
 with FStringOpsImpl with Tup3OpsImpl with Tup3CompilerOps with VectorOpsImpl with VectorCompilerOps with PrimitiveOpsImpl with SHashMapOpsImpl with SHashMapCompilerOps with Tup4OpsImpl with Tup4CompilerOps with Tup6OpsImpl with Tup6CompilerOps with Tup9OpsImpl with Tup9CompilerOps with Tup8OpsImpl with Tup8CompilerOps with Tup5OpsImpl with Tup5CompilerOps with Tup7OpsImpl with Tup7CompilerOps with Tup2OpsImpl with Tup2CompilerOps with ForgeArrayCompilerOps with ForgeArrayBufferCompilerOps with ForgeHashMapCompilerOps with VarCompilerOps with LambdaCompilerOps with RecordCompilerOps with InputOutputCompilerOps with ProfilingCompilerOps with ReppableCompilerOps with TestsCompilerOps with AssertsCompilerOps {
  this: SimpleVectorApplication with SimpleVectorExp => 

}

trait SimpleVectorInteractive extends SimpleVectorApplication with DeliteInteractive
trait SimpleVectorInteractiveRunner[R] extends SimpleVectorApplicationCompilerTrait with DeliteInteractiveRunner[R]

// executes scope immediately
object SimpleVector {
  def apply[R](b: => R) = new Scope[SimpleVectorInteractive, SimpleVectorInteractiveRunner[R], R](b)
}

trait SimpleVectorLower extends SimpleVectorApplication with DeliteRestageOps
trait SimpleVectorLowerRunner[R] extends SimpleVectorApplicationCompilerTrait with DeliteRestageRunner[R]

// stages scope and generates re-stageable code
object SimpleVector_ {
  def apply[R](b: => R) = new Scope[SimpleVectorLower, SimpleVectorLowerRunner[R], R](b)
}

trait SimpleVectorExp extends SimpleVectorCompiler with ExpressionsOpt with DeliteOpsExp with DeliteRestageOpsExp with DeliteTestOpsExp
 with FStringOpsExp with Tup3OpsExp with VectorOpsExp with PrimitiveOpsExp with MiscOpsExp with FractionalOpsExp with SHashMapOpsExp with CastOpsExp with Tup4OpsExp with SByteBufferOpsExp with NumericOpsExp with MathOpsExp with Tup6OpsExp with Tup9OpsExp with Tup8OpsExp with Tup5OpsExp with OrderingOpsExp with Tup7OpsExp with Tup2OpsExp with ForgeArrayOpsExp with ForgeArrayBufferOpsExp with ForgeHashMapOpsExp with VarOpsExp with LambdaOpsExp with RecordOpsExp with InputOutputOpsExp with ProfilingOpsExp with ReppableOpsExp with TestsOpsExp with AssertsOpsExp with DeliteAllOverridesExp with MultiloopSoATransformExp {
 this: DeliteApplication with SimpleVectorApplication => 

  /**
   * disambiguations for Delite internal operations
   */
  override def primitive_forge_int_plus(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = delite_int_plus(__arg0, __arg1)
  override def primitive_forge_int_minus(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = delite_int_minus(__arg0, __arg1)
  override def primitive_forge_int_times(__arg0: Rep[Int],__arg1: Rep[Int])(implicit __pos: SourceContext) = delite_int_times(__arg0, __arg1)
  override def primitive_unary_bang(__arg0: Rep[Boolean])(implicit __pos: SourceContext): Rep[Boolean] = delite_boolean_negate(__arg0)
  override def misc_unsafeimmutable[A:Manifest](lhs: Rep[A])(implicit pos: SourceContext): Rep[A] = delite_unsafe_immutable(lhs)
  override def __whileDo(cond: => Exp[Boolean], body: => Rep[Unit])(implicit pos: SourceContext) = delite_while(cond, body)
  override def __ifThenElse[T:Manifest](cond: Rep[Boolean], thenp: => Rep[T], elsep: => Rep[T])(implicit ctx: SourceContext) = delite_ifThenElse(cond, thenp, elsep, false, true)
  override def __ifThenElse[T:Manifest](cond: => Rep[Boolean], thenp: => Rep[T], elsep: => Rep[T])(implicit ctx: SourceContext) = delite_ifThenElse(cond, thenp, elsep, false, true)
  override def forge_equals[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext) = delite_equals(__arg0,__arg1)
  override def forge_notequals[A:Manifest,B:Manifest](__arg0: Rep[A],__arg1: Rep[B])(implicit __pos: SourceContext) = delite_notequals(__arg0,__arg1)

  /**
   * dsl types
   */
  abstract class Tup2[A,B]
  def m_Tup2[A:Manifest,B:Manifest] = manifest[Tup2[A,B]]
  abstract class Tup3[A,B,C]
  def m_Tup3[A:Manifest,B:Manifest,C:Manifest] = manifest[Tup3[A,B,C]]
  abstract class Tup4[A,B,C,D]
  def m_Tup4[A:Manifest,B:Manifest,C:Manifest,D:Manifest] = manifest[Tup4[A,B,C,D]]
  abstract class Tup5[A,B,C,D,E]
  def m_Tup5[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest] = manifest[Tup5[A,B,C,D,E]]
  abstract class Tup6[A,B,C,D,E,F]
  def m_Tup6[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest] = manifest[Tup6[A,B,C,D,E,F]]
  abstract class Tup7[A,B,C,D,E,F,G]
  def m_Tup7[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest] = manifest[Tup7[A,B,C,D,E,F,G]]
  abstract class Tup8[A,B,C,D,E,F,G,H]
  def m_Tup8[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest] = manifest[Tup8[A,B,C,D,E,F,G,H]]
  abstract class Tup9[A,B,C,D,E,F,G,H,I]
  def m_Tup9[A:Manifest,B:Manifest,C:Manifest,D:Manifest,E:Manifest,F:Manifest,G:Manifest,H:Manifest,I:Manifest] = manifest[Tup9[A,B,C,D,E,F,G,H,I]]
  abstract class Vector[T] extends DeliteCollection[T]
  def m_Vector[T:Manifest] = manifest[Vector[T]]

  def getCodeGenPkg(t: Target{val IR: SimpleVectorExp.this.type}): GenericFatCodegen{val IR: SimpleVectorExp.this.type} = {
    t match {
      case _:TargetScala => new SimpleVectorCodegenScala{val IR: SimpleVectorExp.this.type = SimpleVectorExp.this}
      case _:TargetCuda => new SimpleVectorCodegenCuda{val IR: SimpleVectorExp.this.type = SimpleVectorExp.this}
      case _:TargetOpenCL => new SimpleVectorCodegenOpenCL{val IR: SimpleVectorExp.this.type = SimpleVectorExp.this}
      case _:TargetCpp => new SimpleVectorCodegenC{val IR: SimpleVectorExp.this.type = SimpleVectorExp.this}
      case _:TargetRestage => new SimpleVectorCodegenRestage{val IR: SimpleVectorExp.this.type = SimpleVectorExp.this}
      case _ => throw new RuntimeException("SimpleVector does not support this target")
    }
  }
}

/**
 * code generators
 */
trait SimpleVectorCodegenBase extends GenericFatCodegen {
  val IR: DeliteApplication with SimpleVectorExp
  override def initialDefs = IR.deliteGenerator.availableDefs

  def dsmap(line: String) = line
  override def emitDataStructures(path: String) {
    val s = File.separator
    val dsRoot = sys.env.get("SIMPLEVECTOR_HOME").getOrElse(System.getProperty("user.dir"))+s+"compiler"+s+"src"+s+"simplevector"+s+"compiler"+s+"datastruct"+s+this.toString

    val dsDir = Directory(Path(dsRoot))
    val outDir = Directory(Path(path))
    outDir.createDirectory()

    for(f <- dsDir.files) {
      val outFile = path + s + f.name
      val out = new BufferedWriter(new FileWriter(outFile))
      for (line <- scala.io.Source.fromFile(f.jfile).getLines) {
        out.write(dsmap(line) + "\n")
      }
      out.close()
    }
  }

  override def remap[A](m: Manifest[A]): String = {
    var res = super.remap(m)
    if (res.contains("$")) {
      res = res.slice(res.indexOf("#")+1,res.length)
      res = res.slice(0, res.lastIndexOf(".")+1) + res.slice(res.lastIndexOf("$")+1, res.length)
    }
    res
  }

}

trait SimpleVectorCodegenScala extends SimpleVectorCodegenBase
 with ScalaGenFStringOps with ScalaGenVectorOps with ScalaGenPrimitiveOps with ScalaGenMiscOps with ScalaGenFractionalOps with ScalaGenSHashMapOps with ScalaGenCastOps with ScalaGenSByteBufferOps with ScalaGenNumericOps with ScalaGenMathOps with ScalaGenOrderingOps with ScalaGenForgeArrayOps with ScalaGenForgeArrayBufferOps with ScalaGenForgeHashMapOps with ScalaGenVarOps with ScalaGenLambdaOps with ScalaGenRecordOps with ScalaGenInputOutputOps with ScalaGenProfilingOps with ScalaGenReppableOps with ScalaGenTestsOps with ScalaGenAssertsOps with ScalaGenDeliteTest 
 with ScalaGenDeliteOps with DeliteScalaGenAllOverrides {
  val IR: DeliteApplication with SimpleVectorExp

 // these methods translate types in the compiler to typed in the generated code
  override def dsmap(line: String): String = {
    var res = line.replaceAll("simplevector.compiler.datastruct.scala", this.packageName)
    res
  }

  override def remap[A](m: Manifest[A]): String = {
    var res = super.remap(m)
    res = res.replaceAllLiterally("package$", "")
    dsmap(res)
  }

}
trait SimpleVectorCodegenCuda extends SimpleVectorCodegenBase
 with CudaGenPrimitiveOps with CudaGenMiscOps with CudaGenFractionalOps with CudaGenCastOps with CudaGenNumericOps with CudaGenMathOps with CudaGenOrderingOps with CudaGenForgeArrayOps with CudaGenForgeArrayBufferOps with CudaGenForgeHashMapOps with CudaGenVarOps with CudaGenLambdaOps with CudaGenRecordOps with CudaGenInputOutputOps with CudaGenProfilingOps with CudaGenReppableOps with CudaGenTestsOps with DeliteCppHostTransfer with DeliteCudaDeviceTransfer 
 with CudaGenDeliteOps with DeliteCudaGenAllOverrides {
  val IR: DeliteApplication with SimpleVectorExp
}
trait SimpleVectorCodegenOpenCL extends SimpleVectorCodegenBase
 with OpenCLGenForgeArrayOps with OpenCLGenForgeArrayBufferOps with OpenCLGenForgeHashMapOps with OpenCLGenVarOps with OpenCLGenLambdaOps with OpenCLGenRecordOps with OpenCLGenInputOutputOps with OpenCLGenProfilingOps with OpenCLGenReppableOps with OpenCLGenTestsOps with OpenCLGenDeliteOps with DeliteOpenCLGenAllOverrides {
  val IR: DeliteApplication with SimpleVectorExp
}
trait SimpleVectorCodegenC extends SimpleVectorCodegenBase
 with CGenFStringOps with CGenVectorOps with CGenPrimitiveOps with CGenMiscOps with CGenFractionalOps with CGenSHashMapOps with CGenCastOps with CGenNumericOps with CGenMathOps with CGenOrderingOps with CGenForgeArrayOps with CGenForgeArrayBufferOps with CGenForgeHashMapOps with CGenVarOps with CGenLambdaOps with CGenRecordOps with CGenInputOutputOps with CGenProfilingOps with CGenReppableOps with CGenTestsOps with DeliteCppHostTransfer 
 with CGenDeliteOps with DeliteCGenAllOverrides {
  val IR: DeliteApplication with SimpleVectorExp
}
trait SimpleVectorCodegenRestage extends SimpleVectorCodegenBase
 with SimpleVectorCodegenScala with DeliteCodeGenRestage { 
  val IR: DeliteApplication with SimpleVectorExp
}
