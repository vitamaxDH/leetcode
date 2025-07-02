def mergeAlternately(word1: str, word2: str) -> str:
    len1 = len(word1)
    len2 = len(word2)
    long_idx = max(len1, len2)
    res = ""
    for i in range(long_idx):
        if i < len1:
            res += word1[i]
        if i < len2:
            res += word2[i]
    return res
    
    
if __name__ == "__main__":
    res= mergeAlternately("abc", "pqr")
    print(f"res {res}")