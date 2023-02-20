package data.stack.NextLargest
 
import java.util.*

fun main() {
    val input = listOf(1,3,2,4)
    println("Next Largest to Right: ${input.nextLargerToRight()}")
    println("Next Largest to Left: ${input.nextLargerToLeft()}")
}

/**
 * Given an array of integers, find the closest (not considering distance, but value) greater 
 * on right of every element. 
 * 
 * If an element has no greater on the left side, print -1 
 */
fun List<Int>.nextLargerToRight(): List<Int> {
    val result = arrayListOf<Int>()
    val stack = Stack<Int>()
    var current: Int
    for(i in lastIndex downTo 0) {
        current = get(i)
        if(stack.isEmpty())
            result.add(-1)
        else if(stack.peek() > current)
            result.add(stack.peek())
        else {
            while(stack.isNotEmpty() && stack.peek() < current) {
                stack.pop()
            }
            result.add(if(stack.isEmpty()) -1 else stack.peek())
        }
        stack.push(current)
    }
    result.reverse()
    return result
}


/**
 * Given an array of integers, find the closest (not considering distance, but value) greater 
 * on left of every element. 
 * 
 * If an element has no greater on the left side, print -1 
 */
fun List<Int>.nextLargerToLeft(): List<Int> {
    val result = arrayListOf<Int>()
    val stack = Stack<Int>()
    var current: Int
    for(i in 0..lastIndex) {
        current = get(i)
        if(stack.isEmpty())
            result.add(-1)
        else if(stack.peek() > current)
            result.add(stack.peek())
        else {
            while(stack.isNotEmpty() && stack.peek() < current) {
                stack.pop()
            }
            result.add(if(stack.isEmpty()) -1 else stack.peek())
        }
        stack.push(current)
    }
    return result
}