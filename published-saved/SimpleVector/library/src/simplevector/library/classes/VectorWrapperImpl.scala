package simplevector.library.classes

import scala.reflect.{Manifest,SourceContext}
import scala.math.Ordering.Implicits._
import scala.math.Numeric.Implicits._
import simplevector.shared._
import simplevector.shared.ops._
import simplevector.library._
import simplevector.library.classes._

/**
 * SingleTask and Composite Impls
 */

trait VectorWrapperImpl {
  this: SimpleVectorApplication with SimpleVectorCompilerOps => 

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

  def vector_pl_impl17[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[Vector[T]])(implicit __pos: SourceContext,__imp0: Numeric[T]): Rep[Vector[T]] = {
    def func: (Rep[T],Rep[T]) => Rep[T] = (a,b) => a+b
    val inA = self
    val inB = __arg1
    val out = vector_raw_alloc[T,T](inA, vector_length(inA))
    var i = 0
    while (i < vector_length(inA)) {
      vector_update(out, i, func(vector_apply(inA, i),vector_apply(inB, i)))
      i += 1
    }
    out
  }

  def vector_mul_impl1[T:Manifest](self: Rep[Vector[T]],__arg1: Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T]): Rep[Vector[T]] = {
    def func: Rep[T] => Rep[T] = e => e*__arg1
    val in = self
    val out = vector_raw_alloc[T,T](in, vector_length(in))
    var i = 0
    while (i < vector_length(in)) {
      vector_update(out, i, func(vector_apply(in, i)))
      i += 1
    }
    out
  }

  def vector_sum_impl[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext,__imp0: Numeric[T]): Rep[T] = {
    def func: (Rep[T],Rep[T]) => Rep[T] = (a,b) => a+b
    def zero: Rep[T] = numeric_zero[T]
    val in = self
    var acc = if (vector_length(in) == 0) zero else vector_apply(in, 0)
    var i = 1
    while (i < vector_length(in)) {
      acc =  func(acc, vector_apply(in, i))
      i += 1
    }
    acc
  }

  def vector_map_impl[T:Manifest,R:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[R])(implicit __pos: SourceContext): Rep[Vector[R]] = {
    def func: Rep[T] => Rep[R] = e => __arg1(e)
    val in = self
    val out = vector_raw_alloc[T,R](in, vector_length(in))
    var i = 0
    while (i < vector_length(in)) {
      vector_update(out, i, func(vector_apply(in, i)))
      i += 1
    }
    out
  }

  def vector_reduce_impl[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T]): Rep[T] = {
    def func: (Rep[T],Rep[T]) => Rep[T] = (a,b) => __arg1(a,b)
    def zero: Rep[T] = numeric_zero[T]
    val in = self
    var acc = if (vector_length(in) == 0) zero else vector_apply(in, 0)
    var i = 1
    while (i < vector_length(in)) {
      acc =  func(acc, vector_apply(in, i))
      i += 1
    }
    acc
  }

  def vector_filter_impl[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[Boolean])(implicit __pos: SourceContext): Rep[Vector[T]] = {
    def func: Rep[T] => Rep[T] = e => e
    def cond: Rep[T] => Rep[Boolean] = e => __arg1(e)
    val in = self
    val out = vector_raw_alloc[T,T](in,0)
    var i = 0
    while (i < vector_length(in)) {
      val e = vector_apply(in, i)
      if (cond(e)) {
        vector_append(out, i, func(e))
      }
      i += 1
    }
    out
  }

  def vector_mapreduce_impl[T:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[T],__arg2: (Rep[T],Rep[T]) => Rep[T])(implicit __pos: SourceContext,__imp0: Numeric[T]): Rep[T] = {
    def map: Rep[T] => Rep[T] = e => __arg1(e)
    def reduce: (Rep[T],Rep[T]) => Rep[T] = (a,b) => __arg2(a,b)
    def zero: Rep[T] = numeric_zero[T]
    val in = self
    var acc = if (vector_length(in) == 0) zero else map(vector_apply(in, 0))
    var i = 1
    while (i < vector_length(in)) {
      val e = vector_apply(in, i)
      acc =  reduce(acc, map(e))
      i += 1
    }
    acc
  }

  def vector_flatmap_impl[T:Manifest,R:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[Vector[R]])(implicit __pos: SourceContext): Rep[Vector[R]] = {
    def func: Rep[T] => Rep[Vector[R]] = e => __arg1(e)
    val in = self
    val out = vector_raw_alloc[T,R](in,0)
    var sz = 0
    var i = 0
    while (i < vector_length(in)) {
      val e = vector_apply(in, i)
      val buf = func(e)
      var j = 0
      while (j < vector_length(buf)) {
        vector_append(out, sz, buf(j))
        sz += 1
        j += 1
      }
      i += 1
    }
    out
  }

  def groupby_helper_impl[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V])(implicit __pos: SourceContext): Rep[ForgeHashMap[K,ForgeArrayBuffer[V]]] = {
    def key: Rep[T] => Rep[K] = e => __arg1(e)
    def map: Rep[T] => Rep[V] = e => __arg2(e)
    val in = self
    val out = SHashMap[K,ForgeArrayBuffer[V]]()
    var i = 0
    while (i < vector_length(in)) {
      val e = vector_apply(in, i)
        val k = key(e)
        if (!out.contains(k)) {
          val bucket = array_buffer_raw_alloc[V](null.asInstanceOf[Rep[ForgeArrayBuffer[V]]],0)
          array_buffer_dcappend(bucket, 0, map(e))
          out(k) = bucket
        }
        else {
          val bucket = out(k)
          array_buffer_dcappend(bucket, array_buffer_length(bucket), map(e))
        }
      i += 1
    }
    fhashmap_from_shashmap(out)
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

  def vector_groupbyreduce_impl[T:Manifest,K:Manifest,V:Manifest](self: Rep[Vector[T]],__arg1: (Rep[T]) => Rep[K],__arg2: (Rep[T]) => Rep[V],__arg3: (Rep[V],Rep[V]) => Rep[V])(implicit __pos: SourceContext,__imp0: Numeric[V]): Rep[ForgeHashMap[K,V]] = {
    def key: Rep[T] => Rep[K] = e => __arg1(e)
    def map: Rep[T] => Rep[V] = e => __arg2(e)
    def reduce: (Rep[V],Rep[V]) => Rep[V] = (a,b) => __arg3(a,b)
    val in = self
    val out = SHashMap[K,V]()
    var i = 0
    while (i < vector_length(in)) {
      val e = vector_apply(in, i)
        val k = key(e)
        if (!out.contains(k)) {
          out(k) = map(e)
        }
        else {
          out(k) = reduce(out(k), map(e))
        }
      i += 1
    }
    fhashmap_from_shashmap(out)
  }

  def vector_pprint_impl[T:Manifest](self: Rep[Vector[T]])(implicit __pos: SourceContext): Rep[Unit] = {
    def func: Rep[T] => Rep[Unit] = a => println(a)
    val in = self
    var i = 0
    while (i < vector_length(in)) {
      func(vector_apply(in, i))
      i += 1
    }
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
