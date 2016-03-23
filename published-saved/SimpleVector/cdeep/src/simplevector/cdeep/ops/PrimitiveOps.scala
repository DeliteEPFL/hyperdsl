package simplevector.cdeep.ops

import simplevector.cdeep._

/**
 * Operations
 */

trait PrimitivesAPI extends Booleans with Ints with Longs with Floats with Doubles
    with GenOverloadHack
    with Units
trait PrimitivesImpl extends PrimitivesAPI with BooleansImpl with IntsImpl with LongsImpl with FloatsImpl with DoublesImpl
    with UnitsImpl

trait Booleans extends Base {
  protected trait BooleanOps {
    def unary_!(): Boolean
    def ||(__arg1: Boolean): Boolean
    def &&(__arg1: Boolean): Boolean
  }

  type Boolean <: BooleanOps
  implicit val booleanManifest: Manifest[Boolean]
  implicit val booleanTyp: Typ[Boolean]
  implicit val booleanLift: Lift[scala.Boolean,Boolean]
}

trait BooleansImpl extends BaseExp with Booleans {
  case class Boolean(e: Exp[Boolean]) extends BooleanOps {
    def unary_!(): Boolean = ???
    def ||(__arg1: Boolean): Boolean = ???
    def &&(__arg1: Boolean): Boolean = ???
  }

  val booleanManifest: Manifest[Boolean] = manifest[Boolean]
  val booleanTyp: Typ[Boolean] = new Typ[Boolean] {
    def from(e:Exp[Boolean]) = Boolean(e)
    def to(x:Boolean) = x.e
    override def toString = "Boolean"
  }
  val booleanLift: Lift[scala.Boolean,Boolean] = new Lift[scala.Boolean,Boolean] {
    def to(x:scala.Boolean) = Boolean(unit[scala.Boolean,Boolean](x))
  }
}


trait Ints extends Base {
    this: PrimitivesAPI => 
  protected trait IntOps {
    def unary_-(): Int
    def %(__arg1: Int): Int
    def unary_~(): Int
    def <<(__arg1: Int): Int
    def >>(__arg1: Int): Int
    def >>>(__arg1: Int): Int
    def &(__arg1: Int): Int
    def |(__arg1: Int): Int
    def +(rhs: scala.Double): Int
    def -(rhs: scala.Double): Int
    def *(rhs: scala.Double): Int
    def /(rhs: scala.Double): Int
    def +(rhs: Double): Int
    def -(rhs: Double): Int
    def *(rhs: Double): Int
    def /(rhs: Double): Int
    def +(rhs: Var[Double])(implicit __imp1: ROverload1): Int
    def -(rhs: Var[Double])(implicit __imp1: ROverload1): Int
    def *(rhs: Var[Double])(implicit __imp1: ROverload1): Int
    def /(rhs: Var[Double])(implicit __imp1: ROverload1): Int
    def +(rhs: scala.Float): Int
    def -(rhs: scala.Float): Int
    def *(rhs: scala.Float): Int
    def /(rhs: scala.Float): Int
    def +(rhs: Float): Int
    def -(rhs: Float): Int
    def *(rhs: Float): Int
    def /(rhs: Float): Int
    def +(rhs: Var[Float])(implicit __imp1: ROverload2): Int
    def -(rhs: Var[Float])(implicit __imp1: ROverload2): Int
    def *(rhs: Var[Float])(implicit __imp1: ROverload2): Int
    def /(rhs: Var[Float])(implicit __imp1: ROverload2): Int
    def +(rhs: scala.Int): Int
    def -(rhs: scala.Int): Int
    def *(rhs: scala.Int): Int
    def /(rhs: scala.Int): Int
    def +(rhs: Int): Int
    def -(rhs: Int): Int
    def *(rhs: Int): Int
    def /(rhs: Int): Int
    def +(rhs: Var[Int])(implicit __imp1: ROverload3): Int
    def -(rhs: Var[Int])(implicit __imp1: ROverload3): Int
    def *(rhs: Var[Int])(implicit __imp1: ROverload3): Int
    def /(rhs: Var[Int])(implicit __imp1: ROverload3): Int
    def +(rhs: scala.Long): Int
    def -(rhs: scala.Long): Int
    def *(rhs: scala.Long): Int
    def /(rhs: scala.Long): Int
    def +(rhs: Long): Int
    def -(rhs: Long): Int
    def *(rhs: Long): Int
    def /(rhs: Long): Int
    def +(rhs: Var[Long])(implicit __imp1: ROverload4): Int
    def -(rhs: Var[Long])(implicit __imp1: ROverload4): Int
    def *(rhs: Var[Long])(implicit __imp1: ROverload4): Int
    def /(rhs: Var[Long])(implicit __imp1: ROverload4): Int
  }

