package data.stack.NextSmallest
 
import java.util.*

fun main() {
    val input = listOf(4,5,2,10,8)
    println("Next Smaller to Right: ${input.nextSmallerToRight()}")
    println("Next Smaller to Left: ${input.nextSmallerToLeft()}")
}

/**
 * Given an array of integers, find the closest (not considering distance, but value) 
 * smaller on left of every element. 
 * 
 * If an element has no smaller on the left side, print -1 
 */
fun List<Int>.nextSmallerToLeft(): List<Int> {
    val result = arrayListOf<Int>()
    val stack = Stack<Int>()
    forEach { number ->
        val value = when {
            stack.isEmpty() -> -1
            stack.peek() < number -> stack.peek()
            else -> {
                while(stack.isNotEmpty() && stack.peek() > number)
                    stack.pop()

                if(stack.isEmpty()) -1 else stack.peek()
            }
        }
        result.add(value)
        stack.push(number)
    }
    return result
}


/**
 * Given an array of integers, find the closest (not considering distance, but value) 
 * smaller on right of every element. 
 * 
 * If an element has no smaller on the left side, print -1 
 */
fun List<Int>.nextSmallerToRight(): List<Int> {
    val result = arrayListOf<Int>()
    val stack = Stack<Int>()
    var number: Int
    for(i in lastIndex downTo 0) {
        number = get(i)
        val value = when {
            stack.isEmpty() -> -1
            stack.peek() < number -> stack.peek()
            else -> {
                while(stack.isNotEmpty() && stack.peek() > number)
                    stack.pop()

                if(stack.isEmpty()) -1 else stack.peek()
            }
        }
        result.add(value)
        stack.push(number)
    }
    result.reverse()
    return result
}