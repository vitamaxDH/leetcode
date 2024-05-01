package top_75;

public class _443_string_compression {
    public int compress(char[] chars) {
        if (chars.length == 1) return 1;
        int res = 0;
        char prev = chars[0];
        int curCnt = 1;
        int curPos = 0;
        for (int i = 1; i < chars.length; i++) {
            if (prev == chars[i]) {
                curCnt++;
                prev = chars[i];
            } else {
                // We need to add count to the result (res)
                chars[curPos++] = prev;
                if (curCnt == 1) {
                    res++;
                } else {
                    String curCntStr = String.valueOf(curCnt);
                    for (int j = 0; j < curCntStr.length(); j++) {
                        chars[curPos++] = curCntStr.charAt(j);
                    }
                    res += curCntStr.length() + 1;
                }
                prev = chars[i];
                curCnt = 1;
            }
        }

        chars[curPos++] = prev;
        if (curCnt == 1) {
            res++;
        } else {
            String curCntStr = String.valueOf(curCnt);
            for (int j = 0; j < curCntStr.length(); j++) {
                chars[curPos++] = curCntStr.charAt(j);
            }
            res += curCntStr.length() + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        var s = new _443_string_compression();
        System.out.println(s.compress(new char[]{'a','a','b','b','c','c','c'}));
        System.out.println(s.compress(new char[]{'a'}));
        System.out.println(s.compress(new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }
}
