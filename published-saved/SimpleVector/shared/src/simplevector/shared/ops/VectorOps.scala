package simplevector.shared.ops

import scala.reflect.{Manifest,SourceContext}
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import simplevector.shared._
import simplevector.shared.ops._

/**
 * Operations
 */

trait VectorOps extends Base {
  this: SimpleVector => 

  object Vector {
    def apply[T:Manifest](__arg0: Rep[Int])(implicit __pos: SourceContext) = vector_object_apply[T](__arg0)(implicitly[Manifest[T]],__pos)
  }

  def foo[T:Manifest](__arg0: (Rep[Int]) => Rep[T],__arg1: Rep[Int],__arg2:  => Rep[Int],__arg3: (Rep[Int],Rep[Int]) => Rep[Int],__arg4: Rep[Double],__arg5: (Rep[Double]) => Rep[Double])(implicit __pos: SourceContext) = vector_foo[T](__arg0,__arg1,__arg2,__arg3,__arg4,__arg5)(implicitly[Manifest[T]],__pos)
  def foo2[T:Manifest](__arg0: (Rep[Int]) => Rep[Unit],__arg1: Rep[Int],__arg2:  => Rep[Int],__arg3: (Rep[Int],Rep[T]) => Rep[Int])(implicit __pos: SourceContext) = vector_foo2[T](__arg0,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],__pos)

  implicit def repToVectorVectorOpsCls[T:Manifest](x: Rep[Vector[T]])(implicit __pos: SourceContext) = new VectorVectorOpsCls(x)(implicitly[Manifest[T]],__pos)
  implicit def varToVectorVectorOpsCls[T:Manifest](x: Var[Vector[T]])(implicit __pos: SourceContext) = new VectorVectorOpsCls(readVar(x))(implicitly[Manifest[T]],__pos)

  class VectorVectorOpsCls[T:Manifest](val self: Rep[Vector[T]])(implicit __pos: SourceContext) {
    def apply(__arg1: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload1) = vector_apply[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def update(i: Rep[Int],e: Rep[T])(implicit __pos: SourceContext,__imp1: Overload1) = vector_update[T](self,i,e)(implicitly[Manifest[T]],__pos)
    def *(__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T],__imp2: Overload1) = vector_mul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
    def map[R:Manifest](__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext) = vector_map[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    def reduce(__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T]) = vector_reduce[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
    def filter(__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = vector_filter[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def mapreduce(__arg1: (Rep[T]) => Rep[T],__arg2: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T]) = vector_mapreduce[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos,__imp0)
    def flatMap[R:Manifest](__arg1: (Rep[T]) => Rep[Vector[R]])(implicit __pos: SourceContext) = vector_flatmap[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    def groupBy[K:Manifest,V:Manifest](__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit __pos: SourceContext) = vector_groupby[T,K,V](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
    def groupByReduce[K:Manifest,V:Manifest](__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V],__arg3: (Rep[V],Rep[V]) => Rep[V])(implicit __pos: SourceContext,__imp0: Numeric[V]) = vector_groupbyreduce[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0)
  }


  def infix_length[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext,__imp1: Overload2) = vector_length[T](self)(implicitly[Manifest[T]],__pos)
  def infix_slice[T:Manifest](self: Rep[Vector[T]],start: Rep[Int] = unit(0),end: Rep[Int])(implicit __pos: SourceContext,__imp1: Overload2) = vector_slice[T](self,start,end)(implicitly[Manifest[T]],__pos)
  def infix_insert[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext) = vector_insert[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  def infix_append[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext) = vector_append[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  def infix_+[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Vector[T]])(implicit __pos: SourceContext,__imp0: Numeric[T],__imp2: Overload17) = vector_pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_sum[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext,__imp0: Numeric[T]) = vector_sum[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  def infix_pprint[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext) = vector_pprint[T](self)(implicitly[Manifest[T]],__pos)

  def vector_object_apply[T:Manifest](__arg0: Rep[Int])(implicit __pos: SourceContext): Rep[Vector[T]]
  def vector_length[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext): Rep[Int]
  def vector_apply[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[T]
  def vector_update[T:Manifest](self: Rep[Vector[T]],i: Rep[Int],e: Rep[T])(implicit __pos: SourceContext): Rep[Unit]
  def vector_slice[T:Manifest](self: Rep[Vector[T]],start: Rep[Int] = unit(0),end: Rep[Int])(implicit __pos: SourceContext): Rep[Vector[T]]
  def vector_insert[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext): Rep[Unit]
  def vector_append[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext): Rep[Unit]
  def vector_pl[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Vector[T]])(implicit __pos: SourceContext,__imp0: Numeric[T]): Rep[Vector[T]]
  def vector_mul[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T]): Rep[Vector[T]]
  def vector_sum[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext,__imp0: Numeric[T]): Rep[T]
  def vector_map[T:Manifest,R:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext): Rep[Vector[R]]
  def vector_reduce[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T]): Rep[T]
  def vector_filter[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Vector[T]]
  def vector_mapreduce[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[T],__arg2: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T]): Rep[T]
  def vector_flatmap[T:Manifest,R:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[Vector[R]])(implicit __pos: SourceContext): Rep[Vector[R]]
  def vector_groupby[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit __pos: SourceContext): Rep[Vector[Vector[V]]]
  def vector_groupbyreduce[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V],__arg3: (Rep[V],Rep[V]) => Rep[V])(implicit __pos: SourceContext,__imp0: Numeric[V]): Rep[ForgeHashMap[K,V]]
  def vector_pprint[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext): Rep[Unit]
  def vector_foo[T:Manifest](__arg0: (Rep[Int]) => Rep[T],__arg1: Rep[Int],__arg2:  => Rep[Int],__arg3: (Rep[Int],Rep[Int]) => Rep[Int],__arg4: Rep[Double],__arg5: (Rep[Double]) => Rep[Double])(implicit __pos: SourceContext): Rep[T]
  def vector_foo2[T:Manifest](__arg0: (Rep[Int]) => Rep[Unit],__arg1: Rep[Int],__arg2:  => Rep[Int],__arg3: (Rep[Int],Rep[T]) => Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
}
trait VectorCompilerOps extends VectorOps {
  this: SimpleVector => 

  def vector_raw_data[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext): Rep[ForgeArray[T]]
  def vector_set_raw_data[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[ForgeArray[T]])(implicit __pos: SourceContext): Rep[Unit]
  def vector_set_length[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def vector_insertspace[T:Manifest](self: Rep[Vector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def vector_ensureextra[T:Manifest](self: Rep[Vector[T]],extra: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def vector_realloc[T:Manifest](self: Rep[Vector[T]],minLen: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
  def groupby_helper[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit __pos: SourceContext): Rep[ForgeHashMap[K,ForgeArrayBuffer[V]]]
  def vector_raw_alloc[T:Manifest,R:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Vector[R]]
  def vector_appendable[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext): Rep[Boolean]
  def vector_copy[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[Vector[T]],__arg3: Rep[Int],__arg4: Rep[Int])(implicit __pos: SourceContext): Rep[Unit]
}

