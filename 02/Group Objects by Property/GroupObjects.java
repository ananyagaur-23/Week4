import java.util.*;
class Employee{
    private String name;
    private String department;
    Employee(String name, String department){
        this.name = name;
        this.department = department;
    }
    public String getName(){
        return name;
    }
    public String getDepartment(){
        return department;
    }
}

public class GroupObjects{
    public static void main (String[] args){
        List<Employee> employees = Arrays.asList(
                new Employee("Alex","IT"),
                new Employee("Haley","HR"),
                new Employee("Manny","IT"),
                new Employee("Luke","Finance")
                );
        Map<String, List<Employee>> departmentMap = new HashMap<>();
        for(Employee e : employees){
            departmentMap.putIfAbsent(e.getDepartment(), new ArrayList<>());
            departmentMap.get(e.getDepartment()).add(e);
        }
        for(Map.Entry<String, List<Employee>> entry : departmentMap.entrySet()){
            System.out.println(entry.getKey()+": ");
            for(Employee emp : entry.getValue()){
                System.out.println(emp.getName()+" ");
            }
            System.out.println();
        }
    }
}
