from typing import List


class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        fill_idx = len(nums1) - 1
        l = m - 1
        r = n - 1
        while fill_idx >= 0:
            if l >= 0 and r >= 0:
                if nums1[l] >= nums2[r]:
                    nums1[fill_idx] = nums1[l]
                    l -= 1
                else:
                    nums1[fill_idx] = nums2[r]
                    r -= 1
            elif l < 0:
                nums1[fill_idx] = nums2[r]
                r -= 1
            elif r <0:
                nums1[fill_idx] = nums1[l]
                l -= 1
            fill_idx -= 1


if __name__ == "__main__":
    s = Solution()
    nums1 = [1, 2, 3, 0, 0, 0]
    nums2 = [2, 5, 6]
    s.merge(nums1, 3, nums2, 3)
    print(nums1)
    print(nums2)

    nums1 = [0]
    nums2 = [1]
    s.merge(nums1, 0, nums2, 1)
    print(nums1)
    print(nums2)
