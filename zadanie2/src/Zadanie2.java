import java.util.Scanner;

public class Zadanie2 {
    private final static int MATRIX_SIZE = 3;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//      Zadanie 1
        System.out.println("Podaj długość i szerokość prostokonta(naprzykład: 9, 14)");
        String answer = s.nextLine().replaceAll(" ", "");
        int a = Integer.parseInt(answer.split(",")[0]);
        int b = Integer.parseInt(answer.split(",")[1]);
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
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
        int [][] matrix = new int[MATRIX_SIZE][MATRIX_SIZE];
        int number = 0;
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                matrix[i][j] = ++number;
            }
        }
        for (int i = 0; i < MATRIX_SIZE; i++) {
            for (int j = 0; j < MATRIX_SIZE; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
//      Zadanie 4
        System.out.println("Podaj długość i szerokość prostokonta(naprzykład: 9, 14)");
        s.nextLine();
        String answer2 = s.nextLine().replaceAll(" ", "");
        int a2 = Integer.parseInt(answer2.split(",")[0]);
        int b2 = Integer.parseInt(answer2.split(",")[1]);
        for (int i = 0; i < b2; i++) {
            if (i == 0 || i == b2 - 1) {
                for (int j = 0; j < a2; j++) {
                    System.out.print("*");
                }
            } else {
                System.out.print("*");
                for (int j = 0; j < a2 - 2; j++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
