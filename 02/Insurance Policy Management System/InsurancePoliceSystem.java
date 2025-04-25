import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

class Policy implements Comparable<Policy> {
    String policyNumber;
    String policyHolderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate, String coverageType, double premiumAmount){
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }
    public String toString(){
        return policyNumber+" - "+policyHolderName+" - "+expiryDate+" - "+coverageType+" - $ "+premiumAmount;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Policy)) return false;
        Policy p = (Policy) o;
        return this.policyNumber.equals(p.policyNumber);
    }

    public int hashCode() {
        return policyNumber.hashCode();
    }

    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }
}

public class InsurancePoliceSystem {
    static Set<Policy> hashSet = new HashSet<>();
    static Set<Policy> linkedHashSet = new LinkedHashSet<>();
    static Set<Policy> treeSet = new TreeSet<>();
    static List<Policy> allPolicies = new ArrayList<>();

    public static void main(String[] args) {
        addSamplePolicies();

        System.out.println("\n--- All Unique Policies (HashSet) ---");
        printSet(hashSet);

        System.out.println("\n--- Insertion Order (LinkedHashSet) ---");
        printSet(linkedHashSet);

        System.out.println("\n--- Sorted by Expiry Date (TreeSet) ---");
        printSet(treeSet);

        System.out.println("\n--- Policies Expiring Soon (Within 30 Days) ---");
        printExpiringSoon();

        System.out.println("\n--- Policies with Coverage Type: 'Auto' ---");
        printByCoverageType("Auto");

        System.out.println("\n--- Duplicate Policies (by Policy Number) ---");
        printDuplicates();
    }

    static void addSamplePolicies() {
        addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Auto", 12000));
        addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Health", 15000));
        addPolicy(new Policy("P003", "Charlie", LocalDate.now().plusDays(25), "Home", 11000));
        addPolicy(new Policy("P004", "David", LocalDate.now().plusDays(5), "Auto", 13000));
        addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Health", 15000)); // duplicate

        allPolicies.addAll(Arrays.asList(
                new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Auto", 12000),
                new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Health", 15000),
                new Policy("P003", "Charlie", LocalDate.now().plusDays(25), "Home", 11000),
                new Policy("P004", "David", LocalDate.now().plusDays(5), "Auto", 13000),
                new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Health", 15000) // duplicate
        ));
    }
    static void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    static void printSet(Set<Policy> set) {
        for (Policy p : set) {
            System.out.println(p);
        }
    }

    static void printExpiringSoon() {
        LocalDate now = LocalDate.now();
        for (Policy p : treeSet) {
            long daysBetween = ChronoUnit.DAYS.between(now, p.expiryDate);
            if (daysBetween >= 0 && daysBetween <= 30) {
                System.out.println(p);
            }
        }
    }

    static void printByCoverageType(String type) {
        for (Policy p : hashSet) {
            if (p.coverageType.equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    static void printDuplicates() {
        Set<String> seen = new HashSet<>();
        Set<String> duplicates = new HashSet<>();

        for (Policy p : allPolicies) {
            if (!seen.add(p.policyNumber)) {
                duplicates.add(p.policyNumber);
            }
        }

        for (Policy p : allPolicies) {
            if (duplicates.contains(p.policyNumber)) {
                System.out.println(p);
            }
        }
    }
}