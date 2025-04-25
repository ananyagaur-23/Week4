import java.util.*;
import java.time.LocalDate;
class Policy{
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;
    Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount){
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    public String toString(){
        return policyNumber+" | "+policyholderName+" | "+expiryDate+" | "+coverageType+" | "+premiumAmount;
    }
}

public class InsurancePolicySystem{
    Map<String, Policy> hashMap = new HashMap<>();
    Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
    TreeMap<LocalDate, List<Policy>> treeMap = new TreeMap<>();

    public void addPolicy(Policy policy){
        hashMap.put(policy.policyNumber, policy);
        linkedHashMap.put(policy.policyNumber, policy);
        treeMap.putIfAbsent(policy.expiryDate, new ArrayList<>());
        treeMap.get(policy.expiryDate).add(policy);
    }
    public Policy getPolicyByNumber(String number){
        return hashMap.get(number);
    }
    public List<Policy> getPoliciesExpiringSoon() {
        List<Policy> soon = new ArrayList<>();
        LocalDate now = LocalDate.now();
        LocalDate limit = now.plusDays(30);
        for (Map.Entry<LocalDate, List<Policy>> entry : treeMap.subMap(now, true, limit, true).entrySet()) {
            soon.addAll(entry.getValue());
        }
        return soon;
    }

    public List<Policy> getPoliciesByHolder(String name) {
        List<Policy> list = new ArrayList<>();
        for (Policy p : hashMap.values()) {
            if (p.policyholderName.equalsIgnoreCase(name)) {
                list.add(p);
            }
        }
        return list;
    }

    public void removeExpiredPolicies() {
        LocalDate now = LocalDate.now();
        Iterator<Map.Entry<String, Policy>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Policy> entry = iterator.next();
            if (entry.getValue().expiryDate.isBefore(now)) {
                iterator.remove();
                linkedHashMap.remove(entry.getKey());
            }
        }
        treeMap.headMap(now).clear();
    }

    public void printAll() {
        System.out.println("HashMap:");
        for (Policy p : hashMap.values()) System.out.println(p);
        System.out.println("\nLinkedHashMap:");
        for (Policy p : linkedHashMap.values()) System.out.println(p);
        System.out.println("\nTreeMap (by Expiry):");
        for (List<Policy> list : treeMap.values()) {
            for (Policy p : list) System.out.println(p);
        }
    }

    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();

        system.addPolicy(new Policy("P101", "Alice", LocalDate.now().plusDays(10), "Health", 5000));
        system.addPolicy(new Policy("P102", "Bob", LocalDate.now().plusDays(40), "Auto", 7000));
        system.addPolicy(new Policy("P103", "Alice", LocalDate.now().minusDays(5), "Home", 6000));
        system.addPolicy(new Policy("P104", "Carol", LocalDate.now().plusDays(25), "Auto", 7500));

        System.out.println("Retrieve P102:");
        System.out.println(system.getPolicyByNumber("P102"));

        System.out.println("\nPolicies expiring soon:");
        for (Policy p : system.getPoliciesExpiringSoon()) System.out.println(p);

        System.out.println("\nPolicies for Alice:");
        for (Policy p : system.getPoliciesByHolder("Alice")) System.out.println(p);

        System.out.println("\nRemoving expired policies...");
        system.removeExpiredPolicies();

        System.out.println("\nAll Policies After Removal:");
        system.printAll();
    }
}
