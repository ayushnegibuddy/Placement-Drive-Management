import java.io.*;
public class FileIOStreamsDemo
{
    public static void main(String[] args)
    {
        // Step 1: Write 3 lines to input.txt
        try (FileWriter fw = new FileWriter("input.txt"))
        {
            fw.write("Line 1: Hello File I/O\n");
            fw.write("Line 2: Java Streams Demo\n");
            fw.write("Line 3: End of file\n");
        }
        catch (IOException e)
        {
            System.out.println("Error writing file: " + e.getMessage());
        }
        // Step 2: Read and print file contents
        try (FileReader fr = new FileReader("input.txt"))
        {
            int ch;
            System.out.println("Contents of input.txt:");
            while ((ch = fr.read()) != -1)
            {
                System.out.print((char) ch);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
        // Step 3 & 4: Copy input.txt to copy.txt using buffer
        int count = 0;
        try (FileReader fr = new FileReader("input.txt");
             FileWriter fw = new FileWriter("copy.txt"))
        {
            char[] buffer = new char[1024];
            int n;
            while ((n = fr.read(buffer)) != -1) {
                fw.write(buffer, 0, n);
                count += n;
            }
        }
        catch (IOException e)
        {
            System.out.println("Error copying file: " + e.getMessage());
        }
        System.out.println("\nCharacters copied: " + count);
    }
}