package topic.graph;

import java.util.Arrays;

public class _684_redundant_connection {

    public int[] findRedundantConnection(int[][] edges) {
        return null;
    }

    public static void main(String[] args) {
        var s = new _684_redundant_connection();
        var res1 = s.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}});
        System.out.println(Arrays.toString(res1));
        var res2 = s.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}});
        System.out.println(Arrays.toString(res2));
    }
}
