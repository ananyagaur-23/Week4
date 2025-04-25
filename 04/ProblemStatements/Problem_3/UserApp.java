package problem;
import java.util.*;

class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String message) {
        super(message);
    }
}

class UserNotFoundException extends Exception {
    public UserNotFoundException(String message) {
        super(message);
    }
}

class UserService {
    private Set<String> users = new HashSet<>();

    public void registerUser(String username) throws UserAlreadyExistsException {
        if (users.contains(username)) {
            throw new UserAlreadyExistsException("User already exists: " + username);
        }
        users.add(username);
        System.out.println("User registered successfully: " + username);
    }

    public void checkUserExistence(String username) throws UserNotFoundException {
        if (!users.contains(username)) {
            throw new UserNotFoundException("User not found: " + username);
        }
        System.out.println("User exists in the system: " + username);
    }
}

public class UserApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserService service = new UserService();

        System.out.print("Enter username to register: ");
        String username = sc.nextLine();

        try {
            service.registerUser(username);
        } catch (UserAlreadyExistsException e) {
            System.out.println("Registration failed: " + e.getMessage());
        }

        System.out.print("Enter username to check existence: ");
        String checkUser = sc.nextLine();

        try {
            service.checkUserExistence(checkUser);
        } catch (UserNotFoundException e) {
            System.out.println("Check failed: " + e.getMessage());
        }
    }
}
