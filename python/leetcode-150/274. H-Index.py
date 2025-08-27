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
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        citations.sort()

        for i,v in enumerate(citations):
            if n - i <= v:
                return n - i
        return 0
        

if __name__ == "__main__":
    s = Solution()
    print(f'{s.hIndex([3,0,6,1,5]) = }')
    print(f'{s.hIndex([1,3,1]) = }')
    print(f'{s.hIndex([0,0,2]) = }')
    
    