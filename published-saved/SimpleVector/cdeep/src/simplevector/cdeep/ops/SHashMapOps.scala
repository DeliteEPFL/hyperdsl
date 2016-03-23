package simplevector.cdeep.ops

import scala.annotation.unchecked.uncheckedVariance
import scala.reflect.{Manifest,SourceContext}

/**
 * Operations
 */

// Front-end
trait ForgeHashMapsAPI extends Base {
  this: PrimitivesAPI =>

  trait ForgeHashMapOps[K,V] {
    def apply(key: K)(implicit ctx: SourceContext): V
    def contains(key: K)(implicit ctx: SourceContext): Boolean
  }

  type ForgeHashMap[K,V] <: ForgeHashMapOps[K,V]
  implicit def forgeMapManifest[K:Manifest:Typ,V:Manifest:Typ]: Manifest[ForgeHashMap[K,V]]
  implicit def forgeMapTyp[K:Manifest:Typ,V:Manifest:Typ]: Typ[ForgeHashMap[K,V]]

  // def fhashmap_get[K:Manifest,V:Manifest](m: ForgeHashMap[K,V], key: K)(implicit ctx: SourceContext): V
  // def fhashmap_contains[K:Manifest,V:Manifest](m: ForgeHashMap[K,V], key: K)(implicit ctx: SourceContext): Boolean
  // def fhashmap_keys[K:Manifest,V:Manifest](m: ForgeHashMap[K,V])(implicit ctx: SourceContext): ForgeArray[K]
  // def fhashmap_values[K:Manifest,V:Manifest](m: ForgeHashMap[K,V])(implicit ctx: SourceContext): ForgeArray[V]
}

trait ForgeHashMapsImpl extends BaseExp with ForgeHashMapsAPI {
  this: PrimitivesImpl =>

  case class ForgeHashMap[K:Manifest:Typ,V:Manifest:Typ](e: Exp[ForgeHashMap[K,V]]) extends ForgeHashMapOps[K,V] {
    def apply(key: K)(implicit ctx: SourceContext): V = ???
    def contains(key: K)(implicit ctx: SourceContext): Boolean = ???
  }

  def forgeMapManifest[K:Manifest:Typ,V:Manifest:Typ]: Manifest[ForgeHashMap[K,V]] = manifest[ForgeHashMap[K,V]]

  def forgeMapTyp[K:Manifest:Typ,V:Manifest:Typ]: Typ[ForgeHashMap[K,V]] = new Typ[ForgeHashMap[K,V]] {
    def from(e:Exp[ForgeHashMap[K,V]]) = ForgeHashMap[K,V](e)
    def to(x:ForgeHashMap[K,V]) = x.e
    override def toString = "ForgeHashMap["+typ[K]+","+typ[V]+"]"
  }

  // def fhashmap_from_shashmap[K:Manifest,V:Manifest](m: scala.collection.mutable.HashMap[K,V])(implicit ctx: SourceContext): ForgeHashMap[K,V]
  // def fhashmap_from_arrays[K:Manifest,V:Manifest](keys: ForgeArray[K], values: ForgeArray[V])(implicit ctx: SourceContext): ForgeHashMap[K,V]
  // def fhashmap_size[K:Manifest,V:Manifest](m: ForgeHashMap[K,V])(implicit ctx: SourceContext): Int
  //def fhashmap_toArray[K:Manifest,V:Manifest](m: Rep[ForgeHashMap[K,V]])(implicit ctx: SourceContext): Rep[ForgeArray[(K,V)]]
}
