package object Warmup{
  val square: Int => Int = (x: Int) => x*x

  private val factor = 3

  def apply[A, B](function1: A => B, parameter: A): B = function1(parameter)

  def multiply(i: Int): Int = i * factor
}