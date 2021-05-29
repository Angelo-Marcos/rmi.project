import java.rmi.registry.*;
import java.util.Scanner;

/**
 *
 * @author Angelo
 */
public class CalculadoraClient {

    public static void main(String[] args) {
        try {
            // Procura o registro do RMI no Servidor
            // Se o servidor estiver em outro host basta substituir pelo seu IP
            Registry registry = LocateRegistry.getRegistry("localhost");

            // Procura a stub do servidor
            Calculadora stub = (Calculadora) registry.lookup("Servidor");

            // Chama o método do servidor e imprime a mensagem
            System.out.println("Invocando metodo do servidor");
            Scanner sc = new Scanner(System.in);
            int op;
            float a, b;
            do {
                System.out.print("\n-----Calculadora-----"
                        + "\n-----MENU-----"
                        + "\n(1) Adicao"
                        + "\n(2) Subtracao"
                        + "\n(3) Multiplicacao"
                        + "\n(4) Divisao"
                        + "\n(5) SAIR \nEscolha: ");
                op = sc.nextInt();

                switch (op) {
                    case 1:
                        System.out.print("Digite o primeiro numero: ");
                        a = sc.nextFloat();
                        System.out.print("Digite o segundo numero: ");
                        b = sc.nextFloat();
                        System.out.print("\nA soma e igual a " + stub.add(a, b) + "\n");
                        break;

                    case 2:
                        System.out.print("Digite o primeiro numero: ");
                        a = sc.nextFloat();
                        System.out.print("Digite o segundo numero: ");
                        b = sc.nextFloat();
                        System.out.print("\nA subtracao e igual a " + stub.sub(a, b) + "\n");
                        break;

                    case 3:
                        System.out.print("Digite o primeiro numero: ");
                        a = sc.nextFloat();
                        System.out.print("Digite o segundo numero: ");
                        b = sc.nextFloat();
                        System.out.print("\nA multiplicacao e igual a " + stub.mul(a, b) + "\n");
                        break;

                    case 4:
                        System.out.print("Digite o primeiro numero: ");
                        a = sc.nextFloat();
                        System.out.print("Digite o segundo numero: ");
                        b = sc.nextFloat();
                        System.out.print("\nA divisao e igual a " + stub.div(a, b) + "\n");
                        break;

                    case 5:
                        System.exit(0);
                        break;
                }
            } while (op != 5);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
