from typing import (
    Any,
    Optional,
    Union,
    List,
    Dict,
    Tuple,
    Set,
    FrozenSet,
    Iterable,
    Iterator,
    Generator,
    Callable,
    Type,
    TypeVar,
    Generic,
    Sequence,
    Mapping,
    Literal
)


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        nums.reverse()
        k = k % len(nums)
        self._rotate(nums, 0, k - 1)
        self._rotate(nums, k, len(nums) - 1)
        
    def _rotate(self, nums: List[int], start: int, end: int)-> None:
        while start < end:
            temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            start += 1
            end -= 1

if __name__ == "__main__":
    s = Solution()
    nums = [1,2,3,4,5,6,7]
    print(f'{s.rotate(nums, 3) = }')
    print(f'{nums = }')
    nums = [-1,-100,3,99]
    print(f'{s.rotate(nums, 2) = }')
    print(f'{nums = }')
    nums = [-1]
    print(f'{s.rotate(nums, 2) = }')
    print(f'{nums = }')
    