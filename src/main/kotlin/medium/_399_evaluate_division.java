package medium;

import java.util.Arrays;
import java.util.List;

public class _399_evaluate_division {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        return null;
    }

    public static void main(String[] args) {
        var s = new _399_evaluate_division();
        System.out.println(Arrays.toString(
            s.calcEquation(
                    List.of(
                            List.of("a", "b"),
                            List.of("b", "c")
                    ),
                    new double[]{2.0, 3.0},
                    List.of(
                            List.of("a", "c"),
                            List.of("b", "a"),
                            List.of("a", "e"),
                            List.of("a", "a"),
                            List.of("x", "x")
                    )
                )
            )
        );
    }
}
