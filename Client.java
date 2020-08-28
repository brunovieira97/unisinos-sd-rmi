import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	
	private Client() {}

	public static void main(String args[]) {
		try {
			Registry registry = LocateRegistry.getRegistry(8080);
			Hello stub = (Hello) registry.lookup("Hello");
			String response = stub.sayHello();
			
			System.out.println("Response: " + response);
		} catch (Exception exception) {
			System.err.println("Client exception: " + exception.toString());
			exception.printStackTrace();
		}
	}
}