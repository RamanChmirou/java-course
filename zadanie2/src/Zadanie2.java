import java.util.Scanner;

public class Zadanie2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//      Zadanie 1
        System.out.println("Podaj długość i szerokość prostokonta(9,14)");
        String answer = s.nextLine().replaceAll(" ", "");
        int a = Integer.parseInt(answer.split(",")[0]);
        int b = Integer.parseInt(answer.split(",")[1]);
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
//      Zadanie 2
        System.out.println("Podaj wysokość piramidy");
        int h = s.nextInt();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < h - i - 1; j++) {
                System.out.print(' ');
            }
            for (int l = 0; l < i * 2 + 1; l++) {
                System.out.print('*');
            }
            for (int k = 0; k < h - i - 1; k++) {
                System.out.print(' ');
            }
            System.out.println();
        }
//      Zadanie 3
        int [][] matrix = new int[3][3];
        int number = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = ++number;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
