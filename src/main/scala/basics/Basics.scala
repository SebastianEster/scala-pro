package object Basics {
  def swap(x: Int, y: Int): (Int, Int) = (y, x)

  type Page = Array[String]
  type Book = Array[Page]
  type Index = Map[String, Set[Int]]

  def newIndex(): Index = Map.empty[String, Set[Int]]

  def makeIndex(book: Book): Index = {
    var index = newIndex()
    for((page, i) <- book.view.zipWithIndex) {
      for(word <- page) {
        val pages = index(word)
        index = index + (word -> (pages ++ Array(i)))
      }
    }
  }
}