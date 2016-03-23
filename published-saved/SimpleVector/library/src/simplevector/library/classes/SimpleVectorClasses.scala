package simplevector.library.classes

import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import simplevector.shared._
import simplevector.shared.ops._
import simplevector.library._
import simplevector.library.classes._

trait SimpleVectorClasses extends FStringWrapper with FStringWrapperImpl with Tup3Wrapper with Tup3WrapperImpl with VectorWrapper with VectorWrapperImpl with PrimitiveWrapper with PrimitiveWrapperImpl with MiscWrapper with FractionalWrapper with SHashMapWrapper with SHashMapWrapperImpl with CastWrapper with Tup4Wrapper with Tup4WrapperImpl with SByteBufferWrapper with NumericWrapper with MathWrapper with Tup6Wrapper with Tup6WrapperImpl with Tup9Wrapper with Tup9WrapperImpl with Tup8Wrapper with Tup8WrapperImpl with Tup5Wrapper with Tup5WrapperImpl with OrderingWrapper with Tup7Wrapper with Tup7WrapperImpl with Tup2Wrapper with Tup2WrapperImpl with ForgeArrayWrapper with ForgeArrayBufferWrapper with ForgeHashMapWrapper with VarWrapper with LambdaWrapper with RecordWrapper with InputOutputWrapper with ProfilingWrapper with ReppableWrapper with TestsWrapper with AssertsWrapper{
  this: SimpleVectorLib with SimpleVectorApplication => 
}

