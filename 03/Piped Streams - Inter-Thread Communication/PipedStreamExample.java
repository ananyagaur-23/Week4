import java.io.*;
public class PipedStreamExample{
    public static void main(String[] args){
        try{
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);
            Thread writerThread = new Thread(()->{
               try(pos){
                   String message = "Hello from Writer Thread!";
                   pos.write(message.getBytes());
                   System.out.println("Writer: Message sent");
               }
               catch(IOException e){
                   System.out.println("Writer Error: "+e.getMessage());
               }
            });
            Thread readerThread = new Thread(()->{
                try(pis){
                    byte[] buffer = new byte[1024];
                    int length = pis.read(buffer);
                    String received = new String(buffer,0,length);
                    System.out.println("Reader: Message received - "+received);
                }
                catch(IOException e){
                    System.out.println("Reader Error: "+e.getMessage());
                }
            });
            writerThread.start();
            readerThread.start();
            writerThread.join();
            readerThread.join();
        }
        catch (IOException | InterruptedException e){
            System.out.println("main Error: "+e.getMessage());
        }
    }
}
