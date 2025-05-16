package example.hello;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello {

    public Server() {}

    @Override
    public String sayHello() {
        return "Hello, world!";
    }

    @Override
    public int soma (int a, int b){
        return a + b;
    }

    @Override
    public int subtrai(int a, int b){
        return a - b;
    }

    @Override
    public String digaOlaPara(String nome){
        return "Olá, " + nome + "!";
    }

    public static void main(String args[]) {
        try {
            Server obj = new Server();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Hello", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}

