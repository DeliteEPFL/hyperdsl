package simplevector.cdeep

import simplevector.cdeep.ops._
import scala.reflect.{Manifest,SourceContext}

trait WhileAPI extends Base {
  this: PrimitivesAPI =>
  
  def __whileDo(cond: => Boolean, body: => Unit)(implicit pos: SourceContext): Unit = ???
}
