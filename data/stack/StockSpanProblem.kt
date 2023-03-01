package data.stack.StockSnapProblem
 
import java.util.*

fun main() {
    val input = listOf(100,80,60,70,60,75,85)
    println("Stock span: ${input.stockSpan()}")
}

/**
 * The stock span problem is a financial problem where we have a series of n daily 
 * price quotes for a stock and we need to calculate span of stock’s price for all n days.
 * 
 * The span Si of the stock’s price on a given day i is defined as the maximum 
 * number of consecutive days just before the given day, for which the price of the 
 * stock on the current day is less than or equal to its price on the given day.
 * 
 * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, 
 * then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 */
fun List<Int>.stockSpan(): List<Int> {
    val result = arrayListOf<Int>()
    val stack = Stack<Pair<Int, Int>>()
    for(i in 0..lastIndex) {
        val index = when {
            stack.isEmpty() -> -1
            stack.peek().first > get(i) -> stack.peek().second
            else -> {
                while(stack.isNotEmpty() && stack.peek().first < get(i))
                    stack.pop()
                
                if(stack.isEmpty()) -1 else stack.peek().second
            }
        }
        result.add(index)
        stack.push(Pair(get(i), i))
    }

    for(i in 0..lastIndex) {
        result[i] = i - result[i]
    }

    return result
}