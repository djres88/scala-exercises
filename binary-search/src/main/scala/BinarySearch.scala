object BinarySearch {
  def find(list: List[Int], value: Int): Option[Int] = {
    if (list.length == 0) {
      return None
    }

    val key = list.length / 2
    val middle = list(key)

    if (middle == value) {
      //found
      Some(key)
    } else if (list.length < 2) {
      //there's only one element and it's not the value
      None
    } else {
      //keep looking
      if (value < middle) {
        find(list.slice(0, key), value)
      } else {
        //note: option type returns a box value. you can map over a value that either exists or does not exist
        find(list.slice(key, list.length), value).map(v => v + (list.length / 2))
        //        val o = find(list.slice(checkIndex, list.length), value)
        //        if (o.isDefined) {
        //          Some(list.length+ o.get) // option works like a box
        //        } else {
        //          None
        //        }
      }
    }
  }
}
