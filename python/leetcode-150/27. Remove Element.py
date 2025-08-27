from typing import List

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        cur_idx = 0
        for i, e in enumerate(nums):
            if e != val:
                nums[cur_idx] = e
                cur_idx += 1

        return cur_idx

if __name__ == "__main__":
    s = Solution()
    nums = [3,2,2,3]
    print(f'{s.removeElement(nums, 3) = }')
    nums = [0,1,2,2,3,0,4,2]
    print(f'{s.removeElement(nums, 2) = }')
