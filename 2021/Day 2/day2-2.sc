import scala.io.Source

val distances = Source
    .fromFile("day2-input.txt")
    .getLines()
    .map(x => x.split(" "))
    .foldLeft(Array(0,0,0))((totals, pair) => {
        val horizontal = totals(0)
        val depth = totals(1) 
        val aim = totals(2) 
        val instruction = pair(0)
        val amount = pair(1).toInt
        
        instruction match {
            case "forward" => Array(horizontal + amount, depth + (aim * amount), aim)
            case "up" => Array(horizontal, depth, aim-amount)
            case "down" => Array(horizontal, depth, aim+amount)
            case _ => totals
        }
    })

println("Horizontal: " + distances(0))
println("Depth: " + distances(1))
println("Aim: " + distances(2))
println("Multiplied: " + distances(0) * distances(1))
