import Basics.{Book, Index, Page}
import org.scalatest.FlatSpec

class BasicsSpec extends FlatSpec {
  "The function swap" should "exchange the values of two integers" in {
    val exchanged = Basics.swap(3, 6)
    assert(exchanged._1 == 6)
    assert(exchanged._2 == 3)
  }

  "The function makeIndex" should "return a damn index" in {
    val book: Book = Array(new Page(Array("hello", "from", "scala"), 1),
      new Page(Array("hello", "from", "sebastian"), 2), new Page(Array("hello", "you", "fool"), 3))
    val index: Index = Basics.makeIndex(book)
    assert(index("hello").size == 3)
  }

}