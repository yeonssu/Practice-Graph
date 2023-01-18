import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
    public static void main(String[] args) {
        int result = connectedVertices(new int[][]{
                {0, 1},
                {2, 3},
                {4, 5},
        });
        System.out.println(result); // 3
        int result2 = connectedVertices(new int[][]{
                {0, 1},
                {2, 3},
                {3, 4},
                {3, 5},
        });
        System.out.println(result2); // 2
    }
    public static int connectedVertices(int[][] edges) {
        //노드 최댓값 찾기
        int max = 0;
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                if (edges[i][j] > max) max = edges[i][j];
            }
        }
        //인접행렬로 표현
        int[][] matrix = new int[max + 1][max + 1];
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                int start = edges[i][0];
                int end = edges[i][1];

                matrix[start][end] = 1;
                matrix[end][start] = 1;
            }
        }

        //bfs
        int count = 0;
        boolean[] result = new boolean[max + 1];
        for (int i = 0; i < matrix.length; i++) {
            if (result[i]==false) {
                boolean[] visited = new boolean[matrix.length];
                Queue<Integer> queue = new LinkedList<>();
                visited[i] = true;
                queue.add(i);
                result[i] = true;

                while (!queue.isEmpty()) {
                    int num = queue.poll();

                    for (int j = 0; j < matrix[num].length; j++) {
                        if (matrix[num][j] == 1 && !visited[j]) {
                            queue.add(j);
                            result[j] = true;
                            visited[j] = true;
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}
