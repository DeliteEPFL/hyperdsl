package simplevector.shallow.classes

import scala.math.Ordering.Implicits._
import scala.math.Numeric.Implicits._
import simplevector.shallow._
import simplevector.shallow.classes._
import Delite._
import Forge._
import ForgeArray._
import ForgeArrayBuffer._
import ForgeHashMap._
import ForgeFileReader._
import Numeric._

/**
 * Operations
 */

object Vector {
  // static ops
  def apply[T:Manifest](__arg0: Int) = vector_object_apply[T](__arg0)(implicitly[Manifest[T]])

  // direct ops
  def foo[T:Manifest](__arg0: (Int) => T,__arg1: Int,__arg2:  => Int,__arg3: (Int,Int) => Int,__arg4: Double,__arg5: (Double) => Double) = vector_foo[T](__arg0,__arg1,__arg2,__arg3,__arg4,__arg5)(implicitly[Manifest[T]])
  def foo2[T:Manifest](__arg0: (Int) => Unit,__arg1: Int,__arg2:  => Int,__arg3: (Int,T) => Int) = vector_foo2[T](__arg0,__arg1,__arg2,__arg3)(implicitly[Manifest[T]])

  // compiler ops
  def vector_raw_data[T:Manifest](self: Vector[T]): ForgeArray[T] = {
    self._data
  }
  def vector_set_raw_data[T:Manifest](self: Vector[T],__arg1: ForgeArray[T]): Unit = {
    self._data = __arg1
  }
  def vector_set_length[T:Manifest](self: Vector[T],__arg1: Int): Unit = {
    self._length = __arg1
  }
  def vector_insertspace[T:Manifest](self: Vector[T],pos: Int,len: Int): Unit = {
    vector_ensureextra(self,len)
    val data = vector_raw_data(self)
    array_copy(data,pos,data,pos+len,self.length-pos)
    vector_set_length(self,self.length+len)
  }
  def vector_ensureextra[T:Manifest](self: Vector[T],extra: Int): Unit = {
    val data = vector_raw_data(self)
    if (array_length(data) - self.length < extra) {
      vector_realloc(self, self.length+extra)
    }
  }
  def vector_realloc[T:Manifest](self: Vector[T],minLen: Int): Unit = {
    val data = vector_raw_data(self)
    var n = unit(4) max (array_length(data)*2)
    while (n < minLen) n = n*2
    val d = array_empty[T](n)
    array_copy(data, 0, d, 0, self.length)
    vector_set_raw_data(self, d.unsafeImmutable)
  }
  def groupby_helper[T:Manifest,K:Manifest,V:Manifest](self: Vector[T],__arg1: (T) => K,__arg2: (T) => V): ForgeHashMap[K,ForgeArrayBuffer[V]] = {
    def key: Rep[T] => Rep[K] = e => __arg1(e)
    def map: Rep[T] => Rep[V] = e => __arg2(e)
    val in = self
    val out = new SHashMap[K,ForgeArrayBuffer[V]]()
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
  def vector_raw_alloc[T:Manifest,R:Manifest](self: Vector[T],__arg1: Int): Vector[R] = {
    Vector[R](__arg1)
  }
  def vector_appendable[T:Manifest](self: Vector[T],__arg1: Int,__arg2: T): Boolean = {
    true
  }
  def vector_copy[T:Manifest](self: Vector[T],__arg1: Int,__arg2: Vector[T],__arg3: Int,__arg4: Int): Unit = {
    val src = vector_raw_data(self)
    val dest = vector_raw_data(__arg2)
    array_copy(src, __arg1, dest, __arg3, __arg4)
  }

  // abstract implemented ops
  def vector_object_apply[T:Manifest](__arg0: Int): Vector[T] = {
    new Vector[T](__arg0,array_empty[T](__arg0))
  }
  def vector_length[T:Manifest](self: Vector[T]): Int = {
    self._length
  }
  def vector_apply[T:Manifest](self: Vector[T],__arg1: Int): T = {
    array_apply(vector_raw_data(self), __arg1)
  }
  def vector_update[T:Manifest](self: Vector[T],i: Int,e: T): Unit = {
    array_update(vector_raw_data(self), i, e)
  }
  def vector_slice[T:Manifest](self: Vector[T],start: Int = unit(0),end: Int): Vector[T] = {
    val out = Vector[T](end - start)
    var i = start
    while (i < end) {
      out(i-start) = self(i)
      i += 1
    }
    out
  }
  def vector_insert[T:Manifest](self: Vector[T],__arg1: Int,__arg2: T): Unit = {
    vector_insertspace(self,__arg1,1)
    self(__arg1) = __arg2
  }
  def vector_append[T:Manifest](self: Vector[T],__arg1: Int,__arg2: T): Unit = {
    self.insert(self.length, __arg2)
  }
  def vector_pl[T:Manifest](self: Vector[T],__arg1: Vector[T])(implicit __imp0: Numeric[T]): Vector[T] = {
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
  def vector_mul[T:Manifest](self: Vector[T],__arg1: T)(implicit __imp0: Numeric[T]): Vector[T] = {
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
  def vector_sum[T:Manifest](self: Vector[T])(implicit __imp0: Numeric[T]): T = {
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
  def vector_map[T:Manifest,R:Manifest](self: Vector[T],__arg1: (T) => R): Vector[R] = {
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
  def vector_reduce[T:Manifest](self: Vector[T],__arg1: (T,T) => T)(implicit __imp0: Numeric[T]): T = {
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
  def vector_filter[T:Manifest](self: Vector[T],__arg1: (T) => Boolean): Vector[T] = {
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
  def vector_mapreduce[T:Manifest](self: Vector[T],__arg1: (T) => T,__arg2: (T,T) => T)(implicit __imp0: Numeric[T]): T = {
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
  def vector_flatmap[T:Manifest,R:Manifest](self: Vector[T],__arg1: (T) => Vector[R]): Vector[R] = {
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
  def vector_groupby[T:Manifest,K:Manifest,V:Manifest](self: Vector[T],__arg1: (T) => K,__arg2: (T) => V): Vector[Vector[V]] = {
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
  def vector_groupbyreduce[T:Manifest,K:Manifest,V:Manifest](self: Vector[T],__arg1: (T) => K,__arg2: (T) => V,__arg3: (V,V) => V)(implicit __imp0: Numeric[V]): ForgeHashMap[K,V] = {
    def key: Rep[T] => Rep[K] = e => __arg1(e)
    def map: Rep[T] => Rep[V] = e => __arg2(e)
    def reduce: (Rep[V],Rep[V]) => Rep[V] = (a,b) => __arg3(a,b)
    val in = self
    val out = new SHashMap[K,V]()
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
  def vector_pprint[T:Manifest](self: Vector[T]): Unit = {
    def func: Rep[T] => Rep[Unit] = a => println(a)
    val in = self
    var i = 0
    while (i < vector_length(in)) {
      func(vector_apply(in, i))
      i += 1
    }
  }
  def vector_foo[T:Manifest](__arg0: (Int) => T,__arg1: Int,__arg2:  => Int,__arg3: (Int,Int) => Int,__arg4: Double,__arg5: (Double) => Double): T = {
/*codegen*/{
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
  }
  def vector_foo2[T:Manifest](__arg0: (Int) => Unit,__arg1: Int,__arg2:  => Int,__arg3: (Int,T) => Int): Unit = {
/*codegen*/{
  var i = 0
  val a = new Array[T](5)
  
  while (i < 5) {
    __arg0(__arg3(__arg1,a(i)))
    i += 1
  }
  println("i = " + i)
}
  }
}

class Vector[T:Manifest](___length: Int, ___data: ForgeArray[T]) { self => 
  var _length = ___length
  var _data = ___data

  import Vector._
  def length = vector_length[T](self)(implicitly[Manifest[T]])
  def apply(__arg1: Int) = vector_apply[T](self,__arg1)(implicitly[Manifest[T]])
  def update(i: Int,e: T) = vector_update[T](self,i,e)(implicitly[Manifest[T]])
  def slice(start: Int = unit(0),end: Int) = vector_slice[T](self,start,end)(implicitly[Manifest[T]])
  def insert(__arg1: Int,__arg2: T) = vector_insert[T](self,__arg1,__arg2)(implicitly[Manifest[T]])
  def append(__arg1: Int,__arg2: T) = vector_append[T](self,__arg1,__arg2)(implicitly[Manifest[T]])
  def +(__arg1: Vector[T])(implicit __imp0: Numeric[T]) = vector_pl[T](self,__arg1)(implicitly[Manifest[T]],__imp0)
  def *(__arg1: T)(implicit __imp0: Numeric[T]) = vector_mul[T](self,__arg1)(implicitly[Manifest[T]],__imp0)
  def sum(implicit __imp0: Numeric[T]) = vector_sum[T](self)(implicitly[Manifest[T]],__imp0)
  def map[R:Manifest](__arg1: (T) => R) = vector_map[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]])
  def reduce(__arg1: (T,T) => T)(implicit __imp0: Numeric[T]) = vector_reduce[T](self,__arg1)(implicitly[Manifest[T]],__imp0)
  def filter(__arg1: (T) => Boolean) = vector_filter[T](self,__arg1)(implicitly[Manifest[T]])
  def mapreduce(__arg1: (T) => T,__arg2: (T,T) => T)(implicit __imp0: Numeric[T]) = vector_mapreduce[T](self,__arg1,__arg2)(implicitly[Manifest[T]],__imp0)
  def flatMap[R:Manifest](__arg1: (T) => Vector[R]) = vector_flatmap[T,R](self,__arg1)(implicitly[Manifest[T]],implicitly[Manifest[R]])
  def groupBy[K:Manifest,V:Manifest](__arg1: (T) => K,__arg2: (T) => V) = vector_groupby[T,K,V](self,__arg1,__arg2)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]])
  def groupByReduce[K:Manifest,V:Manifest](__arg1: (T) => K,__arg2: (T) => V,__arg3: (V,V) => V)(implicit __imp0: Numeric[V]) = vector_groupbyreduce[T,K,V](self,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],implicitly[Manifest[K]],implicitly[Manifest[V]],__imp0)
  def pprint() = vector_pprint[T](self)(implicitly[Manifest[T]])
}