  type Int <: IntOps
  implicit val intManifest: Manifest[Int]
  implicit val intTyp: Typ[Int]
  implicit val intLift: Lift[scala.Int,Int]
}

trait IntsImpl extends BaseExp with Ints {
    this: PrimitivesImpl => 
  case class Int(e: Exp[Int]) extends IntOps {
    def unary_-(): Int = ???
    def %(__arg1: Int): Int = ???
    def unary_~(): Int = ???
    def <<(__arg1: Int): Int = ???
    def >>(__arg1: Int): Int = ???
    def >>>(__arg1: Int): Int = ???
    def &(__arg1: Int): Int = ???
    def |(__arg1: Int): Int = ???
    def +(rhs: scala.Double): Int = ???
    def -(rhs: scala.Double): Int = ???
    def *(rhs: scala.Double): Int = ???
    def /(rhs: scala.Double): Int = ???
    def +(rhs: Double): Int = ???
    def -(rhs: Double): Int = ???
    def *(rhs: Double): Int = ???
    def /(rhs: Double): Int = ???
    def +(rhs: Var[Double])(implicit __imp1: ROverload1): Int = ???
    def -(rhs: Var[Double])(implicit __imp1: ROverload1): Int = ???
    def *(rhs: Var[Double])(implicit __imp1: ROverload1): Int = ???
    def /(rhs: Var[Double])(implicit __imp1: ROverload1): Int = ???
    def +(rhs: scala.Float): Int = ???
    def -(rhs: scala.Float): Int = ???
    def *(rhs: scala.Float): Int = ???
    def /(rhs: scala.Float): Int = ???
    def +(rhs: Float): Int = ???
    def -(rhs: Float): Int = ???
    def *(rhs: Float): Int = ???
    def /(rhs: Float): Int = ???
    def +(rhs: Var[Float])(implicit __imp1: ROverload2): Int = ???
    def -(rhs: Var[Float])(implicit __imp1: ROverload2): Int = ???
    def *(rhs: Var[Float])(implicit __imp1: ROverload2): Int = ???
    def /(rhs: Var[Float])(implicit __imp1: ROverload2): Int = ???
    def +(rhs: scala.Int): Int = ???
    def -(rhs: scala.Int): Int = ???
    def *(rhs: scala.Int): Int = ???
    def /(rhs: scala.Int): Int = ???
    def +(rhs: Int): Int = ???
    def -(rhs: Int): Int = ???
    def *(rhs: Int): Int = ???
    def /(rhs: Int): Int = ???
    def +(rhs: Var[Int])(implicit __imp1: ROverload3): Int = ???
    def -(rhs: Var[Int])(implicit __imp1: ROverload3): Int = ???
    def *(rhs: Var[Int])(implicit __imp1: ROverload3): Int = ???
    def /(rhs: Var[Int])(implicit __imp1: ROverload3): Int = ???
    def +(rhs: scala.Long): Int = ???
    def -(rhs: scala.Long): Int = ???
    def *(rhs: scala.Long): Int = ???
    def /(rhs: scala.Long): Int = ???
    def +(rhs: Long): Int = ???
    def -(rhs: Long): Int = ???
    def *(rhs: Long): Int = ???
    def /(rhs: Long): Int = ???
    def +(rhs: Var[Long])(implicit __imp1: ROverload4): Int = ???
    def -(rhs: Var[Long])(implicit __imp1: ROverload4): Int = ???
    def *(rhs: Var[Long])(implicit __imp1: ROverload4): Int = ???
    def /(rhs: Var[Long])(implicit __imp1: ROverload4): Int = ???
  }

