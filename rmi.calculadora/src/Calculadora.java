import java.rmi.*;
/**
 *
 * @author Angelo
 */
public interface Calculadora extends Remote {
    public String calculadora() throws RemoteException;

    public float add(float a, float b)
            throws java.rmi.RemoteException;

    public float sub(float a, float b)
            throws java.rmi.RemoteException;

    public float mul(float a, float b)
            throws java.rmi.RemoteException;

    public float div(float a, float b)
            throws java.rmi.RemoteException;
}
