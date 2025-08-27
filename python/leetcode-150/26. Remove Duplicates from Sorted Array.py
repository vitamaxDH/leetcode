from os import curdir
from pydoc import safeimport
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
    Literal,
)


class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        cur_idx = 0
        prev_val = None
        for e in nums:
            if e == prev_val:
                continue
            else:
                nums[cur_idx] = e
                cur_idx += 1
                prev_val = e
        return cur_idx


if __name__ == "__main__":
    s = Solution()
    nums = [1,1,2]
    print(f'{s.removeDuplicates(nums) = }')
    print(f'{nums = }')
