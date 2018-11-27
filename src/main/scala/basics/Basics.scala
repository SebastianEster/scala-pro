package object Basics {
  def swap(x: Int, y: Int): (Int, Int) = (y, x)

  type Page = Array[String]
  type Book = Array[Page]
  type Index = Map[String, Set[Int]]

  def newIndex(): Index = Map.empty[String, Set[Int]]

  def makeIndex(book: Book, currentPageNumber: Int, index: Index): Index = {
    if (!book.isEmpty){
      val updatedIndex = updateIndex(index, book(0), currentPageNumber)
      makeIndex(book.tail, currentPageNumber + 1, updatedIndex)
    } else {
      index
    }
  }

  private[this] def updateIndex(index: Index, page: Page, currentPageNumber: Int): Index = {
    if (!page.isEmpty){
      val word = page(0)
      if (index.contains(word)) {
        val pageNumberSet = index(word)
        val updatedPageSet = pageNumberSet + currentPageNumber
        val updatedIndex = index + (word -> updatedPageSet)
        updateIndex(updatedIndex, page.tail, currentPageNumber)
      } else {
        val updatedIndex = index + (word -> Set(currentPageNumber))
        updateIndex(updatedIndex, page.tail, currentPageNumber)
      }
    } else {
      index
    }
  }


}