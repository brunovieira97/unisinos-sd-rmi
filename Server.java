import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello {
	
	public Server() {}

	public String sayHello() {
		return "Hello, friend";
	}

	public static void main(String args[]) throws RemoteException {
		try {
			Server server = new Server();
			Hello stub = (Hello) UnicastRemoteObject.exportObject(server, 0);

			Registry registry = LocateRegistry.createRegistry(8080);
			registry.bind("Hello", stub);

			System.err.println("Server ready.");
		} catch (Exception exception) {
			System.err.println("Server exception: " + exception.toString());
			exception.printStackTrace();
		}
	}
}