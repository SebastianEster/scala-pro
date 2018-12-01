import org.scalatest.FlatSpec

class WarmupSpec extends FlatSpec {
  "The field square" should "contain a function that squares an integer number" in {
    assert(Warmup.square(5) == 25)
  }

  "The function apply" should "apply the passed function to the passed parameter" in{
    val result = Warmup.apply((x: Int) => x + x, 5)
    assert(result == 10)
  }

  "The function multiply" should "return the passed integer value multiplied by 3" in {
    assert(Warmup.multiply(5) == 15)
  }

  "The function compose" should "take two functions and return a composition of those two" in {
    val composed = Warmup.compose((x: Int) => x * x, (x: Int) => x + x)
    assert(composed(5) == 100)
  }
}
