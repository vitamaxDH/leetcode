package top_150;

import java.util.ArrayList;
import java.util.List;

public class _68_text_justification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        List<String> wordList = new ArrayList<>();
        for (var word : words) {
            wordList.add(word);
            var minWidth = getMinWidth(wordList);

            // too long,
            if (minWidth > maxWidth) {
                // remove curr
                wordList.removeLast();
                minWidth = getMinWidth(wordList);
                StringBuilder sb = new StringBuilder();
                var extraSpaceToDistribute = maxWidth - minWidth;
                int numOfSpaces = wordList.size() - 1;
                if (numOfSpaces == 0) {
                    res.add(String.format("%-" + maxWidth + "s", wordList.getFirst()));
                } else {
                    var spaceToAll = extraSpaceToDistribute / numOfSpaces + 1; // + 1 is already included into the min width
                    var idxForExtraSpace = extraSpaceToDistribute % numOfSpaces;
                    for (int j = 0; j < numOfSpaces; j++) {
                        sb.append(wordList.get(j));
                        var space = spaceToAll;
                        if (j < idxForExtraSpace) {
                            space++;
                        }
                        sb.append(" ".repeat(space));
                    }
                    sb.append(wordList.getLast());
                    res.add(sb.toString());
                }
                wordList.clear();
                wordList.add(word);
            }
        }

        if (!wordList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < wordList.size() - 1; i++) {
                sb.append(wordList.get(i));
                sb.append(" ");
            }
            sb.append(wordList.getLast());
            res.add(String.format("%-" + maxWidth + "s", sb));
        }
        return res;
    }

    private int getMinWidth(List<String> words) {
        int size = words.size() - 1; // words.size() - 1, minimum space size
        for (var word: words) {
            size += word.length();
        }
        return size;
    }

//    public List<String> fullJustify2(String[] words, int maxWidth) {
//        var res = new ArrayList<String>();
//        List<List<String>> wordEachLine = new ArrayList<>();
//        for (int i = 0; i < words.length; i++) {
//            var wordsForLine = new ArrayList<String>();
//            var size = 0;
//            while (i < words.length && size + words[i].length() < maxWidth) {
//                wordsForLine.add(words[i]);
//                size += words[i].length() + 1;
//                i++;
//            }
//            i--;
//            size--;
//            wordEachLine.add(wordsForLine);
//
//        }
//
//        for (int i = 0; i < wordEachLine.size() - 1; i++) {
//            var wordsForLine = wordEachLine.get(i);
//            int spaceNum = wordsForLine.size() - 1;
//            if (spaceNum == 0) {
//                res.add(String.format("%-" + maxWidth + "s", wordsForLine.getFirst()));
//            } else {
//                var spaceToDistribute = maxWidth - size;
//                var baseSpace = spaceToDistribute / spaceNum + 1; // min 1 since it is guaranteed.
//                var numLeftAligned = spaceToDistribute % spaceNum;
//                StringBuilder sb = new StringBuilder();
//                for (int j = 0; j < wordsForLine.size() - 1; j++) {
//                    sb.append(wordsForLine.get(j));
//                    if (j < numLeftAligned) {
//                        sb.append(" ".repeat(baseSpace + 1));
//                    } else {
//                        sb.append(" ".repeat(baseSpace));
//                    }
//                }
//                sb.append(wordsForLine.getLast());
//                res.add(sb.toString());
//            }
//        }
//
//        return res;
//    }

    public static void main(String[] args) {
        var s = new _68_text_justification();
//        var res1 = s.fullJustify2(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16);
//        for (var word: res1) {
//            System.out.printf("\"%s\"\n", word);
//        }
        var res2 = s.fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"}, 16);
        for (var word: res2) {
            System.out.printf("\"%s\"\n", word);
        }
//        var res3 = s.fullJustify2(new String[]{"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"}, 20);
//        for (var word: res3) {
//            System.out.printf("\"%s\"\n", word);
//        }
//        var res4 = s.fullJustify(new String[]{"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"}, 16);
//        for (var word: res4) {
//            System.out.printf("\"%s\"\n", word);
//        }
    }
}

//"This    is    an",
//"example  of text",
//"justification.  "
