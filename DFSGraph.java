import java.util.Scanner;

public class DFSGraph {
    
    // Глобальні змінні для зберігання матриці інцидентності, кількості вершин та ребер, а також масиву відвіданих вершин.
    static int[][] incidence;
    static boolean[] visited;
    static int n, m;
    
    // Рекурсивна функція DFS для обходу графу
    public static void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " "); // Виведення відвіданої вершини
        
        // Перевірка кожного ребра, чи є воно інцидентним до поточної вершини
        for (int j = 0; j < m; j++) {
            if (incidence[vertex][j] == 1) {
                // Для цього ребра знаходимо іншу вершину, до якої воно веде
                for (int i = 0; i < n; i++) {
                    // Шукаємо сусідню вершину: i ≠ vertex і incidence[i][j] == 1
                    if (i != vertex && incidence[i][j] == 1) {
                        if (!visited[i]) {
                            DFS(i); // Рекурсивний виклик для невідвіданої вершини
                        }
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Зчитування кількості вершин та ребер
        System.out.print("Введіть кількість вершин: ");
        n = scanner.nextInt();
        System.out.print("Введіть кількість ребер: ");
        m = scanner.nextInt();
        
        // Ініціалізація матриці інцидентності та масиву відвіданих вершин
        incidence = new int[n][m];
        visited = new boolean[n];
        
        // Зчитування матриці інцидентності
        System.out.println("Введіть матрицю інцидентності (рядки – вершини, колонки – ребра):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                incidence[i][j] = scanner.nextInt();
            }
        }
        
        // Зчитування початкової вершини для обходу
        System.out.print("Введіть початкову вершину для обходу (індекс від 0 до " + (n-1) + "): ");
        int start = scanner.nextInt();
        
        // Виконання обходу графу за допомогою DFS
        System.out.println("DFS обхід:");
        DFS(start);
        
        scanner.close();
    }
}
