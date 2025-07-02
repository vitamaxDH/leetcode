from typing import List

def kidsWithCandies(candies: List[int], extraCandies: int) -> List[bool]:
    max_candy = max(candies)
    result: List[bool] = []
    return [candy + extraCandies >= max_candy for candy in candies]


if __name__ == "__main__":
    print(kidsWithCandies([2,3,5,1,3], 3))
    