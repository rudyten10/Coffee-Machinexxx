package machine

// Stage 3/6: Estimate the number of servings
fun main() {
//   println("Starting to make a coffee")
//   println("Grinding coffee beans")
//   println("Boiling water")
//   println("Mixing boiled water with crushed coffee beans")
//   println("Pouring coffee into the cup")
//   println("Pouring some milk into the cup")
//   println("Coffee is ready!")



   println("Write how many ml of water the coffee machine has:")
   val water = readLine()!!.toInt()
   println("Write how many ml of milk the coffee machine has:")
   val milk = readLine()!!.toInt()
   println("Write how many grams of coffee beans the coffee machine has:")
   val beans = readLine()!!.toInt()

   println("Write how many cups of coffee you will need:")
   val cups = readLine()!!.toInt()

   calcCoffeeCupsPossible(cups, water, milk, beans)


//   val list = calcIngredientsQty(cups)
//
//   println("For $cups cups of coffee you will need:")
//   println("${list[0]} ml of water") // water
//   println("${list[1]} ml of milk") // milk
//   println("${list[2]} g of coffee beans") // beans
}


fun calcCoffeeCupsPossible (cups: Int, water: Int, milk: Int, beans: Int) {
   val baseWater = 200 // ml
   val baseMilk = 50 // ml
   val baseBeans = 15 // g

   var inCups = 1
   if (cups == 0)
      inCups = 1
   else
      inCups = cups
   val needWater = baseWater * inCups
   val needMilk = baseMilk * inCups
   val needBeans = baseBeans * inCups

   var yes = false
   var totalCups = 1
   while (true) {
      if (baseWater*totalCups <= water && baseMilk*totalCups <= milk && baseBeans*totalCups <= beans) {
         ++totalCups
      } else {
         break
      }
   }
   totalCups--

   if (totalCups > 0)
      yes = true

   if (totalCups == cups) {
      println("Yes, I can make that amount of coffee")
   } else if (totalCups < cups) {
      println("No, I can make only ${totalCups} cups of coffee")
   } else {
      println("Yes, I can make that amount of coffee (and even ${totalCups - cups} more than that)")
   }
}


fun calcIngredientsQty(cups: Int = 1): List<Int>{
   val water = 200 // ml
   val milk = 50 // ml
   val coffeeBeans = 15 // g


   val list = listOf(water*cups, milk*cups, coffeeBeans*cups)

   return list
}
