import java.util.*;
class Patient implements Comparable<Patient>{
    String name;
    int severity;
    Patient(String name, int severity){
        this.name = name;
        this.severity = severity;
    }
    public int compareTo(Patient other){
        return Integer.compare(other.severity, this.severity);
    }
    public String toString(){
        return name+"\nSeverity: "+severity;
    }
}

public class HospitalTriageSystem{
    public static void main(String[] args){
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>();
        triageQueue.add(new Patient("Alex",5));
        triageQueue.add(new Patient("Haley",2));
        triageQueue.add(new Patient("Luke",3));

        System.out.println("Treatment Order:");
        while(!triageQueue.isEmpty()){
            System.out.println(triageQueue.poll());
        }
    }
}
