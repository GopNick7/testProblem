import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestProblem {

    private static int M;
    private static int N;
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(reader.readLine());
        N = Integer.parseInt(reader.readLine());

        floydWarshall(matrix);

    }

    // метод принимает массив описывающий корридоры
    private static int[][] arr(int arr[][]) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = arr[i][j];
            }
        }
        return matrix;
    }

    // логика алгоритма Флойда Маршала
    private static void floydWarshall(int graph[][]) {
        int dist[][] = new int[M][M];

        // копирую matrix в dist
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                dist[i][j] = graph[i][j];
            }
        }

        // сравниваем в цикле значения, складываю стоимость пути, и записываю в двумерный массив
        for (int k = 0; k < M; k++) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        shortPathMatrix(dist);
    }

    // метод вывода общей стоимости
    private static void shortPathMatrix(int dist[][]) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
}