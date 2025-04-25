package problem;

class Connection {
    public void open() {
        System.out.println("Connection opened.");
    }

    public void close() {
        System.out.println("Connection closed.");
    }

    public void performOperation() {
        throw new RuntimeException("Operation failed during connection usage.");
    }
}

public class ConnectionApp {
    public static void main(String[] args) {
        Connection connection = new Connection();
        
        try {
            connection.open();
            connection.performOperation();
        } catch (RuntimeException e) {
            System.out.println("Exception caught: " + e.getMessage());
        } finally {
            connection.close();
        }
    }
}
