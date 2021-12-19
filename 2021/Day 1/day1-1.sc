import scala.io.Source

val depth_increases_count = Source
    .fromFile("day1-input.txt")
    .getLines()
    .map(s => s.toInt)
    .sliding(2,1)
    .fold(0)((total, pair) => if (pair(1) > pair(0)) total + 1 else total)

println(depth_increases_count)