  val intManifest: Manifest[Int] = manifest[Int]
  val intTyp: Typ[Int] = new Typ[Int] {
    def from(e:Exp[Int]) = Int(e)
    def to(x:Int) = x.e
    override def toString = "Int"
  }
  val intLift: Lift[scala.Int,Int] = new Lift[scala.Int,Int] {
    def to(x:scala.Int) = Int(unit[scala.Int,Int](x))
  }
}


trait Longs extends Base {
    this: PrimitivesAPI => 
  protected trait LongOps {
    def unary_-(): Long
    def %(__arg1: Long): Long
    def unary_~(): Long
    def &(__arg1: Long): Long
    def |(__arg1: Long): Long
    def ^(__arg1: Long): Long
    def >>>(__arg1: Int): Long
    def <<(__arg1: Int): Long
    def >>(__arg1: Int): Long
    def +(rhs: scala.Double): Long
    def -(rhs: scala.Double): Long
    def *(rhs: scala.Double): Long
    def /(rhs: scala.Double): Long
    def +(rhs: Double): Long
    def -(rhs: Double): Long
    def *(rhs: Double): Long
    def /(rhs: Double): Long
    def +(rhs: Var[Double])(implicit __imp1: ROverload1): Long
    def -(rhs: Var[Double])(implicit __imp1: ROverload1): Long
    def *(rhs: Var[Double])(implicit __imp1: ROverload1): Long
    def /(rhs: Var[Double])(implicit __imp1: ROverload1): Long
    def +(rhs: scala.Float): Long
    def -(rhs: scala.Float): Long
    def *(rhs: scala.Float): Long
    def /(rhs: scala.Float): Long
    def +(rhs: Float): Long
    def -(rhs: Float): Long
    def *(rhs: Float): Long
    def /(rhs: Float): Long
    def +(rhs: Var[Float])(implicit __imp1: ROverload2): Long
    def -(rhs: Var[Float])(implicit __imp1: ROverload2): Long
    def *(rhs: Var[Float])(implicit __imp1: ROverload2): Long
    def /(rhs: Var[Float])(implicit __imp1: ROverload2): Long
    def +(rhs: scala.Int): Long
    def -(rhs: scala.Int): Long
    def *(rhs: scala.Int): Long
    def /(rhs: scala.Int): Long
    def +(rhs: Int): Long
    def -(rhs: Int): Long
    def *(rhs: Int): Long
    def /(rhs: Int): Long
    def +(rhs: Var[Int])(implicit __imp1: ROverload3): Long
    def -(rhs: Var[Int])(implicit __imp1: ROverload3): Long
    def *(rhs: Var[Int])(implicit __imp1: ROverload3): Long
    def /(rhs: Var[Int])(implicit __imp1: ROverload3): Long
    def +(rhs: scala.Long): Long
    def -(rhs: scala.Long): Long
    def *(rhs: scala.Long): Long
    def /(rhs: scala.Long): Long
    def +(rhs: Long): Long
    def -(rhs: Long): Long
    def *(rhs: Long): Long
    def /(rhs: Long): Long
    def +(rhs: Var[Long])(implicit __imp1: ROverload4): Long
    def -(rhs: Var[Long])(implicit __imp1: ROverload4): Long
    def *(rhs: Var[Long])(implicit __imp1: ROverload4): Long
    def /(rhs: Var[Long])(implicit __imp1: ROverload4): Long
  }

  type Long <: LongOps
  implicit val longManifest: Manifest[Long]
  implicit val longTyp: Typ[Long]
  implicit val longLift: Lift[scala.Long,Long]
}

