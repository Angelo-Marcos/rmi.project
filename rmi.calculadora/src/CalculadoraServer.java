import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

/**
 *
 * @author Angelo
 */
public class CalculadoraServer implements Calculadora{
    public CalculadoraServer() throws java.rmi.RemoteException {
        super();
    }

    public static void main(String[] args) {
        try {
            CalculadoraServer server = new CalculadoraServer();
            //Exporta o server para o stub ("apendice ou toco") do RMI na porta 0
            Calculadora stub = (Calculadora) UnicastRemoteObject.exportObject(server, 0);

            Registry registry = LocateRegistry.getRegistry();
            // Registra a stub no RMI para que ela seja obtida pelos clientes
            registry.bind("Servidor", stub);

            System.out.println("Servidor inicializado com sucesso.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String calculadora() throws RemoteException {
        System.out.println("Executando metodo neste host");
        return "Ola!!!! Consegui executar o metodo remoto!!!";
    }

    public float add(float a, float b)
            throws java.rmi.RemoteException {
        System.out.println("Executando metodo neste host");
        return a + b;
    }

    public float sub(float a, float b)
            throws java.rmi.RemoteException {
        System.out.println("Executando metodo neste host");
        return a - b;
    }

    public float mul(float a, float b)
            throws java.rmi.RemoteException {
        System.out.println("Executando metodo neste host");
        return a * b;
    }

    public float div(float a, float b)
            throws java.rmi.RemoteException {
        System.out.println("Executando metodo neste host");
        return a / b;
    }
}
