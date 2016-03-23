package simplevector.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import simplevector.shared._
import simplevector.shared.ops._
import simplevector.compiler._
import simplevector.compiler.ops._

/**
 * Op Impls
 */

trait VectorOpsImpl {
  this: SimpleVectorCompiler with SimpleVectorLift => 

  def vector_apply_impl1[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[T] = {
    array_apply(vector_raw_data(self), __arg1)
  }

  def vector_update_impl1[T:Manifest](self: Rep[Vector[T]],i: Rep[Int],e: Rep[T])(implicit __pos: SourceContext): Rep[Unit] = {
    array_update(vector_raw_data(self), i, e)
  }

  def vector_slice_impl2[T:Manifest](self: Rep[Vector[T]],start: Rep[Int] = unit(0),end: Rep[Int])(implicit __pos: SourceContext): Rep[Vector[T]] = {
    val out = Vector[T](end - start)
    var i = start
    while (i < end) {
      out(i-start) = self(i)
      i += 1
    }
    out
  }

  def vector_insert_impl[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext): Rep[Unit] = {
    vector_insertspace(self,__arg1,1)
    self(__arg1) = __arg2
  }

  def vector_append_impl[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext): Rep[Unit] = {
    self.insert(self.length, __arg2)
  }

  def vector_insertspace_impl[T:Manifest](self: Rep[Vector[T]],pos: Rep[Int],len: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    vector_ensureextra(self,len)
    val data = vector_raw_data(self)
    array_copy(data,pos,data,pos+len,self.length-pos)
    vector_set_length(self,self.length+len)
  }

  def vector_ensureextra_impl[T:Manifest](self: Rep[Vector[T]],extra: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    val data = vector_raw_data(self)
    if (array_length(data) - self.length < extra) {
      vector_realloc(self, self.length+extra)
    }
  }

  def vector_realloc_impl[T:Manifest](self: Rep[Vector[T]],minLen: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    val data = vector_raw_data(self)
    var n = unit(4) max (array_length(data)*2)
    while (n < minLen) n = n*2
    val d = array_empty[T](n)
    array_copy(data, 0, d, 0, self.length)
    vector_set_raw_data(self, d.unsafeImmutable)
  }

  def vector_pl_impl17_zip[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Vector[T]])(implicit __pos: SourceContext,__imp0: Numeric[T]): (Rep[T],Rep[T]) => Rep[T] = {
    (a,b) => a+b
  }

  def vector_mul_impl1_map[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T]): (Rep[T]) => Rep[T] = {
    e => e*__arg1
  }

  def vector_sum_impl_reduce[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext,__imp0: Numeric[T]): (Rep[T],Rep[T]) => Rep[T] = {
    (a,b) => a+b
  }

  def vector_sum_impl_zero[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext,__imp0: Numeric[T]): Rep[T] = {
    numeric_zero[T]
  }

  def vector_map_impl_map[T:Manifest,R:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext): (Rep[T]) => Rep[R] = {
    e => __arg1(e)
  }

  def vector_reduce_impl_reduce[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T]): (Rep[T],Rep[T]) => Rep[T] = {
    (a,b) => __arg1(a,b)
  }

  def vector_reduce_impl_zero[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T]): Rep[T] = {
    numeric_zero[T]
  }

  def vector_filter_impl_cond[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): (Rep[T]) => Rep[Boolean] = {
    e => __arg1(e)
  }

  def vector_filter_impl_map[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): (Rep[T]) => Rep[T] = {
    e => e
  }

  def vector_mapreduce_impl_map[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[T],__arg2: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T]): (Rep[T]) => Rep[T] = {
    e => __arg1(e)
  }

  def vector_mapreduce_impl_reduce[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[T],__arg2: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T]): (Rep[T],Rep[T]) => Rep[T] = {
    (a,b) => __arg2(a,b)
  }

  def vector_mapreduce_impl_zero[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[T],__arg2: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T]): Rep[T] = {
    numeric_zero[T]
  }

  def vector_flatmap_impl_func[T:Manifest,R:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[Vector[R]])(implicit __pos: SourceContext): (Rep[T]) => Rep[Vector[R]] = {
    e => __arg1(e)
  }

  def groupby_helper_impl_key[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit __pos: SourceContext): (Rep[T]) => Rep[K] = {
    e => __arg1(e)
  }

  def groupby_helper_impl_map[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit __pos: SourceContext): (Rep[T]) => Rep[V] = {
    e => __arg2(e)
  }

  def vector_groupby_impl[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit __pos: SourceContext): Rep[Vector[Vector[V]]] = {
    val map = groupby_helper(self, __arg1, __arg2)
    val groups = fhashmap_values(map)
    val out = Vector[Vector[V]](array_length(groups))
    var i = 0
    while (i < array_length(groups)) {
      val inGroup = groups(i)
      val outGroup = Vector[V](array_buffer_length(inGroup))
      var j = 0
      while (j < array_buffer_length(inGroup)) {
        outGroup(j) = array_buffer_apply(inGroup, j)
        j += 1
      }
      out(i) = outGroup.unsafeImmutable
      i += 1
    }
    out.unsafeImmutable
  }

  def vector_groupbyreduce_impl_key[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V],__arg3: (Rep[V],Rep[V]) => Rep[V])(implicit __pos: SourceContext,__imp0: Numeric[V]): (Rep[T]) => Rep[K] = {
    e => __arg1(e)
  }

  def vector_groupbyreduce_impl_map[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V],__arg3: (Rep[V],Rep[V]) => Rep[V])(implicit __pos: SourceContext,__imp0: Numeric[V]): (Rep[T]) => Rep[V] = {
    e => __arg2(e)
  }

  def vector_groupbyreduce_impl_zero[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V],__arg3: (Rep[V],Rep[V]) => Rep[V])(implicit __pos: SourceContext,__imp0: Numeric[V]): Rep[V] = {
    numeric_zero[V]
  }

  def vector_groupbyreduce_impl_reduce[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V],__arg3: (Rep[V],Rep[V]) => Rep[V])(implicit __pos: SourceContext,__imp0: Numeric[V]): (Rep[V],Rep[V]) => Rep[V] = {
    (a,b) => __arg3(a,b)
  }

  def vector_pprint_impl_func[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext): (Rep[T]) => Rep[Unit] = {
    a => println(a)
  }

  def vector_raw_alloc_impl[T:Manifest,R:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int])(implicit __pos: SourceContext): Rep[Vector[R]] = {
    Vector[R](__arg1)
  }

  def vector_appendable_impl[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[T])(implicit __pos: SourceContext): Rep[Boolean] = {
    true
  }

  def vector_copy_impl[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Int],__arg2: Rep[Vector[T]],__arg3: Rep[Int],__arg4: Rep[Int])(implicit __pos: SourceContext): Rep[Unit] = {
    val src = vector_raw_data(self)
    val dest = vector_raw_data(__arg2)
    array_copy(src, __arg1, dest, __arg3, __arg4)
  }

}
