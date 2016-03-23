package simplevector.compiler.ops

import scala.reflect.{Manifest,SourceContext}
import simplevector.shared._
import simplevector.shared.ops._
import simplevector.compiler._
import simplevector.compiler.ops._

/**
 * Op Impls
 */

trait SHashMapOpsImpl {
  this: SimpleVectorCompiler with SimpleVectorLift => 

  def shashmap_keys_impl[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext): Rep[ForgeArray[K]] = {
    farray_from_sarray(shashmap_keys_array(__arg0))
  }

  def shashmap_values_impl[K:Manifest,V:Manifest](__arg0: Rep[scala.collection.mutable.HashMap[K,V]])(implicit __pos: SourceContext): Rep[ForgeArray[V]] = {
    farray_from_sarray(shashmap_values_array(__arg0))
  }

}
