import random
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


class RandomizedSet:

    def __init__(self):
        self.arr = []
        self.pos = {}
        return
        

    def insert(self, val: int) -> bool:
        if val in self.pos:
            return False
        self.pos[val] = len(self.arr)
        self.arr.append(val)
        return True
            
    def remove(self, val: int) -> bool:
        if val not in self.pos:
            return False
        i = self.pos[val]
        last = self.arr[-1]
        self.arr[i] = last
        self.pos[last] = i
        
        self.arr.pop()
        del self.pos[val]
        return True
        

    def getRandom(self) -> int:
        return self.arr[random.randint(0, len(self.arr) - 1)]


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()

if __name__ == "__main__":
    s = RandomizedSet()
    