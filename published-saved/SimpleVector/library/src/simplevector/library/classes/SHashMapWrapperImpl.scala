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

trait SHashMapWrapperImpl {
  this: SimpleVectorApplication with SimpleVectorCompilerOps => 

  def shashmap_keys_impl[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext): Rep[ForgeArray[K]] = {
    farray_from_sarray(shashmap_keys_array(__arg0))
  }

  def shashmap_values_impl[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext): Rep[ForgeArray[V]] = {
    farray_from_sarray(shashmap_values_array(__arg0))
  }

}
