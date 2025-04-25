import java.util.*;
import java.io.*;
import java.util.zip.InflaterOutputStream;

class Employee implements Serializable{
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department,double salary){
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public String toString(){
        return "ID: "+id+"\nName: "+name+"\nDept: "+department+"Salary: "+salary;
    }
}

public class EmployeeSerialization{
    public static void main(String[] args){
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,"Alex","HR",50000));
        employeeList.add(new Employee(2,"Luke","IT",60000));
        employeeList.add(new Employee(3,"Haley","Finance",55000));

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employee.dat"))){
            oos.writeObject(employeeList);
            System.out.println("Employees serialized to employee.dat");
        }
        catch(IOException e){
            System.out.println("Serialization error: "+e.getMessage());
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employee.dat"))){
            List<Employee> readList = (List<Employee>) ois.readObject();
            System.out.println("\nDeserialized Employees: ");
            for(Employee e :readList){
                System.out.println(e);
            }
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println("Deserialization error: "+e.getMessage());
        }
    }
}
