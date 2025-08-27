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
    def removeDuplicates(self, nums: List[int]) -> int:
        idx = 0
        pre_val = None
        dup = 0
        for e in nums:
            if pre_val == e:
                if dup < 2:
                    nums[idx] = e
                    idx += 1
                    dup += 1
            else:
                nums[idx]= e
                pre_val = e
                dup = 1
                idx += 1
        return idx
                    

if __name__ == "__main__":
    s = Solution()
    nums = [1,1,1,2,2,3]
    print(f'{s.removeDuplicates(nums) = }')
    print(f'{nums = }')
    