package machine

// Stage 2/6: Making coffee
fun main() {
   println("Starting to make a coffee")
   println("Grinding coffee beans")
   println("Boiling water")
   println("Mixing boiled water with crushed coffee beans")
   println("Pouring coffee into the cup")
   println("Pouring some milk into the cup")
   println("Coffee is ready!")



   println("Write how many cups of coffee you will need:")
   val cups = readLine()!!.toInt()

   val list = calcIngredientsQty(cups)

   println("For $cups cups of coffee you will need:")
   println("${list[0]} ml of water") // water
   println("${list[1]} ml of milk") // milk
   println("${list[2]} g of coffee beans") // beans
}

fun calcIngredientsQty(cups: Int = 1): List<Int>{
   val water = 200 // ml
   val milk = 50 // ml
   val coffeeBeans = 15 // g


   val list = listOf(water*cups, milk*cups, coffeeBeans*cups)

   return list
}
