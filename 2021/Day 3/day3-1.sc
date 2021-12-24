import scala.io.Source
import java.lang.Integer

val buckets = 12 

val counts = Source
    .fromFile("day3-input.txt")
    .getLines()
    .foldLeft(Array.fill(buckets)(Array(0,0)))((totals, line) => {
        line.zipWithIndex.map(pair => {
            val currentCount = totals(pair._2)
            val currentChar = pair._1
            
            currentChar match {
                case '0' => Array(currentCount(0) + 1, currentCount(1)) 
                case '1' => Array(currentCount(0), currentCount(1) + 1)
                case _ => currentCount
            }
        }).toArray
    })

val output = counts.foldLeft(Array.fill(2)(Array.empty[Char]))((highLow, bucket) => {
    val high = highLow(0)
    val low = highLow(1)

    if (bucket(0) > bucket(1)) {
        Array(high.appended('0'), low.appended('1'))
    } else if (bucket(0) < bucket(1)) {
        Array(high.appended('1'), low.appended('0'))
    } else {
        highLow
    }
}).map(chars => Integer.parseInt(chars.mkString, 2)).product

println("Final Answer: " + output)