package example.hello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        System.out.println("Initiating client");

       String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry(host);
            System.out.println("Registry has been located");
            Hello stub = (Hello) registry.lookup("Hello");
            System.out.println("Found server");

            String response = stub.sayHello();
            System.out.println("Response: " + response);

            int soma = stub.soma(100, 1000);
            System.out.println("Response from soma: " + soma);

            int subtracao = stub.subtrai(50, 20);
            System.out.println("Response from subtrai: " + subtracao);

            String saudacao = stub.digaOlaPara("Pedro");
            System.out.println("Response from digaOlaPara: " + saudacao);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
