package problem;
import java.io.IOException;

class DataProcessor {
    public void processData(String data) throws IOException {
        if (data == null) {
            throw new NullPointerException("Data is null");
        }
        if (data.isEmpty()) {
            throw new IOException("Data is empty"); 
        }
        System.out.println("Processing data: " + data);
    }
}

public class DataApp {
    public static void main(String[] args) {
        DataProcessor processor = new DataProcessor();

        String inputData = "";
        try {
            processor.processData(inputData);
        } catch (IOException e) {
            System.out.println("Checked Exception: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Unchecked Exception: " + e.getMessage());
        }
    }
}
