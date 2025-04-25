import java.io.*;
public class BufferedFileComparison{
    public static void copyUnbuffered(File source, File dest){
        try(FileInputStream fis = new FileInputStream(source);
            FileOutputStream fos = new FileOutputStream(dest)){

            byte[] buffer = new byte[4096];
            int bytesRead;
            long start = System.nanoTime();
            while((bytesRead = fis.read(buffer))!=-1){
                fos.write(buffer,0,bytesRead);
            }
            long end = System.nanoTime();
            System.out.println("Unbuffered Copy Time: "+(end-start)/1_000_000+" ms");
        }
        catch(IOException e){
            System.out.println("Error is unbuffered copy: "+ e.getMessage());
        }
    }
    public static void copyBuffered(File source, File dest){
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))){

            byte[] buffer = new byte[4096];
            int bytesRead;
            long start = System.nanoTime();
            while((bytesRead = bis.read(buffer))!=-1){
                bos.write(buffer,0,bytesRead);
            }
            long end = System.nanoTime();
            System.out.println("Buffered Copy Time: "+(end-start)/1_000_000+" ms");
        }
        catch(IOException e){
            System.out.println("Error in buffered copy: "+e.getMessage());
        }
    }
    public static void main(String[] args){
            File sourceFile = new File("largefile.txt");
            File unbufferedDest = new File("unbuffered_copy.txt");
            File bufferedDest = new File("buffered_copy.txt");

            System.out.println("Starting Unbuffered Copy...");
            copyUnbuffered(sourceFile, unbufferedDest);

            System.out.println("\nStarting Buffered Copy...");
            copyBuffered(sourceFile, bufferedDest);
    }
}
