package easy

object _27_remove_element {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var lastNotToRemoveIndex = 0

        //let's scan each member of the original array
        nums.forEach {
            //did I find a target to remove? Then Skip!
            if (it == `val`) { return@forEach }

            //Not the target? then set it to the index of last not target
            //AKA squash to left
            nums[lastNotToRemoveIndex] = it

            //Update the last index of not target
            lastNotToRemoveIndex++

        }

        return lastNotToRemoveIndex
    }
}


fun main() {
    with(_27_remove_element) {
        println("removeElement: ${removeElement(intArrayOf(3,2,2,3), 3)}")
        println("removeElement: ${removeElement(intArrayOf(0,1,2,2,3,0,4,2), 2)}")
        println("removeElement: ${removeElement(intArrayOf(2), 3)}")
        println("removeElement: ${removeElement(intArrayOf(1), 1)}")
    }
}
