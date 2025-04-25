package problem;

public class TransactionProcessor {
	public void processTransaction(String userId, double amount) throws TransactionException{
		try {
			if(amount<0) {
				throw new TransactionException("Negative transaction amount fro user: "+userId);
			}
			System.out.println("Transaction successful for user "+userId+": Amount "+amount);
		}
		catch(TransactionException e) {
			throw new TransactionException("Transaction failed for user "+userId+": "+e.getMessage());
		}
	}
}