trait LongsImpl extends BaseExp with Longs {
    this: PrimitivesImpl => 
  case class Long(e: Exp[Long]) extends LongOps {
    def unary_-(): Long = ???
    def %(__arg1: Long): Long = ???
    def unary_~(): Long = ???
    def &(__arg1: Long): Long = ???
    def |(__arg1: Long): Long = ???
    def ^(__arg1: Long): Long = ???
    def >>>(__arg1: Int): Long = ???
    def <<(__arg1: Int): Long = ???
    def >>(__arg1: Int): Long = ???
    def +(rhs: scala.Double): Long = ???
    def -(rhs: scala.Double): Long = ???
    def *(rhs: scala.Double): Long = ???
    def /(rhs: scala.Double): Long = ???
    def +(rhs: Double): Long = ???
    def -(rhs: Double): Long = ???
    def *(rhs: Double): Long = ???
    def /(rhs: Double): Long = ???
    def +(rhs: Var[Double])(implicit __imp1: ROverload1): Long = ???
    def -(rhs: Var[Double])(implicit __imp1: ROverload1): Long = ???
    def *(rhs: Var[Double])(implicit __imp1: ROverload1): Long = ???
    def /(rhs: Var[Double])(implicit __imp1: ROverload1): Long = ???
    def +(rhs: scala.Float): Long = ???
    def -(rhs: scala.Float): Long = ???
    def *(rhs: scala.Float): Long = ???
    def /(rhs: scala.Float): Long = ???
    def +(rhs: Float): Long = ???
    def -(rhs: Float): Long = ???
    def *(rhs: Float): Long = ???
    def /(rhs: Float): Long = ???
    def +(rhs: Var[Float])(implicit __imp1: ROverload2): Long = ???
    def -(rhs: Var[Float])(implicit __imp1: ROverload2): Long = ???
    def *(rhs: Var[Float])(implicit __imp1: ROverload2): Long = ???
    def /(rhs: Var[Float])(implicit __imp1: ROverload2): Long = ???
    def +(rhs: scala.Int): Long = ???
    def -(rhs: scala.Int): Long = ???
    def *(rhs: scala.Int): Long = ???
    def /(rhs: scala.Int): Long = ???
    def +(rhs: Int): Long = ???
    def -(rhs: Int): Long = ???
    def *(rhs: Int): Long = ???
    def /(rhs: Int): Long = ???
    def +(rhs: Var[Int])(implicit __imp1: ROverload3): Long = ???
    def -(rhs: Var[Int])(implicit __imp1: ROverload3): Long = ???
    def *(rhs: Var[Int])(implicit __imp1: ROverload3): Long = ???
    def /(rhs: Var[Int])(implicit __imp1: ROverload3): Long = ???
    def +(rhs: scala.Long): Long = ???
    def -(rhs: scala.Long): Long = ???
    def *(rhs: scala.Long): Long = ???
    def /(rhs: scala.Long): Long = ???
    def +(rhs: Long): Long = ???
    def -(rhs: Long): Long = ???
    def *(rhs: Long): Long = ???
    def /(rhs: Long): Long = ???
    def +(rhs: Var[Long])(implicit __imp1: ROverload4): Long = ???
    def -(rhs: Var[Long])(implicit __imp1: ROverload4): Long = ???
    def *(rhs: Var[Long])(implicit __imp1: ROverload4): Long = ???
    def /(rhs: Var[Long])(implicit __imp1: ROverload4): Long = ???
  }

  val longManifest: Manifest[Long] = manifest[Long]
  val longTyp: Typ[Long] = new Typ[Long] {
    def from(e:Exp[Long]) = Long(e)
    def to(x:Long) = x.e
    override def toString = "Long"
  }
  val longLift: Lift[scala.Long,Long] = new Lift[scala.Long,Long] {
    def to(x:scala.Long) = Long(unit[scala.Long,Long](x))
  }
}


