trait SimpleLinkedList[T] {
  def value: Option[T]
  def next: Option[SimpleLinkedList[T]]
  def isEmpty: Boolean = value == None
  def add(item: T): SimpleLinkedList[T] = {
    if (isEmpty) {

    } else {

    }
  }
  def reverse: SimpleLinkedList[T] = {
    val ll = new SimpleLinkedList[Int]()
  }
  def toSeq: Seq[T] = {

  }
}

//object, singleton
object SimpleLinkedList {
  def apply[T](): SimpleLinkedList[T]

}

case class Node[T](private val value: T, private val nextItem: T) {
  def next: SimpleLinkedList[T] = nextItem
}


//

//object SimpleLinkedList {
//  def apply[T](): SimpleLinkedList[T] = new SimpleLinkedListItem[T](None, None)
//  def apply[T](item: T, next: SimpleLinkedList[T]) = new SimpleLinkedListItem[T](Some(item), Some(next))
////  def fromSeq[T](seq: Seq[T]): SimpleLinkedList[T] = seq.foldLeft(SimpleLinkedList[T]())((acc, item) => acc.add(item))
//  def fromSeq[T](seq: Seq[T]): SimpleLinkedList[T] = {
//    val list: SimpleLinkedList[T] = SimpleLinkedList()
//    seq.foreach(el => list.add(el))
//    list
//  }
//}
//
////template for instances of objects that will be contained in the linked list
//case class SimpleLinkedListItem[T](private val containedItem: Option[T], private val nextItem: Option[SimpleLinkedList[T]]) extends SimpleLinkedList[T] {
//  override def next = nextItem.map(item => item)
//  override def value = containedItem.map(item => item)
//}