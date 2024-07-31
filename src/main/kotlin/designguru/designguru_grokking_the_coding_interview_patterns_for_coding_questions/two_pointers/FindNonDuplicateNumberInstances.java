package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.two_pointers;

public class FindNonDuplicateNumberInstances {
    public int moveElements(int[] arr) {
        int prev = arr[0];
        int size = 1;
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            if (prev != cur) {
                size++;
                prev = cur;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        FindNonDuplicateNumberInstances obj = new FindNonDuplicateNumberInstances();
        System.out.println(obj.moveElements(new int[] { 2, 3, 3, 3, 6, 9, 9 }));
        System.out.println(obj.moveElements(new int[] { 2, 2, 2, 11 }));
    }
}