trait Floats extends Base {
    this: PrimitivesAPI => 
  protected trait FloatOps {
    def unary_-(): Float
    def +(rhs: scala.Double): Float
    def -(rhs: scala.Double): Float
    def *(rhs: scala.Double): Float
    def /(rhs: scala.Double): Float
    def +(rhs: Double): Float
    def -(rhs: Double): Float
    def *(rhs: Double): Float
    def /(rhs: Double): Float
    def +(rhs: Var[Double])(implicit __imp1: ROverload1): Float
    def -(rhs: Var[Double])(implicit __imp1: ROverload1): Float
    def *(rhs: Var[Double])(implicit __imp1: ROverload1): Float
    def /(rhs: Var[Double])(implicit __imp1: ROverload1): Float
    def +(rhs: scala.Float): Float
    def -(rhs: scala.Float): Float
    def *(rhs: scala.Float): Float
    def /(rhs: scala.Float): Float
    def +(rhs: Float): Float
    def -(rhs: Float): Float
    def *(rhs: Float): Float
    def /(rhs: Float): Float
    def +(rhs: Var[Float])(implicit __imp1: ROverload2): Float
    def -(rhs: Var[Float])(implicit __imp1: ROverload2): Float
    def *(rhs: Var[Float])(implicit __imp1: ROverload2): Float
    def /(rhs: Var[Float])(implicit __imp1: ROverload2): Float
    def +(rhs: scala.Int): Float
    def -(rhs: scala.Int): Float
    def *(rhs: scala.Int): Float
    def /(rhs: scala.Int): Float
    def +(rhs: Int): Float
    def -(rhs: Int): Float
    def *(rhs: Int): Float
    def /(rhs: Int): Float
    def +(rhs: Var[Int])(implicit __imp1: ROverload3): Float
    def -(rhs: Var[Int])(implicit __imp1: ROverload3): Float
    def *(rhs: Var[Int])(implicit __imp1: ROverload3): Float
    def /(rhs: Var[Int])(implicit __imp1: ROverload3): Float
    def +(rhs: scala.Long): Float
    def -(rhs: scala.Long): Float
    def *(rhs: scala.Long): Float
    def /(rhs: scala.Long): Float
    def +(rhs: Long): Float
    def -(rhs: Long): Float
    def *(rhs: Long): Float
    def /(rhs: Long): Float
    def +(rhs: Var[Long])(implicit __imp1: ROverload4): Float
    def -(rhs: Var[Long])(implicit __imp1: ROverload4): Float
    def *(rhs: Var[Long])(implicit __imp1: ROverload4): Float
    def /(rhs: Var[Long])(implicit __imp1: ROverload4): Float
  }

  type Float <: FloatOps
  implicit val floatManifest: Manifest[Float]
  implicit val floatTyp: Typ[Float]
  implicit val floatLift: Lift[scala.Float,Float]
}

trait FloatsImpl extends BaseExp with Floats {
    this: PrimitivesImpl => 
  case class Float(e: Exp[Float]) extends FloatOps {
    def unary_-(): Float = ???
    def +(rhs: scala.Double): Float = ???
    def -(rhs: scala.Double): Float = ???
    def *(rhs: scala.Double): Float = ???
    def /(rhs: scala.Double): Float = ???
    def +(rhs: Double): Float = ???
    def -(rhs: Double): Float = ???
    def *(rhs: Double): Float = ???
    def /(rhs: Double): Float = ???
    def +(rhs: Var[Double])(implicit __imp1: ROverload1): Float = ???
    def -(rhs: Var[Double])(implicit __imp1: ROverload1): Float = ???
    def *(rhs: Var[Double])(implicit __imp1: ROverload1): Float = ???
    def /(rhs: Var[Double])(implicit __imp1: ROverload1): Float = ???
    def +(rhs: scala.Float): Float = ???
    def -(rhs: scala.Float): Float = ???
    def *(rhs: scala.Float): Float = ???
    def /(rhs: scala.Float): Float = ???
    def +(rhs: Float): Float = ???
    def -(rhs: Float): Float = ???
    def *(rhs: Float): Float = ???
    def /(rhs: Float): Float = ???
    def +(rhs: Var[Float])(implicit __imp1: ROverload2): Float = ???
    def -(rhs: Var[Float])(implicit __imp1: ROverload2): Float = ???
    def *(rhs: Var[Float])(implicit __imp1: ROverload2): Float = ???
    def /(rhs: Var[Float])(implicit __imp1: ROverload2): Float = ???
    def +(rhs: scala.Int): Float = ???
    def -(rhs: scala.Int): Float = ???
    def *(rhs: scala.Int): Float = ???
    def /(rhs: scala.Int): Float = ???
    def +(rhs: Int): Float = ???
    def -(rhs: Int): Float = ???
    def *(rhs: Int): Float = ???
    def /(rhs: Int): Float = ???
    def +(rhs: Var[Int])(implicit __imp1: ROverload3): Float = ???
    def -(rhs: Var[Int])(implicit __imp1: ROverload3): Float = ???
    def *(rhs: Var[Int])(implicit __imp1: ROverload3): Float = ???
    def /(rhs: Var[Int])(implicit __imp1: ROverload3): Float = ???
    def +(rhs: scala.Long): Float = ???
    def -(rhs: scala.Long): Float = ???
    def *(rhs: scala.Long): Float = ???
    def /(rhs: scala.Long): Float = ???
    def +(rhs: Long): Float = ???
    def -(rhs: Long): Float = ???
    def *(rhs: Long): Float = ???
    def /(rhs: Long): Float = ???
    def +(rhs: Var[Long])(implicit __imp1: ROverload4): Float = ???
    def -(rhs: Var[Long])(implicit __imp1: ROverload4): Float = ???
    def *(rhs: Var[Long])(implicit __imp1: ROverload4): Float = ???
    def /(rhs: Var[Long])(implicit __imp1: ROverload4): Float = ???
  }

