import java.util.LinkedList;
import java.util.Queue;

public class LinkedComponent {
    public static void main(String[] args) {
        boolean result1 = getDirections(new int[][]
                        {
                                {0, 1, 0, 0},
                                {0, 0, 1, 0},
                                {0, 0, 0, 1},
                                {0, 1, 0, 0}
                        }, 0, 2
        );
        boolean result2 = getDirections(new int[][]
                        {
                                {0, 1, 0, 0, 0},
                                {0, 0, 0, 1, 0},
                                {0, 1, 0, 0, 0},
                                {0, 1, 1, 0, 0},
                                {1, 1, 1, 1, 0}
                        }, 1, 4
        );
        System.out.println(result1); // true
        System.out.println(result2); // false
    }
    public static boolean getDirections(int[][] matrix, int from, int to) {
        boolean[] visited = new boolean[matrix.length];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);
        visited[from] = true;

        while(!queue.isEmpty()){
            int num = queue.poll();
            if (num==to) return true;

            for (int i = 0; i < matrix[num].length; i++) {
                if(matrix[num][i]==1&&!visited[i]){ //
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }
        return false;

    }
}
