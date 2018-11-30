package object Basics {
  def swap(x: Int, y: Int): (Int, Int) = (y, x)

  class Page(val words: Array[String],val number: Int)
  type Book = Array[Page]
  type Index = Map[String, Set[Int]]

  def newIndex(): Index = Map.empty[String, Set[Int]]

  def makeIndex(book: Book): Index = {
    book.foldLeft(newIndex()) { (bookIndex, page) =>

      // create index for one page
      val updatedIndex = page.words.foldLeft(newIndex()) { (pageIndex, word) =>
        val pageNumberSet = pageIndex.getOrElse(word, Set.empty[Int])
        val updatedPageNumberSet = pageNumberSet + page.number
        pageIndex + (word -> updatedPageNumberSet)
      }

      // merge the index of the current page with the index of the previous pages
      updatedIndex.foldLeft(bookIndex) { (mergedIndex, elementTuple) =>
        val pageNumberSet = mergedIndex.getOrElse(elementTuple._1, Set.empty[Int])
        val updatedPageNumberSet = pageNumberSet ++ elementTuple._2
        mergedIndex + (elementTuple._1 -> updatedPageNumberSet)
      }

    }
  }

}