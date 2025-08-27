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
    def maxProfit(self, prices: List[int]) -> int:
        prev = prices[0]
        profit = 0
        for price in range(1, len(prices)):
            if prev < price:
                profit += price - prev
            prev = price
        return profit

if __name__ == "__main__":
    s = Solution()
    print(f'{s.maxProfit([7,1,5,3,6,4]) = }')
    print(f'{s.maxProfit([1,2,3,4,5]) = }')
    print(f'{s.maxProfit([7,6,4,3,1]) = }')
    