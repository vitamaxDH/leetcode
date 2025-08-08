package top_150;

public class _6_zigzag_conversion {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder();
        }
        var extraNumOfRowsOver3 = numRows - 3;
        var betweenCharNum = 3 + (2 * extraNumOfRowsOver3);
        int hopSize = betweenCharNum + 1;

        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                for (int j = 0; j < s.length(); j += hopSize) {
                    sbs[0].append(s.charAt(j));
                }
            } else if (i == numRows - 1) {
                for (int j = hopSize / 2; j < s.length(); j += hopSize) {
                    sbs[i].append(s.charAt(j));
                }
            } else {
                for (int j = 0; j < s.length(); j += hopSize) {
                    var sb = sbs[i];
                    if (j + i < s.length()) {
                        sb.append(s.charAt(j + i));
                    }
                    if (j + hopSize - i < s.length()) {
                        sb.append(s.charAt(j + hopSize - i));
                    }
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (var sb : sbs) {
            res.append(sb);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        var s = new _6_zigzag_conversion();
        System.out.println(s.convert("PAYPALISHIRING", 3));
        System.out.println(s.convert("PAYPALISHIRING", 4));
    }
}
