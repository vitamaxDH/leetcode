package top_150;

public class _13_romanto_integer {
    public int romanToInt(String s) {
        var res = 0;
        var size = s.length();
        for (var i = 0; i < size; i++) {
            var c = s.charAt(i);
            int nextIdx = i + 1;
            switch (c) {
                case 'I':
                    if (nextIdx < size && s.charAt(nextIdx) == 'V') {
                        i++;
                        res += 4;
                    } else if (nextIdx < size && s.charAt(nextIdx) == 'X') {
                        i++;
                        res += 9;
                    } else {
                        res += 1;
                    }
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    if (nextIdx < size && s.charAt(nextIdx) == 'L') {
                        res += 40;
                        i++;
                    } else if (nextIdx < size && s.charAt(nextIdx) == 'C') {
                        res += 90;
                        i++;
                    } else {
                        res += 10;
                    }
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    if (nextIdx < size && s.charAt(nextIdx) == 'D') {
                        res += 400;
                        i++;
                    } else if (nextIdx < size && s.charAt(nextIdx) == 'M') {
                        res += 900;
                        i++;
                    } else {
                        res += 100;
                    }
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        var s = new _13_romanto_integer();
//        System.out.println(s.romanToInt("III"));
//        System.out.println(s.romanToInt("LVIII"));
//        System.out.println(s.romanToInt("MCMXCIV"));
        System.out.println(s.romanToInt("DCXXI"));
    }
}
