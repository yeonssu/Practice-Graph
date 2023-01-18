public class AdjacencyMatrix {
    public static void main(String[] args) {
        //{시작정점, 도착정점, 방향성(1은 양방향, 0은 무방향)}
        int[][] output1 = createMatrix(new int[][]{
                {0, 3, 0},
                {0, 2, 0},
                {1, 3, 0},
                {2, 1, 0},
        });
        int[][] output2 = createMatrix(new int[][]{
                {0, 2, 0},
                {2, 4, 1},
                {1, 3, 1},
                {2, 1, 0},
        });
        System.out.println(output1);
        System.out.println(output2);
    }

    public static int[][] createMatrix(int[][] edges) {
        int max = 0;
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                if(edges[i][j]>max) max = edges[i][j];
            }
        }
        int[][] matrix = new int[max+1][max+1];

        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                int start = edges[i][0];
                int end = edges[i][1];

                matrix[start][end] = 1;
                if(edges[i][2]==1) matrix[end][start] = 1;
            }
        }

        return matrix;
    }
}