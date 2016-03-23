package simplevector.shallow

object Numeric {
  def numeric_zero[T](implicit num: Numeric[T]): T = num.zero
}
