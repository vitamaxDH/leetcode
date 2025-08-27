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
    def canJump(self, nums: List[int]) -> bool:
        gas = 0
        for n in nums:
            if gas < 0:
                return False
            if gas < n:
                gas = n
            gas -= 1
        return True
            
    
if __name__ == "__main__":
    s = Solution()
    print(f'{s.canJump([2,3,1,1,4]) = }')
    print(f'{s.canJump([3,2,1,0,4]) = }')