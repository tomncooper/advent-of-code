import scala.io.Source

val distances = Source
    .fromFile("day2-input.txt")
    .getLines()
    .map(x => x.split(" "))
    .foldLeft(Array(0,0))((totals, pair) => {
        val horizontal = totals(0)
        val depth = totals(1) 
        val instruction = pair(0)
        val amount = pair(1).toInt
        
        instruction match {
            case "forward" => Array(horizontal + amount, depth)
            case "up" => Array(horizontal, depth - amount)
            case "down" => Array(horizontal, depth + amount)
            case _ => totals
        }
    })

println("Horizontal: " + distances(0))
println("Depth: " + distances(1))
println("Multiplied: " + distances.reduce(_*_))
