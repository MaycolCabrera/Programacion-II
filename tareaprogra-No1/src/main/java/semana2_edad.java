import java.util.Scanner;
public class semana2_edad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce tu nombre");
        String nombre = scanner.nextLine();
        System.out.println("Introduce tu año de nacimiento");
        int añonacimiento = scanner.nextInt();
        int añoactual = 2025;
        int edad = añoactual - añonacimiento;
        System.out.println("Hola " + nombre + ", tu edad aproximada es : " + edad + "años.");
    }
}
