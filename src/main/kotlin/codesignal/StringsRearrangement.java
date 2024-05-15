package codesignal;

import java.util.Arrays;

public class StringsRearrangement {
    boolean solution(String[] inputArray) {
        Arrays.sort(inputArray);

        for (int i = 1; i < inputArray.length; i++) {
            String s1 = inputArray[i];
            String s2 = inputArray[i - 1];
            int cnt = 0;
            for (int j = 0; j < s1.length(); j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    cnt++;
                }
            }
            if (cnt != 1) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        var s = new StringsRearrangement();
//        System.out.println(s.solution(new String[]{"aba", "bbb", "bab"}));
//        System.out.println(s.solution(new String[]{"q", "q"}));
        System.out.println(s.solution(new String[]{"abc",
                "abx",
                "axx",
                "abx",
                "abc"}));
    }
}
