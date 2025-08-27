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
from collections import Counter


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        nums.sort()
        return nums[len(nums) // 2]
        
        # avg = len(nums) / 2
        # counter = Counter()
        # for e in nums:
        #     counter[e] += 1
        #     if counter[e] > avg:
        #         return e
        # return 1
            

if __name__ == "__main__":
    s = Solution()
    nums = [3,2,3]
    print(f'{s.majorityElement(nums) = }')
    