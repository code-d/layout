package example

import org.specs2._

class TestSpec extends mutable.Specification {

  "s" should {
    "1" in {
      layout(parentWidth = 10.0, padding = 0, vSpacing = 0, hSpacing = 0, Seq(Size(5, 7), Size(5, 5))) must be equalTo Seq(Point(0.0, 0.0), Point(5.0, 1.0))
    }
    "2" in {
      layout(parentWidth = 10.0, padding = 0, vSpacing = 3.0, hSpacing = 0, Seq(Size(5, 7), Size(5, 5))) must be equalTo Seq(Point(0.0, 0.0), Point(5.0, 1.0))
    }
    "3" in {
      layout(parentWidth = 10.0, padding = 0.0, vSpacing = 0, hSpacing = 1.0, Seq(Size(5, 7), Size(5, 5))) must be equalTo Seq(Point(0.0, 0.0), Point(0.0, 7.0))
    }
    "4" in {
      layout(parentWidth = 10.0, padding = 1.0, vSpacing = 0, hSpacing = 0, Seq(Size(5, 7), Size(5, 5))) must be equalTo Seq(Point(1.0, 1.0), Point(1.0, 8.0))
    }
    "5" in {
      layout(parentWidth = 10.0, padding = 1.0, vSpacing = 1.0, hSpacing = 0, Seq(Size(5, 7), Size(5, 5))) must be equalTo Seq(Point(1.0, 1.0), Point(1.0, 9.0))
    }
    "6" in {
      layout(parentWidth = 10.0, padding = 1.0, vSpacing = 1.0, hSpacing = 1.0, Seq(Size(5, 7), Size(5, 5))) must be equalTo Seq(Point(1.0, 1.0), Point(1.0, 9.0))
    }

    "x1" in {
      layout(parentWidth = 10.0, padding = 1.0, vSpacing = 1.0, hSpacing = 0, Seq(Size(5, 7))) must be equalTo Seq(Point(1.0, 1.0))
    }
    "x2" in {
      layout(parentWidth = 10.0, padding = 1.0, vSpacing = 1.0, hSpacing = 1.0, Seq()) must be equalTo Seq()
    }
  }
}
