import java.io.*;
public class StudentDataStream{
    public static void main(String[] args){
        File file = new File("Student.dat");
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
            dos.writeInt(101);
            dos.writeUTF("Bob");
            dos.writeDouble(8.7);

            dos.writeInt(102);
            dos.writeUTF("Larry");
            dos.writeDouble(9.2);
            System.out.println("Student data written successfully.");
        }
        catch(IOException e){
            System.out.println("Error writing data: "+e.getMessage());
        }

        try(DataInputStream dis = new DataInputStream(new FileInputStream(file))){
            while (dis.available()>0){
                int roll = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("Roll: "+roll+"\nName: "+name+"\nGPA: "+gpa);
            }
        }
        catch(IOException e){
            System.out.println("Error reading data: "+e.getMessage());
        }
    }
}