  val floatManifest: Manifest[Float] = manifest[Float]
  val floatTyp: Typ[Float] = new Typ[Float] {
    def from(e:Exp[Float]) = Float(e)
    def to(x:Float) = x.e
    override def toString = "Float"
  }
  val floatLift: Lift[scala.Float,Float] = new Lift[scala.Float,Float] {
    def to(x:scala.Float) = Float(unit[scala.Float,Float](x))
  }
}


trait Doubles extends Base {
    this: PrimitivesAPI => 
  protected trait DoubleOps {
    def unary_-(): Double
    def +(rhs: scala.Double): Double
    def -(rhs: scala.Double): Double
    def *(rhs: scala.Double): Double
    def /(rhs: scala.Double): Double
    def +(rhs: Double): Double
    def -(rhs: Double): Double
    def *(rhs: Double): Double
    def /(rhs: Double): Double
    def +(rhs: Var[Double])(implicit __imp1: ROverload1): Double
    def -(rhs: Var[Double])(implicit __imp1: ROverload1): Double
    def *(rhs: Var[Double])(implicit __imp1: ROverload1): Double
    def /(rhs: Var[Double])(implicit __imp1: ROverload1): Double
    def +(rhs: scala.Float): Double
    def -(rhs: scala.Float): Double
    def *(rhs: scala.Float): Double
    def /(rhs: scala.Float): Double
    def +(rhs: Float): Double
    def -(rhs: Float): Double
    def *(rhs: Float): Double
    def /(rhs: Float): Double
    def +(rhs: Var[Float])(implicit __imp1: ROverload2): Double
    def -(rhs: Var[Float])(implicit __imp1: ROverload2): Double
    def *(rhs: Var[Float])(implicit __imp1: ROverload2): Double
    def /(rhs: Var[Float])(implicit __imp1: ROverload2): Double
    def +(rhs: scala.Int): Double
    def -(rhs: scala.Int): Double
    def *(rhs: scala.Int): Double
    def /(rhs: scala.Int): Double
    def +(rhs: Int): Double
    def -(rhs: Int): Double
    def *(rhs: Int): Double
    def /(rhs: Int): Double
    def +(rhs: Var[Int])(implicit __imp1: ROverload3): Double
    def -(rhs: Var[Int])(implicit __imp1: ROverload3): Double
    def *(rhs: Var[Int])(implicit __imp1: ROverload3): Double
    def /(rhs: Var[Int])(implicit __imp1: ROverload3): Double
    def +(rhs: scala.Long): Double
    def -(rhs: scala.Long): Double
    def *(rhs: scala.Long): Double
    def /(rhs: scala.Long): Double
    def +(rhs: Long): Double
    def -(rhs: Long): Double
    def *(rhs: Long): Double
    def /(rhs: Long): Double
    def +(rhs: Var[Long])(implicit __imp1: ROverload4): Double
    def -(rhs: Var[Long])(implicit __imp1: ROverload4): Double
    def *(rhs: Var[Long])(implicit __imp1: ROverload4): Double
    def /(rhs: Var[Long])(implicit __imp1: ROverload4): Double
  }

