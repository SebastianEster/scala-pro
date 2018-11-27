import Basics.{Book, Index}
import org.scalatest.FlatSpec

class BasicsSpec extends FlatSpec {
  "The function swap" should "exchange the values of two integers" in {
    val exchanged = Basics.swap(3, 6)
    assert(exchanged._1 == 6)
    assert(exchanged._2 == 3)
  }

  "The function makeIndex" should "return a damn index" in {
    val book: Book = Array(Array("hello", "from", "scala"), Array("hello", "from", "sebastian"), Array("hello", "you", "bastard"))
    val index: Index = Basics.makeIndex(book, 1, Basics.newIndex())
    assert(index("hello").size == 3)
  }

}