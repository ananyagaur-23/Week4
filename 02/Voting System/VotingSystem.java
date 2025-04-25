import java.util.*;
public class VotingSystem{
    public static void main(String[] args){
        HashMap<String, Integer> votes = new HashMap<>();
        votes.put("Alex",3);
        votes.put("Haley",3);
        votes.put("Luke",2);

        LinkedHashMap<String, Integer> orderedVotes =  new LinkedHashMap<>();
        orderedVotes.put("Alex",3);
        orderedVotes.put("Haley",5);
        orderedVotes.put("Luke",2);

        TreeMap<String,Integer> sortedVotes = new TreeMap<>(votes);
        System.out.println("Votes (HashMap): "+votes);
        System.out.println("Order of Voting (LinkedHashmap): "+orderedVotes);
        System.out.println("Sorted by Candidate name (Treemap): "+sortedVotes);
    }
}
