package problem;

public class TransactionApp {
	public static void main(String[] args) {
		TransactionProcessor processor = new TransactionProcessor();
		String userId = "UserABC";
		double amount = -10000;
		try {
			processor.processTransaction(userId, amount);
		}
		catch(TransactionException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}
