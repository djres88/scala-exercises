case class Deque[T]() {
  val nodes: List[Node[T]] = List.empty
  private var head: Option[Node[T]] = None
  private var tail: Option[Node[T]] = None

  def push(value: T): Unit = {
    val node = new Node(value, tail, None)
    tail.map(t => t.setNext(Some(node)))
    tail = Some(node)
    if (head == None) {
      head = Some(node)
    }
  }

  def unshift(value: T): Unit = {
    val node = new Node(value, None, head)
    head.map(t => t.setPrev(Some(node)))
    head = Some(node)
    if (tail == None) {
      tail = Some(node)
    }
  }

  def shift(): Option[T] = head.map(headNode => {
    val removedHeadValue = headNode.getCurrentValue
    headNode.getNext() match {
      case Some(newHead) => {
        newHead.setPrev(None)
        head = Some(newHead)
      }
      case _ => head = None
    }
    removedHeadValue
  })

  //OTHER WAYS
  //    head match {
  //      case Some(x) => {
  //        Some(x.getCurrentValue)
  //      }
  //      case _ => None
  //    }

  //    head.map(o => {
  //      val newHead = o.getPrev()
  //      newHead match {
  //        case Some(x) => x.setNext(None)
  //      }
  //      o.getCurrentValue
  //    })

  def pop(): Option[T] = tail.map(tailNode => {
    val removedTailValue = tailNode.getCurrentValue
    tailNode.getPrev() match {
      case Some(newTail) => {
        newTail.setNext(None)
        tail = Some(newTail)
      }
      case _ => tail = None
    }
    removedTailValue
  })
}

case class Node[T](
                    current: T,
                    private var prev: Option[Node[T]] = None,
                    private var next: Option[Node[T]] = None
                  ) {
  def getCurrentValue = current

  def setPrev(node: Option[Node[T]]) = prev = node

  def setNext(node: Option[Node[T]]) = next = node

  def getPrev() = prev

  def getNext() = next
}