package medium

import common.TreeNode

class _654_maximum_binary_tree {
    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        fun walk(left: Int, right: Int): TreeNode? {
            if (left > right) return null
            val newNums = nums.sliceArray(left..right)
            val maxIdx = nums.indexOf(newNums.max())
            return with(TreeNode(nums[maxIdx])) {
                this.left = walk(left, maxIdx - 1)
                this.right = walk(maxIdx + 1, right)
                this
            }
        }

        return walk(0, nums.lastIndex)
    }
}

fun main() {
    with(_654_maximum_binary_tree()) {
        constructMaximumBinaryTree(intArrayOf(3,2,1,6,0,5))?.printTree()
        constructMaximumBinaryTree(intArrayOf(3,2,1))?.printTree()
    }
}
