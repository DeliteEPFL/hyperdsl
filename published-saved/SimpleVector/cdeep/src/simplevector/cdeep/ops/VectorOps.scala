package simplevector.cdeep.ops

import scala.reflect.SourceContext

/**
 * Operations
 */

trait VectorsAPI extends Base {
  this: PrimitivesAPI with ForgeHashMapsAPI =>
  trait VectorOps[T] {
    def length(): Int
    def apply(__arg1: Int): Vector[T]
    def update(i: Int,e: T): Unit
    def slice(start: Int/* = unit[scala.Int, Int](0)*/,end: Int): Vector[T]
    def insert(__arg1: Int,__arg2: T): Unit
    def append(__arg1: Int,__arg2: T): Unit
    def +(__arg1: Vector[T]): Vector[T]
    def *(__arg1: T): Vector[T]
    def sum(): T
    def map[R:Typ:Manifest](__arg1: (T) => R): Vector[R]
    def reduce(__arg1: (T,T) => T): T
    def filter(__arg1: (T) => Boolean): Vector[T]
    def mapreduce(__arg1: (T) => T,__arg2: (T,T) => T): T
    def flatMap[R:Typ:Manifest](__arg1: (T) => Vector[R]): Vector[R]
    def groupBy[K:Typ:Manifest,V:Typ:Manifest](__arg1: (T) => K,__arg2: (T) => V): Vector[Vector[T]]
    def groupByReduce[K:Typ:Manifest,V:Typ:Manifest](__arg1: (T) => K,__arg2: (T) => V,__arg3: (V,V) => V): ForgeHashMap[K,V]
    def pprint(): Unit
  }

  object Vector {
    // Can't have case class apply here without exposing Exps. Use new Vector[T](e: Exp[Vector[T]]) instead.
    // def apply[T:Manifest:Typ](e: Exp[Vector[T]]) = ???
    def apply[T:Manifest:Typ](__arg0: Int): Vector[T] = ??? //vector_object_apply[T](__arg0)(implicitly[Manifest[T]],__pos)
  }
  // val Vector : {def apply[T:Manifest:Typ](__arg0: Int): Vector[T]}

  def foo[T:Manifest:Typ](__arg0: (Int) => T,__arg1: Int,__arg2:  => Int,__arg3: (Int,Int) => Int,__arg4: Double,__arg5: (Double) => Double)(implicit __pos: SourceContext) = ???//vector_foo[T](__arg0,__arg1,__arg2,__arg3,__arg4,__arg5)(implicitly[Manifest[T]],__pos)
  def foo2[T:Manifest:Typ](__arg0: (Int) => Unit,__arg1: Int,__arg2:  => Int,__arg3: (Int,T) => Int)(implicit __pos: SourceContext) = ???//vector_foo2[T](__arg0,__arg1,__arg2,__arg3)(implicitly[Manifest[T]],__pos)


  type Vector[T] <: VectorOps[T]
  implicit def vectorManifest[T:Typ:Manifest]: Manifest[Vector[T]]
  implicit def vectorTyp[T:Typ:Manifest]: Typ[Vector[T]]
  implicit def vectorLift[T:Typ:Manifest]: Lift[simplevector.shallow.classes.Vector[T],Vector[T]]
}

trait VectorsImpl extends BaseExp with VectorsAPI {
  this: PrimitivesImpl with ForgeHashMapsImpl =>
  class Vector[T:Manifest:Typ](val e: Exp[Vector[T]]) extends VectorOps[T] {
    def length(): Int = ???
    def apply(__arg1: Int): Vector[T] = ???
    def update(i: Int,e: T): Unit = ???
    def slice(start: Int/* = unit[scala.Int, Int](0)*/,end: Int): Vector[T] = ???
    def insert(__arg1: Int,__arg2: T): Unit = ???
    def append(__arg1: Int,__arg2: T): Unit = ???
    def +(__arg1: Vector[T]): Vector[T] = ???
    def *(__arg1: T): Vector[T] = ???
    def sum(): T = ???
    def map[R:Typ:Manifest](__arg1: (T) => R): Vector[R] = ???
    def reduce(__arg1: (T,T) => T): T = ???
    def filter(__arg1: (T) => Boolean): Vector[T] = ???
    def mapreduce(__arg1: (T) => T,__arg2: (T,T) => T): T = ???
    def flatMap[R:Typ:Manifest](__arg1: (T) => Vector[R]): Vector[R] = ???
    def groupBy[K:Typ:Manifest,V:Typ:Manifest](__arg1: (T) => K,__arg2: (T) => V): Vector[Vector[T]] = ???
    def groupByReduce[K:Typ:Manifest,V:Typ:Manifest](__arg1: (T) => K,__arg2: (T) => V,__arg3: (V,V) => V): ForgeHashMap[K,V] = ???
    def pprint(): Unit = ???
  }

  def vectorManifest[T:Typ:Manifest]: Manifest[Vector[T]] = manifest[Vector[T]]
  def vectorTyp[T:Typ:Manifest]: Typ[Vector[T]] = new Typ[Vector[T]] {
    def from(e:Exp[Vector[T]]) = new Vector[T](e)
    def to(x:Vector[T]) = x.e
    override def toString = "Vector["+typ[T]+"]"
  }
  def vectorLift[T:Typ:Manifest]: Lift[simplevector.shallow.classes.Vector[T],Vector[T]] = new Lift[simplevector.shallow.classes.Vector[T],Vector[T]] {
    def to(x:simplevector.shallow.classes.Vector[T]) = new Vector(unit[simplevector.shallow.classes.Vector[T],Vector[T]](x))
  }
}



