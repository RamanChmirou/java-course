import java.util.Scanner;

public class Kalkulator {
    public static void main(String[] args) {
        double liczba1;
        double liczba2;
        String operator;
        Double wynik = null;
        boolean nextStep = true;

        Scanner s = new Scanner(System.in);

        while (nextStep) {
            System.out.println("Podaj 1 liczbe");
            liczba1 = s.nextDouble();
            s.nextLine();
            System.out.println("Podaj operator");
            operator = s.nextLine();
            System.out.println("Podaj 2 liczbe");
            liczba2 = s.nextDouble();
            s.nextLine();

            wynik = switch (operator) {
                case "+" -> liczba1 + liczba2;
                case "-" -> liczba1 - liczba2;
                case "*" -> liczba1 * liczba2;
                case "/" -> {
                    if (liczba2 == 0) {
                        System.out.print("Liczba2 jest zerem, nie mozna dzielic przez zero.");
                        yield  null;
                    }
                    yield liczba1 / liczba2;
                }
                case "%" -> liczba1 % liczba2;
                case "^" -> Math.pow(liczba1, liczba2);
                default -> {
                    System.out.print("Podales zly operator.");
                    yield null;
                }
            };

            if (wynik == null) {
                System.out.println(" Spróbuj ponownie.");
                continue;
            }

            System.out.println(wynik);
            System.out.println("Chcesz kontynuowac?");
            nextStep = s.nextLine().equals("y");
        }

        System.out.println(wynik % 2 == 0 ? "Ostatni wynik jest parzysty" : "Ostatni wynik jest nieparzysty");

    }
}
