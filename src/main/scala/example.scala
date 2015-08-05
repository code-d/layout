
package object example  {

  case class Point(x: Double, y: Double)
  case class Size(width: Double, height: Double)

  def layout(parentWidth: Double, padding: Double, vSpacing: Double, hSpacing: Double, children: Seq[Size]): Seq[Point] = {

    def align(size: Size): Alignment = Alignment(left = padding, row = 0, size = size)

    val alignments = children match {
      case s :: Nil ⇒ Seq(align(s))
      case s :: tail ⇒ tail.scanLeft(align(s)) {
        case (a, x) ⇒
          val offsetLeft = a.left + a.size.width + hSpacing
          if (offsetLeft + padding + x.width > parentWidth) {
            Alignment(left = padding, row = a.row + 1, size = x)
          } else {
            a.copy(left = offsetLeft, size = x)
          }
      }
      case Nil ⇒ Nil
    }
    val h = alignments.groupBy(_.row).mapValues(_.maxBy(_.size.height).size.height)

    alignments map {
      case Alignment(left, row, size) ⇒
        val offsetTop = padding + (0 until row).map(h).sum + row * vSpacing
        val height = h(row)
        Point(left, offsetTop + (height - size.height) / 2)
    }
  }

  case class Alignment(left: Double, row: Int, size: Size)


}


