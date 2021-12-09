package machine

// Stage 5/6: Keep track of the supplies
fun main() {
   var waterQty = 400
   var milkQty = 540
   var beansQty = 120
   var cupQty = 9
   var moneyQty = 550


   while (true) {
      println("Write action (buy, fill, take, remaining, exit):")
      val action = readLine()!!

      if (action == "exit") {
         break
      }

      if (action == "remaining") {
         printSupplies(waterQty, milkQty, beansQty, cupQty, moneyQty)
      }

      if (action == "buy") {
         buyLoop@while (true) {
            println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:")
            val type = readLine()!!

            if (type == "back") {
               break@buyLoop
            }

            val msg = checkSupplies(type.toInt(), waterQty, milkQty, beansQty, cupQty, moneyQty)
            if (msg == "") {
               val supplies = updateSupplies(type.toInt(), waterQty, milkQty, beansQty, cupQty, moneyQty)
               waterQty = supplies[0]
               milkQty = supplies[1]
               beansQty = supplies[2]
               cupQty = supplies[3]
               moneyQty = supplies[4]
            } else {
               println(msg)
            }
            break@buyLoop
         }
      }

      if (action == "fill") {
         println("Write how many ml of water do you want to add:") // > 2000
         waterQty += readLine()!!.toInt()

         println("Write how many ml of milk do you want to add:") //  > 500
         milkQty += readLine()!!.toInt()

         println("Write how many grams of coffee beans do you want to add:") // > 100
         beansQty += readLine()!!.toInt()

         println("Write how many disposable cups of coffee do you want to add:") //  > 10
         cupQty += readLine()!!.toInt()
      }
      if (action == "take") {
         val money = moneyQty
         println("I gave you: $money")
         moneyQty = takeAllMoney(moneyQty)
      }

      //printSupplies(waterQty, milkQty, beansQty, cupQty, moneyQty)
   }
}


fun calcIngredientsQty(cups: Int = 1): List<Int>{
   val water = 200 // ml
   val milk = 50 // ml
   val coffeeBeans = 15 // g

   val list = listOf(water*cups, milk*cups, coffeeBeans*cups)

   return list
}


fun printSupplies(waterQty: Int, milkQty: Int, beansQty: Int, cupQty: Int, money: Int) {
   println("The coffee machine has:")
   println("$waterQty of water")
   println("$milkQty of milk")
   println("$beansQty of coffee beans")
   println("$cupQty of disposable cups")
   println("$money of money")
}


fun takeAllMoney(moneyQty: Int): Int {
   return 0
}


fun updateSupplies (type: Int, waterQty: Int, milkQty: Int, beansQty: Int, cupQty: Int, moneyQty: Int): MutableList<Int> {
   var baseWater = 0
   var baseMilk = 0
   var baseBeans = 0
   var baseCupQty = 1
   var baseMoneyQty = 0

   if (type == 1) { // 1 is expresso
      baseWater = 250 // ml
      baseMilk = 0 // ml
      baseBeans = 16 // g
      baseMoneyQty = 4
   } else if (type == 2) { // 2 is latte
      baseWater = 350 // ml
      baseMilk = 75 // ml
      baseBeans = 20 // g
      baseMoneyQty = 7
   } else { // 3 is cappuccino
      baseWater = 200 // ml
      baseMilk = 100 // ml
      baseBeans = 12 // g
      baseMoneyQty = 6
   }

   var newWaterQty = waterQty - baseWater
   var newMilkQty = milkQty - baseMilk
   var newBeansQty = beansQty - baseBeans
   var newCupQty = cupQty - baseCupQty
   var newMoneyQty = moneyQty + baseMoneyQty

   return mutableListOf<Int>(newWaterQty, newMilkQty, newBeansQty, newCupQty, newMoneyQty)
}


fun checkSupplies (type: Int, waterQty: Int, milkQty: Int, beansQty: Int, cupQty: Int, moneyQty: Int): String {
   var baseWater = 0
   var baseMilk = 0
   var baseBeans = 0
   var baseCup = 1
   var baseMoney = 0

   if (type == 1) { // 1 is expresso
      baseWater = 250 // ml
      baseMilk = 0 // ml
      baseBeans = 16 // g
      baseMoney = 4
   } else if (type == 2) { // 2 is latte
      baseWater = 350 // ml
      baseMilk = 75 // ml
      baseBeans = 20 // g
      baseMoney = 7
   } else { // 3 is cappuccino
      baseWater = 200 // ml
      baseMilk = 100 // ml
      baseBeans = 12 // g
      baseMoney = 6
   }

   var msg = ""
   if (waterQty < baseWater) {
      msg = "Sorry, not enough water!"
   }
   if (milkQty < baseMilk) {
      msg = "Sorry, not enough milk!"
   }
   if (beansQty < baseBeans) {
      msg = "Sorry, not enough coffee beans!"
   }
   if (cupQty < baseCup) {
      msg = "Sorry, not enough cups!"
   }
   return msg
}