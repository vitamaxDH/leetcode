package designguru.designguru_grokking_the_coding_interview_patterns_for_coding_questions.two_pointers;

public class SquaringASortedArray {
    public static int[] makeSquares(int[] arr) {
        int n = arr.length;
        int[] squares = new int[n];
        int left = 0;
        int right = arr.length - 1;
        int squaresIdx = squares.length - 1;
        while (left < right) {
            int leftNum = arr[left] * arr[left];
            int rightNum = arr[right] * arr[right];
            if (leftNum > rightNum) {
                squares[squaresIdx--] = leftNum;
                left++;
            } else {
                squares[squaresIdx--] = rightNum;
                right--;
            }
        }
        return squares;
    }

    public static void main(String[] args) {
        int[] result = SquaringASortedArray.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();

        result = SquaringASortedArray.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
