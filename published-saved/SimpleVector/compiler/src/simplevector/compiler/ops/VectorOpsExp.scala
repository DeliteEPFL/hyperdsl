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

trait VectorOpsExp extends VectorCompilerOps with DeliteCollectionOpsExp with DeliteStructsExp {
  this: SimpleVectorExp => 

  case class VectorObject_Apply[T:Manifest](__arg0: Rep[Int])(implicit val __pos: SourceContext) extends DeliteStruct[Vector[T]] {
    val _mT = implicitly[Manifest[T]]
    val elems = copyTransformedElems(collection.Seq(("_length",var_new(__arg0).e),("_data",var_new(array_empty[T](__arg0)).e)))
  }

  case class Vector2_Slice[T:Manifest](self: Rep[Vector[T]],start: Rep[Int] = unit(0),end: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Vector[T]](reifyEffectsHere(vector_slice_impl2[T](self,start,end)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Vector_Insert[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(vector_insert_impl[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Vector_Append[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(vector_append_impl[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Vector_insertspace[T:Manifest](self: Rep[Vector[T]],pos: Rep[Int],len: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(vector_insertspace_impl[T](self,pos,len)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Vector_ensureextra[T:Manifest](self: Rep[Vector[T]],extra: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(vector_ensureextra_impl[T](self,extra)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Vector_realloc[T:Manifest](self: Rep[Vector[T]],minLen: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(vector_realloc_impl[T](self,minLen)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Vector17_Pl[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Vector[T]])(implicit val __pos: SourceContext,val __imp0: Numeric[T]) extends DeliteOpZipWith[T,T,T,Vector[T]] {
    val _mT = implicitly[Manifest[T]]

    val inA = self
    val inB = __arg1
    def func = vector_pl_impl17_zip[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
    override def alloc(len: Exp[Int]) = vector_raw_alloc[T,T](inA, len)
    val size = copyTransformedOrElse(_.size)(vector_length(inA))
    override val numDynamicChunks = 0
  }

  case class Vector1_Mul[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[T])(implicit val __pos: SourceContext,val __imp0: Numeric[T]) extends DeliteOpMap[T,T,Vector[T]] {
    val _mT = implicitly[Manifest[T]]

    val in = self
    def func = vector_mul_impl1_map[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
    override def alloc(len: Exp[Int]) = vector_raw_alloc[T,T](in, len)
    val size = copyTransformedOrElse(_.size)(vector_length(in))
    override val numDynamicChunks = 0
  }

  case class Vector_Sum[T:Manifest](self: Rep[Vector[T]])(implicit val __pos: SourceContext,val __imp0: Numeric[T]) extends DeliteOpReduce[T] {
    val _mT = implicitly[Manifest[T]]

    val in = self
    def func = vector_sum_impl_reduce[T](self)(implicitly[Manifest[T]],__pos,__imp0)
    def zero = vector_sum_impl_zero[T](self)(implicitly[Manifest[T]],__pos,__imp0)
    val size = copyTransformedOrElse(_.size)(vector_length(in))
    override val numDynamicChunks = 0
  }

  case class Vector_Map[T:Manifest,R:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[R])(implicit val __pos: SourceContext) extends DeliteOpMap[T,R,Vector[R]] {
    val _mT = implicitly[Manifest[T]]
    val _mR = implicitly[Manifest[R]]

    val in = self
    def func = vector_map_impl_map[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    override def alloc(len: Exp[Int]) = vector_raw_alloc[T,R](in, len)
    val size = copyTransformedOrElse(_.size)(vector_length(in))
    override val numDynamicChunks = 0
  }

  case class Vector_Reduce[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit val __pos: SourceContext,val __imp0: Numeric[T]) extends DeliteOpReduce[T] {
    val _mT = implicitly[Manifest[T]]

    val in = self
    def func = vector_reduce_impl_reduce[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
    def zero = vector_reduce_impl_zero[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
    val size = copyTransformedOrElse(_.size)(vector_length(in))
    override val numDynamicChunks = 0
  }

  case class Vector_Filter[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit val __pos: SourceContext) extends DeliteOpFilter[T,T,Vector[T]] {
    val _mT = implicitly[Manifest[T]]

    val in = self
    def cond = vector_filter_impl_cond[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    def func = vector_filter_impl_map[T](self,__arg1)(implicitly[Manifest[T]],__pos)
    override def alloc(len: Exp[Int]) = vector_raw_alloc[T,T](in, len)
    val size = copyTransformedOrElse(_.size)(vector_length(in))
    override val numDynamicChunks = 0
  }

  case class Vector_Mapreduce[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[T],__arg2: (Rep[T],Rep[T]) => Rep[T])(implicit val __pos: SourceContext,val __imp0: Numeric[T]) extends DeliteOpMapReduce[T,T] {
    val _mT = implicitly[Manifest[T]]

    val in = self
    def zero = vector_mapreduce_impl_zero[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos,__imp0)
    def reduce = vector_mapreduce_impl_reduce[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos,__imp0)
    def map = vector_mapreduce_impl_map[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos,__imp0)
    val size = copyTransformedOrElse(_.size)(vector_length(in))
    override val numDynamicChunks = 0
  }

  case class Vector_FlatMap[T:Manifest,R:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[Vector[R]])(implicit val __pos: SourceContext) extends DeliteOpFlatMap[T,R,Vector[R]] {
    val _mT = implicitly[Manifest[T]]
    val _mR = implicitly[Manifest[R]]

    val in = self
    def func = vector_flatmap_impl_func[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
    override def alloc(len: Exp[Int]) = vector_raw_alloc[T,R](in, len)
    val size = copyTransformedOrElse(_.size)(vector_length(in))
    override val numDynamicChunks = 0
  }

  case class Vector_Pprint[T:Manifest](self: Rep[Vector[T]])(implicit val __pos: SourceContext) extends DeliteOpForeach[T] {
    val _mT = implicitly[Manifest[T]]

    val in = self
    def func = vector_pprint_impl_func[T](self)(implicitly[Manifest[T]],__pos)
    def sync = n => unit(List())
    val size = copyTransformedOrElse(_.size)(vector_length(in))
    override val numDynamicChunks = 0
  }

  case class Vector_appendable[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Boolean](reifyEffectsHere(vector_appendable_impl[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Vector_copy[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[Vector[T]],__arg3: Rep[Int],__arg4: Rep[Int])(implicit val __pos: SourceContext) extends DeliteOpSingleTask[Unit](reifyEffectsHere(vector_copy_impl[T](self,__arg1,__arg2,__arg3,__arg4)(implicitly[Manifest[T]],__pos))) {
    val _mT = implicitly[Manifest[T]]
  }

  case class Vector_Foo[T:Manifest](__arg0: Block[T],f___arg0___arg0: Rep[Int],__arg1: Rep[Int],__arg2: Block[Int],__arg3: Block[Int],f___arg3___arg0: Rep[Int],f___arg3___arg1: Rep[Int],__arg4: Rep[Double],__arg5: Block[Double],f___arg5___arg0: Rep[Double])(implicit val __pos: SourceContext) extends Def[T] {
    val _mT = implicitly[Manifest[T]]
  }

  case class Vector_Foo2[T:Manifest](__arg0: Block[Unit],f___arg0___arg0: Rep[Int],__arg1: Rep[Int],__arg2: Block[Int],__arg3: Block[Int],f___arg3___arg0: Rep[Int],f___arg3___arg1: Rep[T])(implicit val __pos: SourceContext) extends Def[Unit] {
    val _mT = implicitly[Manifest[T]]
  }

  case class Groupby_helperKeys[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit val __pos: SourceContext) extends DeliteOpFilteredGroupByReduce[T,K,K,ForgeArray[K]] {
    val _mT = implicitly[Manifest[T]]
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]

    val in = self
    def cond: Exp[T] => Exp[Boolean] = null
    val size = copyTransformedOrElse(_.size)(vector_length(in))
    def keyFunc = groupby_helper_impl_key[T,K,V](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
    def valFunc = keyFunc
    def reduceFunc = (a,b) => a
    def zero = unit(null).asInstanceOf[Rep[K]]
    override def alloc(len: Exp[Int]) = array_raw_alloc[K](null.asInstanceOf[Rep[ForgeArray[K]]], len)
  }

  case class Groupby_helperIndex[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit val __pos: SourceContext) extends DeliteOpBuildIndex[T,K,DeliteIndex[K]] {
    val _mT = implicitly[Manifest[T]]
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]

    val in = self
    def cond: Exp[T] => Exp[Boolean] = null
    val size = copyTransformedOrElse(_.size)(vector_length(in))
    def keyFunc = groupby_helper_impl_key[T,K,V](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  }

  case class Groupby_helper[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit val __pos: SourceContext) extends DeliteOpFilteredGroupBy[T,K,V,ForgeArrayBuffer[V],ForgeArray[ForgeArrayBuffer[V]]] {
    val _mT = implicitly[Manifest[T]]
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]

    val in = self
    def cond: Exp[T] => Exp[Boolean] = null
    val size = copyTransformedOrElse(_.size)(vector_length(in))
    def keyFunc = groupby_helper_impl_key[T,K,V](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
    def valFunc = groupby_helper_impl_map[T,K,V](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
    override def allocI(len: Exp[Int]) = array_buffer_raw_alloc[V](null.asInstanceOf[Rep[ForgeArrayBuffer[V]]], len)
    override def alloc(len: Exp[Int]) = array_raw_alloc[ForgeArrayBuffer[V]](null.asInstanceOf[Rep[ForgeArray[ForgeArrayBuffer[V]]]], len)
  }

  case class Vector_GroupByReduceKeys[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V],__arg3: (Rep[V],Rep[V]) => Rep[V])(implicit val __pos: SourceContext,val __imp0: Numeric[V]) extends DeliteOpFilteredGroupByReduce[T,K,K,ForgeArray[K]] {
    val _mT = implicitly[Manifest[T]]
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]

    val in = self
    def cond: Exp[T] => Exp[Boolean] = null
    val size = copyTransformedOrElse(_.size)(vector_length(in))
    def keyFunc = vector_groupbyreduce_impl_key[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0)
    def valFunc = keyFunc
    def reduceFunc = (a,b) => a
    def zero = unit(null).asInstanceOf[Rep[K]]
    override def alloc(len: Exp[Int]) = array_raw_alloc[K](null.asInstanceOf[Rep[ForgeArray[K]]], len)
  }

  case class Vector_GroupByReduceIndex[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V],__arg3: (Rep[V],Rep[V]) => Rep[V])(implicit val __pos: SourceContext,val __imp0: Numeric[V]) extends DeliteOpBuildIndex[T,K,DeliteIndex[K]] {
    val _mT = implicitly[Manifest[T]]
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]

    val in = self
    def cond: Exp[T] => Exp[Boolean] = null
    val size = copyTransformedOrElse(_.size)(vector_length(in))
    def keyFunc = vector_groupbyreduce_impl_key[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0)
  }

  case class Vector_GroupByReduce[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V],__arg3: (Rep[V],Rep[V]) => Rep[V])(implicit val __pos: SourceContext,val __imp0: Numeric[V]) extends DeliteOpFilteredGroupByReduce[T,K,V,ForgeArray[V]] {
    val _mT = implicitly[Manifest[T]]
    val _mK = implicitly[Manifest[K]]
    val _mV = implicitly[Manifest[V]]

    val in = self
    def cond: Exp[T] => Exp[Boolean] = null
    val size = copyTransformedOrElse(_.size)(vector_length(in))
    def keyFunc = vector_groupbyreduce_impl_key[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0)
    def valFunc = vector_groupbyreduce_impl_map[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0)
    def zero = vector_groupbyreduce_impl_zero[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0)
    def reduceFunc = vector_groupbyreduce_impl_reduce[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0)
    override def alloc(len: Exp[Int]) = array_raw_alloc[V](null.asInstanceOf[Rep[ForgeArray[V]]], len)
  }



  def vector_object_apply[T:Manifest](__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    reflectMutable[Vector[T]](VectorObject_Apply[T](__arg0)(implicitly[Manifest[T]],__pos))
  }
  def vector_raw_data[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext) = {
    field[ForgeArray[T]](self,"_data")
  }
  def vector_set_raw_data[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[ForgeArray[T]])(implicit __pos: SourceContext) = {
    field_update[ForgeArray[T]](self,"_data",__arg1)
  }
  def vector_length[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext) = {
    field[Int](self,"_length")
  }
  def vector_set_length[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    field_update[Int](self,"_length",__arg1)
  }
  def vector_apply[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    vector_apply_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def vector_update[T:Manifest](self: Rep[Vector[T]],i: Rep[Int],e: Rep[T])(implicit __pos: SourceContext) = {
    vector_update_impl1[T](self,i,e)(implicitly[Manifest[T]],__pos)
  }
  def vector_slice[T:Manifest](self: Rep[Vector[T]],start: Rep[Int] = unit(0),end: Rep[Int])(implicit __pos: SourceContext) = {
    reflectPure(Vector2_Slice[T](self,start,end)(implicitly[Manifest[T]],__pos))
  }
  def vector_insert[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext) = {
    reflectWrite[Unit](self)(Vector_Insert[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos))
  }
  def vector_append[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext) = {
    reflectWrite[Unit](self)(Vector_Append[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos))
  }
  def vector_insertspace[T:Manifest](self: Rep[Vector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext) = {
    reflectWrite[Unit](self)(Vector_insertspace[T](self,pos,len)(implicitly[Manifest[T]],__pos))
  }
  def vector_ensureextra[T:Manifest](self: Rep[Vector[T]],extra: Rep[Int])(implicit __pos: SourceContext) = {
    reflectWrite[Unit](self)(Vector_ensureextra[T](self,extra)(implicitly[Manifest[T]],__pos))
  }
  def vector_realloc[T:Manifest](self: Rep[Vector[T]],minLen: Rep[Int])(implicit __pos: SourceContext) = {
    reflectWrite[Unit](self)(Vector_realloc[T](self,minLen)(implicitly[Manifest[T]],__pos))
  }
  def vector_pl[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Vector[T]])(implicit __pos: SourceContext,__imp0: Numeric[T]) = {
    reflectPure(Vector17_Pl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0))
  }
  def vector_mul[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T]) = {
    reflectPure(Vector1_Mul[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0))
  }
  def vector_sum[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext,__imp0: Numeric[T]) = {
    reflectPure(Vector_Sum[T](self)(implicitly[Manifest[T]],__pos,__imp0))
  }
  def vector_map[T:Manifest,R:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext) = {
    reflectPure(Vector_Map[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos))
  }
  def vector_reduce[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T]) = {
    reflectPure(Vector_Reduce[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0))
  }
  def vector_filter[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    reflectPure(Vector_Filter[T](self,__arg1)(implicitly[Manifest[T]],__pos))
  }
  def vector_mapreduce[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[T],__arg2: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T]) = {
    reflectPure(Vector_Mapreduce[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos,__imp0))
  }
  def vector_flatmap[T:Manifest,R:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[Vector[R]])(implicit __pos: SourceContext) = {
    reflectPure(Vector_FlatMap[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos))
  }
  def groupby_helper[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit __pos: SourceContext) = {
    val keys = reflectPure(Groupby_helperKeys[T,K,V](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos))
    val index = reflectPure(Groupby_helperIndex[T,K,V](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos))
    val values = reflectPure(Groupby_helper[T,K,V](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos))
    reflectPure(DeliteMapNewImm(keys, values, index, darray_length(values)))
  }
  def vector_groupby[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit __pos: SourceContext) = {
    vector_groupby_impl[T,K,V](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  }
  def vector_groupbyreduce[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V],__arg3: (Rep[V],Rep[V]) => Rep[V])(implicit __pos: SourceContext,__imp0: Numeric[V]) = {
    val keys = reflectPure(Vector_GroupByReduceKeys[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0))
    val index = reflectPure(Vector_GroupByReduceIndex[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0))
    val values = reflectPure(Vector_GroupByReduce[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0))
    reflectPure(DeliteMapNewImm(keys, values, index, darray_length(values)))
  }
  def vector_pprint[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext) = {
    reflectEffect[Unit](Vector_Pprint[T](self)(implicitly[Manifest[T]],__pos))
  }
  def vector_raw_alloc[T:Manifest,R:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    vector_raw_alloc_impl[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def vector_appendable[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext) = {
    reflectPure(Vector_appendable[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos))
  }
  def vector_copy[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[Vector[T]],__arg3: Rep[Int],__arg4: Rep[Int])(implicit __pos: SourceContext) = {
    reflectWrite[Unit](__arg2)(Vector_copy[T](self,__arg1,__arg2,__arg3,__arg4)(implicitly[Manifest[T]],__pos))
  }
  def vector_foo[T:Manifest](__arg0: (Rep[Int]) => Rep[T],__arg1: Rep[Int],__arg2:  => Rep[Int],__arg3: (Rep[Int],Rep[Int]) => Rep[Int],__arg4: Rep[Double],__arg5: (Rep[Double]) => Rep[Double])(implicit __pos: SourceContext) = {

    val f___arg0___arg0 = fresh[Int]
    val b___arg0 = reifyEffects(__arg0(f___arg0___arg0))
    val sb___arg0 = summarizeEffects(b___arg0)

    val b___arg2 = reifyEffects(__arg2)
    val sb___arg2 = summarizeEffects(b___arg2)

    val f___arg3___arg0 = fresh[Int]
    val f___arg3___arg1 = fresh[Int]
    val b___arg3 = reifyEffects(__arg3(f___arg3___arg0,f___arg3___arg1))
    val sb___arg3 = summarizeEffects(b___arg3)

    val f___arg5___arg0 = fresh[Double]
    val b___arg5 = reifyEffects(__arg5(f___arg5___arg0))
    val sb___arg5 = summarizeEffects(b___arg5)
    reflectEffect[T](Vector_Foo[T](b___arg0,f___arg0___arg0,__arg1,b___arg2,b___arg3,f___arg3___arg0,f___arg3___arg1,__arg4,b___arg5,f___arg5___arg0)(implicitly[Manifest[T]],__pos), sb___arg0 andThen ((sb___arg2 andThen ((sb___arg3 andThen ((sb___arg5 andThen sb___arg3).star) andThen sb___arg2).star) andThen sb___arg0).star))
  }
  def vector_foo2[T:Manifest](__arg0: (Rep[Int]) => Rep[Unit],__arg1: Rep[Int],__arg2:  => Rep[Int],__arg3: (Rep[Int],Rep[T]) => Rep[Int])(implicit __pos: SourceContext) = {

    val f___arg0___arg0 = fresh[Int]
    val b___arg0 = reifyEffects(__arg0(f___arg0___arg0))
    val sb___arg0 = summarizeEffects(b___arg0)

    val b___arg2 = reifyEffects(__arg2)
    val sb___arg2 = summarizeEffects(b___arg2)

    val f___arg3___arg0 = fresh[Int]
    val f___arg3___arg1 = fresh[T]
    val b___arg3 = reifyEffects(__arg3(f___arg3___arg0,f___arg3___arg1))
    val sb___arg3 = summarizeEffects(b___arg3)
    reflectEffect[Unit](Vector_Foo2[T](b___arg0,f___arg0___arg0,__arg1,b___arg2,b___arg3,f___arg3___arg0,f___arg3___arg1)(implicitly[Manifest[T]],__pos), sb___arg0 andThen ((sb___arg2 andThen ((sb___arg3 andThen sb___arg2).star) andThen sb___arg0).star))
  }

  /**
   * Syms
   */
  override def syms(e: Any): List[Sym[Any]] = e match {
    case Vector_Foo(__arg0,f___arg0___arg0,__arg1,__arg2,__arg3,f___arg3___arg0,f___arg3___arg1,__arg4,__arg5,f___arg5___arg0) => syms(__arg0):::syms(__arg1):::syms(__arg2):::syms(__arg3):::syms(__arg4):::syms(__arg5)
    case Vector_Foo2(__arg0,f___arg0___arg0,__arg1,__arg2,__arg3,f___arg3___arg0,f___arg3___arg1) => syms(__arg0):::syms(__arg1):::syms(__arg2):::syms(__arg3)
    case _ => super.syms(e)
  }
  override def boundSyms(e: Any): List[Sym[Any]] = e match {
    case Vector_Foo(__arg0,f___arg0___arg0,__arg1,__arg2,__arg3,f___arg3___arg0,f___arg3___arg1,__arg4,__arg5,f___arg5___arg0) => effectSyms(__arg0):::effectSyms(__arg1):::effectSyms(__arg2):::effectSyms(__arg3):::effectSyms(__arg4):::effectSyms(__arg5) ::: List(f___arg0___arg0.asInstanceOf[Sym[Any]],f___arg3___arg0.asInstanceOf[Sym[Any]],f___arg3___arg1.asInstanceOf[Sym[Any]],f___arg5___arg0.asInstanceOf[Sym[Any]])
    case Vector_Foo2(__arg0,f___arg0___arg0,__arg1,__arg2,__arg3,f___arg3___arg0,f___arg3___arg1) => effectSyms(__arg0):::effectSyms(__arg1):::effectSyms(__arg2):::effectSyms(__arg3) ::: List(f___arg0___arg0.asInstanceOf[Sym[Any]],f___arg3___arg0.asInstanceOf[Sym[Any]],f___arg3___arg1.asInstanceOf[Sym[Any]])
    case _ => super.boundSyms(e)
  }
  override def symsFreq(e: Any): List[(Sym[Any], Double)] = e match {
    case Vector_Foo(__arg0,f___arg0___arg0,__arg1,__arg2,__arg3,f___arg3___arg0,f___arg3___arg1,__arg4,__arg5,f___arg5___arg0) => freqNormal(__arg0):::freqNormal(__arg1):::freqNormal(__arg2):::freqNormal(__arg3):::freqNormal(__arg4):::freqNormal(__arg5)
    case Vector_Foo2(__arg0,f___arg0___arg0,__arg1,__arg2,__arg3,f___arg3___arg0,f___arg3___arg1) => freqNormal(__arg0):::freqNormal(__arg1):::freqNormal(__arg2):::freqNormal(__arg3)
    case _ => super.symsFreq(e)
  }


  /**
   * Mirroring
   */
  override def mirror[A:Manifest](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
    case mn@VectorObject_Apply(__arg0) => reflectPure(new { override val original = Some(f,mn) } with VectorObject_Apply(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@VectorObject_Apply(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with VectorObject_Apply(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector2_Slice(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Vector2_Slice(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector2_Slice(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Vector2_Slice(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector_Insert(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Vector_Insert(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector_Insert(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Vector_Insert(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector_Append(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Vector_Append(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector_Append(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Vector_Append(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector_insertspace(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Vector_insertspace(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector_insertspace(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Vector_insertspace(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector_ensureextra(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Vector_ensureextra(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector_ensureextra(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Vector_ensureextra(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector_realloc(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Vector_realloc(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector_realloc(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Vector_realloc(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector17_Pl(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Vector17_Pl(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos,ntype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector17_Pl(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Vector17_Pl(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos,ntype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector1_Mul(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Vector1_Mul(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos,ntype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector1_Mul(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Vector1_Mul(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos,ntype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector_Sum(__arg0) => reflectPure(new { override val original = Some(f,mn) } with Vector_Sum(f(__arg0.asInstanceOf[Rep[Vector[A]]]))(mtype(mn._mT),mn.__pos,ntype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector_Sum(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Vector_Sum(f(__arg0.asInstanceOf[Rep[Vector[A]]]))(mtype(mn._mT),mn.__pos,ntype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector_Map(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Vector_Map(f(__arg0),f(__arg1))(mtype(mn._mT),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector_Map(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Vector_Map(f(__arg0),f(__arg1))(mtype(mn._mT),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector_Reduce(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Vector_Reduce(f(__arg0.asInstanceOf[Rep[Vector[A]]]),f(__arg1.asInstanceOf[(Rep[A],Rep[A]) => Rep[A]]))(mtype(mn._mT),mn.__pos,ntype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector_Reduce(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Vector_Reduce(f(__arg0.asInstanceOf[Rep[Vector[A]]]),f(__arg1.asInstanceOf[(Rep[A],Rep[A]) => Rep[A]]))(mtype(mn._mT),mn.__pos,ntype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector_Filter(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Vector_Filter(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector_Filter(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Vector_Filter(f(__arg0),f(__arg1))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector_Mapreduce(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Vector_Mapreduce(f(__arg0.asInstanceOf[Rep[Vector[A]]]),f(__arg1.asInstanceOf[(Rep[A]) => Rep[A]]),f(__arg2.asInstanceOf[(Rep[A],Rep[A]) => Rep[A]]))(mtype(mn._mT),mn.__pos,ntype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector_Mapreduce(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Vector_Mapreduce(f(__arg0.asInstanceOf[Rep[Vector[A]]]),f(__arg1.asInstanceOf[(Rep[A]) => Rep[A]]),f(__arg2.asInstanceOf[(Rep[A],Rep[A]) => Rep[A]]))(mtype(mn._mT),mn.__pos,ntype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector_FlatMap(__arg0,__arg1) => reflectPure(new { override val original = Some(f,mn) } with Vector_FlatMap(f(__arg0),f(__arg1))(mtype(mn._mT),mtype(mn._mR),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector_FlatMap(__arg0,__arg1), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Vector_FlatMap(f(__arg0),f(__arg1))(mtype(mn._mT),mtype(mn._mR),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Groupby_helperKeys(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Groupby_helperKeys(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Groupby_helperKeys(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Groupby_helperKeys(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Groupby_helperIndex(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Groupby_helperIndex(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Groupby_helperIndex(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Groupby_helperIndex(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Groupby_helper(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Groupby_helper(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Groupby_helper(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Groupby_helper(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector_GroupByReduceKeys(__arg0,__arg1,__arg2,__arg3) => reflectPure(new { override val original = Some(f,mn) } with Vector_GroupByReduceKeys(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos,ntype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector_GroupByReduceKeys(__arg0,__arg1,__arg2,__arg3), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Vector_GroupByReduceKeys(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos,ntype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector_GroupByReduceIndex(__arg0,__arg1,__arg2,__arg3) => reflectPure(new { override val original = Some(f,mn) } with Vector_GroupByReduceIndex(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos,ntype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector_GroupByReduceIndex(__arg0,__arg1,__arg2,__arg3), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Vector_GroupByReduceIndex(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos,ntype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector_GroupByReduce(__arg0,__arg1,__arg2,__arg3) => reflectPure(new { override val original = Some(f,mn) } with Vector_GroupByReduce(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos,ntype(mn.__imp0)))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector_GroupByReduce(__arg0,__arg1,__arg2,__arg3), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Vector_GroupByReduce(f(__arg0),f(__arg1),f(__arg2),f(__arg3))(mtype(mn._mT),mtype(mn._mK),mtype(mn._mV),mn.__pos,ntype(mn.__imp0)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector_Pprint(__arg0) => reflectPure(new { override val original = Some(f,mn) } with Vector_Pprint(f(__arg0))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector_Pprint(__arg0), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Vector_Pprint(f(__arg0))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector_appendable(__arg0,__arg1,__arg2) => reflectPure(new { override val original = Some(f,mn) } with Vector_appendable(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector_appendable(__arg0,__arg1,__arg2), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Vector_appendable(f(__arg0),f(__arg1),f(__arg2))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector_copy(__arg0,__arg1,__arg2,__arg3,__arg4) => reflectPure(new { override val original = Some(f,mn) } with Vector_copy(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4))(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector_copy(__arg0,__arg1,__arg2,__arg3,__arg4), u, es) => reflectMirrored(Reflect(new { override val original = Some(f,mn) } with Vector_copy(f(__arg0),f(__arg1),f(__arg2),f(__arg3),f(__arg4))(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector_Foo(__arg0,f___arg0___arg0,__arg1,__arg2,__arg3,f___arg3___arg0,f___arg3___arg1,__arg4,__arg5,f___arg5___arg0) => reflectPure(Vector_Foo(f(__arg0),f___arg0___arg0,f(__arg1),f(__arg2),f(__arg3),f___arg3___arg0,f___arg3___arg1,f(__arg4),f(__arg5),f___arg5___arg0)(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector_Foo(__arg0,f___arg0___arg0,__arg1,__arg2,__arg3,f___arg3___arg0,f___arg3___arg1,__arg4,__arg5,f___arg5___arg0), u, es) => reflectMirrored(Reflect(Vector_Foo(f(__arg0),f___arg0___arg0,f(__arg1),f(__arg2),f(__arg3),f___arg3___arg0,f___arg3___arg1,f(__arg4),f(__arg5),f___arg5___arg0)(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case mn@Vector_Foo2(__arg0,f___arg0___arg0,__arg1,__arg2,__arg3,f___arg3___arg0,f___arg3___arg1) => reflectPure(Vector_Foo2(f(__arg0),f___arg0___arg0,f(__arg1),f(__arg2),f(__arg3),f___arg3___arg0,f___arg3___arg1)(mtype(mn._mT),mn.__pos))(mtype(manifest[A]), pos)
    case Reflect(mn@Vector_Foo2(__arg0,f___arg0___arg0,__arg1,__arg2,__arg3,f___arg3___arg0,f___arg3___arg1), u, es) => reflectMirrored(Reflect(Vector_Foo2(f(__arg0),f___arg0___arg0,f(__arg1),f(__arg2),f(__arg3),f___arg3___arg0,f___arg3___arg1)(mtype(mn._mT),mn.__pos), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
    case _ => super.mirror(e, f)
  }).asInstanceOf[Exp[A]]

  /**
   * Delite collection
   */
  def isVectorTpe(x: Manifest[_])(implicit ctx: SourceContext) = isSubtype(x.erasure,classOf[Vector[_]])
  def isVector[A](x: Exp[DeliteCollection[A]])(implicit ctx: SourceContext) = isVectorTpe(x.tp)
  def asVector[A](x: Exp[DeliteCollection[A]])(implicit ctx: SourceContext) = x.asInstanceOf[Exp[Vector[A]]]

  override def dc_size[A:Manifest](x: Exp[DeliteCollection[A]])(implicit ctx: SourceContext) = {
    if (isVector(x)) vector_length(asVector(x))
    else super.dc_size(x)
  }

  override def dc_apply[A:Manifest](x: Exp[DeliteCollection[A]], n: Exp[Int])(implicit ctx: SourceContext) = {
    if (isVector(x)) vector_apply(asVector(x), n).asInstanceOf[Exp[A]]
    else super.dc_apply(x,n)
  }

  override def dc_update[A:Manifest](x: Exp[DeliteCollection[A]], n: Exp[Int], y: Exp[A])(implicit ctx: SourceContext) = {
    if (isVector(x)) vector_update(asVector(x), n, y.asInstanceOf[Exp[A]])
    else super.dc_update(x,n,y)
  }

  override def dc_parallelization[A:Manifest](x: Exp[DeliteCollection[A]], hasConditions: Boolean)(implicit ctx: SourceContext) = {
    if (isVector(x)) { if (hasConditions) ParSimpleBuffer else ParFlat } // TODO: always generating this right now
    else super.dc_parallelization(x, hasConditions)
  }

  override def dc_set_logical_size[A:Manifest](x: Exp[DeliteCollection[A]], y: Exp[Int])(implicit ctx: SourceContext) = {
    if (isVector(x)) vector_set_length(asVector(x), y)
    else super.dc_set_logical_size(x,y)
  }

  override def dc_appendable[A:Manifest](x: Exp[DeliteCollection[A]], i: Exp[Int], y: Exp[A])(implicit ctx: SourceContext) = {
    if (isVector(x)) vector_appendable(asVector(x), i, y)
    else super.dc_appendable(x,i,y)
  }

  override def dc_append[A:Manifest](x: Exp[DeliteCollection[A]], i: Exp[Int], y: Exp[A])(implicit ctx: SourceContext) = {
    if (isVector(x)) vector_append(asVector(x), i, y)
    else super.dc_append(x,i,y)
  }

  override def dc_alloc[A:Manifest,CA<:DeliteCollection[A]:Manifest](x: Exp[CA], size: Exp[Int])(implicit ctx: SourceContext) = {
    if (isVector(x)) vector_raw_alloc[A,A](asVector(x), size).asInstanceOf[Exp[CA]]
    else super.dc_alloc[A,CA](x,size)
  }

  override def dc_copy[A:Manifest](src: Exp[DeliteCollection[A]], srcPos: Exp[Int], dst: Exp[DeliteCollection[A]], dstPos: Exp[Int], size: Exp[Int])(implicit ctx: SourceContext) = {
    if (isVector(src) && isVector(dst)) vector_copy(asVector(src), srcPos, asVector(dst), dstPos, size)
    else super.dc_copy(src,srcPos,dst,dstPos,size)
  }

  /**
   * Delite struct
   */
  override def unapplyStructType[T:Manifest]: Option[(StructTag[T], List[(String,Manifest[_])])] = {
    val m = manifest[T]
    if (m.erasure == classOf[Vector[_]]) Some((classTag(m), collection.immutable.List(("_length",manifest[Int]),("_data",makeManifest(classOf[ForgeArray[_]], List(m.typeArguments(0)))))))
    else super.unapplyStructType(m)
  }
  override def dc_data_field(x: Manifest[_]) = {
    if (isVectorTpe(x)) "_data"
    else super.dc_data_field(x)
  }

  override def dc_size_field(x: Manifest[_]) = {
    if (isVectorTpe(x)) "_length"
    else super.dc_size_field(x)
  }
}

/**
 * Code generators
 */

trait ScalaGenVectorOps extends ScalaGenFat {
  val IR: VectorOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Vector_Foo(__arg0,f___arg0___arg0,__arg1,__arg2,__arg3,f___arg3___arg0,f___arg3___arg1,__arg4,__arg5,f___arg5___arg0) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("var i = 0\nval a = new Array["+remap(mn._mT)+"](100)\n\nwhile (i < 100) {\n  a(i) = { ")
      emitVarDecl(f___arg0___arg0.asInstanceOf[Sym[Any]])
      stream.print("{ ")
      emitVarDecl(f___arg3___arg0.asInstanceOf[Sym[Any]])
      stream.print("{ ")
      emitBlock(__arg2)
      emitAssignment(f___arg3___arg0.asInstanceOf[Sym[Any]], quote(getBlockResult(__arg2)))
      stream.print( " }\n ")
      emitVarDecl(f___arg3___arg1.asInstanceOf[Sym[Any]])
      stream.print("{ ")
      emitBlock(__arg2)
      emitAssignment(f___arg3___arg1.asInstanceOf[Sym[Any]], quote(getBlockResult(__arg2)))
      stream.print( " }\n ")
      emitBlock(__arg3)
      emitAssignment(f___arg0___arg0.asInstanceOf[Sym[Any]], quote(getBlockResult(__arg3)))
      stream.print( " }\n ")
      emitBlock(__arg0)
      stream.print(quote(getBlockResult(__arg0))+"\n")
      stream.print( " }\n \n  a(i) = { ")
      emitVarDecl(f___arg0___arg0.asInstanceOf[Sym[Any]])
      stream.print("{ ")
      emitValDef(f___arg3___arg0.asInstanceOf[Sym[Any]],""+quote(__arg1)+"")
      emitValDef(f___arg3___arg1.asInstanceOf[Sym[Any]],""+quote(__arg1)+"")
      emitBlock(__arg3)
      emitAssignment(f___arg0___arg0.asInstanceOf[Sym[Any]], quote(getBlockResult(__arg3)))
      stream.print( " }\n ")
      emitBlock(__arg0)
      stream.print(quote(getBlockResult(__arg0))+"\n")
      stream.print( " }\n \n  i += 1\n}\nprintln(\"a(5) = \" + a(5))\nval z = { ")
      emitValDef(f___arg5___arg0.asInstanceOf[Sym[Any]],""+quote(__arg4)+"")
      emitBlock(__arg5)
      stream.print(quote(getBlockResult(__arg5))+"\n")
      stream.print( " }\n \nval y = { ")
      emitBlock(__arg2)
      stream.print(quote(getBlockResult(__arg2))+"\n")
      stream.print( " }\n +"+quote(__arg1)+"\nprintln(\"z = \" + z)\nprintln(\"y = \" + y)\na(5)")
      stream.println("}")

    case mn@Vector_Foo2(__arg0,f___arg0___arg0,__arg1,__arg2,__arg3,f___arg3___arg0,f___arg3___arg1) => 
      stream.println("val "+quote(sym)+" = {")
      stream.print("var i = 0\nval a = new Array["+remap(mn._mT)+"](5)\n\nwhile (i < 5) {\n  { ")
      emitVarDecl(f___arg0___arg0.asInstanceOf[Sym[Any]])
      stream.print("{ ")
      emitValDef(f___arg3___arg0.asInstanceOf[Sym[Any]],""+quote(__arg1)+"")
      emitValDef(f___arg3___arg1.asInstanceOf[Sym[Any]],"a(i)")
      emitBlock(__arg3)
      emitAssignment(f___arg0___arg0.asInstanceOf[Sym[Any]], quote(getBlockResult(__arg3)))
      stream.print( " }\n ")
      emitBlock(__arg0)
      stream.print( " }\n \n  i += 1\n}\nprintln(\"i = \" + i)")
      stream.println("}")

    case _ => super.emitNode(sym, rhs)
  }
}
trait CGenVectorOps extends CGenFat {
  val IR: VectorOpsExp
  import IR._

  override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
    case mn@Vector_Foo2(__arg0,f___arg0___arg0,__arg1,__arg2,__arg3,f___arg3___arg0,f___arg3___arg1) => 
      stream.print("int i = 0;\n"+remap(mn._mT)+" *a = new "+remap(mn._mT)+"();\nwhile (i < 5) {\n  { ")
      emitVarDecl(f___arg0___arg0.asInstanceOf[Sym[Any]])
      stream.print("{ ")
      emitValDef(f___arg3___arg0.asInstanceOf[Sym[Any]],""+quote(__arg1)+"")
      emitValDef(f___arg3___arg1.asInstanceOf[Sym[Any]],"a[i]")
      emitBlock(__arg3)
      emitAssignment(f___arg0___arg0.asInstanceOf[Sym[Any]], quote(getBlockResult(__arg3)))
      stream.print( " }\n ")
      emitBlock(__arg0)
      stream.print( " }\n ;\n  i += 1;\n}\ndelete[] a;\nstd::cout << \"i = \" << i << std::endl;")
      stream.println(";")

    case _ => super.emitNode(sym, rhs)
  }
}
