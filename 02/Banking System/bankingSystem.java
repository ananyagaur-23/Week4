import java.util.*;
public class bankingSystem{
    public static void main(String[] args){
        HashMap<String,Double> accounts = new HashMap<>();
        accounts.put("A101",1500.0);
        accounts.put("A102",900.0);
        accounts.put("A103",2000.0);

        TreeMap<String,Double> sortedAccounts = new TreeMap<>(accounts);
        Queue<String> withdrawalQueue = new LinkedList<>();
        withdrawalQueue.add("A102");
        withdrawalQueue.add("A101");

        System.out.println("Accounts (HashMap): " + accounts);
        System.out.println("Sorted Accounts by Account Number (TreeMap): " + sortedAccounts);
        System.out.println("Withdrawal Queue: " + withdrawalQueue);
    }
}
