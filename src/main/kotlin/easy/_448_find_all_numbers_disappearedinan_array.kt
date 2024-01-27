package easy

class _448_find_all_numbers_disappearedinan_array {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val result = mutableListOf<Int>()



        return result
    }

//    var dupNum = 0
//    var lastVal = 0
//    nums.forEachIndexed { index, n ->
//        if (index == 0 && n != 1) {
//            for (i in 1 ..< n) {
//                result.add(i)
//            }
//        }
//        if (index < nums.lastIndex) {
//            if (n == nums[index + 1]) {
//                dupNum++
//                lastVal = n
//            } else if (n + 1 == nums[index + 1]){
//                lastVal = n + 1
//            } else if (n + 1 < nums[index + 1]) {
//                for (i in n + 1..< nums[index + 1]) {
//                    dupNum--
//                    result.add(i)
//                    lastVal = nums[index + 1]
//                }
//            }
//        }
//    }
//    if (dupNum > 0) {
//        for (i in 1 .. dupNum) {
//            result.add(lastVal + i)
//        }
//    }
}