  type Double <: DoubleOps
  implicit val doubleManifest: Manifest[Double]
  implicit val doubleTyp: Typ[Double]
  implicit val doubleLift: Lift[scala.Double,Double]
}

trait DoublesImpl extends BaseExp with Doubles {
    this: PrimitivesImpl => 
  case class Double(e: Exp[Double]) extends DoubleOps {
    def unary_-(): Double = ???
    def +(rhs: scala.Double): Double = ???
    def -(rhs: scala.Double): Double = ???
    def *(rhs: scala.Double): Double = ???
    def /(rhs: scala.Double): Double = ???
    def +(rhs: Double): Double = ???
    def -(rhs: Double): Double = ???
    def *(rhs: Double): Double = ???
    def /(rhs: Double): Double = ???
    def +(rhs: Var[Double])(implicit __imp1: ROverload1): Double = ???
    def -(rhs: Var[Double])(implicit __imp1: ROverload1): Double = ???
    def *(rhs: Var[Double])(implicit __imp1: ROverload1): Double = ???
    def /(rhs: Var[Double])(implicit __imp1: ROverload1): Double = ???
    def +(rhs: scala.Float): Double = ???
    def -(rhs: scala.Float): Double = ???
    def *(rhs: scala.Float): Double = ???
    def /(rhs: scala.Float): Double = ???
    def +(rhs: Float): Double = ???
    def -(rhs: Float): Double = ???
    def *(rhs: Float): Double = ???
    def /(rhs: Float): Double = ???
    def +(rhs: Var[Float])(implicit __imp1: ROverload2): Double = ???
    def -(rhs: Var[Float])(implicit __imp1: ROverload2): Double = ???
    def *(rhs: Var[Float])(implicit __imp1: ROverload2): Double = ???
    def /(rhs: Var[Float])(implicit __imp1: ROverload2): Double = ???
    def +(rhs: scala.Int): Double = ???
    def -(rhs: scala.Int): Double = ???
    def *(rhs: scala.Int): Double = ???
    def /(rhs: scala.Int): Double = ???
    def +(rhs: Int): Double = ???
    def -(rhs: Int): Double = ???
    def *(rhs: Int): Double = ???
    def /(rhs: Int): Double = ???
    def +(rhs: Var[Int])(implicit __imp1: ROverload3): Double = ???
    def -(rhs: Var[Int])(implicit __imp1: ROverload3): Double = ???
    def *(rhs: Var[Int])(implicit __imp1: ROverload3): Double = ???
    def /(rhs: Var[Int])(implicit __imp1: ROverload3): Double = ???
    def +(rhs: scala.Long): Double = ???
    def -(rhs: scala.Long): Double = ???
    def *(rhs: scala.Long): Double = ???
    def /(rhs: scala.Long): Double = ???
    def +(rhs: Long): Double = ???
    def -(rhs: Long): Double = ???
    def *(rhs: Long): Double = ???
    def /(rhs: Long): Double = ???
    def +(rhs: Var[Long])(implicit __imp1: ROverload4): Double = ???
    def -(rhs: Var[Long])(implicit __imp1: ROverload4): Double = ???
    def *(rhs: Var[Long])(implicit __imp1: ROverload4): Double = ???
    def /(rhs: Var[Long])(implicit __imp1: ROverload4): Double = ???
  }

  val doubleManifest: Manifest[Double] = manifest[Double]
  val doubleTyp: Typ[Double] = new Typ[Double] {
    def from(e:Exp[Double]) = Double(e)
    def to(x:Double) = x.e
    override def toString = "Double"
  }
  val doubleLift: Lift[scala.Double,Double] = new Lift[scala.Double,Double] {
    def to(x:scala.Double) = Double(unit[scala.Double,Double](x))
  }
}



