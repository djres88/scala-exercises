case class Matrix(args: String) {
  val matrix: Vector[Vector[Int]] = args.split(("\n")).toVector.map(row => row.split(" ").toVector.map(el => el.toInt))

  def row(i: Int): Vector[Int] = {
    matrix(i)
  }

  def column(i: Int): Vector[Int] = {
    matrix.map(row => row(i))
  }
}