package simplevector.library.classes

import scala.reflect.{Manifest,SourceContext}
import scala.math.Ordering.Implicits._
import scala.math.Numeric.Implicits._
import scala.virtualization.lms.common.{Base,BaseExp,EffectExp,BaseFatExp}
import scala.virtualization.lms.common.{ScalaGenBase,ScalaGenEffect,ScalaGenFat,CudaGenFat,CGenFat}
import scala.virtualization.lms.util._
import scala.virtualization.lms.internal._
import simplevector.shared._
import simplevector.shared.ops._
import simplevector.library._
import simplevector.library.classes._

trait VectorWrapper {
  this: SimpleVectorBase with SimpleVectorClasses => 

class Vector[T:Manifest](___length: Int, ___data: ForgeArray[T]) {
  var _length = ___length
  var _data = ___data

}

  def vector_object_apply[T:Manifest](__arg0: Rep[Int])(implicit __pos: SourceContext) = {
    new Vector[T](__arg0,array_empty[T](__arg0))
  }
  def vector_raw_data[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext) = {
    self._data
  }
  def vector_set_raw_data[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[ForgeArray[T]])(implicit __pos: SourceContext) = {
    self._data = __arg1
  }
  def vector_length[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext) = {
    def __imp1 = ()
    self._length
  }
  def vector_set_length[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    self._length = __arg1
  }
  def vector_apply[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    vector_apply_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def vector_update[T:Manifest](self: Rep[Vector[T]],i: Rep[Int],e: Rep[T])(implicit __pos: SourceContext) = {
    vector_update_impl1[T](self,i,e)(implicitly[Manifest[T]],__pos)
  }
  def vector_slice[T:Manifest](self: Rep[Vector[T]],start: Rep[Int] = unit(0),end: Rep[Int])(implicit __pos: SourceContext) = {
    vector_slice_impl2[T](self,start,end)(implicitly[Manifest[T]],__pos)
  }
  def vector_insert[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext) = {
    vector_insert_impl[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def vector_append[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext) = {
    vector_append_impl[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def vector_insertspace[T:Manifest](self: Rep[Vector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext) = {
    vector_insertspace_impl[T](self,pos,len)(implicitly[Manifest[T]],__pos)
  }
  def vector_ensureextra[T:Manifest](self: Rep[Vector[T]],extra: Rep[Int])(implicit __pos: SourceContext) = {
    vector_ensureextra_impl[T](self,extra)(implicitly[Manifest[T]],__pos)
  }
  def vector_realloc[T:Manifest](self: Rep[Vector[T]],minLen: Rep[Int])(implicit __pos: SourceContext) = {
    vector_realloc_impl[T](self,minLen)(implicitly[Manifest[T]],__pos)
  }
  def vector_pl[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Vector[T]])(implicit __pos: SourceContext,__imp0: Numeric[T]) = {
    vector_pl_impl17[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def vector_mul[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T]) = {
    vector_mul_impl1[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def vector_sum[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext,__imp0: Numeric[T]) = {
    vector_sum_impl[T](self)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def vector_map[T:Manifest,R:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext) = {
    vector_map_impl[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def vector_reduce[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T]) = {
    vector_reduce_impl[T](self,__arg1)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def vector_filter[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext) = {
    vector_filter_impl[T](self,__arg1)(implicitly[Manifest[T]],__pos)
  }
  def vector_mapreduce[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[T],__arg2: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T]) = {
    vector_mapreduce_impl[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos,__imp0)
  }
  def vector_flatmap[T:Manifest,R:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[Vector[R]])(implicit __pos: SourceContext) = {
    vector_flatmap_impl[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def groupby_helper[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit __pos: SourceContext) = {
    groupby_helper_impl[T,K,V](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  }
  def vector_groupby[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit __pos: SourceContext) = {
    vector_groupby_impl[T,K,V](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos)
  }
  def vector_groupbyreduce[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V],__arg3: (Rep[V],Rep[V]) => Rep[V])(implicit __pos: SourceContext,__imp0: Numeric[V]) = {
    vector_groupbyreduce_impl[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__pos,__imp0)
  }
  def vector_pprint[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext) = {
    vector_pprint_impl[T](self)(implicitly[Manifest[T]],__pos)
  }
  def vector_raw_alloc[T:Manifest,R:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext) = {
    vector_raw_alloc_impl[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]],__pos)
  }
  def vector_appendable[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext) = {
    vector_appendable_impl[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__pos)
  }
  def vector_copy[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[Vector[T]],__arg3: Rep[Int],__arg4: Rep[Int])(implicit __pos: SourceContext) = {
    vector_copy_impl[T](self,__arg1,__arg2,__arg3,__arg4)(implicitly[Manifest[T]],__pos)
  }
  def vector_foo[T:Manifest](__arg0: (Rep[Int]) => Rep[T],__arg1: Rep[Int],__arg2:  => Rep[Int],__arg3: (Rep[Int],Rep[Int]) => Rep[Int],__arg4: Rep[Double],__arg5: (Rep[Double]) => Rep[Double])(implicit __pos: SourceContext) = {
    var i = 0
    val a = new Array[T](100)
    
    while (i < 100) {
      a(i) = __arg0(__arg3(__arg2,__arg2))
      a(i) = __arg0(__arg3(__arg1,__arg1))
      i += 1
    }
    println("a(5) = " + a(5))
    val z = __arg5(__arg4)
    val y = __arg2+__arg1
    println("z = " + z)
    println("y = " + y)
    a(5)
  }
  def vector_foo2[T:Manifest](__arg0: (Rep[Int]) => Rep[Unit],__arg1: Rep[Int],__arg2:  => Rep[Int],__arg3: (Rep[Int],Rep[T]) => Rep[Int])(implicit __pos: SourceContext) = {
    var i = 0
    val a = new Array[T](5)
    
    while (i < 5) {
      __arg0(__arg3(__arg1,a(i)))
      i += 1
    }
    println("i = " + i)
  }

}

