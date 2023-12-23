import java.io.IOException;

public class FileWriterUtil {
    private String fileName;

    public FileWriterUtil(String fileName) {
        this.fileName = fileName;
    }

    public void writeToFile(String result) {
        try (java.io.FileWriter writer = new java.io.FileWriter(fileName, true)) {
            writer.write(result + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}