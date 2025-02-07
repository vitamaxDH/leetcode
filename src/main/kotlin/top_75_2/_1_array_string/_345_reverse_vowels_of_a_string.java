package top_75_2._1_array_string;

public class _345_reverse_vowels_of_a_string {
    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] chars = s.toCharArray();
        while (l < r) {
            while (l < r && !isVowel(chars[l])){
                l++;
            }
            while (l < r && !isVowel(chars[r])){
                r--;
            }
            if (l >= r) {
                break;
            }
            int temp = chars[l];
            chars[l] = chars[r];
            chars[r] = (char) temp;
            l++;
            r--;
        }
        return new String(chars);
    }

    public boolean isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> true;
            default -> false;
        };
    }

    public static void main(String[] args) {
        _345_reverse_vowels_of_a_string test = new _345_reverse_vowels_of_a_string();
        System.out.println(test.reverseVowels("IceCreAm"));
        System.out.println(test.reverseVowels("leetcode"));
    }
}
