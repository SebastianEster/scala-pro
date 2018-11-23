import org.scalatest.FlatSpec

class BasicsSpec extends FlatSpec {
  "The function swap" should "exchange the values of two integers" in {
    val exchanged = Basics.swap(3, 6)
    assert(exchanged._1 == 6)
    assert(exchanged._2 == 3)
  }
}